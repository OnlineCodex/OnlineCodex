package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDDaemonPrinceofChaoswithWings extends Eintrag {

    OptionsUpgradeGruppe waffe1;
    OptionsEinzelUpgrade waffe2;

    public CDDaemonPrinceofChaoswithWings() {

        name = "Daemon Prince of Chaos with Wings";
        grundkosten = getPts("Daemon Prince of Chaos with Wings");
        power = 11;

        ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword")));
        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warp bolter", getPts("Warp bolter")));

        complete();

    }

    @Override
    public void refreshen() {
    }
}
