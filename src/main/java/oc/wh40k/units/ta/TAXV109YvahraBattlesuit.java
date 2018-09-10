package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

//[IA Experimental]

public class TAXV109YvahraBattlesuit extends Eintrag {

	OptionsZaehlerGruppe o3;
	OptionsUpgradeGruppe o4;

	public TAXV109YvahraBattlesuit() {
		name = "XV109 Y'vahra Battlesuit";
		grundkosten = 230;

		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Schild-Raketendrohnen", 25));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohnen", 12));
		add(o3 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Drohnensteuerung", 8));
		ogE.addElement(new OptionsGruppeEintrag("Frühwarnsystem", "Frühwarn-Reaktivsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Gegenfeuersystem", "Gegenfeuer-Abwehrsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Zielsystem", "Hochentwickeltes Zielsystem", 3));
		ogE.addElement(new OptionsGruppeEintrag("Luftzielverfolger", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multiple Zielerfassung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Positionssender", 5));
		ogE.addElement(new OptionsGruppeEintrag("Stimulanzinjektor", 35));
        add(o4 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}
	
}
