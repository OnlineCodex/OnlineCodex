package oc.wh40k.units.necrons;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class NETombCitadel extends Eintrag {



    OptionsZaehlerGruppe o1;



    public NETombCitadel() {

        name = "Tomb Citadel";

        grundkosten = getPts("TombCitadel");

        power = 40;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Tesla destructor", getPts("Tesla destructor")));

        ogE.addElement(new OptionsGruppeEintrag("Gauss exterminator", getPts("Gauss exterminator")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

