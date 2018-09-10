package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMAquilaLander extends Eintrag {

        OptionsUpgradeGruppe o4;

	public AMAquilaLander() {
		name = "Aquila Lander";
		grundkosten = 110;
		
		add(ico = new oc.Picture("oc/wh40k/images/AquilaLander.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("multi-laser", 10));
		ogE.addElement(new OptionsGruppeEintrag("autocannon", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare/Chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Paint scheme","Distincitve paint scheme or markings", 10));
		
		complete();
	}

	public void refreshen() {
            o4.alwaysSelected();
	}
}
