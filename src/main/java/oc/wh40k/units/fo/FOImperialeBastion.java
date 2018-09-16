package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class FOImperialeBastion extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	RuestkammerStarter hauptGeb;
	RuestkammerStarter hauptHind;

	public FOImperialeBastion() {
		name = "Imperiale Bastion";
		grundkosten = 75;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

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
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}