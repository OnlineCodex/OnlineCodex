package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDeathCompanyDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3, o4;

    public IMDeathCompanyDreadnought() {
        name = "Death Company Dreadnought";
        grundkosten = getPts("Death Company Dreadnought");
        power = 11;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Furioso fists", getPts("Furioso fist (pair)")));
        ogE.addElement(new OptionsGruppeEintrag("Blood talons", getPts("blood talons")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Smoke launchers", getPts("smoke launchers")));
        ogE.addElement(new OptionsGruppeEintrag("Magna-grapple", getPts("magna-grapple")));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o4.alwaysSelected();
    }
}
