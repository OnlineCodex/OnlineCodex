package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKHellhound extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade dozer;
    OptionsEinzelUpgrade mine;

    public DKHellhound() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Devil dog", 120));
        ogE.addElement(new OptionsGruppeEintrag("Hellhound", 130));
        ogE.addElement(new OptionsGruppeEintrag("Bane wolf", 130));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));

        seperator();

        add(dozer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 5));
        add(mine = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());


        dozer.setAktiv(!mine.isSelected());
        mine.setAktiv(!dozer.isSelected());
    }

}
