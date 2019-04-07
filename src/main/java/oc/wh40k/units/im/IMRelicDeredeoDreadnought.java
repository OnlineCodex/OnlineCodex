//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicDeredeoDreadnought extends Eintrag {



	public IMRelicDeredeoDreadnought() {

        name = "Relic Deredeo Dreadnought";

        grundkosten = getPts("Relic Deredeo Dreadnought");

        power = 14;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy flamer")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Aiolos missile launcher", getPts("Aiolos missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Atomantic pavaise", getPts("Atomantic pavaise")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Anvillus autocannon battery", getPts("Anvillus autocannon battery")));

        ogE.addElement(new OptionsGruppeEintrag("Hellfire plasma carronade", getPts("Hellfire plasma carronade")));

        ogE.addElement(new OptionsGruppeEintrag("Arachnus heavy lascannon battery", getPts("Arachnus heavy lascannon battery")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

