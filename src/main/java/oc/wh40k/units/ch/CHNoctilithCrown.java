package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHNoctilithCrown extends Eintrag {

    public CHNoctilithCrown() {

        kategorie = 1;

        name = "Noctilith Crown";
        grundkosten = getPts("Noctilith Crown");

        power = 5;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
