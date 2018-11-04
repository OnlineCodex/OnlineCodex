package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMTrojan extends RuestkammerVater {

    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public AMTrojan() {
        grundkosten = 35;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

        sizeSetzen();
    }

    // @OVERRIDE
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o2.alwaysSelected();
    }

}
