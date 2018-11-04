package oc.wh40k.units.ab;

import oc.*;

public class ABCompanyCommandTank extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe o5;
    OptionsEinzelUpgrade shell1;
    OptionsEinzelUpgrade shell2;
    OptionsEinzelUpgrade shell3;
    OptionsEinzelUpgrade shell4;
    RuestkammerStarter rkAceCrew;

    boolean mutex = false;

    public ABCompanyCommandTank() {
        name = "Company Command Tank";
        grundkosten = 160;

        add(ico = new oc.Picture("oc/wh40k/images/ABCompanyCommandTank.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Battle cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Exterminator", "Exterminator autocannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("Conqueror", "Conqueror cannon and co-axial storm bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Annihilator", "T/L Annihilator autocannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vanquisher", "Vanquisher battle cannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Eradicator", "Eradicator Nova cannon", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", "Pair of heavy bolters", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 heavy flamers", "Pair of heavy flamers", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 multi-meltas", "Pair of multi-meltas", 30));
        ogE.addElement(new OptionsGruppeEintrag("2 plasma cannons", "Pair of plasma cannons", 40));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Co-axial storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Co-axial heavy stubber", 10));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("AA Heavy stubber", "Anti-aircraft mount heavy stubber", 15));
        ogE.addElement(new OptionsGruppeEintrag("AA Storm bolter", "Anti-aircraft mount storm bolter", 15));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozerblade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Mine plough", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Artificer hull", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured track guards", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Improved comms", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Anti-grenade mesh", 15));

        seperator();

        add(shell1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum Shells", 10));
        add(shell2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Beast Hunter Shells", 15));
        add(shell3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Augur Shells", 20));
        add(shell4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infernus Shells", 5));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o4.setAktiv(o1.isSelected("Vanquisher battle cannon"));

        shell1.setAktiv(o1.isSelected("Battle cannon") || o1.isSelected("Vanquisher battle cannon") || o1.isSelected("Eradicator Nova cannon") || o1.isSelected("Conqueror cannon and co-axial storm bolter"));
        shell2.setAktiv(o1.isSelected("Vanquisher battle cannon"));
        shell3.setAktiv(o1.isSelected("Conqueror cannon and co-axial storm bolter"));
        shell4.setAktiv(o1.isSelected("Battle cannon"));
    }

}
