package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYOldOneEye extends Eintrag {
	

    public TYOldOneEye() {
        name = "Old One Eye";
        grundkosten = getPts("OldOneEye");
        power = 7;
        add(ico = new oc.Picture("oc/wh40k/images/TYDerSchwarmherrscher.jpg"));
        complete();

        seperator();
        
		addWarlordTraits("", true);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
