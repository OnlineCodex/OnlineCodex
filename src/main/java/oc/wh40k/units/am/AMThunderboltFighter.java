package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMThunderboltFighter extends Eintrag {

        OptionsUpgradeGruppe o4;
        
	public AMThunderboltFighter() {
		name = "Thunderbolt Fighter";
		grundkosten = 180;


		add(ico = new oc.Picture("oc/wh40k/images/IGThunderboltFighter.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("4 Hellstrike missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("6 Tactical bombs", 40));
		ogE.addElement(new OptionsGruppeEintrag("4 Skystrike missiles", 50));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaff Launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infra-red targeting", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Distincitve paint scheme", 10));
                
		complete();

	}

	public void refreshen() {
	}
}
