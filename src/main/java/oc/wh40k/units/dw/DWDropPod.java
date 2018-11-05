package oc.wh40k.units.dw;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DWDropPod extends Eintrag {

    OptionsUpgradeGruppe o2;

    public DWDropPod() {
        name = "Drop Pod";
        grundkosten = 35;

        add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederStorm.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10));

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
    }

}

