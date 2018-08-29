package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class HHCAImperialAvengerStrikeFighter extends Eintrag {

	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o1;

	public HHCAImperialAvengerStrikeFighter() {
		name = "Imperial Avenger Strike Fighter";
		grundkosten = 150;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("6 Tactical bombs", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Missile launchers", 40));
		ogE.addElement(new OptionsGruppeEintrag("2 Autocannons", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 Multi-lasers", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chaff launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Infra-red targeting", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Servitor control", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
				
		
	}

}
