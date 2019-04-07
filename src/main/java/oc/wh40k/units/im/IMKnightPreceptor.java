package oc.wh40k.units.im;

import oc.Eintrag;


public class IMKnightPreceptor extends Eintrag {

    public IMKnightPreceptor() {
        name = "Knight Preceptor";
        grundkosten = getPts("Knight Preceptor") + getPts("Titanic feet");
        power = 23;

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
