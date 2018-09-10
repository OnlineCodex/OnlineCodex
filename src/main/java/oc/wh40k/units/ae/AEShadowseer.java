package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AEShadowseer extends Eintrag {
	
	OptionsZaehlerGruppe o1;

	public AEShadowseer() {
		name = "Shadowseer";
		grundkosten = getPts("Shadowseer");
		power = 7;

		ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
    	ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		complete();
	}

	@Override
	public void refreshen() { 
	}
}