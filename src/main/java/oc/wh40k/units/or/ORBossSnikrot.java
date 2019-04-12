package oc.wh40k.units.or;

import oc.Eintrag;

public class ORBossSnikrot extends Eintrag {


    public ORBossSnikrot() {

        category = 1;
        name = "Boss Snikrot";
        grundkosten = getPts("Boss Snikrot");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();

        addWarlordTraits("Blood Axes: I've got a plan, Ladz");

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
