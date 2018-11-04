package oc.wh40k.units.dkab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKABStormChimera extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public DKABStormChimera() {
        grundkosten = 75;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
        ogE.addElement(new OptionsGruppeEintrag("Mine plough", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o2.alwaysSelected();
    }

}
