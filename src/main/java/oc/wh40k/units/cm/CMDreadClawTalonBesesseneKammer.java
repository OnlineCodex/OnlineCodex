package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMDreadClawTalonBesesseneKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
	OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    
	public CMDreadClawTalonBesesseneKammer() {}
	
	public void initButtons(boolean... defaults) {
		grundkosten = 0;

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
		
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 2));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Champion der Besessenen");
		champion.initKammer(true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 3 * count);
		mal.setPreis("Mal des Tzeentch", 5 * count);
		mal.setPreis("Mal des Nurgle", 4 * count);
		mal.setPreis("Mal des Slaanesh", 3 * count);
		
		vdlk.setPreis("Veteranen des Langen Krieges", 2 * count);
		
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
		
	}
}
