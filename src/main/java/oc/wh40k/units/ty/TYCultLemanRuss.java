package oc.wh40k.units.ty;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class TYCultLemanRuss extends Eintrag {



    OptionsUpgradeGruppe o1;

    OptionsUpgradeGruppe o2;

    OptionsUpgradeGruppe o3;

    OptionsEinzelUpgrade pask;

    OptionsEinzelUpgrade oe1;

    OptionsEinzelUpgrade oe2;



    boolean paskSelected = false;



    public TYCultLemanRuss() {

        grundkosten = getPts("Cult Leman Russ");

        power = 9;



        ogE.addElement(new OptionsGruppeEintrag("Battle Cannon", getPts("Battle Cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Exterminator Autocannon", getPts("Exterminator Autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("Vanquisher battle cannon", getPts("Vanquisher battle cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Eradicator nova cannon", getPts("Eradicator nova cannon")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setSelected(0, true);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o2.setSelected(0, true);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter") * 2));

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer") * 2));

        ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", getPts("Multi-melta") * 2));

        ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", getPts("Plasma cannon") * 2));

        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter")));

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile")));

    }



    @Override

    public void refreshen() {

        if (!o1.isSelected()) o1.setSelected(0, true);

        if (!o2.isSelected()) o2.setSelected(0, true);



        oe1.setAktiv(!oe2.isSelected());

        oe2.setAktiv(!oe1.isSelected());

    }



}

