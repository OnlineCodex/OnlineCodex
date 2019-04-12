package oc.wh40k.units.ae;

import static oc.KeyWord.HAEMUNCULUS_COVEN;

import oc.Eintrag;

public class AEUrienRakarth extends Eintrag {

    public AEUrienRakarth() {
        name = "Urien Rakarth";
        grundkosten = getPts("Urien Rakarth");
        power = 6;

        seperator();

        addWarlordTraits("Prophets of Flesh: Diabolical Soothsayer", HAEMUNCULUS_COVEN);

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}