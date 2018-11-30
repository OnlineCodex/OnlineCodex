package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptainGeneralTrajannValoris extends Eintrag {
	

    public IMCaptainGeneralTrajannValoris() {
        name = "Captain-General Trajann Valoris";
        grundkosten = getPts("Captain-General Trajann Valoris");
        power = 10;
        
        seperator();

        addWarlordTraits("Champion of the Imperium (AC)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
