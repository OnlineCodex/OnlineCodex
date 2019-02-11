package oc.wh40k.units.ty;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class TYAbominant extends Eintrag {



    OptionsZaehlerGruppe o1;



    public TYAbominant() {

        name = "Abominant";

        grundkosten = getPts("Abominant") + getPts("Rending claws (GSC)" + getPts("Power sledgehammer"));

        power = 6;

        ogE.addElement(new OptionsGruppeEintrag("Mindwyrm Familiar", getPts("Familiars")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        
        addWarlordTraits("", true);

        complete();

    }



    @Override
    public void refreshen() {
    	o1.setAnzahl(0, 1);
    }



}

