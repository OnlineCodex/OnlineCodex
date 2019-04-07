//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMChaplainVenerableDreadnought extends Eintrag {



	public IMChaplainVenerableDreadnought() {

        name = "Chaplain Venerable Dreadnought";

        grundkosten = getPts("Chaplain Venerable Dreadnought") + getPts("Dreadnought combat weapon");

        power = 11;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Dreadnought CW & storm bolter", "Dreadnought combat weapon & storm bolter", getPts("Dreadnought combat weapon") + getPts("Storm bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought CW & heavy flamer", "Dreadnought combat weapon & heavy flamer", getPts("Dreadnought combat weapon") + getPts("Heavy flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought inferno cannon", getPts("Dreadnought inferno cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {



    }

}

