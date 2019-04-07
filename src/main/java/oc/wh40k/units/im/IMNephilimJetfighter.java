package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class IMNephilimJetfighter extends Eintrag {



	public IMNephilimJetfighter() {

        name = "Nephilim Jetfighter";

        grundkosten = getPts("Nephilim Jetfighter") + getPts("Twin heavy bolter (SM)") + 2 * getPts("Blacksword missile launcher");

        power = 9;

        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Avenger mega bolter", getPts("Avenger mega bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));

        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

