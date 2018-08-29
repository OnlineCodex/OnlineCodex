package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CMChaosReaverBattleTitan extends Eintrag {

        OptionsZaehlerGruppe o1;
        OptionsZaehlerGruppe o2;
    	OptionsUpgradeGruppe mal;


	public CMChaosReaverBattleTitan() {
		name = "Chaos Reaver Battle Titan";
		grundkosten = 1460;


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

        ogE.addElement(new OptionsGruppeEintrag("Gatlingblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("Meltergeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vulkangeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multilaserkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Titanen-NKW", "Titanen-Nahkampfwaffe", 0));
		add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 100));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 200));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 150));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 100));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		
		complete();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
            o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
	}
}
