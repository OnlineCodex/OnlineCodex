package oc.wh40k.units.im;



import oc.AnzahlPanel;

import oc.Eintrag;



public class IMCelestine extends Eintrag {



    AnzahlPanel squad;



    public IMCelestine() {

        name = "Celestine";

        grundkosten = getPts("Celestine");



        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Geminae Superia", 0, 2, getPts("Celestine - Geminae Superia")));



        complete();

    }



    @Override

    public void refreshen() {

        setUnikat(true);

        power = 8 + squad.getModelle() * 3;

    }

}

