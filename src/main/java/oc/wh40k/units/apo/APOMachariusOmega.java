package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOMachariusOmega extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public APOMachariusOmega() {
        name = "Macharius Omega";
        grundkosten = 355;


        add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolters", "Side Sponsons with Heavy Bolters", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamers", "Side Sponsons with Heavy Flamers", 10));
        ogE.addElement(new OptionsGruppeEintrag("Autocannons", "Side Sponsons with Autocannons", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();

    }

    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }
}
