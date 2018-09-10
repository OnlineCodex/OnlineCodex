package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class HHCAMoritat extends Eintrag {

	RuestkammerStarter Servo;

	public HHCAMoritat() {
		name = "Moritat";
		grundkosten = 85;
		setCountToMinimum(false);

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, false, true, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);		
		

		complete();
	}

	

	@Override
	public void refreshen() {
				
		
	}

}
