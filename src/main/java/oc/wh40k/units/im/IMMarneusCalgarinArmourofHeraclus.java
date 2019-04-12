package oc.wh40k.units.im;

import oc.Eintrag;

public class IMMarneusCalgarinArmourofHeraclus extends Eintrag {

    public IMMarneusCalgarinArmourofHeraclus() {
        name = "Marneus Calgar in Armour of Heraclus";
        grundkosten = getPts("Marneus Calgar in Armour of Heraclus");
        power = 11;

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
