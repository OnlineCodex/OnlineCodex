package oc.wh40k.units.cd;

import oc.Eintrag;


public class CDAetaosraukeresSlayerofSouls extends Eintrag {

    public CDAetaosraukeresSlayerofSouls() {
        name = "Aetaos'rau'keres - Slayer of Souls";
        grundkosten = 999;

        add(ico = new oc.Picture("oc/wh40k/images/AetaosraukeresSlayerofSouls.gif"));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

    }

}
