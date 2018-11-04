package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMRedemptorDreadnought extends Eintrag {

    OptionsUpgradeGruppe o1, o2, o3;
    OptionsEinzelUpgrade oe1;

    public IMRedemptorDreadnought() {
        name = "Redemptor Dreadnought";
        grundkosten = getPts("Redemptor Dreadnought");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy onslaught gatling cannon", getPts("Heavy onslaught gatling cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Macro plasma incinerator", getPts("Macro plasma incinerator")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer (SM)", getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Onslaught gatling cannon", getPts("Onslaught gatling cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two fragstorm grenade launchers", getPts("Fragstorm grenade launcher") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Two storm bolters", getPts("Stormbolter (SM)") * 2));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icarus rocket pod", getPts("Icarus rocket pod")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}
