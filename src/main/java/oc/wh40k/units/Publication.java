package oc.wh40k.units;

import static java.util.Objects.requireNonNull;
import static oc.wh40k.units.Publication.PublicationType.FORGE_WORLD;

public enum Publication {
    IMPERIAL_ARMOUR_XENOS(FORGE_WORLD, "Imperial Armour - Index: Xenos"),
    ;

    public enum PublicationType {
        FORGE_WORLD,
    }

    private final PublicationType type;
    private final String name;

    Publication(PublicationType type, String name) {
        this.type = requireNonNull(type);
        this.name = requireNonNull(name); }

    public String getPublicationName() { return name; }

    public PublicationType getPublicationType() {
        return type;
    }
}
