package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKnightCrusader extends Eintrag {

    public IMKnightCrusader() {
        name = "Knight Crusader";
        grundkosten = getPts("Knight Crusader") + getPts("Titanic feet");
        power = 25;

        seperator();

        addWeapons(IMImperialKnightRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        complete();
    }

    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
