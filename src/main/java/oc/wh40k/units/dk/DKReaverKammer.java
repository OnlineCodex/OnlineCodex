package oc.wh40k.units.dk;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKReaverKammer extends RuestkammerVater {

        OptionsZaehlerGruppe o1;
        OptionsZaehlerGruppe o2;

	public DKReaverKammer() {}
	
	public void initButtons(boolean... b) {
		name = "Reaver Battle Titan";
		grundkosten = 1450;


		add(ico = new oc.Picture("oc/wh40k/images/ReaverBattleTitan.gif"));
		

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Doppelläufiger Turbolaseer-Annihilator", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmageschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Geschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", "Apokalypse-Raketenbwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Warpfeldgranate", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multilaserkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Gatlingblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("Meltergeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vulkangeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Titanen-NKW", "Titanen-Nahkampfwaffe", 0));
		add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
            o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}
}
