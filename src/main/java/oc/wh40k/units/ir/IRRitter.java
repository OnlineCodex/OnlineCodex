package oc.wh40k.units.ir;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IRRitter extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IRRitter() {
        name = "Ritter";
        grundkosten = 0;
        überschriftSetzen = false;

        ogE.addElement(new OptionsGruppeEintrag("Fahrender Ritter", 370));
        ogE.addElement(new OptionsGruppeEintrag("Paladinritter", 375));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
    }

}
