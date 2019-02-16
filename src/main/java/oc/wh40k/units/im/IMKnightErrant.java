package oc.wh40k.units.im;

import oc.Eintrag;


public class IMKnightErrant extends Eintrag {

    public IMKnightErrant() {
        name = "Knight Errant";
        grundkosten = getPts("Knight Errant") + getPts("Titanic feet");
        power = 22;

        seperator();

        addWeapons(IMImperialKnightRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);
		
        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") + 1);

        complete();
    }
    
    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Knight selected", getCountFromInformationVector("Knight selected") - 1);
    }
}
