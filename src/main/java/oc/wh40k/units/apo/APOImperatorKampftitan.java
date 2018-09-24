package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class APOImperatorKampftitan extends Eintrag {

        OptionsZaehlerGruppe o1;
        OptionsZaehlerGruppe o2;

	public APOImperatorKampftitan() {
		name = "Imperator-Kampftitan";
		grundkosten = 4000;


		add(ico = new oc.Picture("oc/wh40k/images/ImperatorKampftitan.gif"));
		

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multilaserkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Annihilator", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Geschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Gatlingblaster", 0));
		ogE.addElement(new OptionsGruppeEintrag("Meltergeschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tremorgeschütz", "Ragnarok-Tremorgeschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkangeschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", "Apokalypse-Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Warpfeldrakete", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));

                seperator();

                ogE.addElement(new OptionsGruppeEintrag("Plasma-Annihilator", "schwerer Plasma-Annihilator", 0));
                ogE.addElement(new OptionsGruppeEintrag("Höllensturm-Geschütz", 0));
                ogE.addElement(new OptionsGruppeEintrag("Vergelter-Geschütz", 0));
                ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", "Verhängnis-Raketenwerfer", 0));
		add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		complete();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
            o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}
}
