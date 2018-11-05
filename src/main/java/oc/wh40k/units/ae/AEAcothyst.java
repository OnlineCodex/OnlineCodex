package oc.wh40k.units.ae;



import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerVater;



public class AEAcothyst extends RuestkammerVater {



    OptionsUpgradeGruppe o1, o2;



    public AEAcothyst() {

    }



    @Override

    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Haemonculus tools", getPts("Haemonculus tools")));

        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));

        ogE.addElement(new OptionsGruppeEintrag("Electrocorrosive whip", getPts("Electrocorrosive whip")));

        ogE.addElement(new OptionsGruppeEintrag("Flesh gauntlet", getPts("Flesh gauntlet")));

        ogE.addElement(new OptionsGruppeEintrag("Mindphase gauntlet", getPts("Mindphase gauntlet")));

        ogE.addElement(new OptionsGruppeEintrag("Scissorhand", getPts("Scissorhand")));

        ogE.addElement(new OptionsGruppeEintrag("Venom blade", getPts("Venom blade")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Hexrifle", getPts("Hexrifle")));

        ogE.addElement(new OptionsGruppeEintrag("Liquifier gun", getPts("Liquifier gun")));

        ogE.addElement(new OptionsGruppeEintrag("Stinger pistol", getPts("Stinger pistol")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        sizeSetzen();

    }



    @Override

    public void refreshen() {

    }



}

