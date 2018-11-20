package oc.wh40k.units.im;

import oc.*;

public class IMWarlordtraits extends Eintrag {
    OptionsUpgradeGruppe fk1;
    boolean spacewolves;

    public IMWarlordtraits() {
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
        name = "Warlord Traits";
        grundkosten = 0;
        power = 0;

        if(spacewolves) {
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Warrior Born", getPts("")));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Wolfkin", getPts("")));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of Majesty", getPts("")));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Beastslayer", getPts("")));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Hunter", getPts("")));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Bear", getPts("")));
	        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
