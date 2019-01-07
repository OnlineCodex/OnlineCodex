package oc.wh40k.units;

import java.util.Objects;

public enum Publication {
    IMPERIAL_ARMOUR_XENOS("Imperial Armour - Index: Xenos"),
    ;

    private final String name;

    Publication(String name) { this.name = Objects.requireNonNull(name); }

    public String getPublicationName() { return name; }
}
