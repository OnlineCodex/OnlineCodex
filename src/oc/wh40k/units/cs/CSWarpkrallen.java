package oc.wh40k.units.cs;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CSWarpkrallen extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;

	public CSWarpkrallen() {
		//name = "Warpkrallen\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Warpkrallen", 5, 10, 30, "Warpkrallen");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 3));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 2));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Warpkrallen Champion");
		rkBoss.initKammer(true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		rkBoss.setGrundkosten(10);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 4 * count);
		mal.setPreis("Mal des Tzeentch", 6 * count);
		mal.setPreis("Mal des Nurgle", 4 * count);
		mal.setPreis("Mal des Slaanesh", 3 * count);
	}

}
