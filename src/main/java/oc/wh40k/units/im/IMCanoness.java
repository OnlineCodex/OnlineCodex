package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCanoness extends Eintrag {

    public IMCanoness() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, CHARACTER, INFANTRY, CANONESS);
        name = "Canoness";
        grundkosten = getPts("Canoness");
        power = 3;

        add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

        seperator();

        addWeapons(new IMAdeptaSororitasRuestkammer(name, getKeywords()), true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
