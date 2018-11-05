package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class AMThundererSiegeTank extends RuestkammerVater {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public AMThundererSiegeTank() {
        grundkosten = 140;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", "Pintle-mounted Heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", "Pintle-mounted Storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }

}
