package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKnightCastellan extends Eintrag {

    public IMKnightCastellan() {
        name = "Knight Castellan";
        grundkosten = getPts("Knight Castellan") + getPts("Titanic feet");
        power = 30;

        seperator();

        addWeapons(IMImperialKnightRuestkammer.class, true);

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        seperator();

		addWarlordTraits("", true);

        
        complete();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
