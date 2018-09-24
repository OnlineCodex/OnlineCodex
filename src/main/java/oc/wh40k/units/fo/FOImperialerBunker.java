package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class FOImperialerBunker extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe ozg1;
	OptionsUpgradeGruppe o2;
	
	public FOImperialerBunker() {
		name = "Imperialer Bunker";
		grundkosten = 55;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Voxrelais", 20));
		ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone","Waffenstellung mit Icarus-Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Vierlings-Flak","Waffenstellung mit Vierlings-Flak", 50));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Munitionslager", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("[BK] Stacheldraht", 5));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Barrikaden", 10));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Panzersperren", 15));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,6));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("[BK] Deflektorschild", 25));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Fluchtluke", 25));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Magos-Maschinengeist", 30));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Munitionsdepot", 15));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Sprengfallen", 20));
		ogE.addElement(new OptionsGruppeEintrag("[BK] Suchscheinwerfer", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,2));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}