package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHRenegadeKnightCastigator extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public CHRenegadeKnightCastigator() {
        name = "Renegade Knight Castigator";
        grundkosten = getPts("Renegade Knight Castigator");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Castigator bolt cannon", getPts("Castigator bolt cannon")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tempest warblade", getPts("Tempest warblade")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        power = 25;
    }

}
