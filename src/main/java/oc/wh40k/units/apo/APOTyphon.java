//APO2

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOTyphon extends Eintrag {

    OptionsUpgradeGruppe o6;

    public APOTyphon() {
        name = "Typhon";
        grundkosten = 350;


        add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy bolter", "pintle mounted heavy bolter", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy flamer", "pintle mounted heavy flamer", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", "pintle mounted multi-melta", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", 40));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();

    }

    public void refreshen() {

    }
}
