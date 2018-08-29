package oc.wh40k.units.kd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class KDChaosBikers extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe ikone;
	
	public KDChaosBikers() {
		//name = "Chaosbiker\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Biker", 3, 10, 22, "Chaosbiker");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));
	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 20));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "KDAspiringChampion", "Chaos Biker Champion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		rkBoss.initKammer(false,false,false, false, false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		rkBoss.setGrundkosten(10);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
