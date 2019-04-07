package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SALAMANDERS;
import static oc.KeyWord.VULKAN_HESTAN;

import oc.Eintrag;

public class IMVulkanHestan extends Eintrag {

    public IMVulkanHestan() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, SALAMANDERS, CHARACTER, INFANTRY, CAPTAIN, VULKAN_HESTAN);

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