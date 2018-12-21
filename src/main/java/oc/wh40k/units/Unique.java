package oc.wh40k.units;

import oc.Eintrag;

public interface Unique<T extends Eintrag & Unique<T>> {
}
