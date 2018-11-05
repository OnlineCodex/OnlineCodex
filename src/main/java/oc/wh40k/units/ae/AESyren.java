package oc.wh40k.units.ae;



import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerVater;



public class AESyren extends RuestkammerVater {



    OptionsUpgradeGruppe o1, o2;



    public AESyren() {

    }



    @Override

    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Hekatarii blade", getPts("Hekatarii blade")));

        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));

        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setSelected(0, true);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));

        ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast pistol")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o2.setSelected(0, true);



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));



        sizeSetzen();

    }



    @Override

    public void refreshen() {

    }

}

