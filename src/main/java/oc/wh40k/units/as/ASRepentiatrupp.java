package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ASRepentiatrupp extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public ASRepentiatrupp() {
		name = "Repentiatrupp\n";
		grundkosten = 15;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentia", 5, 10, 14);
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
		
		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
