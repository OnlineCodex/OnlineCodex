package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class AEGuardianDefenders extends Eintrag {

    private final AnzahlPanel squad;
    private final RuestkammerStarter weaponPlatform2;

    public AEGuardianDefenders() {
        name = "Guardian Defenders";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Guardian Defenders", 10, 20, getPts("Guardian Defenders") + getPts("Shuriken catapult") + getPts("Sunburst grenade"));
        add(squad);

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new AEHeavyWeaponPlatform(), "Heavy weapon platform"));

        seperator();

        weaponPlatform2 = new RuestkammerStarter(ID, randAbstand, cnt, new AEHeavyWeaponPlatform(), "Heavy weapon platform");
        add(weaponPlatform2);
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() == 20) {
            weaponPlatform2.setAktiv(true);
        } else {
            weaponPlatform2.setAktiv(false);
        }

        if (squad.getModelle() > 10) {
            power = 8;
        } else {
            power = 4;
        }
    }
}