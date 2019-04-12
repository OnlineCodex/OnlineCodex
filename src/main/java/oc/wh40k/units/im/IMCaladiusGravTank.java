package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMCaladiusGravTank extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMCaladiusGravTank() {
        name = "Caladius Grav-tank";
        grundkosten = getPts("Caladius Grav-tank");
        power = 16;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin Iliastus accelerator cannon", getPts("Twin Iliastus accelerator cannon")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin Lastrum bolt cannon", getPts("Twin Lastrum bolt cannon")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
