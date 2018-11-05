package oc.wh40k.units.dh;

import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DHKanoptechSpinneKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

    boolean added = false;

    public DHKanoptechSpinneKammer() {
        grundkosten = 50;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fabrikatorklauen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zwielichtprisma", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sync. Partikelstrahler", "Synchronisierter Partikelstrahler", 25));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}