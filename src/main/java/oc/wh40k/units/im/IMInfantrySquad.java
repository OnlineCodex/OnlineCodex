package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMInfantrySquad extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    RuestkammerStarter kammer;

    public IMInfantrySquad() {
        checkBuildaVater();
        name = "Infantry Squad";
        grundkosten = (getPts("Infantry Squad") + getPts("Frag grenade (AM)")) * 10;
        power = 3;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", getPts("Vox-caster")));

        seperator();

        ogE = IMAstraMilitarumSpecialWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMAstraMilitarumHeavyWeapons.createRK("", "", buildaVater);
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, "IMAstraMilitarumRuestkammer", "Sergeant");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Sergeant");
        kammer.initKammer();
        add(kammer);
        kammer.setUeberschriftTrotzNullKostenAusgeben(true);
        kammer.setAbwaehlbar(false);

        complete();
    }

    // @OVERRIDE
    public void refreshen() {
    }

}
