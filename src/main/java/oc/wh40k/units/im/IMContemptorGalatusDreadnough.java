package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMContemptorGalatusDreadnough extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public IMContemptorGalatusDreadnough() {
        name = "Contemptor-Galatus Dreadnought";
        grundkosten = getPts("Contemptor-Galatus");
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Galatus warblade", getPts("Galatus warblade") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Galatus shield", getPts("Galatus shield")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
