package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKnightGallant extends Eintrag {

    public IMKnightGallant() {
        name = "Knight Gallant";
        grundkosten = getPts("Knight Gallant") + getPts("Titanic feet");
        power = 20;

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