package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEUrienRakarth extends Eintrag {

    public AEUrienRakarth() {
        name = "Urien Rakarth";
        grundkosten = getPts("Urien Rakarth");
        power = 6;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}