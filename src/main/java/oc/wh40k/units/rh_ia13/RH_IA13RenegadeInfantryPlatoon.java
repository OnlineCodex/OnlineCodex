package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeInfantryPlatoon extends Eintrag {

	RuestkammerStarter commandSquad;
	RuestkammerStarter infantrySquad1;
	RuestkammerStarter infantrySquad2;
	RuestkammerStarter infantrySquad3;
	RuestkammerStarter infantrySquad4;
	
	boolean masterBool=false;

	public RH_IA13RenegadeInfantryPlatoon() {
		name = "Renegade Infantry Platoon";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/RHRenegadeMilitiaPlatoon.jpg"));
		

		seperator();

		commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeInfantrySquadKammer", "Platoon Command Squad", 1);
		commandSquad.initKammer(true,false);
		commandSquad.setUeberschriftTrotzNullKostenAusgeben(true);
		add(commandSquad);

		seperator();

		infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeInfantrySquadKammer", "Renegade Infantry Squad", 1);
		infantrySquad1.initKammer(false,false);
		infantrySquad1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad1);

		seperator();

		infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeInfantrySquadKammer", "Renegade Infantry Squad", 1);
		infantrySquad2.initKammer(false,false);
		infantrySquad2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad2);

		seperator();

		infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeInfantrySquadKammer", "Renegade Infantry Squad", 1);
		infantrySquad3.initKammer(false,false);
		infantrySquad3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad3);

		seperator();

		infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeInfantrySquadKammer", "Renegade Infantry Squad", 1);
		infantrySquad4.initKammer(false,false);
		infantrySquad4.setUeberschriftTrotzNullKostenAusgeben(true);
		add(infantrySquad4);
		
		addToInformationVector("InfPlatoon", 1);

		complete();
	}

	@Override
	public void refreshen() {
		commandSquad.setLegal(commandSquad.isSelected());
		infantrySquad1.setLegal(infantrySquad1.isSelected());
		infantrySquad2.setLegal(infantrySquad2.isSelected());
		infantrySquad3.setAktiv(infantrySquad2.isSelected());
		infantrySquad4.setAktiv(infantrySquad3.isSelected());
		
		if(getCountFromInformationVector("RHMasterOfTheHorde")==1 && masterBool==false){
			masterBool=true;
			((RH_IA13RenegadeInfantrySquadKammer)commandSquad.getKammer()).squad.setMaxModelle(30);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad1.getKammer()).squad.setMaxModelle(30);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad2.getKammer()).squad.setMaxModelle(30);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad3.getKammer()).squad.setMaxModelle(30);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad4.getKammer()).squad.setMaxModelle(30);
		}else if(getCountFromInformationVector("RHMasterOfTheHorde")==0 && masterBool==true){
			masterBool=false;
			((RH_IA13RenegadeInfantrySquadKammer)commandSquad.getKammer()).squad.setMaxModelle(20);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad1.getKammer()).squad.setMaxModelle(20);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad2.getKammer()).squad.setMaxModelle(20);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad3.getKammer()).squad.setMaxModelle(20);
			((RH_IA13RenegadeInfantrySquadKammer)infantrySquad4.getKammer()).squad.setMaxModelle(20);
			RefreshListener.fireRefresh();
		}
		
		if(getCountFromInformationVector("RHMutantOverlord")==1 && getCountFromInformationVector("MutantRabble")<2){
			setFehlermeldung("2+ Mutant Rabble");
		}else if(getCountFromInformationVector("RHMasterOfTheHorde")==1 && getCountFromInformationVector("InfPlatoon")<2){
			setFehlermeldung("2+ Inf. Platoons");
		}else{
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("InfPlatoon", -1);
		super.deleteYourself();
	}
}
