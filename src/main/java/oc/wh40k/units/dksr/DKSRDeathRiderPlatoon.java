package oc.wh40k.units.dksr;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKSRDeathRiderPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter infantrySquad1;
	RuestkammerStarter infantrySquad2;
	RuestkammerStarter infantrySquad3;
	RuestkammerStarter infantrySquad4;
	RuestkammerStarter infantrySquad5;
	RuestkammerStarter infantrySquad6;

	public DKSRDeathRiderPlatoon() {
		name = "Death Rider Platoon";
		grundkosten = 0;
		überschriftSetzen = true;


		add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderCommandSquad", "Death Rider Command Squad", 1);
		commandSquad.initKammer();
		add(commandSquad);

		seperator();

        infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron\n", 1);
		infantrySquad1.initKammer();
		infantrySquad1.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad1);

		seperator();

		infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron", 1);
		infantrySquad2.initKammer();
		infantrySquad2.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad2);

		seperator();

		infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron", 1);
		infantrySquad3.initKammer();
		infantrySquad3.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad3);

		seperator();

		infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron", 1);
		infantrySquad4.initKammer();
		infantrySquad4.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad4.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad4);

		seperator();

		infantrySquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron", 1);
		infantrySquad5.initKammer();
		infantrySquad5.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad5.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad5);

		seperator();

		infantrySquad6 = new RuestkammerStarter(ID, randAbstand, cnt, "DKSRDeathRiderSquadron", "Death Rider Squadron", 1);
		infantrySquad6.initKammer();
		infantrySquad6.setButtonText("Death Rider Squadron . . . . . . .85 Pkt.");
		infantrySquad6.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad6);

		complete();
	}

	@Override
	public void refreshen() {

		infantrySquad1.setAbwaehlbar(false);
		infantrySquad2.setAktiv(infantrySquad1.isSelected());
		infantrySquad3.setAktiv(infantrySquad2.isSelected());
		infantrySquad4.setAktiv(infantrySquad3.isSelected());
		infantrySquad5.setAktiv(infantrySquad4.isSelected());
		infantrySquad6.setAktiv(infantrySquad5.isSelected());

		infantrySquad1.getPanel().setLocation((int) infantrySquad1.getPanel().getLocation().getX(), (int) commandSquad.getPanel().getLocation().getY() + (int)commandSquad.getPanel().getSize().height + 10);
		infantrySquad2.getPanel().setLocation((int) infantrySquad2.getPanel().getLocation().getX(), (int) infantrySquad1.getPanel().getLocation().getY() + (int)infantrySquad1.getPanel().getSize().height + 10);
		infantrySquad3.getPanel().setLocation((int) infantrySquad3.getPanel().getLocation().getX(), (int) infantrySquad2.getPanel().getLocation().getY() + (int)infantrySquad2.getPanel().getSize().height + 10);
		infantrySquad4.getPanel().setLocation((int) infantrySquad4.getPanel().getLocation().getX(), (int) infantrySquad3.getPanel().getLocation().getY() + (int)infantrySquad3.getPanel().getSize().height + 10);
		infantrySquad5.getPanel().setLocation((int) infantrySquad5.getPanel().getLocation().getX(), (int) infantrySquad4.getPanel().getLocation().getY() + (int)infantrySquad4.getPanel().getSize().height + 10);
		infantrySquad6.getPanel().setLocation((int) infantrySquad6.getPanel().getLocation().getX(), (int) infantrySquad5.getPanel().getLocation().getY() + (int)infantrySquad5.getPanel().getSize().height + 10);

		if(((DKSRDeathRiderCommandSquad)commandSquad.getKammer()).uniqueError==true){
			setFehlermeldung("max 1 Colonel");
		}else if(((DKSRDeathRiderCommandSquad)commandSquad.getKammer()).stdError==true){
			setFehlermeldung("max 1 Standard");
		}else{
			setFehlermeldung("");
		}
		
    }
}
