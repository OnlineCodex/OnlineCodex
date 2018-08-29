package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHExaltedChampion extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;
    
	public CHExaltedChampion() {

		name = "Exalted Champion";
        grundkosten = getPts("Exalted Champion");
        power = 5;   
		complete();

        seperator();
        
		complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultNK("Chainsword");
        ((CHWaffenkammer)waffen.getKammer()).setChampion(true);
        waffen.initKammer(true,true,true,true);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
		
	}

	@Override
	public void refreshen() {
	}
}
