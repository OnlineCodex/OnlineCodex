package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHCerasatusKnightAtropos extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public CHCerasatusKnightAtropos() {
        name = "Cerasatus Knight Atropos";
        grundkosten = getPts("Cerasatus Knight Atropos");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Atropos lascutter", getPts("Atropos lascutter")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Graviton singularity", getPts("Graviton singularity")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        power = 25;
    }

}
