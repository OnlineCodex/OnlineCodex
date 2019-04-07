package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class NEWarriorsKammer extends RuestkammerVater {

	private AnzahlPanel squad;
	private RuestkammerStarter rkTransport;

    public NEWarriorsKammer() {
        grundkosten = 0;
    }

    @Override
	public void initButtons(boolean... defaults) {
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Necron-Warriors", 5, 20, 13);
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
