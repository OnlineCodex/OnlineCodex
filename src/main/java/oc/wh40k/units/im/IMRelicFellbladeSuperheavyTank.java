//IA Adeptus Astartes + FAQ 1.2

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicFellbladeSuperheavyTank extends Eintrag {



	public IMRelicFellbladeSuperheavyTank() {

        name = "Relic Fellblade Super-heavy Tank";

        grundkosten = getPts("Relic Fellblade Super-heavy Tank") + getPts("Demolisher cannon") + getPts("Fellblade accelerator cannon") + getPts("Crushing tracks");

        power = 35;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 quad lascannon", 2 * getPts("Quad lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 laser destroyers", 2 * getPts("Laser destroyer")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", 2 * getPts("Twin heavy flamer")));

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

