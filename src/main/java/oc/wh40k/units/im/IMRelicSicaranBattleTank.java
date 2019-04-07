//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicSicaranBattleTank extends Eintrag {



	public IMRelicSicaranBattleTank() {

        name = "Relic Sicaran Battle Tank";

        grundkosten = getPts("Relic Sicaran Battle Tank") + getPts("Twin accelerator autocannon") + getPts("Heavy bolter (IA)");

        power = 14;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", 2 * getPts("Heavy bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", 2 * getPts("Lascannon (IA)")));

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

