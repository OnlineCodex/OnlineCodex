package oc.wh40k.units.cs;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CSBesessene extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsZaehlerGruppe o7;
	OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    
	public CSBesessene() {
		//name = "Besessene Chaos Space Marines\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Besessene", 5, 20, 26);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 3));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 4));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 3));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Flammen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Verzweiflung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 35));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 5));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Champion der Besessenen");
		champion.initKammer(true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);

		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CSTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 3 * count);
		mal.setPreis("Mal des Tzeentch", 5 * count);
		mal.setPreis("Mal des Nurgle", 4 * count);
		mal.setPreis("Mal des Slaanesh", 3 * count);
		
        if(!champion.isSelected()) champion.setSelected(true);
	
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
		
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
	}
}
