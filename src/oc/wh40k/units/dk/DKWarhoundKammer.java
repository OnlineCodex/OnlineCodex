package oc.wh40k.units.dk;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKWarhoundKammer extends RuestkammerVater {

        OptionsZaehlerGruppe o1;

	public DKWarhoundKammer() {}
	
	public void initButtons(boolean... b) {
		name = "Warhound-Scouttitan";
		grundkosten = 750;


		add(ico = new oc.Picture("oc/wh40k/images/WarhoundScouttitan.gif"));
		

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Doppelläufiger Turbolaseer-Annihilator", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmageschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Geschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
	}
}
