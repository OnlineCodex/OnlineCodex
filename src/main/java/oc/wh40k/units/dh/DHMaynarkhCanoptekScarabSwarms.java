package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DHMaynarkhCanoptekScarabSwarms extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade cs;

	public DHMaynarkhCanoptekScarabSwarms() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kanoptech-Skarabäen", 3, 10, 15);
		add(squad);
		
		seperator();
		add(cs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Charnel scarabs", 15));

		add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechSkarabaeen.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		cs.setPreis(squad.getModelle()*5);
	}

}
