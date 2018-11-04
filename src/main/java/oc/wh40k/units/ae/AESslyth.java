package oc.wh40k.units.ae;

import oc.Eintrag;

public class AESslyth extends Eintrag {

    public AESslyth() {
        name = "Sslyth";
        grundkosten = getPts("Sslyth") + getPts("Shardcarbine") + getPts("Splinter pistol") + getPts("Sslyth battle-blade");
        power = 3;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}