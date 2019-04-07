//IA Adeptus Astartes + FAQ 1.2

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicJavelinAttackSpeeder extends Eintrag {



	public IMRelicJavelinAttackSpeeder() {

        name = "Relic Javelin Attack Speeder";

        grundkosten = getPts("Relic Javelin Attack Speeder");

        power = 9;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", getPts("Hunter-killer missile  (IA)")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

