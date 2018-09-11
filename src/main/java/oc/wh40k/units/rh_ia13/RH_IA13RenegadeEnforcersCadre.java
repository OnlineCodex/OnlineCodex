package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeEnforcersCadre extends Eintrag {

	RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;
    RuestkammerStarter t4;
    RuestkammerStarter t5;
    RuestkammerStarter t6;
    RuestkammerStarter t7;
    RuestkammerStarter t8;
    RuestkammerStarter t9;
    RuestkammerStarter t10;

	public RH_IA13RenegadeEnforcersCadre() {
		name = "Renegade Enforcers Cadre";
		grundkosten = 0;
		überschriftSetzen=true;
		
		addToInformationVector("RHEnforcerCadre", +1);

		add(ico = new oc.Picture("oc/wh40k/images/RHEnforcer.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t1.initKammer();
		add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t2.initKammer();
		add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t3.initKammer();
		add(t3);
		
		seperator();
		
		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t4.initKammer();
		add(t4);

        seperator();

        t5 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t5.initKammer();
		add(t5);

		seperator();

        t6 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t6.initKammer();
		add(t6);
		
		seperator();

        t7 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t7.initKammer();
		add(t7);
		
		seperator();

        t8 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t8.initKammer();
		add(t8);
		
		seperator();

        t9 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t9.initKammer();
		add(t9);
		
		seperator();

        t10 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeEnforcerKammer", "Enforcer");
		t10.initKammer();
		add(t10);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(getCountFromInformationVector("RHEnforcerCadre") > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
		
		if(getCountFromInformationVector("RHArchHereticRev")==1){
			t6.setAktiv(true);
			t7.setAktiv(true);
			t8.setAktiv(true);
			t9.setAktiv(true);
			t10.setAktiv(true);
		}else{
			t6.setAktiv(false);
			t7.setAktiv(false);
			t8.setAktiv(false);
			t9.setAktiv(false);
			t10.setAktiv(false);
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("RHEnforcerCadre", -1);
	}

}
