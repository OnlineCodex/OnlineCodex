package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.im.IMSergeant;

public class AEHowlingBanshees extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkBoss;

	public AEHowlingBanshees() {

		name = "Howling Banshees";

		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Howling Banshees", 5, 10, getPts("Howling Banshees") + getPts("Shuriken pistol") + getPts("Power sword"));
		add(squad);

		seperator();
		
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "AEExarch", "Exarch");
		((AEExarch)rkBoss.getKammer()).type = "Howling Banshees";
		((AEExarch)rkBoss.getKammer()).weaponCost = getPts("Shuriken pistol") + getPts("Power sword");
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Exarch"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(true);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		if (squad.getModelle() > 5){
			power = 8;
		}else{
			power = 4;
		}
	}
}
