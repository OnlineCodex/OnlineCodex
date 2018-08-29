package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORFlakkBattleFortress extends Eintrag {

	public ORFlakkBattleFortress() {
		name = "Flakk Battle Fortress";
		grundkosten = 460;

		add(ico = new oc.Picture("oc/wh40k/images/ORKustomBattleFortress.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Dethrolla"));
		ogE.addElement(new OptionsGruppeEintrag("Reinforced Ram"));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding plank", 10));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Sponson", 4, 5));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grabbin\' Klaw", 15));
		ogE.addElement(new OptionsGruppeEintrag("Wreckin\' Ball", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 15));
		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 20));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		complete();
	}

	public void refreshen() {
	}
}
