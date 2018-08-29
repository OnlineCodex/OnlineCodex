package oc.wh40k.units.fo;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class FOFeuersturmAbwehrstellungKammer extends RuestkammerVater {

	OptionsZaehlerGruppe ozgX;
	OptionsZaehlerGruppe ozg1;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter hauptGeb;
	RuestkammerStarter hauptHind;

	public FOFeuersturmAbwehrstellungKammer() {}
	public void initButtons(boolean... defaults) {
		name = "Feuersturm Abwehrstellung";
		grundkosten = 200;
		add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));
		
        seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone", 0));
		add(ozgX = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Vollstrecker-Stuka","Vollstrecker-Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfgeschütz", 10));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Voxrelais", 20));
		ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone","Waffenstellung mit Icarus-Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Vierlings-Flak","Waffenstellung mit Vierlings-Flak", 50));
		ogE.addElement(new OptionsGruppeEintrag("Munitionslager", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		hauptGeb = new RuestkammerStarter(ID, randAbstand, cnt, "FOGebaeude", "Gebäude");
		hauptGeb.initKammer(true);
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptGeb);
		
		hauptHind = new RuestkammerStarter(ID, randAbstand, cnt, "FOHindernisse", "Hindernisse");
		hauptHind.initKammer();
		hauptGeb.setUeberschriftTrotzNullKostenAusgeben(true);
		add(hauptHind);
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
        ozgX.setMaxAnzahl(2-ozg1.getAnzahl());
        ozgX.setAnzahl(0,2-ozg1.getAnzahl());
	}
}
