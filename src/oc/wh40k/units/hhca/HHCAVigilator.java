package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class HHCAVigilator extends Eintrag {

	RuestkammerStarter Servo;

	public HHCAVigilator() {
		name = "Vigilator";
		grundkosten = 95;

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, false, false, false, false, true);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);		
		

		complete();
	}

	

	@Override
	public void refreshen() {
				
		
	}

}
