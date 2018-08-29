package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORFightaBommer extends Eintrag {

	OptionsZaehlerGruppe rokkits;
	OptionsZaehlerGruppe wpns;
	
	OptionsUpgradeGruppe apo;
	
	public ORFightaBommer() {
		name = "Fighta-Bommer";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/Kampfbomba.gif"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Rokkit", 0));
		add(rokkits = new OptionsZaehlerGruppe(ID, randAbstand, cnt,"", ogE,6));
		
		ogE.addElement(new OptionsGruppeEintrag("Bomms", 0));
		ogE.addElement(new OptionsGruppeEintrag("Grot Bomms", 15));
		add(wpns = new OptionsZaehlerGruppe(ID, randAbstand, cnt,"", ogE,6));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("[APO] Burna Bomms", 25));
		ogE.addElement(new OptionsGruppeEintrag("[APO] Apokalypse Bomms", 25));
		add(apo =new OptionsUpgradeGruppe(ID, randAbstand, cnt,"", ogE));

		complete();
	}

	public void refreshen() {
		rokkits.setAktiv(!apo.isSelected());
		wpns.setAktiv(!apo.isSelected());
		
		rokkits.setMaxAnzahl(6-wpns.getAnzahl());
		rokkits.setAnzahl(0,6-wpns.getAnzahl());
	}
}
