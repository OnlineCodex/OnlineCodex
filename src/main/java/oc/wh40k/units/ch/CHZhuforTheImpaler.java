package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHZhuforTheImpaler extends Eintrag {

    public CHZhuforTheImpaler() {

        name = "Zhufor the Impaler";
        grundkosten = getPts("Zhufor the Impaler");
        power = 8;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
