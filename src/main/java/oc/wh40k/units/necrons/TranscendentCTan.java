package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Fly;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.CTanShards;

public class TranscendentCTan extends Eintrag<CTanShards, HeavySupport, Monster> implements CharacterModel, Fly {

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