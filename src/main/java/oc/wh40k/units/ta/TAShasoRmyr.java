package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAShasoRmyr extends Eintrag {

    public TAShasoRmyr() {
        name = "Shas'o R'myr";
        grundkosten = getPts("Shas'o R'myr") + getPts("Double-barrelled plasma rifle") + getPts("Miniaturised fletchette pod (shooting)") + getPts("Miniaturised fletchette pod (melee)");

        add(ico = new oc.Picture("oc/wh40k/images/TAShasORMyr.jpg"));

        seperator();

        addToInformationVector("TACommander", 1);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        power = 7;
    }

    //@OVERRIDE
    @Override
	public void deleteYourself() {
        addToInformationVector("TACommander", -1);

        super.deleteYourself();
    }

}
