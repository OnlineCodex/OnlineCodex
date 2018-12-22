package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.CTanShards;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class TranscendentCTan extends Eintrag<CTanShards, HeavySupport> implements CharacterModel, Monster, Fly {

    public TranscendentCTan() {
        name = "Transcendent C'tan";
        grundkosten = getPts("Transcendent C'tan") + getPts("Crackling tendrils");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));
        
        seperator();

        addWarlordTraits("", false);

        complete();
    }
}