package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORLootedRhino extends Eintrag {

	OptionsUpgradeGruppe o1;


	public ORLootedRhino() {

		name = "Looted Rhino";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/LootedRhino.gif"));
        
        ogE.addElement(new OptionsGruppeEintrag("synchr. Fette Wumme", "synchronisierte Fette Wumme", 0));
		ogE.addElement(new OptionsGruppeEintrag("synchr. Bazzukka", "synchronisierte Bazzukka", 0));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zugetakkat", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rotä Farbä", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschlueda", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplankä", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5));

       	complete();



	}

	//@OVERRIDE
	public void refreshen() {
        o1.alwaysSelected();
	}
}
