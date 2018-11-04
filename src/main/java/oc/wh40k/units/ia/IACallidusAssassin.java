package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IACallidusAssassin extends Eintrag {

    RuestkammerStarter rkTransport;

    public IACallidusAssassin() {
        name = "Callidus Assassine";
        grundkosten = 145;

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
