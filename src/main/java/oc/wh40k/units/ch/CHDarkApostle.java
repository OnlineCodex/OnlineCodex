package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHDarkApostle extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;
    
	public CHDarkApostle() {

		name = "DarkApostle";
        grundkosten = getPts("DarkApostle");
        power = 5;   
		complete();

        seperator();
        
		complete();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultNK("Power maul");
        waffen.initKammer(false,true,false,false);
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
