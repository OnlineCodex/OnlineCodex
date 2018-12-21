package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.DedicatedTransport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Transport;
import oc.wh40k.units.UnitType.Vehicle;

public class GhostArk extends Eintrag<Necrons, DedicatedTransport, Vehicle> implements Transport, Fly {

    public GhostArk() {
        name = "Ghost Ark";
        grundkosten = getPts("Ghost Ark") + getPts("Gauss flayer array") * 2;
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        complete();
    }
}