package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;



public class AEMandrakes extends Eintrag {



    AnzahlPanel squad;



    public AEMandrakes() {

        name = "Mandrakes";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Mandrakes", 5, 10, getPts("Mandrakes") +

                getPts("Bale blast") + getPts("Glimmersteel blade"));

        add(squad);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 5) {

            power = 9;

        } else {

            power = 5;

        }

    }



}

