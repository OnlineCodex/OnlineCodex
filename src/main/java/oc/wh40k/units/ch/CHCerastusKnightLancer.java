package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHCerastusKnightLancer extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public CHCerastusKnightLancer() {
        name = "Cerastus Knight Lancer";
        grundkosten = getPts("Cerastus Knight Lancer");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Cerastus shock lance", getPts("Cerastus shock lance")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();

        power = 24;
    }

}
