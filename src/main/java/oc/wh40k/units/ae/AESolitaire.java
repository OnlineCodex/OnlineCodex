package oc.wh40k.units.ae;



import oc.Eintrag;



public class AESolitaire extends Eintrag {



    public AESolitaire() {

        name = "Solitaire";

        grundkosten = getPts("Solitaire") + getPts("Harlequin's caress") + getPts("Harlequin's kiss");

        power = 6;

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

    }

}