package oc.wh40k.units.or;

import oc.Eintrag;

public class ORGrotBommLauncha extends Eintrag {

    public ORGrotBommLauncha() {
        name = "Grot Bomm Launcha";
        grundkosten = 35;


        add(ico = new oc.Picture("oc/wh40k/images/GrotBommLauncha.gif"));


        complete();

    }

}
