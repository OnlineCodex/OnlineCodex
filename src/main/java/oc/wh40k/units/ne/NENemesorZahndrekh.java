package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NENemesorZahndrekh extends Eintrag {
	

    public NENemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}

