package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DHMaynarkhFlayedOnePack extends Eintrag {

	AnzahlPanel squad;

	public DHMaynarkhFlayedOnePack() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Albträume", 10, 20, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEAlbtraumMeute.jpg"));


		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flensing scrarabs",10));
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}
