package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKromDragongaze extends Eintrag {


    public IMKromDragongaze() {
        name = "Krom Dragongaze";
        grundkosten = getPts("Krom Dragongaze");
        power = 6;

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
