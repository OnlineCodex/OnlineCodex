package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightGallant extends Eintrag {
    OptionsUpgradeGruppe o1, o2, o3;
    OptionsUpgradeGruppe fk2;

    public IMKnightGallant() {
        name = "Knight Gallant";
        grundkosten = getPts("Knight Gallant") + getPts("Titanic feet");
        power = 20;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper Chainsword", getPts("Reaper Chainsword")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike Gauntlet", getPts("Thunderstrike Gauntlet")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk2.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}