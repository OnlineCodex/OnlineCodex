package oc.wh40k.units.or;

import oc.Eintrag;

public class ORGrukkFaceRippa extends Eintrag {

    public ORGrukkFaceRippa() {

        category = 1;
        name = "Grukk Face-Rippa";
        grundkosten = 130;

        add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));

        addToInformationVector("ORHQ", 1);
        complete();
    }

    @Override
	public void deleteYourself() {
        addToInformationVector("ORHQ", -1);
        super.deleteYourself();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}
