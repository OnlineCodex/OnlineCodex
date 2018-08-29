package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOMarauderBomber extends Eintrag {

        OptionsUpgradeGruppe o1;

	public APOMarauderBomber() {
		name = "Marauder Bomber";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/IGMarauderBomber.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Bomb payload", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstorm bombs",0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Cockpit", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Paint sheme", "distinctive paint sheme", 10));

		
		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
	}
}
