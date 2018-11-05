package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCaptainGeneralTrajannValoris extends Eintrag {

    public IMCaptainGeneralTrajannValoris() {
        name = "Captain Tycho";
        grundkosten = getPts("Captain-General Trajann Valoris");
        power = 10;
        seperator();
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
