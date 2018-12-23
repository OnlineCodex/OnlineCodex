package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ORKnowWots extends RuestkammerVater {

    public ORKnowWots() {
        grundkosten = 0;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Trophä'enstangä", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork-Körpa", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gitsucha", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warbike", 25)); //falls keine Megarüstung

        setUeberschrift("Spezielle Ausrüstung");

        sizeSetzen();
    }
}