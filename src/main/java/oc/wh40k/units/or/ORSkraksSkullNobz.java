package oc.wh40k.units.or;

import oc.Eintrag;

public class ORSkraksSkullNobz extends Eintrag {

    public ORSkraksSkullNobz() {

        category = 2;
        name = "Skrak's Skull-Nobz";
        grundkosten = 190;

        add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));
        complete();
    }

    @Override
	public void deleteYourself() {
        super.deleteYourself();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}
