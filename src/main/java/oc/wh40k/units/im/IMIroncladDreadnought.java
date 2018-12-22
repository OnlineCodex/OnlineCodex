package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMIroncladDreadnought extends Eintrag {
    OptionsUpgradeGruppe o2, o1, o3;

    public IMIroncladDreadnought() {
        name = "Ironclad Dreadnought";
        grundkosten = getPts("Ironclad Dreadnought");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seismic Hammer", getPts("Seismic Hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Dreadnought chainfist", getPts("Dreadnought chainfist")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DCW + Storm bolter", "Dreadnought combat weapon + Storm bolter", getPts("Dreadnought combat weapon (Ironclad)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("DCW + Heavy flamer", "Dreadnought combat weapon + Heavy flamer", getPts("Dreadnought combat weapon (Ironclad)") + getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Hurricane bolter", getPts("Hurricane bolter")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 2, getPts("Hunter-killer missile (SM)")));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Troops launchers", 1, getPts("Ironclad assault launchers")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}
