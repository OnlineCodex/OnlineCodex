package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;



public class AERazorwingFlocks extends Eintrag {



    AnzahlPanel squad;



    public AERazorwingFlocks() {

        name = "Razorwing Flocks";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Razorwing Flocks", 1, 12, getPts("Razorwing Flocks") + getPts("Claws and talons"));

        add(squad);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 6) {

            power = 4;

        } else if (squad.getModelle() > 3) {

            power = 2;

        } else {

            power = 1;

        }

    }



}

