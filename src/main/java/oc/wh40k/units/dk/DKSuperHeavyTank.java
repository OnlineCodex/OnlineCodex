package oc.wh40k.units.dk;

import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DKSuperHeavyTank extends RuestkammerVater {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;
	RuestkammerStarter t6;
	RuestkammerStarter t7;
	RuestkammerStarter t8;
	RuestkammerStarter t9;

	public DKSuperHeavyTank() {
	}
		
		
	public void initButtons(boolean... defaults) {
		//name = "Super Heavy Tank Squadron";
		grundkosten = 0;
		//this.überschriftSetzen = true;
		
		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBanebladeKammer", "Baneblade");
		t1.initKammer(false);
		t1.setButtonText("Baneblade");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKShadowswordKammer", "Shadowsword");
		t2.initKammer();
		t2.setButtonText("Shadowsword");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKStormswordKammer", "Stormsword");
		t3.initKammer();
		t3.setButtonText("Stormsword");
		add(t3);
		
		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKStormbladeKammer", "Stormblade");
		t4.initKammer();
		t4.setButtonText("Stormblade");
		add(t4);
		
		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "DKStormlordKammer", "Stormlord");
		t5.initKammer();
		t5.setButtonText("Stormlord");
		add(t5);

		seperator();

		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHellhammerKammer", "Hellhammer");
		t6.initKammer();
		t6.setButtonText("Hellhammer");
		add(t6);

		seperator();

		t7 = new RuestkammerStarter(ID, randAbstand, cnt, "DKDoomhammerKammer", "Doomhammer");
		t7.initKammer();
		t7.setButtonText("Doomhammer");
		add(t7);

		seperator();

		t8 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBaneswordKammer", "Banesword");
		t8.initKammer();
		t8.setButtonText("Banesword");
		add(t8);

		seperator();

		t9 = new RuestkammerStarter(ID, randAbstand, cnt, "DKBanehammerKammer", "Banehammer");
		t9.initKammer();
		t9.setButtonText("Banehammer");
		add(t9);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		t1.setAktiv(!t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t2.setAktiv(!t1.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t3.setAktiv(!t1.isSelected() && !t2.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t4.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t5.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t6.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t7.isSelected() && !t8.isSelected() && !t9.isSelected());
		t7.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t8.isSelected() && !t9.isSelected());
		t8.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t9.isSelected());
		t9.setAktiv(!t1.isSelected() && !t2.isSelected() && !t3.isSelected() && !t4.isSelected() && !t5.isSelected() && !t6.isSelected() && !t7.isSelected() && !t8.isSelected());
	}

}
