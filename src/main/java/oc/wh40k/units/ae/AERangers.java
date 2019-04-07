package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;



public class AERangers extends Eintrag {



	private final AnzahlPanel squad;



    public AERangers() {

        name = "Rangers";

        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Rangers", 5, 10, getPts("Rangers") + getPts("Shuriken pistol") +

                getPts("Ranger long rifle")));

        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 5) {

            power = 10;

        } else {

            power = 5;

        }

    }

}