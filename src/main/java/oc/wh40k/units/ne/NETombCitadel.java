package oc.wh40k.units.ne;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class NETombCitadel extends Eintrag {



	public NETombCitadel() {

        name = "Tomb Citadel";

        grundkosten = getPts("TombCitadel");

        power = 40;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Tesla destructor", getPts("Tesla destructor")));

        ogE.addElement(new OptionsGruppeEintrag("Gauss exterminator", getPts("Gauss exterminator")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

