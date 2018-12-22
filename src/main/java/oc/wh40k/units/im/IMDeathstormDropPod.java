package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDeathstormDropPod extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMDeathstormDropPod() {
        name = "Deathstorm Drop Pod";
        grundkosten = getPts("Deathstorm Drop Pod");
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/SMDeathwindDropPod.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Deathstorm missile array", getPts("Deathstorm missile array")));
        ogE.addElement(new OptionsGruppeEintrag("Deathstorm cannon array", getPts("Deathstorm cannon array")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        //seperator();

        //add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Drop Pod Troops SR",25));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
