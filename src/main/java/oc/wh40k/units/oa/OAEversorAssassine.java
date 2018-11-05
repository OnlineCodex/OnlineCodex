package oc.wh40k.units.oa;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class OAEversorAssassine extends Eintrag {

    RuestkammerStarter rkTransport;

    public OAEversorAssassine() {
        name = "Eversor Assassine";
        grundkosten = 135;

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
