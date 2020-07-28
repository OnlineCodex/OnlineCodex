package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMPredator extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMPredator() {
        name = "Predator";
        grundkosten = getPts("Predator");
        power = 9;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Predator autocannon", getPts("Predator autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", getPts("Heavy Bolter (SM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 lascannons", getPts("Lascannon (SM other)") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
