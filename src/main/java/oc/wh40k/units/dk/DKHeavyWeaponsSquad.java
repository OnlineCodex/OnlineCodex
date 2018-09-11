package oc.wh40k.units.dk;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKHeavyWeaponsSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;

	public DKHeavyWeaponsSquad() {
		grundkosten = 75;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Mortar", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("T/L Heavy stubber", "twin-linked Heavy stubber", 5));
		ogE.addElement(new OptionsGruppeEintrag("Lascannons", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));


		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o1x.setMaxAnzahl(3-o1.getAnzahl());
        o1x.setAnzahl(0, o1x.getMaxAnzahl());
	}

}
