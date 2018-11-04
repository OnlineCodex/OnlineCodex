package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMContemptorAchillusDreadnought extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public IMContemptorAchillusDreadnought() {
        name = "Contemptor-Achillus Dreadnought";
        grundkosten = getPts("Contemptor-Achillus");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two lastrum storm bolters", getPts("Lastrum storm bolter") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Achillus dreadspear", getPts("Achillus dreadspear")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
