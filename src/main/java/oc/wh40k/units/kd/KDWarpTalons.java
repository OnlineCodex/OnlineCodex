package oc.wh40k.units.kd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class KDWarpTalons extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade rkBoss;

	public KDWarpTalons() {
		//name = "Warpkrallen\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Warp Talons", 5, 10, 34, "Warpkrallen");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));
		
		seperator();

		add(rkBoss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warp Talon Champion", 10));

		complete();
	}

	@Override
	public void refreshen() {		
		rkBoss.setSelected(true);
	}

}
