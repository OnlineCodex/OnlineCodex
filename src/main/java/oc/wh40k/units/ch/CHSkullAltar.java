package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHSkullAltar extends Eintrag {

    public CHSkullAltar() {

        kategorie = 1;

        name = "Skull Altar";
        grundkosten = getPts("Skull Altar");

        power = 5;

        complete();
    }


    @Override
    public void refreshen() {

    }
}
