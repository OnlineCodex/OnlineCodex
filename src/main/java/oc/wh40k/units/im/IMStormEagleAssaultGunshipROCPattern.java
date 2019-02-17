//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class IMStormEagleAssaultGunshipROCPattern extends Eintrag {



	private final OptionsZaehlerGruppe o1;



    public IMStormEagleAssaultGunshipROCPattern() {

        name = "Storm Eagle Assault Gunship - ROC Pattern";

        grundkosten = getPts("Storm Eagle Assault Gunship - ROC Pattern") + 2 * getPts("Twin lascannon") + getPts("ROC missile launcher");

        power = 19;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

