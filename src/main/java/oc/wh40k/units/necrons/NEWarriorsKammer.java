package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class NEWarriorsKammer extends RuestkammerVater {

    AnzahlPanel squad;
    RuestkammerStarter rkTransport;

    public NEWarriorsKammer() {
        grundkosten = 0;
    }

    public void initButtons(boolean... defaults) {
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Necrons-Warriors", 5, 20, 13);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEWarriors.jpg"));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, NETransporterKammer.class, "Transporter");
        rkTransport.initKammer(true, true);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        sizeSetzen();
    }
}
