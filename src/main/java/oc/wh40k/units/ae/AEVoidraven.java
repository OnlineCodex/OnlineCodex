package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class AEVoidraven extends Eintrag {



    OptionsUpgradeGruppe o1, o2;



    public AEVoidraven() {

        name = "Voidraven";

        grundkosten = getPts("Voidraven");



        power = 8;



        ogE.addElement(new OptionsGruppeEintrag("2 Void lances", 2 * getPts("Void lance")));

        ogE.addElement(new OptionsGruppeEintrag("2 Dark scythes", 2 * getPts("Dark scythe")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voidraven missiles", getPts("Voidraven missiles")));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }

}