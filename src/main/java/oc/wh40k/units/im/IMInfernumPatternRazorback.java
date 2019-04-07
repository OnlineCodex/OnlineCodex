package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;



public class IMInfernumPatternRazorback extends Eintrag {



    public IMInfernumPatternRazorback() {

        name = "Infernum Pattern Razorback";

        grundkosten = getPts("Infernum Pattern Razorback") + getPts("Multi-melta");

        power = 5;



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

