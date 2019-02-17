//Experimental Rules

package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class IMRelicSicaranOmegaTankDestroyer extends Eintrag {



	private final OptionsEinzelUpgrade oe1, oe2;

	private final OptionsZaehlerGruppe o1;



    public IMRelicSicaranOmegaTankDestroyer() {

        name = "Relic Sicaran Omega Tank Destroyer";

        grundkosten = getPts("Relic Sicaran Omega Tank Destroyer") + getPts("Omega plasma array") + getPts("Heavy bolter (IA)");

        power = 16;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 2 * getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("2 Lascannon", 2 * getPts("Lascannon (IA)")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));



        seperator();



        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

