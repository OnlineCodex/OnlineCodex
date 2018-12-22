package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.DedicatedTransport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Transport;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class GhostArk extends Eintrag<Necrons, DedicatedTransport> implements Vehicle, Transport, Fly {

    public GhostArk() {
        name = "Ghost Ark";
        grundkosten = getPts("Ghost Ark") + getPts("Gauss flayer array") * 2;
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        complete();
    }
}