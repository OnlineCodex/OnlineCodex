package oc.wh40k.units.ta;

import static oc.KeyWord.BATTLESUIT;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMMANDER;
import static oc.KeyWord.JET_PACK;
import static oc.KeyWord.TAU_EMPIRE;
import static oc.KeyWord.XV86_COLDSTAR;

import oc.Eintrag;

public class TACommanderinXV86ColdstarBattlesuit extends Eintrag {

    public TACommanderinXV86ColdstarBattlesuit() {
    	super(TAU_EMPIRE, BATTLESUIT, CHARACTER, XV86_COLDSTAR, JET_PACK, COMMANDER);

        name = "Commander";
        grundkosten = getPts("Commander in XV86 Coldstar Battlesuit");

        applyTitle = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

		addWarlordTraits("");

        addToInformationVector("Commander", 1);

        power = 8;

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("Contingent Headquarters") > 0) {
            if (getCountFromInformationVector("Commander") > 1) {
                setFehlermeldung("Max 1 Commander");
            }
        }

        if(((TAKampfanzugKammer) getWeapons()).dronesSelected()) {
        	power = 9;
        } else {
        	power = 8;
        }
    }

    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();
    }

}
