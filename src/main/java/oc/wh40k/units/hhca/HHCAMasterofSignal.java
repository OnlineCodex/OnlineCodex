package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class HHCAMasterofSignal extends Eintrag {

	RuestkammerStarter Servo;

	public HHCAMasterofSignal() {
		name = "Master of signal";
		grundkosten = 85;

		addToInformationVector("HHCASignal", 1);
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "HHCAConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, true, false, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		

		complete();
	}

	@Override
	public void deleteYourself() {
		
		addToInformationVector("HHCASignal", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
				
		
	}

}
