package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMThunderboltAbfangjaeger extends Eintrag {

	public AMThunderboltAbfangjaeger() {
		name = "Thunderbolt-Abfangjäger";
		grundkosten = 180;


		add(ico = new oc.Picture("oc/wh40k/images/ThunderboltAbfangjaeger.gif"));
		

                ogE.addElement(new OptionsGruppeEintrag("Donnerkeil-Raketen","vier Donnerkeil-Raketen", 40));
		ogE.addElement(new OptionsGruppeEintrag("Bomben","vier Bomben",40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
	}
}
