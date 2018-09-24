package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CMChaosWarhoundTitan extends Eintrag {

        OptionsZaehlerGruppe o1;
        OptionsUpgradeGruppe mal;

	public CMChaosWarhoundTitan() {
		name = "Chaos Warhound Titan";
		grundkosten = 730;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosWarhoundTitan.gif"));
		

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Doppelläufiger Turbolaser-Annihilator", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmageschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Geschütz", 0));
		ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 50));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 100));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 75));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 50));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		
		complete();

	}

	public void refreshen() {
            o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
	}
}
