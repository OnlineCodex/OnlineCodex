package oc.wh40k.units.or;

import oc.Eintrag;

public class ORRustgobsRunts extends Eintrag {

    public ORRustgobsRunts() {

        kategorie = 2;
        name = "Rustgob's Runts";
        grundkosten = 45;

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
        setUnikat(true);
    }
}
