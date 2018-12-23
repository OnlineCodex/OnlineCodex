package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class NEWarriorsKammer extends RuestkammerVater {
    public NEWarriorsKammer() {
        add(new AnzahlPanel(ID, randAbstand, cnt, "Necron-Warriors", 5, 20, 13));

        add(ico = new oc.Picture("oc/wh40k/images/NEWarriors.jpg"));

        seperator();

        RuestkammerStarter rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, new NETransporterKammer(true, true), "Transporter");
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        sizeSetzen();
    }
}
