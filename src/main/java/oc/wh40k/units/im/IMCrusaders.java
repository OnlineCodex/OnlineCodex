package oc.wh40k.units.im;



import oc.AnzahlPanel;

import oc.Eintrag;



public class IMCrusaders extends Eintrag {



    AnzahlPanel squad;



    public IMCrusaders() {

        name = "Crusaders";

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crusaders", 2, 10, getPts("Crusaders") + getPts("Power sword (AM)")));

        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 8) {

            power = 5;

        } else if (squad.getModelle() > 6) {

            power = 4;

        } else if (squad.getModelle() > 4) {

            power = 3;

        } else if (squad.getModelle() > 2) {

            power = 2;

        } else {

            power = 1;

        }

    }

}