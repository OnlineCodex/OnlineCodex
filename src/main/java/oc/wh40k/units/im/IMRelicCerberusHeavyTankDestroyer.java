//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicCerberusHeavyTankDestroyer extends Eintrag {



	public IMRelicCerberusHeavyTankDestroyer() {

        name = "Relic Cerberus Heavy Tank Destroyer";

        grundkosten = getPts("Relic Cerberus Heavy Tank Destroyer") + getPts("Heavy neutron pulse array") + getPts("Crushing tracks");

        power = 26;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 lascannon", 2 * getPts("Lascannon (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", 2 * getPts("Heavy bolter (IA)")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 2 * getPts("Heavy flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 2 * getPts("Storm bolter (IA)")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

