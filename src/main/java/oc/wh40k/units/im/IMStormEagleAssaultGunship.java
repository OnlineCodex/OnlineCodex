//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class IMStormEagleAssaultGunship extends Eintrag {



	private final OptionsZaehlerGruppe o1, o2;



    public IMStormEagleAssaultGunship() {

        name = "Storm Eagle Assault Gunship";

        grundkosten = getPts("Storm Eagle Assault Gunship") + getPts("Vengeance launcher");

        power = 18;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 twin hellstrike missile launchers", 2 * getPts("Twin hellstrike missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("2 twin lascannon", 2 * getPts("Twin lascannon")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

