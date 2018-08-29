package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class IARepentiatruppKammer extends RuestkammerVater {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public IARepentiatruppKammer() {}

	public void initButtons(boolean... defaults) {
		name = "Repentiatrupp\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentia", 5, 10, 17);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASRepentiatrupp.jpg"));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASDominatris", "Upgrade zur Dominatris");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ASTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
