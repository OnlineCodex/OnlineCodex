package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMInfantrySquad extends Eintrag {

	private final RuestkammerStarter kammer;

    public IMInfantrySquad() {
        checkBuildaVater();
        name = "Infantry Squad";
        grundkosten = (getPts("Infantry Squad") + getPts("Frag grenade (AM)")) * 10;
        power = 3;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", getPts("Vox-caster")));

        seperator();

        ogE = IMAstraMilitarumSpecialWeapons.createRK("", "", buildaVater);
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMAstraMilitarumHeavyWeapons.createRK("", "", buildaVater);
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        kammer = createTroopChampion(IMAstraMilitarumRuestkammer.class, true, "Sergeant", "Sergeant");
        add(kammer);

        complete();
    }
}
