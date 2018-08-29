package oc.wh40k.units.cs;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CSRaptoren extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;

	public CSRaptoren() {
		//name = "Chaos Space Marines Raptoren\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Raptoren", 5, 15, 17, "Raptoren");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 3));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 2));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Flammen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Verzweiflung", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 25));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Raptorchampion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		rkBoss.initKammer(false,false,false, false, false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		rkBoss.setGrundkosten(10);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 2 * count);
		mal.setPreis("Mal des Nurgle", 3 * count);
		mal.setPreis("Mal des Slaanesh", 2 * count);
		
		if(mal.isSelected("Mal des Khorne")) {
			ikone.setAktiv("Ikone des Zorns", true);
		} else {
			ikone.setAktiv("Ikone des Zorns", false);
		}
		
		if(mal.isSelected("Mal des Tzeentch")) {
			ikone.setAktiv("Ikone der Flammen", true);
		} else {
			ikone.setAktiv("Ikone der Flammen", false);
		}
		
		if(mal.isSelected("Mal des Nurgle")) {
			ikone.setAktiv("Ikone der Verzweiflung", true);
		} else {
			ikone.setAktiv("Ikone der Verzweiflung", false);
		}
		
		if(mal.isSelected("Mal des Slaanesh")) {
			ikone.setAktiv("Ikone der Ausschweifung", true);
		} else {
			ikone.setAktiv("Ikone der Ausschweifung", false);
		}
	}

}
