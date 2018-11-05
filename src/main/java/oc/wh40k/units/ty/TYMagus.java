package oc.wh40k.units.ty;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class TYMagus extends Eintrag {



    OptionsZaehlerGruppe o1;



    public TYMagus() {

        name = "Magus";

        grundkosten = getPts("Magus") + getPts("Autopistol") + getPts("Force stave");

        power = 4;



        ogE.addElement(new OptionsGruppeEintrag("Familiars", getPts("Familiars")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        complete();

    }



    @Override

    public void refreshen() {

    }



}

