package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMImagifier extends Eintrag {

    public IMImagifier() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, CHARACTER, INFANTRY, IMAGIFIER);
        name = "Imagifier";
        grundkosten = getPts("Imagifier");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

        seperator();

        addWeapons(IMAdeptaSororitasRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
