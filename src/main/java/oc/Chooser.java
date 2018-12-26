package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static oc.RefreshListener.Priority.CHOOSER;
import static oc.RefreshListener.addRefreshListener;

public class Chooser extends BuildaPanel implements ActionListener, BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(Chooser.class);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color GREEN = new Color(30, 205, 0);

    private final JComboBox<Class<? extends Eintrag>> myComboBox;

    private BuildaVater buildaVater;
    private JButton cloneButton = new JButton(BuildaHQ.translate("Clonen"));
    private List<List<Class<? extends Eintrag>>> statischeEinträge;
    private List<Class<? extends Eintrag>> spezialEinträge;
    private int kategorie;
    private boolean useActionPerformed = true;
    private Eintrag myEintrag = null;

    Chooser(
            BuildaVater bv,
            int lX, int lY,
            List<List<Class<? extends Eintrag>>> alleEinträge,
            int kategorie, ActionListener cloneListener) {
        this.buildaVater = bv;
        this.kategorie = kategorie;
        this.panel.setLocation(lX, lY);

        myComboBox = new JComboBox<>(toArray(alleEinträge));

        myComboBox.setBounds(0, 0, auswahlBreite - 60, 20);
        myComboBox.addActionListener(this);
        myComboBox.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
        BuildaHQ.newGUIComponent(myComboBox);
        myComboBox.setBackground(Color.WHITE);
        myComboBox.setMaximumRowCount((BILDSCHIRMHÖHE - 150) / 20);
        myComboBox.setEditable(false);
        ListCellRenderer<? super Class<? extends Eintrag>> defaultRenderer = myComboBox.getRenderer();
        myComboBox.setRenderer((JList<? extends Class<? extends Eintrag>> list, Class<? extends Eintrag> value, int index, boolean isSelected, boolean cellHasFocus) -> {
            Component c = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value != null) {
                statischeEinträge.stream()
                        .filter(value::equals)
                        .findFirst()
                        .ifPresent(any -> c.setForeground(BLACK));

                spezialEinträge.stream()
                        .filter(value::equals)
                        .findFirst()
                        .ifPresent(any -> c.setForeground(GREEN));
            }

            return c;
        });
        myComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);

        panel.add(myComboBox);

        cloneButton.setBounds(auswahlBreite - 55, 0, 65, 20);
        cloneButton.addActionListener(cloneListener);

        BuildaHQ.newGUIComponent(cloneButton);

        cloneButton.setBorder(BuildaHQ.createBorder(new Color(134, 201, 218)));
        cloneButton.setFont(new Font("tahoma", Font.PLAIN, 12));
        cloneButton.setToolTipText("Clont diesen Eintrag mit all seinen Einstellungen und Rüstkammern.");
        panel.add(cloneButton);

        sizeSetzen();

        cloneButton.repaint();
        panel.repaint();

        addRefreshListener(CHOOSER, this::sizeSetzen);
    }

    @SuppressWarnings({
            "unchecked", "rawtypes", // fuuuuck generic arrays
    })
    private Class<? extends Eintrag>[] toArray(List<List<Class<? extends Eintrag>>> alleEinträge) {
        if (alleEinträge.isEmpty()) {
            return new Class[1];
        } else {
            return alleEinträge.stream()
                    .flatMap(grp -> Stream.concat(Stream.of(null), grp.stream()))
                    .toArray(Class[]::new);
        }
    }

    JButton getCloneButton() {
        return cloneButton;
    }

    void selectEntryNotLocked(String s) {
        myComboBox.setSelectedItem(s);
    }

    void setAuswahlen(List<List<Class<? extends Eintrag>>> v) {
        useActionPerformed = false;
        Class<? extends Eintrag> currentSelected = selectedEntry();

        myComboBox.removeAllItems();
        Arrays.stream(toArray(v)).forEach(myComboBox::addItem);
        myComboBox.setSelectedItem(currentSelected);

        if (!Objects.equals(selectedEntry(), currentSelected)) {
            myEintrag.deleteYourself();
        }

        useActionPerformed = true;
    }


    public int getKategorie() {
        return this.kategorie;
    }

    public Eintrag getEintrag() {
        return this.myEintrag;
    }

    JComboBox getComboBox() {
        return this.myComboBox;
    }

    public double getKosten() {
        return myEintrag.getKosten();
    }

    Chooser setStatischeEinträge(List<List<Class<? extends Eintrag>>> sE) {
        this.statischeEinträge = sE;
        return this;
    }

    Chooser setSpezialEinträge(List<Class<? extends Eintrag>> sE) {
        this.spezialEinträge = sE;
        return this;
    }

    public void sizeSetzen() {
        int x = myComboBox.getSize().width;
        int y = myComboBox.getSize().height;

        if (myEintrag != null) {
            x = BuildaHQ.wasIstHoeher(x, myEintrag.getBreite());
            y = myEintrag.getHöhe();

            x += myEintrag.getPanel().getLocation().getX();
            y += myEintrag.getPanel().getLocation().getY();
        }

        panel.setSize(x, y + randAbstand);
    }

    private void erstelleEintrag(Class<? extends Eintrag> eintrag) {
        if (eintrag == null) {
            erstelleLeerenEintrag();
        } else {
            try {
                aktuellenEintragLöschen();

                myEintrag = eintrag.getConstructor()
                        .newInstance();

                myEintrag.getPanel().setLocation(0, 30);
                myEintrag.setKategorie(kategorie);
                myEintrag.setBuildaVater(buildaVater);
                panel.add(myEintrag.getPanel());
            } catch (ClassCastException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                LOGGER.error("Error while creating instance of " + eintrag, e);
                OnlineCodex.getInstance().fehler("Konnte den Eintrag " + eintrag.getName() + " nicht initialisiere:\n" + e.getLocalizedMessage());
                erstelleLeerenEintrag();
            }
        }

        RefreshListener.fireRefresh();
        cloneButton.setVisible(!(myEintrag instanceof LeererEintrag));
    }

    @SuppressWarnings({
            "unchecked", // JComboBox.getSelectedObjects() hides the type.
    })
    Class<? extends Eintrag> selectedEntry() {
        return (Class<? extends Eintrag>) myComboBox.getSelectedObjects()[0];
    }

    public void actionPerformed(ActionEvent event) {
        if (useActionPerformed) {
            erstelleEintrag(selectedEntry());
        }
    }

    void aktuellenEintragLöschen() {
        if (myEintrag != null) {
            myEintrag.deleteYourself();
            RefreshListener.remove(myEintrag.getID());
            myEintrag = null;
            try {
                panel.remove(2);
            } catch (Exception e) {
                LOGGER.error("", e);
            }
        }
    }

    private void erstelleLeerenEintrag() {
        aktuellenEintragLöschen();
        myEintrag = new LeererEintrag(0, 0);
        myEintrag.getPanel().setLocation(0, 30);
        panel.add(myEintrag.getPanel());
    }

    public String getText() {
        try {
            return myEintrag.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getSaveText(String trenner) {
        try {
            return myEintrag.getSaveText(trenner);
        } catch (Exception e) {
            return "";
        }
    }

    void selectEntry(String s) {
        myComboBox.setSelectedItem(s);
        myComboBox.setEnabled(false);
        cloneButton.setEnabled(false);
    }

    public void load(String s, String s2) {
        myEintrag.load(s, s2);
    }
}