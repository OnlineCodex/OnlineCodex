package oc.wh40k.units.im;

import oc.BuildaVater;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.INTERROMANCY;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.LIBRARIUS;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANGUINARY;

public final class ImperiumUtils {
    private ImperiumUtils() {}

    static PsychicPowers.PsychicPowerGroup getPsychicPowerGroug(BuildaVater buildaVater) {
        switch (buildaVater.getFormationType()) {
            case "Blood Angels": return SANGUINARY;
            case "Dark Angels": return INTERROMANCY;
            default: return LIBRARIUS;
        }
    }
}
