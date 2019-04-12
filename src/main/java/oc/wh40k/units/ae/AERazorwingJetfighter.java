package oc.wh40k.units.ae;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class AERazorwingJetfighter extends Eintrag {



	private final OptionsUpgradeGruppe o1, o2;



    public AERazorwingJetfighter() {

        name = "Razorwing Jetfighter";

        grundkosten = getPts("Razorwing Jetfighter") + getPts("Razorwing missile");



        power = 8;



        ogE.addElement(new OptionsGruppeEintrag("2 Disintegrator cannons", 2 * getPts("Disintegrator cannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 Dark lances", 2 * getPts("Dark lance")));

        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin splinter rifle", getPts("Twin splinter rifle")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));

        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 3));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

        o2.alwaysSelected();

    }

}