package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMSWVenerableDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3;

    public IMSWVenerableDreadnought() {
        name = "Venerable Dreadnought";
        grundkosten = getPts("Venerable Dreadnought");
        power = 8;

        seperator();

        ogE.addAll(IMSpaceMarinesDreadnoughtHeavyWeapons.createRK("Assault cannon", "Assault cannon", buildaVater));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DCW + Storm bolter", "Dreadnought combat weapon + Storm bolter", getPts("Dreadnought combat weapon (other models)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("DCW + Heavy flamer", "Dreadnought combat weapon + Heavy flamer", getPts("Dreadnought combat weapon (other models)") + getPts("Heavy flamer (SM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Axe & Shield", "Fenrisian great axe and blizzard shield", getPts("Fenrisian great axe") + getPts("Blizzard shield")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o1.setAktiv(!o3.isSelected());
        o2.setAktiv(!o3.isSelected());
    }
}
