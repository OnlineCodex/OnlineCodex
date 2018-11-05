package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDreadnought extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public IMDreadnought() {
        name = "Dreadnought";
        grundkosten = getPts("Dreadnought");
        power = 7;

        seperator();

        if (!buildaVater.getFormationType().equals("Deathwatch")) {
            ogE.addAll(IMSpaceMarinesDreadnoughtHeavyWeapons.createRK("Assault cannon", "Assault cannon", buildaVater));
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Heavy plasma cannon", getPts("Heavy plasma cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        }
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DCW + Storm bolter", "Dreadnought combat weapon + Storm bolter", getPts("Dreadnought combat weapon (other models)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("DCW + Heavy flamer", "Dreadnought combat weapon + Heavy flamer", getPts("Dreadnought combat weapon (other models)") + getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM)")));
        if (!buildaVater.getFormationType().equals("Deathwatch")) {
            ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        }
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
