package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMOrdnanceTank extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;

    public AMOrdnanceTank() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Basilisk", 125));
        ogE.addElement(new OptionsGruppeEintrag("Griffon", 75));
        ogE.addElement(new OptionsGruppeEintrag("Medusa", 135));
        ogE.addElement(new OptionsGruppeEintrag("Colossus", 140));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enclosed crew compartment", 15));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bastion-breacher shells", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        oe3.setAktiv(o1.isSelected("Medusa"));

    }

}
