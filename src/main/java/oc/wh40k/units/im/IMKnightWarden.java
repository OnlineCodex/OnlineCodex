package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMKnightWarden extends Eintrag {
    OptionsUpgradeGruppe o1, o2;
    OptionsUpgradeGruppe fk1;
    OptionsUpgradeGruppe fk2;

    public IMKnightWarden() {
        name = "Knight Warden";
        grundkosten = getPts("Knight Warden") + getPts("Titanic feet") + getPts("Heavy flamer (SM)");
        power = 23;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon", getPts("Avenger gatling cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper Chainsword", getPts("Reaper Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike Gauntlet", getPts("Thunderstrike Gauntlet")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
        add(fk2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
        fk2.alwaysSelected();
        o2.alwaysSelected();
    }
}
