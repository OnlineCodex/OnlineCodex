package oc.wh40k.units.ty;



import oc.Eintrag;

import oc.OptionsEinzelZaehler;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class TYGoliathRockgrinder extends Eintrag {



    OptionsZaehlerGruppe o1;

    OptionsEinzelZaehler oe1;



    public TYGoliathRockgrinder() {

        name = "Goliath Rockgrinder";

        grundkosten = getPts("Goliath Rockgrinder") + getPts("Heavy stubber");

        power = 6;



        ogE.addElement(new OptionsGruppeEintrag("Heavy mining laser", getPts("Heavy mining laser")));

        ogE.addElement(new OptionsGruppeEintrag("Clearance incinerator", getPts("Clearance incinerator")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy seismic cannon", getPts("Heavy seismic cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cache of demolition charges", 1, getPts("Cache of demolition charges")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}