package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class IMRelicLandRaiderProteus extends Eintrag {



    OptionsUpgradeGruppe o1, o2;



    public IMRelicLandRaiderProteus() {

        name = "Relic Land Raider Proteus";

        grundkosten = getPts("Relic Land Raider Proteus") + 2 * getPts("Twin lascannon");

        power = 20;



        seperator();



        /*Auswahl von Explorator Augury Web ODER Heavy Armour Ability*/



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy flamer")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

