package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMInquisitorKaramazov extends Eintrag {

    public IMInquisitorKaramazov() {
    	super(IMPERIUM, INQUISITION, ORDO_HERETICUS);
        name = "Inquisitor Karamazov";
        grundkosten = getPts("Inquisitor Karamazov");
        power = 6;
        
        seperator();
        
		addWarlordTraits("Ordo Hereticus: No Escape", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
