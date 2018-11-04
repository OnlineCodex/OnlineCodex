package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VOLKBloodAngels extends BuildaVater {

	private static final Logger LOGGER = LoggerFactory.getLogger(VOLKBloodAngels.class);

	public VOLKBloodAngels() {
		reflectionKennung = "BA";

		HQeinträge = new String[]{"", "Captain", "Terminator Captain", "Librarian", "Captain Tycho", "Tycho the Lost", "Librarian Dreadnought", "Mephiston", "The Sanguinor", "Astorath", "Sanguinary Priest", "Brother Corbulo", "Techmarine", "Servitoren", "Chaplain",
							   "", "[SoB Deathstorm] Captain Karlaen", "", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax", "",
							   "", "[IA2 2nd Ed] Damocles Command Vehicle",
							   "", "[IA9] Malakim Phoros",
							   "", "[Forgeworld] Damocles Rhino"};
		Eliteeinträge = new String[]{"", "Command Squad", "Death Company Squad", "Lemartes", "Sanguinary Guard", "Dreadnought", "Death Company Dreadnought", "Furioso Dreadnought", "Terminator Squad", "Terminator Assault Squad", "Vanguard Veteran Squad", "Sternguard Veteran Squad",
									 "", "[SoB Deathstorm] Squad Alphaeus",				
									 "", "[IA2 2nd Ed] Land Raider Prometheus",
									 "", "[IA Apo 2013] Blood Angels Contemptor Dreadnought"};
		Standardeinträge = new String[]{"", "Tactical Squad", "Scout Squad",
										"", "[SoB Deathstorm] Raphens Death Company", "[SoB Deathstorm] Cassor the Damned"};
		Sturmeinträge = new String[]{"", "Rhino", "Razorback", "Drop Pod", "Land Speeder Squadron", "Assault Squad", "Bike Squad", "Attack Bike Squad", "Scout Bike Squad",
				"", "[IA2 2nd Ed] Caestus Assault Ram", "[IA2 2nd Ed] Land Speeder Tempest Squadron","[IA2 2nd Ed] Javelin Attack Speeder",
				"", "[IA Experimental] Xiphon Pattern Interceptor"};
		Unterstützungeinträge = new String[]{"", "Stormraven Gunship", "Devastator Squad", "Baal Predator", "Predator", "Vindicator", "Whirlwind", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer",
				  "", "[IA Experimental] Quad Mortar Support Battery",
				  "", "[FW online] Deimos Pattern Vindicator Tank Destroyer",
				"", "[IA2 2nd Ed] Land Raider Helios","[IA2 2nd Ed] Land Raider Proteus", "[IA2 2nd Ed] Land Raider Achilles", 
				    "[IA2 2nd Ed] Deimos Predator","[IA2 2nd Ed] Relic Sicaran Battle Tank","[IA2 2nd Ed] Whirlwind Hyperios",
				    "[IA2 2nd Ed] Relic Whirlwind Scorpius", "[IA2 2nd Ed] Spartan Assault Tank", "[IA2 2nd Ed] Tarantula-Batterie", 
				    "[IA2 2nd Ed] Rapier Carrier Battery", "[IA2 2nd Ed] Deathstorm Drop Pod", "[IA2 2nd Ed] Fire Raptor Gunship",
				"", "[IA12] SentryGunBattery"};
		LordofWar = new String[]{"", "Commander Dante", "Gabriel Seth",
							  "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",
							  "","[IA2 2nd Ed] Fellblade","[IA2 2nd Ed] Typhon","[IA2 2nd Ed] Cerberus", "[IA2 2nd Ed] Thunderhawk Gunship",
			                     "[IA2 2nd Ed] Thunderhawk Transporter"};
		/*
	THE BLACK RAGE
	Astorath the Grim
	1 + Chaplains
	0-1 Death Company Tycho
	3+ Death Company squads (1 squad must include Lemartes, Guardian of the Lost)
	2-4 Death Company Dreadnoughts
	If you wish to represent Captain Tycho's strike force after he succumbed to the Black Rage on
	Armageddon, include him in this Battle Formation.
		 
	LUCIFER ARMOURED TASK FORCE
	1 Captain Tycho
	1 Honour Guard
	3 Tactical Squads
	2 Baal Predators
	2 Predators
	4 Land Raiders(any type)

	WINGS OF SANGUINIUS
	1 Captain
	1 Chaplain
	0-1 The Sanguinor
	1 Honour Guard or Sanguinary Guard Squad
	10 Assault Squads
	FORMATION RESTRICTIONS
	All Assault Squads must have 10 models. All models must be given jump packs. No units may have Dedicated Transports.

*/
		
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 3, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,"FO", cnt, 0, 6, Befestigungen));
    	cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this,"APO", cnt, 0, 7, LordofWar));
        
		cnt += 480;

		nameDerArtDerArmee = "Blood Angels";
		nameDerArtDerArmeeDekliniert = "Blood Angels";
		textAreaUeberschrift = "Blood Angels";

		noAllies.clear();
		noAllies.add("BA");

		battleBrothers.add("AB");
		battleBrothers.add("AM");
		battleBrothers.add("AS");
		battleBrothers.add("BA");
		battleBrothers.add("CR");
		battleBrothers.add("DA");
		battleBrothers.add("DK");
		battleBrothers.add("DKAB");
		battleBrothers.add("ED");
		battleBrothers.add("GK");
		battleBrothers.add("IN");
		battleBrothers.add("IR");
		battleBrothers.add("MT");
		battleBrothers.add("SF");
		battleBrothers.add("SM");
		battleBrothers.add("TL");
		battleBrothers.add("SK");
		battleBrothers.add("CU");
		battleBrothers.add("DW");
		
		alliesOfConvenience.add("EL");
		alliesOfConvenience.add("HQ");
		
		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		desperateAllies.add("EC");
		
		comeTheApocalypse.add("BL");
		comeTheApocalypse.add("CD");
		comeTheApocalypse.add("CM");
		comeTheApocalypse.add("CS");
		comeTheApocalypse.add("DH");
		comeTheApocalypse.add("DM");
		comeTheApocalypse.add("NE");
		comeTheApocalypse.add("OR");
		comeTheApocalypse.add("RH");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("SY");
		
		//Verschiedene Spezialkontingente der Blood Angels
		kontingente.add("");
		kontingente.add("Baal Strike Force");
		kontingente.add("");
		
		//Formationen
		formationen.add("Blood Angels Battle Company");
		formationen.add("");
		
		int[] arr1 = {2,4,6,2,2,0,0,0};
		minAuswahlen.put("Blood Angels Battle Company",arr1);
		maxAuswahlen.put("Blood Angels Battle Company",arr1);
		
		int[] arr2 = {1,1,2,0,0,0,0,0};
		minAuswahlen.put("Baal Strike Force",arr2);
		int[] arr3 = {2,4,6,3,3,1,1,0};
		maxAuswahlen.put("Baal Strike Force",arr3);
		
		//Shield of Baal - Archangels
		kontingente.add("Archangels Strike Force (Shield of Baal - Exterminatus)");
		
		int[] arr4 = {1,2,0,0,0,0,0,0};
		minAuswahlen.put("Archangels Strike Force (Shield of Baal - Exterminatus)",arr4);
		int[] arr5 = {2,16,0,0,0,0,0,0};
		maxAuswahlen.put("Archangels Strike Force (Shield of Baal - Exterminatus)",arr5);
		
		formationen.add("Archangels Orbital Intervention Force (Shield of Baal - Exterminatus)");
		formationen.add("Archangels Sanguine Wing (Shield of Baal - Exterminatus)");
		formationen.add("Archangels Demi-Company (Shield of Baal - Exterminatus)");
		formationen.add("The Archangels (Shield of Baal - Exterminatus)");
		formationen.add("Blooded Demi-Company (Shield of Baal - Exterminatus)");
		formationen.add("Strike Force Mortalis (Shield of Baal - Exterminatus)");
		formationen.add("");
		
		int[] arr11 = {0,3,0,0,0,0,0,0};
		minAuswahlen.put("Archangels Orbital Intervention Force (Shield of Baal - Exterminatus)",arr11);
		maxAuswahlen.put("Archangels Orbital Intervention Force (Shield of Baal - Exterminatus)",arr11);
		
		int[] arr12 = {0,3,0,0,1,0,0,0};
		minAuswahlen.put("Archangels Sanguine Wing (Shield of Baal - Exterminatus)",arr12);
		maxAuswahlen.put("Archangels Sanguine Wing (Shield of Baal - Exterminatus)",arr12);
		
		int[] arr13 = {1,7,0,0,0,0,0,0};
		minAuswahlen.put("Archangels Demi-Company (Shield of Baal - Exterminatus)",arr13);
		maxAuswahlen.put("Archangels Demi-Company (Shield of Baal - Exterminatus)",arr13);
		
		int[] arr14 = {2,14,0,0,0,0,0,0};
		minAuswahlen.put("The Archangels (Shield of Baal - Exterminatus)",arr14);
		maxAuswahlen.put("The Archangels (Shield of Baal - Exterminatus)",arr14);
		
		int[] arr15 = {1,1,3,1,1,0,0,0};
		int[] arr16 = {2,2,3,1,1,0,0,0};
		minAuswahlen.put("Blooded Demi-Company (Shield of Baal - Exterminatus)",arr15);
		maxAuswahlen.put("Blooded Demi-Company (Shield of Baal - Exterminatus)",arr16);

		int[] arr17 = {1,5,0,0,1,0,0,0};
		minAuswahlen.put("Strike Force Mortalis (Shield of Baal - Exterminatus)",arr17);
		maxAuswahlen.put("Strike Force Mortalis (Shield of Baal - Exterminatus)",arr17);
		
		/* ARCHANGELS
		 
		DANTE'S AVENGING HOST //TODO ? Formation mit Unterformationen
		 Commander Dante
		 Mephiston
		 1 Librarian
		 1 Sanguinary Priest
		 1 unit of Sanguinary Guard
		 Blooded Demi-company
		 3 Stormraven Gunships
		RESTRICTIONS:
		The Blooded Demi-company must include the Chaplain, but must otherwise adhere
		to all of the restrictions detailed in its corresponding Formation datasheet. All units
		not equipped with jump packs or beginning the game embarked upon the
		Formation's Stormraven Gunships must begin the game embarked in Drop Pods,
		purchased at the normal points cost.
		 */
		
		//Shield of Baal Flesh Tearers
		kontingente.add("Flesh Tearers Strike Force (Shield of Baal - Exterminatus)");
		
		int[] arr6 = {1,0,1,1,0,0,0,0};
		minAuswahlen.put("Flesh Tearers Strike Force (Shield of Baal - Exterminatus)",arr6);
		int[] arr7 = {2,3,4,6,3,1,1,99};
		maxAuswahlen.put("Flesh Tearers Strike Force (Shield of Baal - Exterminatus)",arr7);
		
		formationen.add("Flesh Tearers Vanguard Strike Force (Shield of Baal - Exterminatus)");
		formationen.add("Lysios Relief Force (Shield of Baal - Exterminatus)");
		formationen.add("The Defenders of the Cathedrum (Shield of Baal - Exterminatus)");
		formationen.add("");
		
		int[] arr8 = {0,2,3,1,0,0,0,0};
		minAuswahlen.put("Flesh Tearers Vanguard Strike Force (Shield of Baal - Exterminatus)",arr8);
		maxAuswahlen.put("Flesh Tearers Vanguard Strike Force (Shield of Baal - Exterminatus)",arr8);
		
		int[] arr9 = {0,1,1,0,3,0,1,0};
		minAuswahlen.put("Lysios Relief Force (Shield of Baal - Exterminatus)",arr9);
		maxAuswahlen.put("Lysios Relief Force (Shield of Baal - Exterminatus)",arr9);
		
		int[] arr10 = {0,3,2,1,0,0,0,0};
		minAuswahlen.put("The Defenders of the Cathedrum (Shield of Baal - Exterminatus)",arr10);
		maxAuswahlen.put("The Defenders of the Cathedrum (Shield of Baal - Exterminatus)",arr10);
		
		/* FLESH TEARERS
		
		STRIKE FORCE RAZORWIND - Formation mit Unter-Formationen
		 Lysios Relief Force
		 The Defenders of the Cathedrum
		
		 */
		
		formationen.add("Strike Force Deathstorm (SoB - Deathstorm)");
		formationen.add("");

		int[] arr18 = {1,1,2,0,0,0,0,0};
		minAuswahlen.put("Strike Force Deathstorm (SoB - Deathstorm)",arr18);
		maxAuswahlen.put("Strike Force Deathstorm (SoB - Deathstorm)",arr18);
		
		complete();
	}

	@Override
	public void volkRefresh() {

		setInformationVectorValue("Sanguine Wing", 0);
		setInformationVectorValue("Demi-Company", 0);
		setInformationVectorValue("Termi Chaplain", 0);
		setInformationVectorValue("Archangels", 0);
		setInformationVectorValue("Flesh Tearers", 0);
		
		if(getKontingentTyp().equals("Blood Angels Battle Company")){

			if(!isLoading){
				addUnit(0,"Captain");
				addUnit(0,"Chaplain");
				addUnit(1,"Command Squad");
				addUnit(1,"Death Company Squad");
				addUnit(1,"Dreadnought");
				addUnit(1,"Furioso Dreadnought");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(3,"Assault Squad");
				addUnit(3,"Assault Squad");
				addUnit(4,"Devastator Squad");
				addUnit(4,"Devastator Squad");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Archangels Orbital Intervention Force (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad", "Terminator Assault Squad"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
			setInformationVectorValue("Archangels", 1);
			if(!isLoading){
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
			}
		}else if(getKontingentTyp().equals("Archangels Sanguine Wing (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veteran Squad", "Sternguard Veteran Squad"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Stormraven Gunship"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Archangels", 1);
			setInformationVectorValue("Sanguine Wing", 1);
			if(!isLoading){
				addUnit(1,"Vanguard Veteran Squad");
				addUnit(1,"Vanguard Veteran Squad");
				addUnit(1,"Sternguard Veteran Squad");
				addUnit(4,"Stormraven Gunship");
			}		
		}else if(getKontingentTyp().equals("Archangels Demi-Company (Shield of Baal - Exterminatus)")){
			
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Terminator Captain", "[SoB Deathstorm] Captain Karlaen", "Chaplain"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Furioso Dreadnought", "Terminator Squad", "Terminator Assault Squad", "Sternguard Veteran Squad", "Vanguard Veteran Squad"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Archangels", 1);
			setInformationVectorValue("Demi-Company", 1);
			setInformationVectorValue("Termi Chaplain", 1);
			if(!isLoading){
				addUnitNotLocked(0,"Terminator Captain");
				addUnit(0,"");
				addUnit(1,"Furioso Dreadnought");
				addUnit(1,"Furioso Dreadnought");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnit(1,"");
			}		
		}else if(getKontingentTyp().equals("The Archangels (Shield of Baal - Exterminatus)")){
			
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Captain", "[SoB Deathstorm] Captain Karlaen","Chaplain"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Furioso Dreadnought", "Terminator Squad", "Terminator Assault Squad", "Sternguard Veteran Squad", "Vanguard Veteran Squad"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Archangels", 1);
			setInformationVectorValue("Flesh Tearers", 0);
			if(!isLoading){
				addUnitNotLocked(0,"Captain");
				addUnit(0,"Chaplain");
				addUnit(0,"");
				addUnit(1,"Furioso Dreadnought");
				addUnit(1,"Furioso Dreadnought");
				addUnit(1,"Furioso Dreadnought");
				addUnit(1,"Furioso Dreadnought");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnitNotLocked(1,"Terminator Squad");
				addUnit(1,"");
			}
			
		}else if(getKontingentTyp().equals("Blooded Demi-Company (Shield of Baal - Exterminatus)")){
			
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Captain", "Chaplain", "Command Squad"});//TODO : Command Squad only if Captain is taken
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Dreadnought", "Furioso Dreadnought"}); //TODO : Furioso Dreadnought only if Chaplain is taken
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Devastator Squad"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
			setInformationVectorValue("Archangels", 1);
			if(!isLoading){
				addUnitNotLocked(0,"Captain");
				addUnitNotLocked(0,"Command Squad");
				addUnitNotLocked(1,"Dreadnought");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(3,"Assault Squad");
				addUnit(4,"Devastator Squad");
			}
			
//			BLOODED DEMI-COMPANY
//			 1 Captain or Chaplain
//			 1 Command Squad (only if Captain is taken)
//			 3 Tactical Squads
//			 1 Assault Squad
//			 1 Devastator Squad
//			 1 Dreadnought
//			 1 Furioso Dreadnought (only if Chaplain is taken)
//			

		}else if(getKontingentTyp().equals("Strike Force Mortalis (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Chaplain"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Death Company Squad", "Death Company Dreadnought"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Stormraven Gunship"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
			setInformationVectorValue("Archangels", 1);
			if(!isLoading){
				addUnit(0,"Chaplain");
				addUnit(1,"Death Company Squad");
				addUnit(1,"Death Company Squad");
				addUnit(1,"Death Company Squad");
				addUnit(1,"Death Company Dreadnought");
				addUnit(1,"Death Company Dreadnought");
				addUnit(4,"Stormraven Gunship");
			}	
		}else if(getKontingentTyp().contains("Flesh Tearers Vanguard Strike Force (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Vanguard Veteran Squad", "Furioso Dreadnought"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});	
			setInformationVectorValue("Flesh Tearers", 1);
			if(!isLoading){
				addUnit(1,"Vanguard Veteran Squad");
				addUnit(1,"Furioso Dreadnought");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(3,"Assault Squad");
			}
			
			
		}else if(getKontingentTyp().contains("Lysios Relief Force (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"",  "Vanguard Veteran Squad"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Baal Predator", "Predator", "Stormraven Gunship"});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{"", "Gabriel Seth"});
			setInformationVectorValue("Flesh Tearers", 1);
			if(!isLoading){
				addUnit(1,"Vanguard Veterans Squad");
				addUnit(2,"Tactical Squad");
				addUnit(4,"Predator");
				addUnit(4,"Baal Predator");
				addUnit(4,"Stormraven Gunship");
				addUnit(6,"Gabriel Seth");
			}
			
		}else if(getKontingentTyp().contains("The Defenders of the Cathedrum (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Terminator Squad", "Death Company Squad", "Furioso Dreadnought"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Tactical Squad"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Assault Squad"});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Flesh Tearers", 1);
			if(!isLoading){
				addUnit(1,"Terminator Squad");
				addUnit(1,"Death Company Squad");
				addUnit(1,"Furioso Dreadnought");
				addUnit(2,"Tactical Squad");
				addUnit(2,"Tactical Squad");
				addUnit(3,"Assault Squad");
			}
			
		}else if(getKontingentTyp().equals("Strike Force Deathstorm (SoB - Deathstorm)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "[SoB Deathstorm] Captain Karlaen"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "[SoB Deathstorm] Squad Alphaeus"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "[SoB Deathstorm] Raphens Death Company", "[SoB Deathstorm] Cassor the Damned"});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Archangels", 1);
			if(!isLoading){
				addUnit(0,"[SoB Deathstorm] Captain Karlaen");
				addUnit(0,"");
				addUnit(1,"[SoB Deathstorm] Squad Alphaeus");
				addUnit(1,"");
				addUnit(2,"[SoB Deathstorm] Raphens Death Company");
				addUnit(2,"[SoB Deathstorm] Cassor the Damned");
				addUnit(2,"");
			}	
		}else if(getKontingentTyp().contains("Archangels Strike Force (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Terminator Captain", "[SoB Deathstorm] Captain Karlaen","Chaplain","Librarian"});
			myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Sternguard Veteran Squad","Terminator Squad","Terminator Assault Squad","Vanguard Veteran Squad",
																		 "Furioso Dreadnought"});
			myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
			myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			setInformationVectorValue("Termi Chaplain", 1);	
			setInformationVectorValue("Archangels", 1);
		}else if(getKontingentTyp().contains("Flesh Tearers Strike Force (Shield of Baal - Exterminatus)")){
			myChooserGruppen.get(0).changeComboBoxAuswahlen(HQeinträge);
			myChooserGruppen.get(1).changeComboBoxAuswahlen(Eliteeinträge);
			myChooserGruppen.get(2).changeComboBoxAuswahlen(Standardeinträge);
			myChooserGruppen.get(3).changeComboBoxAuswahlen(Sturmeinträge);
			myChooserGruppen.get(4).changeComboBoxAuswahlen(Unterstützungeinträge);
			myChooserGruppen.get(5).changeComboBoxAuswahlen(Befestigungen);
			myChooserGruppen.get(6).changeComboBoxAuswahlen(LordofWar);
			setInformationVectorValue("Flesh Tearers", 1);
		}else{
			myChooserGruppen.get(0).changeComboBoxAuswahlen(HQeinträge);
			myChooserGruppen.get(1).changeComboBoxAuswahlen(Eliteeinträge);
			myChooserGruppen.get(2).changeComboBoxAuswahlen(Standardeinträge);
			myChooserGruppen.get(3).changeComboBoxAuswahlen(Sturmeinträge);
			myChooserGruppen.get(4).changeComboBoxAuswahlen(Unterstützungeinträge);
			myChooserGruppen.get(5).changeComboBoxAuswahlen(Befestigungen);
			myChooserGruppen.get(6).changeComboBoxAuswahlen(LordofWar);
		}	
		
		fillChooserSpace();
	}

	@Override
	protected void finalize() {
		LOGGER.info("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}