package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightValiant extends Eintrag {

    public IMKnightValiant() {
        name = "Knight Valiant";
        grundkosten = getPts("Knight Valiant") + getPts("Titanic feet");
        power = 30;

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
