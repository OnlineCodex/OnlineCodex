package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMChimaereIA1 extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o1x;
    OptionsUpgradeGruppe o2x;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public AMChimaereIA1() {
        grundkosten = 55;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
        add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", 0));
        add(o2x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o1x.setSelected(0, !o1.isSelected());
        o2x.setSelected(0, !o2.isSelected());
    }

}
