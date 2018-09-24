package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class SMWaffenUndReliquien extends RuestkammerVater {
	//TODO Nur 1 Artefakt
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsEinzelUpgrade armour;
	OptionsUpgradeGruppe handwaffen = null;
	OptionsUpgradeGruppe fkwaffen = null;
	OptionsEinzelUpgrade glaiveOfVengeance;
	OptionsEinzelUpgrade huntersEye;
	OptionsEinzelUpgrade mantleOfTheStormseer;
	OptionsEinzelUpgrade scimitarOfTheGreatKhan;
	OptionsEinzelUpgrade wraithOfTheHeavens;
	OptionsEinzelUpgrade armourOfShadows;
	OptionsEinzelUpgrade exTenebris;
	OptionsEinzelUpgrade ravenSkullofKorvaad;
	OptionsEinzelUpgrade ravensFury;

	boolean wrathBool=false;
	boolean teethBool=false;
	boolean shieldBool=false;
	boolean bladeBool=false;
	boolean armourBool=false;
	boolean uniqueError=false;
	boolean glaiveOfVengeanceBool=false;
	boolean huntersEyeBool=false;
	boolean mantleOfTheStormseerBool=false;
	boolean scimitarOfTheGreatKhanBool=false;
	boolean wraithOfTheHeavensBool=false;
	boolean SonsOfTheGreatKhan=false;
	boolean armourOfShadowsBool=false;
	boolean exTenebrisBool=false;
	boolean ravenSkullofKorvaadBool=false;
	boolean ravensFuryBool=false;
	boolean swiftstrikeAndMurderBool=false;
	boolean SonsOfCorax=false;
	boolean ClanRaukaan=false;
	boolean mindforgeBool=false;
	boolean axeBool=false;
	boolean stoneBool=false;
	boolean baneBool=false;
	boolean chainBool=false;
	boolean helmBool=false;
	boolean AngelOfSacrifice=false;
	boolean EyeofHypnoth=false;
	boolean BonesofOsrak=false; //Librarian
	boolean Spartean=false;
	boolean SentinelsOfTerra=false;
    boolean SkullofPetronella=false;
    boolean BladeoftheWorthy=false;
    boolean Castigator=false;
    boolean TheFontofFury=false;
    boolean ShroudoftheAntiMartyr=false;
    boolean DesvallessHolyCircle=false;

	boolean isOrdensmeister = false; 
	boolean isAbsolutionspriester = false;        //Psiwaffe, Boltpistole
	boolean isOrdenspriester = false;  //Energieaxt, Boltpistole
	boolean isSkriptor = false;      //Energiestreitkolben, Boltpistole
	boolean isTechmarine = false; //Seuchenmesser, Boltpistole, Bolter

	//BP/NK gg RNG/NK

	public SMWaffenUndReliquien() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isOrdensmeister = defaults[0]; 
			isAbsolutionspriester = defaults[1];        
			isOrdenspriester = defaults[2];  
			isSkriptor = defaults[3];      
			isTechmarine = defaults[4];        
		} catch(Exception e) {}

		if(isOrdensmeister) {
			ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
			add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			fkwaffen.setSelected(0, true);

			ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 25));
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			handwaffen.setSelected(0, true);

		} else if(isSkriptor) {
			ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
			add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			fkwaffen.setSelected(0, true);

			ogE.addElement(new OptionsGruppeEintrag("Psiwaffe", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psistab", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
			ogE.addElement(new OptionsGruppeEintrag("Psiaxt", 0));
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			handwaffen.setSelected(0, true);
		} else if(isAbsolutionspriester || isOrdenspriester) {
			ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
			add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			fkwaffen.setSelected(0, true);

			ogE.addElement(new OptionsGruppeEintrag("Crozius Arcanum", 0));
			if(isOrdenspriester){
				ogE.addElement(new OptionsGruppeEintrag("[SoT] The Angel of Sacrifice", 10)); //Chaplain instead of Crozius
			}
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			handwaffen.setSelected(0, true);
		} else if(isTechmarine){
			ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
			add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			fkwaffen.setSelected(0, true);

			ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 0));
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			handwaffen.setSelected(0, true);
		}

		seperator();
		if(!isSkriptor && !isOrdenspriester){
			ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
			ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		}

		if(isTechmarine){
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));	
		}
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Der Zorn des Primarchen", 20));
		ogE.addElement(new OptionsGruppeEintrag("Die Zähne Terras", 35));
		ogE.addElement(new OptionsGruppeEintrag("Der Schild der Ewigkeit", 50));
		ogE.addElement(new OptionsGruppeEintrag("Die Brennende Klinge", 55));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("[WZK] Swiftstrike and Murder", "Swiftstrike and Murder (WZ Kauyon - Sons of Corax)", 35));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		setUeberschrift("Waffen und Artefakte");

		seperator();

		add(armour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Die Unbezwingliche Rüstung", 60));

		cnt=randAbstand;

		if(isSkriptor)
		{
			ogE.addElement(new OptionsGruppeEintrag("[CR] The Mindforge Stave", 15));
		}
		ogE.addElement(new OptionsGruppeEintrag("[CR] The Axe of Medusa", 25));
		ogE.addElement(new OptionsGruppeEintrag("[CR] The Ironstone", 30));
		ogE.addElement(new OptionsGruppeEintrag("[CR] Betrayer´s Bane", 25));
		ogE.addElement(new OptionsGruppeEintrag("[CR] The Gorgon´s Chain", 45));
		ogE.addElement(new OptionsGruppeEintrag("[CR] The Tempered Helm", 35));		    
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("[SoT] The Eye of Hypnoth", 15));
		if(isSkriptor)
		{
			ogE.addElement(new OptionsGruppeEintrag("[SoT] The Bones of Osrak", 25)); //Librarian
		}
		ogE.addElement(new OptionsGruppeEintrag("[SoT] The Spartean", 5));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

		seperator();

		add(glaiveOfVengeance = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Glaive of Vengeance", "The Glaive of Vengeance (WZ Kauyon - Sons of the Great Khan)", 30));
		add(huntersEye = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Hunter's Eye", "The Hunter's Eye (WZ Kauyon - Sons of the Great Khan)", 20));
		add(mantleOfTheStormseer = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Mantle of the Stormseer", "Mantle of the Stormseer (WZ Kauyon - Sons of the Great Khan)", 20));
		add(scimitarOfTheGreatKhan = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Scimitar of the Great Khan", "Scimitar of the Great Khan (WZ Kauyon - Sons of the Great Khan)", 25));
		add(wraithOfTheHeavens = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Wraith of the Heavens", "Wraith of the Heavens (WZ Kauyon - Sons of the Great Khan)", 25));

		seperator();

		add(armourOfShadows = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Armour of Shadows", "The Armour of Shadows (WZ Kauyon - Sons of Corax)", 35));
		add(exTenebris = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Ex Tenebris", "Ex Tenebris (WZ Kauyon - Sons of Corax)", 10));
		add(ravenSkullofKorvaad = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Raven Skull of Korvaad", "The Raven Skull of Korvaad (WZ Kauyon - Sons of Corax)", 15));
		add(ravensFury = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Raven's Fury", "Raven's Fury (WZ Kauyon - Sons of Corax)", 15));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tarentischer Umhang"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm des Tadels"), 30)); // TODO NKW ersetzen
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stern der Seelenstärke"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge des Soldaten"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ultramars Vergeltung"), 20));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 5));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {

		System.out.println("refresh SMWaffenundReliquien");
		
		boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics")>0;
		
		o6.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
		o6.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
		o6.setAktiv("Castigator (GS)", EcclesiarchyRelics);
		o6.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
		o6.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
		o6.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);
		
		int selected = 0;

		if(o1!=null && o4!=null && o5!=null){
			if(ClanRaukaan){
				o1.setAktiv(false);
				o4.setAktiv(true);
				o5.setAktiv(false);
				if(isOrdenspriester){
					handwaffen.setAktiv("[SoT] The Angel of Sacrifice",false);
				}
			}else if(SentinelsOfTerra){
				o1.setAktiv(false);
				o4.setAktiv(false);
				o5.setAktiv(true);
				if(isOrdenspriester){
					handwaffen.setAktiv("[SoT] The Angel of Sacrifice",true);
				}
			}
			else{		
				o1.setAktiv(true);
				o4.setAktiv(false);
				o5.setAktiv(false);
				if(isOrdenspriester){
					handwaffen.setAktiv("[SoT] The Angel of Sacrifice",false);
				}
			}
		}

		if(isOrdensmeister || isSkriptor || isAbsolutionspriester || isOrdenspriester || isTechmarine) {
			selected = (handwaffen.getAnzahl()+fkwaffen.getAnzahl()+o2.getAnzahl()+o1.getAnzahl() +o3.getAnzahl()*2);
			handwaffen.setMaxAnzahl((selected<2 || handwaffen.isSelected())?1:0);
			fkwaffen.setMaxAnzahl((selected<2 || fkwaffen.isSelected())?1:0);
			o1.setMaxAnzahl((selected<2 || o1.isSelected())?1:0);
			o2.setMaxAnzahl(2-selected+o2.getAnzahl());
			o3.setMaxAnzahl(selected>0?0:1);	
			legal = selected == 2;
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}

		//		glaiveOfVengeance.setAktiv(SonsOfTheGreatKhan);
		//	    huntersEye.setAktiv(SonsOfTheGreatKhan);
		mantleOfTheStormseer.setAktiv(isSkriptor);
		//	    scimitarOfTheGreatKhan.setAktiv(SonsOfTheGreatKhan);
		//	    wraithOfTheHeavens.setAktiv(SonsOfTheGreatKhan);



		//Einzigartige Gegenstände
		if(o1.isSelected("Der Zorn des Primarchen")){
			if(wrathBool==false){
				wrathBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMWrath", 1);
			}
		} else if(!o1.isSelected("Der Zorn des Primarchen")) {
			if(wrathBool==true){
				wrathBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMWrath", -1);
			}
		}

		if(o1.isSelected("Die Zähne Terras")){
			if(teethBool==false){
				teethBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMTeeth", 1);
			}
		} else if(!o1.isSelected("Die Zähne Terras")) {
			if(teethBool==true){
				teethBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMTeeth", -1);
			}
		}

		if(o1.isSelected("Der Schild der Ewigkeit")){
			if(shieldBool==false){
				shieldBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMShield", 1);
			}
		} else if(!o1.isSelected("Der Schild der Ewigkeit")) {
			if(shieldBool==true){
				shieldBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMShield", -1);
			}
		}

		if(o1.isSelected("Die Brennende Klinge")){
			if(bladeBool==false){
				bladeBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMBlade", 1);
			}
		} else if(!o1.isSelected("Die Brennende Klinge")) {
			if(bladeBool==true){
				bladeBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMBlade", -1);
			}
		}

		if(armour.isSelected()){
			if(armourBool==false){
				armourBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMArmour", 1);
			}
		} else if(!armour.isSelected()) {
			if(armourBool==true){
				armourBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMArmour", -1);
			}
		}

		if(glaiveOfVengeance.isSelected()){
			if(glaiveOfVengeanceBool==false){
				glaiveOfVengeanceBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", 1);
			}
		} else if(!glaiveOfVengeance.isSelected()) {
			if(glaiveOfVengeanceBool==true){
				glaiveOfVengeanceBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", -1);
			}
		}

		if(huntersEye.isSelected()){
			if(huntersEyeBool==false){
				huntersEyeBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", 1);
			}
		} else if(!huntersEye.isSelected()) {
			if(huntersEyeBool==true){
				huntersEyeBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", -1);
			}
		}

		if(mantleOfTheStormseer.isSelected()){
			if(mantleOfTheStormseerBool==false){
				mantleOfTheStormseerBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", 1);
			}
		} else if(!mantleOfTheStormseer.isSelected()) {
			if(mantleOfTheStormseerBool==true){
				mantleOfTheStormseerBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", -1);
			}
		}

		if(scimitarOfTheGreatKhan.isSelected()){
			if(scimitarOfTheGreatKhanBool==false){
				scimitarOfTheGreatKhanBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", 1);
			}
		} else if(!scimitarOfTheGreatKhan.isSelected()) {
			if(scimitarOfTheGreatKhanBool==true){
				scimitarOfTheGreatKhanBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", -1);
			}
		}

		if(wraithOfTheHeavens.isSelected()){
			if(wraithOfTheHeavensBool==false){
				wraithOfTheHeavensBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMwraithOfTheHeavens", 1);
			}
		} else if(!wraithOfTheHeavens.isSelected()) {
			if(wraithOfTheHeavensBool==true){
				wraithOfTheHeavensBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMwraithOfTheHeavens", -1);
			}
		}

		if(armourOfShadows.isSelected()){
			if(armourOfShadowsBool==false){
				armourOfShadowsBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", 1);
			}
		} else if(!armourOfShadows.isSelected()) {
			if(armourOfShadowsBool==true){
				armourOfShadowsBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", -1);
			}
		}

		if(exTenebris.isSelected()){
			if(exTenebrisBool==false){
				exTenebrisBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMexTenebris", 1);
			}
		} else if(!exTenebris.isSelected()) {
			if(exTenebrisBool==true){
				exTenebrisBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMexTenebris", -1);
			}
		}

		if(ravenSkullofKorvaad.isSelected()){
			if(ravenSkullofKorvaadBool==false){
				ravenSkullofKorvaadBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", 1);
			}
		} else if(!ravenSkullofKorvaad.isSelected()) {
			if(ravenSkullofKorvaadBool==true){
				ravenSkullofKorvaadBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", -1);
			}
		}

		if(ravensFury.isSelected()){
			if(ravensFuryBool==false){
				ravensFuryBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMravensFury", 1);
			}
		} else if(!ravensFury.isSelected()) {
			if(ravensFuryBool==true){
				ravensFuryBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMravensFury", -1);
			}
		}

		if(o3.isSelected()){
			if(swiftstrikeAndMurderBool==false){
				swiftstrikeAndMurderBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMswiftstrikeAndMurder", 1);
			}
		} else if(!o3.isSelected()) {
			if(swiftstrikeAndMurderBool==true){
				swiftstrikeAndMurderBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMswiftstrikeAndMurder", -1);
			}
		}

		if(o4.isSelected("The Mindforge Stave")){
			if(mindforgeBool==false){
				mindforgeBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMMind", 1);
			}
		} else if(!o4.isSelected("The Mindforge Stave")) {
			if(mindforgeBool==true){
				mindforgeBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMMind", -1);
			}
		}

		if(o4.isSelected("The Axe of Medusa")){
			if(axeBool==false){
				axeBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMAxe", 1);
			}
		} else if(!o4.isSelected("The Axe of Medusa")) {
			if(axeBool==true){
				axeBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMAxe", -1);
			}
		}

		if(o4.isSelected("The Ironstone")){
			if(stoneBool==false){
				stoneBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMStone", 1);
			}
		} else if(!o4.isSelected("The Ironstone")) {
			if(stoneBool==true){
				stoneBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMStone", -1);
			}
		}

		if(o4.isSelected("Betrayer´s Bane")){
			if(baneBool==false){
				baneBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMBane", 1);
			}
		} else if(!o4.isSelected("Betrayer´s Bane")) {
			if(baneBool==true){
				baneBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMBane", -1);
			}
		}

		if(o4.isSelected("The Gorgon´s Chain")){
			if(chainBool==false){
				chainBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMChain", 1);
			}
		} else if(!o4.isSelected("The Gorgon´s Chain")) {
			if(chainBool==true){
				chainBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMChain", -1);
			}
		}

		if(o4.isSelected("The Tempered Helm")){
			if(helmBool==false){
				helmBool=true;
				BuildaHQ.addToInformationVectorGlobal("SMHelm", 1);
			}
		} else if(!o4.isSelected("The Tempered Helm")) {
			if(helmBool==true){
				helmBool=false;
				BuildaHQ.addToInformationVectorGlobal("SMHelm", -1);
			}
		}

		if(handwaffen.isSelected("[SoT] The Angel of Sacrifice")){
			if(AngelOfSacrifice==false){
				AngelOfSacrifice=true;
				BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", 1);
			}
		} else if(!handwaffen.isSelected("[SoT] The Angel of Sacrifice")) {
			if(AngelOfSacrifice==true){
				AngelOfSacrifice=false;
				BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", -1);
			}
		}

		if(o5.isSelected("[SoT] The Eye of Hypnoth")){
			if(EyeofHypnoth==false){
				EyeofHypnoth=true;
				BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", 1);
			}
		} else if(!o5.isSelected("[SoT] The Eye of Hypnoth")) {
			if(EyeofHypnoth==true){
				EyeofHypnoth=false;
				BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", -1);
			}
		}

		if(o5.isSelected("[SoT] The Bones of Osrak")){
			if(BonesofOsrak==false){
				BonesofOsrak=true;
				BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", 1);
			}
		} else if(!o5.isSelected("[SoT] The Bones of Osrak")) {
			if(BonesofOsrak==true){
				BonesofOsrak=false;
				BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", -1);
			}
		}

		if(o5.isSelected("[SoT] The Spartean")){
			if(Spartean==false){
				Spartean=true;
				BuildaHQ.addToInformationVectorGlobal("SMSpartean", 1);
			}
		} else if(!o5.isSelected("[SoT] The Spartean")) {
			if(Spartean==true){
				Spartean=false;
				BuildaHQ.addToInformationVectorGlobal("SMSpartean", -1);
			}
		}
		
		if(o6.isSelected("Skull of Petronella the Pious (GS)")){
			if(SkullofPetronella==false){
				SkullofPetronella=true;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
			}
		} else if(!o6.isSelected("Skull of Petronella the Pious (GS)")) {
			if(SkullofPetronella==true){
				SkullofPetronella=false;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
			}
		}
		
		if(o6.isSelected("Blade of the Worthy (GS)")){
			if(BladeoftheWorthy==false){
				BladeoftheWorthy=true;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
			}
		} else if(!o6.isSelected("Blade of the Worthy (GS)")) {
			if(BladeoftheWorthy==true){
				BladeoftheWorthy=false;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
			}
		}
		
		if(o6.isSelected("Castigator (GS)")){
			if(Castigator==false){
				Castigator=true;
				BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
			}
		} else if(!o6.isSelected("Castigator (GS)")) {
			if(Castigator==true){
				Castigator=false;
				BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
			}
		}
		
		if(o6.isSelected("The Font of Fury (GS)")){
			if(TheFontofFury==false){
				TheFontofFury=true;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
			}
		} else if(!o6.isSelected("The Font of Fury (GS)")) {
			if(TheFontofFury==true){
				TheFontofFury=false;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
			}
		}
		
		if(o6.isSelected("Shroud of the Anti-Martyr (GS)")){
			if(ShroudoftheAntiMartyr==false){
				ShroudoftheAntiMartyr=true;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
			}
		} else if(!o6.isSelected("Shroud of the Anti-Martyr (GS)")) {
			if(ShroudoftheAntiMartyr==true){
				ShroudoftheAntiMartyr=false;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
			}
		}
		//Desvalles's Holy Circle - 35
		if(o6.isSelected("Desvalles's Holy Circle (GS)")){
			if(DesvallessHolyCircle==false){
				DesvallessHolyCircle=true;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
			}
		} else if(!o6.isSelected("Desvalles's Holy Circle (GS)")) {
			if(DesvallessHolyCircle==true){
				DesvallessHolyCircle=false;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
			}
		}

		if(BuildaHQ.getCountFromInformationVectorGlobal("SMWrath")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMTeeth")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMShield")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMBlade")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMArmour")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMglaiveOfVengeance")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMhuntersEye")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMmantleOfTheStormseer")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMscimitarOfTheGreatKhan")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMwraithOfTheHeavens")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMarmourOfShadows")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMexTenebris")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMravenSkullofKorvaad")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMravensFury")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMswiftstrikeAndMurder")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("SMMind")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMAxe")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMStone")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMBane")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMChain")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMHelm")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMAngelOfSacrifice")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMEyeofHypnoth")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMBonesofOsrak")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SMSpartean")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SkullofPetronella")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("BladeoftheWorthy")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("Castigator")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("TheFontofFury")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ShroudoftheAntiMartyr")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("DesvallessHolyCircle")>1) {
			uniqueError=true;
		}else{
			uniqueError=false;
		}
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		boolean entrySwitched=false;

		if(entrySwitched){
			System.out.println("entryswitched SMWaffenundReliquien");
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}

	@Override
	public void deleteYourself() {

		if(AngelOfSacrifice==true){
			AngelOfSacrifice=false;
			BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", -1);
		}

		if(EyeofHypnoth==true){
			EyeofHypnoth=false;
			BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", -1);
		}

		if(BonesofOsrak==true){
			BonesofOsrak=false;
			BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", -1);
		}

		if(Spartean==true){
			Spartean=false;
			BuildaHQ.addToInformationVectorGlobal("SMSpartean", -1);
		}

		if(wrathBool==true){
			wrathBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMWrath", -1);
		}

		if(teethBool==true){
			teethBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMTeeth", -1);
		}

		if(shieldBool==true){
			shieldBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMShield", -1);
		}

		if(bladeBool==true){
			bladeBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMBlade", -1);
		}

		if(armourBool==true){
			armourBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMArmour", -1);
		}

		if(glaiveOfVengeanceBool==true){
			glaiveOfVengeanceBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", -1);
		}

		if(huntersEyeBool==true){
			huntersEyeBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", -1);
		}

		if(mantleOfTheStormseerBool==true){
			mantleOfTheStormseerBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", -1);
		}

		if(scimitarOfTheGreatKhanBool==true){
			scimitarOfTheGreatKhanBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", -1);
		}

		if(wraithOfTheHeavensBool==true){
			wraithOfTheHeavensBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMwraithOfTheHeavens", -1);
		}

		if(armourOfShadowsBool==true){
			armourOfShadowsBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", -1);
		}

		if(exTenebrisBool==true){
			exTenebrisBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMexTenebris", -1);
		}

		if(ravenSkullofKorvaadBool==true){
			ravenSkullofKorvaadBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", -1);
		}

		if(ravensFuryBool==true){
			ravensFuryBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMravensFury", -1);
		}

		if(swiftstrikeAndMurderBool==true){
			swiftstrikeAndMurderBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMswiftstrikeAndMurder", -1);
		}

		if(mindforgeBool==true){
			mindforgeBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMMind", -1);
		}

		if(axeBool==true){
			axeBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMAxe", -1);
		}

		if(stoneBool==true){
			stoneBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMStone", -1);
		}

		if(baneBool==true){
			baneBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMBane", -1);
		}

		if(chainBool==true){
			chainBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMChain", -1);
		}

		if(helmBool==true){
			helmBool=false;
			BuildaHQ.addToInformationVectorGlobal("SMHelm", -1);
		}

		if(SkullofPetronella==true){
			SkullofPetronella=false;
			BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
		}

		if(BladeoftheWorthy==true){
			BladeoftheWorthy=false;
			BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
		}
		
		if(Castigator==true){
			Castigator=false;
			BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
		}
		
		if(TheFontofFury==true){
			TheFontofFury=false;
			BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
		}
		
		if(ShroudoftheAntiMartyr==true){
			ShroudoftheAntiMartyr=false;
			BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
		}
		
		if(DesvallessHolyCircle==true){
			DesvallessHolyCircle=false;
			BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
		}
		
		super.deleteYourself();
	}

}
