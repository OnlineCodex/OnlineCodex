package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;


public class ORFlakkTrukk extends Eintrag {

    public ORFlakkTrukk() {
        name = "Flakk Trukk";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/GunTrukk.gif"));

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORFlakkTrukkKammer(), "Flakk Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORFlakkTrukkKammer(), "Flakk Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORFlakkTrukkKammer(), "Flakk Trukk"));

        complete();
    }
}