package oc.wh40k.units.or;

import oc.Eintrag;

public class ORSkraksSkullNobz extends Eintrag {

    public ORSkraksSkullNobz() {

        kategorie = 2;
        name = "Skrak's Skull-Nobz";
        grundkosten = 190;

        add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));
        complete();
    }

    public void deleteYourself() {
        super.deleteYourself();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
