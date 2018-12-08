package oc.wh40k.units.im;

import oc.Eintrag;

public class IMOfficeroftheFleet extends Eintrag {

    public IMOfficeroftheFleet() {
        name = "Officer of the Fleet";
        grundkosten = getPts("Officer of the Fleet") + getPts("Laspistol");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/IGCaptainThanstadt.jpg"));
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}