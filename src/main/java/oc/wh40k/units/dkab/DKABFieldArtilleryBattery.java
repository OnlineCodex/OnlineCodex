package oc.wh40k.units.dkab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKABFieldArtilleryBattery extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter tr1;
	RuestkammerStarter tr2;
	RuestkammerStarter tr3;
	RuestkammerStarter tr4;
	OptionsEinzelUpgrade carcass;

	public DKABFieldArtilleryBattery() {
		name = "Heavy Quad Launcher Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		seperator();
		
		add(carcass = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Carcass shells",0));

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABFieldArtillery", "Field Artillery");
		t1.initKammer();
		t1.setButtonText("Field Artillery");
		add(t1);

		tr1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABCentaur", "Centaur");
		tr1.initKammer();
		add(tr1);
		
		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABFieldArtillery", "Field Artillery");
		t2.initKammer();
		t2.setButtonText("Field Artillery");
		add(t2);
		
		tr2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABCentaur", "Centaur");
		tr2.initKammer();
		add(tr2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABFieldArtillery", "Field Artillery");
		t3.initKammer();
		t3.setButtonText("Field Artillery");
		add(t3);
		
		tr3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABCentaur", "Centaur");
		tr3.initKammer();
		add(tr3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABFieldArtillery", "Field Artillery");
		t4.initKammer();
		t4.setButtonText("Field Artillery");
		add(t4);
		
		tr4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABCentaur", "Centaur");
		tr4.initKammer();
		add(tr4);

		complete();
	}

	@Override
	public void refreshen() {
        t1.setAbwaehlbar(false);

        t2.setAktiv(t1.isSelected());
        tr2.setAktiv(t2.isSelected());
        t3.setAktiv(t2.isSelected());
        tr3.setAktiv(t3.isSelected());
        t4.setAktiv(t3.isSelected());
        tr4.setAktiv(t4.isSelected());

        tr1.getPanel().setLocation(tr1.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
        t2.getPanel().setLocation(t2.getPanel().getX(), tr1.getPanel().getY() + tr1.getPanel().getHeight() + 10);
        tr2.getPanel().setLocation(tr2.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
        t3.getPanel().setLocation(t3.getPanel().getX(), tr2.getPanel().getY() + tr2.getPanel().getHeight() + 10);
        tr3.getPanel().setLocation(tr3.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 10);
        t4.getPanel().setLocation(t4.getPanel().getX(), tr3.getPanel().getY() + tr3.getPanel().getHeight() + 10);
        tr4.getPanel().setLocation(tr4.getPanel().getX(), t4.getPanel().getY() + t4.getPanel().getHeight() + 10);
        
        boolean legal=true;
        if(tr1.isSelected() || tr2.isSelected() || tr2.isSelected() || tr2.isSelected()){
         legal=(tr1.isSelected() || !tr1.isAktiv()) && (tr2.isSelected() || !tr2.isAktiv()) && (tr3.isSelected() || !tr3.isAktiv()) && (tr4.isSelected() || !tr4.isAktiv());
        }
        tr1.setLegal(legal);
        tr2.setLegal(legal);
        tr3.setLegal(legal);
        tr4.setLegal(legal);
        
        int carcassPoints = (((DKABFieldArtillery)t1.getKammer()).o1.isSelected(1)?1:0) +
        					(((DKABFieldArtillery)t2.getKammer()).o1.isSelected(1)?1:0) +
        					(((DKABFieldArtillery)t3.getKammer()).o1.isSelected(1)?1:0) +
        					(((DKABFieldArtillery)t4.getKammer()).o1.isSelected(1)?1:0);
        carcass.setPreis(carcassPoints*5);
        carcass.setAktiv(carcassPoints>0);
	}

}
