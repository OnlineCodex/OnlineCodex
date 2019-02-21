package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class AEVenom extends Eintrag {



	private final OptionsUpgradeGruppe o1, o2;



    public AEVenom() {

        name = "Venom";

        grundkosten = getPts("Venom") + +getPts("Bladevanes");



        power = 4;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin splinter rifle", getPts("Twin splinter rifle")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chain-snares", getPts("Chain-snares")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grisly trophies", getPts("Grisly trophies")));



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

        o2.alwaysSelected();

    }

}