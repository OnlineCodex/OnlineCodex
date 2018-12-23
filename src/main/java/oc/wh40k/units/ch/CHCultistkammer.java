package oc.wh40k.units.ch;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHCultistkammer extends RuestkammerVater {

    public CHCultistkammer(boolean twistbray) {
        OptionsUpgradeGruppe o2;
        if (twistbray) {
            ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffen", "Nahkampfwaffen", 0));
            ogE.addElement(new OptionsGruppeEintrag("Pistole & Schwert", "Autopistole & Kettenschwert", 1));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected(0, true);
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Autogun", "Autogun", getPts("Autogun")));
            ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Shotgun", getPts("Shotgun")));
            ogE.addElement(new OptionsGruppeEintrag("Pistole & Weapon", "Autopistol and brutal assault weapon", getPts("Autopistole") + getPts("Brutal assault weapon")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected(0, true);

            setUeberschrift("Kultistenchampion");
        }

        sizeSetzen();
    }
}