package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class HHCAApothecarionDetachment extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public HHCAApothecarionDetachment() {
		name = "Apothecarion Detachment";
		grundkosten = 0;
        überschriftSetzen = true;

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAApothecaryKammer", "Apothecary");
		t1.initKammer();
		t1.setAbwaehlbar(false);
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAApothecaryKammer", "Apothecary");
		t2.initKammer();
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAApothecaryKammer", "Apothecary");
		t3.initKammer();
		add(t3);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            }

}
