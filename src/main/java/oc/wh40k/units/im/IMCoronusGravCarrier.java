package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMCoronusGravCarrier extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMCoronusGravCarrier() {
        name = "Coronus Grav-carrier";
        grundkosten = getPts("Coronus Grav-carrier");
        power = 19;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin Arachnus las-blaze", getPts("Twin Arachnus las-blaze")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin Lastrum bolt cannon", getPts("Twin Lastrum bolt cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
