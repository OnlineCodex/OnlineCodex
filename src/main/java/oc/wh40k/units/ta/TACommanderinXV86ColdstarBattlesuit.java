package oc.wh40k.units.ta;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TACommanderinXV86ColdstarBattlesuit extends Eintrag {

    public TACommanderinXV86ColdstarBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV86_COLDSTAR, JET_PACK, COMMANDER);
    	
        name = "Commander";
        grundkosten = getPts("Commander in XV86 Coldstar Battlesuit");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        addToInformationVector("Commander", 1);

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("Contingent Headquarters") > 0) {
            if (getCountFromInformationVector("Commander") > 1) {
                setFehlermeldung("Max 1 Commander");
            } 
        } 
    }

    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();
    }

}
