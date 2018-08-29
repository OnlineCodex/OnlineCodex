package oc.wh40k.units.fo;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class FOSensorTowerGrid extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public FOSensorTowerGrid() {
		name = "Sensor Tower Grid";
		grundkosten = 0;
		setCountToMinimum(false);
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sensor Tower", "Sensor Towers", 1, 4, 30);
		add(squad);

		add(oe1 =new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Positional Relay",10));
		add(oe2 =new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Homing Beacon",15));
		
		add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));
		
        
        seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        oe1.setPreis(10*squad.getModelle());
        oe2.setPreis(10*squad.getModelle());
	}
}
