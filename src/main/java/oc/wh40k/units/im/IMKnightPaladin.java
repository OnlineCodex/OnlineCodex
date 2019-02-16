package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKnightPaladin extends Eintrag {

    public IMKnightPaladin() {
        name = "Knight Paladin";
        grundkosten = getPts("Knight Paladin") + getPts("Titanic feet") + getPts("Heavy stubber (QI)");
        power = 23;

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
