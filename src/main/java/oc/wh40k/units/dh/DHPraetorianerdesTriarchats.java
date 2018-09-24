package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DHPraetorianerdesTriarchats extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;

	public DHPraetorianerdesTriarchats() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Prätorianer des Triarchats", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEPraetorianerdesTriarchats.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Eidstäbe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Klingen & Partikelwerfer", "Entropieklingen und Partikelwerfer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
	}

}
