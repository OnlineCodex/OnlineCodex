//Experimental Rules

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicSicaranArcusStrikeTank extends Eintrag {



	public IMRelicSicaranArcusStrikeTank() {

        name = "Relic Sicaran Arcus Strike Tank";

        grundkosten = getPts("Relic Sicaran Arcus Strike Tank") + getPts("Twin rotary missile launcher") + getPts("Heavy bolter (IA)");

        power = 16;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 2 * getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("2 Lascannon", 2 * getPts("Lascannon (IA)")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

