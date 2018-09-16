package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSpecialWeaponsSquad extends Eintrag {

	OptionsZaehlerGruppe o1x, o1, o2;

	public IMSpecialWeaponsSquad() {
		name = "Special Weapon Squad";
		grundkosten = (getPts("Special Weapon Squad") + getPts("Frag grenade (AM)"))* 6;
		power = 3;

		seperator();
		
		checkBuildaVater();
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", getPts("Lasgun")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,6));
		ogE = IMAstraMilitarumSpecialWeapons.createRK("", "", buildaVater);
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));
		
		ogE.addElement(new OptionsGruppeEintrag("Demolition charge", getPts("Demolition charge")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,3));
		
		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		
		o1x.setAnzahl(0, 6 - o1.getAnzahl());
		o1.setLegal(o1.getAnzahl() + o2.getAnzahl() == 3);
		o2.setLegal(o1.getAnzahl() + o2.getAnzahl() == 3);
		o1.setMaxAnzahl(3-o2.getAnzahl());
		o2.setMaxAnzahl(3-o1.getAnzahl());
	}

}
