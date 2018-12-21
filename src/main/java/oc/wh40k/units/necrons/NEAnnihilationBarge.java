package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NEAnnihilationBarge extends Eintrag {

    OptionsUpgradeGruppe o1;

    public NEAnnihilationBarge() {
        name = "Annihilation Barge";
        grundkosten = getPts("Annihilation Barge") + getPts("Twin tesla destructor");

        add(ico = new oc.Picture("oc/wh40k/images/NEAnnihilatorGleiter.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss cannon", getPts("Gauss cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Tesla cannon", getPts("Tesla cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        power = 8;
    }

}
