package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CMPredatordesChaos extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter ausruestung;

	public CMPredatordesChaos() {
		name = "Predator des Chaos";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", 40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


		seperator();
		
		ausruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMFahrzeugruestkammer", "Ausrüstung");
		ausruestung.initKammer(true);
		ausruestung.setButtonText("Ausrüstung");
		add(ausruestung);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
