package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Monster;
import oc.wh40k.units.Unique;
import oc.wh40k.units.necrons.Necrons.CTanShards;

public class CTanShardOfTheNightbringer extends Eintrag
        implements Necrons, CTanShards, Elite, CharacterModel, Monster, Unique<CTanShardOfTheNightbringer>, Necrons.CTanShardOfTheNightbringer {

    public CTanShardOfTheNightbringer() {
        name = "C'tan Shard of the Nightbringer";
        grundkosten = getPts("C'tan Shard of the Nightbringer");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
        
        seperator();

        addWarlordTraits("", false);

        complete();
    }
}