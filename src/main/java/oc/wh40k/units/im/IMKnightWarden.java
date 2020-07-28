package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKnightWarden extends Eintrag {

    public IMKnightWarden() {
        name = "Knight Warden";
        grundkosten = getPts("Knight Warden") + getPts("Titanic feet") + getPts("Heavy flamer (SM other)");
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
