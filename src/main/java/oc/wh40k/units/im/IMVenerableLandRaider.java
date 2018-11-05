package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class IMVenerableLandRaider extends Eintrag {



    OptionsUpgradeGruppe o1, o2;



    public IMVenerableLandRaider() {

        name = "Venerable Land Raider";

        grundkosten = getPts("Venerable Land Raider");

        power = 19;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (AC)")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));





        ogE.addElement(new OptionsGruppeEintrag("Two twin lascannon", 2 * getPts("Twin lascannon (AC)")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AC)")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AC)")));



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

        o2.alwaysSelected();

    }

}

