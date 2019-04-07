package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;



public class AEClawedFiends extends Eintrag {



	private final AnzahlPanel squad;



    public AEClawedFiends() {

        name = "Clawed Fiends";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Clawed Fiends", 1, 6, getPts("Clawed Fiends") + getPts("Bludgeoning fists"));

        add(squad);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 3) {

            power = 10;

        } else if (squad.getModelle() > 1) {

            power = 5;

        } else {

            power = 2;

        }

    }



}

