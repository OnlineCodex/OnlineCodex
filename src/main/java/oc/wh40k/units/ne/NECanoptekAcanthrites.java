package oc.wh40k.units.ne;



import oc.AnzahlPanel;

import oc.Eintrag;



public class NECanoptekAcanthrites extends Eintrag {



	private final AnzahlPanel squad;



    public NECanoptekAcanthrites() {

        name = "Canoptek Acanthrites";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Acanthrites", 3, 9, getPts("Canoptek Acanthrites") + getPts("Cutting beam") + getPts("Voidblade"));

        add(squad);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {



        if (squad.getModelle() > 6) {

            power = 27;

        } else if (squad.getModelle() > 3) {

            power = 18;

        } else {

            power = 9;

        }

    }

}

