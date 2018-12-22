package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Source;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.CTanShards;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class CTanShardOfTheDeceiver extends Eintrag<CTanShards, Elite> implements CharacterModel, Monster, Unique<CTanShardOfTheDeceiver> {
	
    public CTanShardOfTheDeceiver() {
        name = "C'tan Shard of the Deceiver";
        grundkosten = getPts("C'tan Shard of the Deceiver");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
        
        seperator();

        addWarlordTraits("", false);

        complete();
    }
}