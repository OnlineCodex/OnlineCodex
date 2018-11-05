package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHRenegadeKnightMagaera extends Eintrag {

    OptionsUpgradeGruppe o1, o2, o3;

    public CHRenegadeKnightMagaera() {
        name = "Renegade Knight Magaera";
        grundkosten = getPts("Renegade Knight Magaera");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning cannon", getPts("Lightning cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma fusil", getPts("Ectoplasma fusil")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper chainswords")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        power = 28;
    }

}
