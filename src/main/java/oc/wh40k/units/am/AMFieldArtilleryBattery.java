package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class AMFieldArtilleryBattery extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter tr1;
	RuestkammerStarter tr2;
	RuestkammerStarter tr3;
	RuestkammerStarter tr1x;
	RuestkammerStarter tr2x;
	RuestkammerStarter tr3x;
	OptionsEinzelUpgrade camo;

	public AMFieldArtilleryBattery() {
		name = "Field Artillery Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		add(camo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Camo netting",20));
		
		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFieldArtillery", "Field Artillery");
		t1.initKammer();
		t1.setButtonText("Field Artillery");
		add(t1);

		tr1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMCentaur", "Centaur");
		tr1.initKammer();
		add(tr1);
		
		tr1x = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
		tr1x.initKammer();
		add(tr1x);
		
		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFieldArtillery", "Field Artillery");
		t2.initKammer();
		t2.setButtonText("Field Artillery");
		add(t2);
		
		tr2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMCentaur", "Centaur");
		tr2.initKammer();
		add(tr2);
		
		tr2x = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
		tr2x.initKammer();
		add(tr2x);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFieldArtillery", "Field Artillery");
		t3.initKammer();
		t3.setButtonText("Field Artillery");
		add(t3);
		
		tr3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMCentaur", "Centaur");
		tr3.initKammer();
		add(tr3);
		
		tr3x = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
		tr3x.initKammer();
		add(tr3x);


		complete();
	}

	@Override
	public void refreshen() {
        t1.setAbwaehlbar(false);

        tr1.setAktiv(!tr1x.isAktiv());
        tr1x.setAktiv(!tr1.isAktiv());
        t2.setAktiv(t1.isSelected());
        tr2.setAktiv(t2.isSelected() && !tr2x.isAktiv());
        tr2x.setAktiv(t2.isSelected() && !tr2.isAktiv());
        t3.setAktiv(t2.isSelected());
        tr3.setAktiv(t3.isSelected() && !tr3x.isAktiv());
        tr3x.setAktiv(t2.isSelected() && !tr3.isAktiv());

        tr1.getPanel().setLocation(tr1.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
        t2.getPanel().setLocation(t2.getPanel().getX(), tr1.getPanel().getY() + tr1.getPanel().getHeight() + 10);
        tr2.getPanel().setLocation(tr2.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
        t3.getPanel().setLocation(t3.getPanel().getX(), tr2.getPanel().getY() + tr2.getPanel().getHeight() + 10);
        tr3.getPanel().setLocation(tr3.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 10);
        
        boolean legal=true;
        if(tr1.isSelected() || tr2.isSelected() || tr2.isSelected() || tr2.isSelected()){
         legal=((tr1.isSelected() || !tr1.isAktiv()) && (tr2.isSelected() || !tr2.isAktiv()) && (tr3.isSelected() || !tr3.isAktiv())) ||
        	   ((tr1x.isSelected() || !tr1x.isAktiv()) && (tr2x.isSelected() || !tr2x.isAktiv()) && (tr3x.isSelected() || !tr3x.isAktiv()));
        }
        tr1.setLegal(legal);
        tr2.setLegal(legal);
        tr3.setLegal(legal);
        tr1x.setLegal(legal);
        tr2x.setLegal(legal);
        tr3x.setLegal(legal);
        
        int camoKosten = 0 + (t1.isSelected()?30:0) + (t2.isSelected()?30:0) + (t3.isSelected()?30:0);
        camo.setPreis(camoKosten);
        
        //t1,tr1,tr1x
        
        tr1.getPanel().setLocation(
				(int) tr1.getPanel().getLocation().getX(),
				(int) t1.getPanel().getLocation().getY() + t1.getPanel().getSize().height + 5
	    );
		
        tr1x.getPanel().setLocation(
				(int) tr1x.getPanel().getLocation().getX(),
				(int) tr1.getPanel().getLocation().getY() + tr1.getPanel().getSize().height + 5
	    );
        
        t2.getPanel().setLocation(
				(int) t2.getPanel().getLocation().getX(),
				(int) tr1x.getPanel().getLocation().getY() + tr1x.getPanel().getSize().height + 5
	    );
        
        tr2.getPanel().setLocation(
				(int) tr2.getPanel().getLocation().getX(),
				(int) t2.getPanel().getLocation().getY() + t2.getPanel().getSize().height + 5
	    );
        
        tr2x.getPanel().setLocation(
				(int) tr2x.getPanel().getLocation().getX(),
				(int) tr2.getPanel().getLocation().getY() + tr2.getPanel().getSize().height + 5
	    );
        
        t3.getPanel().setLocation(
				(int) t3.getPanel().getLocation().getX(),
				(int) tr2x.getPanel().getLocation().getY() + tr2x.getPanel().getSize().height + 5
	    );
        
        tr3.getPanel().setLocation(
				(int) tr3.getPanel().getLocation().getX(),
				(int) t3.getPanel().getLocation().getY() + t3.getPanel().getSize().height + 5
	    );
        
        tr3x.getPanel().setLocation(
				(int) tr3x.getPanel().getLocation().getX(),
				(int) tr3.getPanel().getLocation().getY() + tr3.getPanel().getSize().height + 5
	    );
	}

}
