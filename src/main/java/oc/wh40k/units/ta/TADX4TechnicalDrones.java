package oc.wh40k.units.ta;



import oc.AnzahlPanel;
import oc.Eintrag;



public class TADX4TechnicalDrones extends Eintrag {



	private final AnzahlPanel squad;



    public TADX4TechnicalDrones() {

        name = "DX-4 Technical Drones";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "DX-4 Technical Drones", 2, 10, getPts("DX-4 Technical Drones") + getPts("Defensive charge"));

        add(squad);



        complete();

    }



    @Override

    public void refreshen() {

        power = squad.getModelle();

    }

}

