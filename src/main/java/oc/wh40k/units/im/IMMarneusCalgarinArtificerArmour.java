package oc.wh40k.units.im;

import oc.Eintrag;

public class IMMarneusCalgarinArtificerArmour extends Eintrag {

    public IMMarneusCalgarinArtificerArmour() {
        name = "Marneus Calgar in Artificer Armour";
        grundkosten = getPts("Marneus Calgar in Artificer Armour");
        power = 12;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
