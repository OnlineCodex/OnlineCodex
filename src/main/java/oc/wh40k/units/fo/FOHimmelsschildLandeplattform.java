package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class FOHimmelsschildLandeplattform extends Eintrag {
	
	OptionsZaehlerGruppe ozg1;
	
	public FOHimmelsschildLandeplattform() {
		name = "Himmelsschild-Landeplattform";
		grundkosten = 75;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Landeplattform.jpg"));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[BK] Startklar",5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
		ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
		ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,6));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}