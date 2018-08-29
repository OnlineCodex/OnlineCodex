package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class AEGuardianDefenders extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter weaponPlatform1, weaponPlatform2;

	public AEGuardianDefenders() {
		name = "Guardian Defenders";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Guardian Defenders", 10, 20, getPts("Guardian Defenders") + getPts("Shuriken catapult") + getPts("Sunburst grenade"));
		add(squad);
		
		seperator();
		
		weaponPlatform1 = new RuestkammerStarter(ID, randAbstand, cnt, "AEHeavyWeaponPlatform", "Heavy weapon platform");
		weaponPlatform1.initKammer();
		add(weaponPlatform1);
		
		seperator();
		
		weaponPlatform2 = new RuestkammerStarter(ID, randAbstand, cnt, "AEHeavyWeaponPlatform", "Heavy weapon platform");
		weaponPlatform2.initKammer();
		add(weaponPlatform2);
	}

	//@OVERRIDE
	public void refreshen() {
		if (squad.getModelle() == 20){
			weaponPlatform2.setAktiv(true);
		}else{
			weaponPlatform2.setAktiv(false);
		}
		
		if(squad.getModelle() > 10){
			power = 8;
		}else{
			power = 4;
		}
	}
}
