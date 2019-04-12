package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMContemptorDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o2;

    public IMContemptorDreadnought() {
        name = "Contemptor Dreadnought";
        grundkosten = getPts("Contemptor Dreadnought") +
                getPts("Dreadnought combat weapon (other models)") +
                getPts("Combi-bolter");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Kheres assault cannon", "Kheres patternassault cannon", getPts("Kheres patternassault cannon")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
    }
}
