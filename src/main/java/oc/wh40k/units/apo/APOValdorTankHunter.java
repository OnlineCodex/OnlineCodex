package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOValdorTankHunter extends Eintrag {

    OptionsUpgradeGruppe o1;

    public APOValdorTankHunter() {
        name = "Valdor Tank Hunter";
        grundkosten = 320;


        add(ico = new oc.Picture("oc/wh40k/images/ValdorTankHunter.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
        ogE.addElement(new OptionsGruppeEintrag("heavy flamers", "sponsons with heavy flamers", 5));
        ogE.addElement(new OptionsGruppeEintrag("heavy bolters", "sponsons with heavy bolters", 5));
        ogE.addElement(new OptionsGruppeEintrag("autocannons", "sponsons with autocannons", 10));
        ogE.addElement(new OptionsGruppeEintrag("lascannons", "sponsons with lascannons", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();

    }

    public void refreshen() {
        o1.alwaysSelected();
    }
}
