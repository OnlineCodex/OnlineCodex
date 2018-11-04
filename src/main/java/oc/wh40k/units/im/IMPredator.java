package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMPredator extends Eintrag {

    OptionsUpgradeGruppe o1, o2;

    public IMPredator() {
        name = "Predator";
        grundkosten = getPts("Predator");
        power = 9;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Predator autocannon", getPts("Predator autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", getPts("heavy bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 lascannons", getPts("Lascannon (SM)") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
