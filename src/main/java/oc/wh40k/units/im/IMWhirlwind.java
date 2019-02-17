package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMWhirlwind extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMWhirlwind() {
        name = "Whirlwind";
        grundkosten = getPts("Whirlwind");
        power = 6;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Vengeance launcher", getPts("Whirlwind Vengeance launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Castellan launcher", getPts("Whirlwind Castellan launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
