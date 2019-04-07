package oc;

import static java.util.Comparator.comparing;
import static java.util.Objects.requireNonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;


public final class RefreshListener implements Runnable {

    public enum Priority {
        ANZAHL_PANEL,
        OPTIONS_COLLECTION,
        RUESTKAMMER_VATER,
        RUESTKAMMER_STARTER,
        EINTRAG,
        CHOOSER,
        CHOOSER_GRUPPE,
        BUILDA_VATER,
        ONLINE_CODEX,
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshListener.class);
    private static final List<RefreshListener> LISTENERS = new LinkedList<>();
    private static final AtomicInteger NEXT_ID = new AtomicInteger(0);

    private final Priority priority;
    private final int id;
    private final Runnable action;

    private RefreshListener(Priority priority, int id, Runnable action) {
        this.priority = requireNonNull(priority, "priority");
        this.id = id;
        this.action = requireNonNull(action, "action");
    }

    public Priority getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    @Override
	public void run() {
        action.run();
    }

    public static RefreshListener addRefreshListener(Priority priority, Runnable action) {
        // must check arguments before incrementing NEXT_ID
        requireNonNull(priority, "priority");
        requireNonNull(action, "action");
        return addRefreshListener(priority, NEXT_ID.getAndIncrement(), action);
    }

    public static RefreshListener addRefreshListener(Priority priority, int id, Runnable action) {
        final RefreshListener listener = new RefreshListener(priority, id, action);
        synchronized (LISTENERS) {
            LISTENERS.add(listener);
        }
        return listener;
    }

    public static void remove(RefreshListener listener) {
        synchronized (LISTENERS) {
            LISTENERS.remove(listener);
        }
    }

    public static void remove(int id) {
        synchronized (LISTENERS) {
            LISTENERS.removeIf(l -> l.getId() == id);
        }
    }

    public static void removeAll() {
        synchronized (LISTENERS) {
            LISTENERS.clear();
        }
    }

    private static List<RefreshListener> copyListeners() {
        synchronized (LISTENERS) {
            return ImmutableList.copyOf(LISTENERS);
        }
    }

    public static void fireRefresh() {
        final List<RefreshListener> refreshListeners = copyListeners();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("firefing {} refreshlisteners", refreshListeners.size());
        }
        refreshListeners.stream()
                .sorted(comparing(RefreshListener::getPriority))
                .forEach(Runnable::run);
    }

}