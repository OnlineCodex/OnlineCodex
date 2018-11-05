package oc.wh40k.units.oa;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class OACulexusAssassine extends Eintrag {

    RuestkammerStarter rkTransport;

    public OACulexusAssassine() {
        name = "Culexus Assassine";
        grundkosten = 140;

        add(ico = new oc.Picture("oc/wh40k/images/IGCommissarYarrick.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
