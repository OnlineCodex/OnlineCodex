package oc.wh40k.units.im;

import oc.Eintrag;

public class IMVulkanHestan extends Eintrag {

    public IMVulkanHestan() {
        name = "Vulkan He'stan";
        grundkosten = getPts("Vulkan He'stan");
        power = 8;
        
        seperator();

        addWarlordTraits("Salamanders: Anvil of Strength", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}