package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORSquiggoth extends Eintrag {
    OptionsUpgradeGruppe o1;

    public ORSquiggoth() {
        name = "Squiggoth (FW)";
        grundkosten = getPts("Squiggoth") + getPts("gorin' horns");
        power = 12;

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", getPts("Lobba")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap Gun", getPts("Zzap Gun")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
    }

}
