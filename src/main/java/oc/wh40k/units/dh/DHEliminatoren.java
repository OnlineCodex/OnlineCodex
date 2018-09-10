package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DHEliminatoren extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	public DHEliminatoren() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Eliminatoren", 5, 10, 19);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEEliminatoren.jpg"));

        seperator();;

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DHTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
