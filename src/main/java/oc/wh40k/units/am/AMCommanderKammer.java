//IA1 2nd Ed

package oc.wh40k.units.am;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class AMCommanderKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o7;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o8;
	OptionsUpgradeGruppe o1;
	boolean cadianDetachment = false;
	boolean uniqueError = false;
	boolean Loorbeer = false;
	boolean Autoreliquiar = false;
	boolean KlingederEroberung = false;
	boolean Todesmaske = false;
	boolean Kurovs = false;
	boolean Celeritas = false;
	boolean TheIronLeft = false;
	boolean VolkovsCane = false;
	boolean WrathofCadia = false;
    boolean SkullofPetronella=false;
    boolean BladeoftheWorthy=false;
    boolean Castigator=false;
    boolean TheFontofFury=false;
    boolean ShroudoftheAntiMartyr=false;
    boolean DesvallessHolyCircle=false;

	public AMCommanderKammer() {
		name = "Commander";
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o7.setAnzahl(0, 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		o2.setAnzahl(0, 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Loorbeer", "Der Lorbeer der Befehlsgewalt", 25));
		ogE.addElement(new OptionsGruppeEintrag("Autoreliquiar", "Das taktische Autoreliquiar des Tyberius", 25));
		ogE.addElement(new OptionsGruppeEintrag("Klinge der Eroberung", "Die Klinge der Eroberung", 25));
		ogE.addElement(new OptionsGruppeEintrag("Todesmaske", "Die Todesmaske des Ollanius", 30));
		ogE.addElement(new OptionsGruppeEintrag("Kurovs Aquila", 60));
		ogE.addElement(new OptionsGruppeEintrag("Celeritas (Cadians)", 10));
		ogE.addElement(new OptionsGruppeEintrag("The Iron Left (Cadians)", 25));
		ogE.addElement(new OptionsGruppeEintrag("Volkov's Cane (Cadians)", 10));
		ogE.addElement(new OptionsGruppeEintrag("Wrath of Cadia (Cadians)", 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 5));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprenggranaten", 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plattenrüstung", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnmäntel", 10));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		
		if(o8.isSelected("Die Klinge der Eroberung") || o8.isSelected("Blade of the Worthy (GS)"))
		{
			o2.setMaxAnzahl(0);
		}
		else
		{
			o2.setMaxAnzahl(1);
		}
		
		boolean amRelics = o8.isSelected("Der Lorbeer der Befehlsgewalt") || 
				o8.isSelected("Das taktische Autoreliquiar des Tyberius") || 
				o8.isSelected("Die Klinge der Eroberung") ||
				o8.isSelected("Die Todesmaske des Ollanius") ||
				o8.isSelected("Kurovs Aquila") ;
		boolean cadRelics = o8.isSelected("Celeritas (Cadians)") ||
				o8.isSelected("The Iron Left (Cadians)") ||
				o8.isSelected("Volkov's Cane (Cadians)") ||
				o8.isSelected("Wrath of Cadia (Cadians)");
		boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics")>0;
		
		o8.setAktiv("Der Lorbeer der Befehlsgewalt",!cadRelics); 
		o8.setAktiv("Das taktische Autoreliquiar des Tyberius",!cadRelics); 
		o8.setAktiv("Die Klinge der Eroberung",!cadRelics); 
		o8.setAktiv("Die Todesmaske des Ollanius",!cadRelics); 
		o8.setAktiv("Kurovs Aquila",!cadRelics); 
		o8.setAktiv("Celeritas (Cadians)",!amRelics && cadianDetachment);
		o8.setAktiv("The Iron Left (Cadians)",!amRelics && cadianDetachment);
		o8.setAktiv("Volkov's Cane (Cadians)",!amRelics && cadianDetachment);
		o8.setAktiv("Wrath of Cadia (Cadians)",!amRelics && cadianDetachment);
		
		o8.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
		o8.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
		o8.setAktiv("Castigator (GS)", EcclesiarchyRelics);
		o8.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
		o8.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
		o8.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);
		
		//Einzigartige Gegenstände
		if(o8.isSelected("Wrath of Cadia (Cadians)")){
			if(WrathofCadia==false){
				WrathofCadia=true;
				BuildaHQ.addToInformationVectorGlobal("AMWrathofCadia", 1);
			}
		} else if(!o8.isSelected("Wrath of Cadia (Cadians)")) {
			if(WrathofCadia==true){
				WrathofCadia=false;
				BuildaHQ.addToInformationVectorGlobal("AMWrathofCadia", -1);
			}
		}

		if(o8.isSelected("Volkov's Cane (Cadians)")){
			if(VolkovsCane==false){
				VolkovsCane=true;
				BuildaHQ.addToInformationVectorGlobal("AMVolkovsCane", 1);
			}
		} else if(!o8.isSelected("Volkov's Cane (Cadians)")) {
			if(VolkovsCane==true){
				VolkovsCane=false;
				BuildaHQ.addToInformationVectorGlobal("AMVolkovsCane", -1);
			}
		}

		if(o8.isSelected("The Iron Left  (Cadians)")){
			if(TheIronLeft==false){
				TheIronLeft=true;
				BuildaHQ.addToInformationVectorGlobal("AMTheIronLeft", 1);
			}
		} else if(!o8.isSelected("The Iron Left  (Cadians)")) {
			if(TheIronLeft==true){
				TheIronLeft=false;
				BuildaHQ.addToInformationVectorGlobal("AMTheIronLeft", -1);
			}
		}

		if(o8.isSelected("Celeritas (Cadians)")){
			if(Celeritas==false){
				Celeritas=true;
				BuildaHQ.addToInformationVectorGlobal("AMCeleritas", 1);
			}
		} else if(!o8.isSelected("Celeritas (Cadians)")) {
			if(Celeritas==true){
				Celeritas=false;
				BuildaHQ.addToInformationVectorGlobal("AMCeleritas", -1);
			}
		}

		if(o8.isSelected("Kurovs Aquila")){
			if(Kurovs==false){
				Kurovs=true;
				BuildaHQ.addToInformationVectorGlobal("AMKurovs", 1);
			}
		} else if(!o8.isSelected("Kurovs Aquila")) {
			if(Kurovs==true){
				Kurovs=false;
				BuildaHQ.addToInformationVectorGlobal("AMKurovs", -1);
			}
		}

		if(o8.isSelected("Die Todesmaske des Ollanius")){
			if(Todesmaske==false){
				Todesmaske=true;
				BuildaHQ.addToInformationVectorGlobal("AMTodesmaske", 1);
			}
		} else if(!o8.isSelected("Die Todesmaske des Ollanius")) {
			if(Todesmaske==true){
				Todesmaske=false;
				BuildaHQ.addToInformationVectorGlobal("AMTodesmaske", -1);
			}
		}

		if(o8.isSelected("Die Klinge der Eroberung")){
			if(KlingederEroberung==false){
				KlingederEroberung=true;
				BuildaHQ.addToInformationVectorGlobal("AMKlingederEroberung", 1);
			}
		} else if(!o8.isSelected("Die Klinge der Eroberung")) {
			if(KlingederEroberung==true){
				KlingederEroberung=false;
				BuildaHQ.addToInformationVectorGlobal("AMKlingederEroberung", -1);
			}
		}

		if(o8.isSelected("Das taktische Autoreliquiar des Tyberius")){
			if(Autoreliquiar==false){
				Autoreliquiar=true;
				BuildaHQ.addToInformationVectorGlobal("AMAutoreliquiar", 1);
			}
		} else if(!o8.isSelected("Das taktische Autoreliquiar des Tyberius")) {
			if(Autoreliquiar==true){
				Autoreliquiar=false;
				BuildaHQ.addToInformationVectorGlobal("AMAutoreliquiar", -1);
			}
		}

		if(o8.isSelected("Der Lorbeer der Befehlsgewalt")){
			if(Loorbeer==false){
				Loorbeer=true;
				BuildaHQ.addToInformationVectorGlobal("AMLoorbeer", 1);
			}
		} else if(!o8.isSelected("Der Lorbeer der Befehlsgewalt")) {
			if(Loorbeer==true){
				Loorbeer=false;
				BuildaHQ.addToInformationVectorGlobal("AMLoorbeer", -1);
			}
		}
		
		if(o8.isSelected("Skull of Petronella the Pious (GS)")){
			if(SkullofPetronella==false){
				SkullofPetronella=true;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
			}
		} else if(!o8.isSelected("Skull of Petronella the Pious (GS)")) {
			if(SkullofPetronella==true){
				SkullofPetronella=false;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
			}
		}
		
		if(o8.isSelected("Blade of the Worthy (GS)")){
			if(BladeoftheWorthy==false){
				BladeoftheWorthy=true;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
			}
		} else if(!o8.isSelected("Blade of the Worthy (GS)")) {
			if(BladeoftheWorthy==true){
				BladeoftheWorthy=false;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
			}
		}
		
		if(o8.isSelected("Castigator (GS)")){
			if(Castigator==false){
				Castigator=true;
				BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
			}
		} else if(!o8.isSelected("Castigator (GS)")) {
			if(Castigator==true){
				Castigator=false;
				BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
			}
		}
		
		if(o8.isSelected("The Font of Fury (GS)")){
			if(TheFontofFury==false){
				TheFontofFury=true;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
			}
		} else if(!o8.isSelected("The Font of Fury (GS)")) {
			if(TheFontofFury==true){
				TheFontofFury=false;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
			}
		}
		
		if(o8.isSelected("Shroud of the Anti-Martyr (GS)")){
			if(ShroudoftheAntiMartyr==false){
				ShroudoftheAntiMartyr=true;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
			}
		} else if(!o8.isSelected("Shroud of the Anti-Martyr (GS)")) {
			if(ShroudoftheAntiMartyr==true){
				ShroudoftheAntiMartyr=false;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
			}
		}
		//Desvalles's Holy Circle - 35
		if(o8.isSelected("Desvalles's Holy Circle (GS)")){
			if(DesvallessHolyCircle==false){
				DesvallessHolyCircle=true;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
			}
		} else if(!o8.isSelected("Desvalles's Holy Circle (GS)")) {
			if(DesvallessHolyCircle==true){
				DesvallessHolyCircle=false;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
			}
		}

		if(BuildaHQ.getCountFromInformationVectorGlobal("AMLoorbeer")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMAutoreliquiar")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMKlingederEroberung")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMTodesmaske")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMKurovs")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMCeleritas")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMTheIronLeft")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMVolkovsCane")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("AMWrathofCadia")>1 ||
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
	public void deleteYourself() {

		if(WrathofCadia==true){
			WrathofCadia=false;
			BuildaHQ.addToInformationVectorGlobal("AMWrathofCadia", -1);
		}

		if(VolkovsCane==true){
			VolkovsCane=false;
			BuildaHQ.addToInformationVectorGlobal("AMVolkovsCane", -1);
		}

		if(TheIronLeft==true){
			TheIronLeft=false;
			BuildaHQ.addToInformationVectorGlobal("AMTheIronLeft", -1);
		}

		if(Celeritas==true){
			Celeritas=false;
			BuildaHQ.addToInformationVectorGlobal("AMCeleritas", -1);
		}

		if(Kurovs==true){
			Kurovs=false;
			BuildaHQ.addToInformationVectorGlobal("AMKurovs", -1);
		}

		if(Todesmaske==true){
			Todesmaske=false;
			BuildaHQ.addToInformationVectorGlobal("AMTodesmaske", -1);
		}

		if(KlingederEroberung==true){
			KlingederEroberung=false;
			BuildaHQ.addToInformationVectorGlobal("AMKlingederEroberung", -1);
		}

		if(Autoreliquiar==true){
			Autoreliquiar=false;
			BuildaHQ.addToInformationVectorGlobal("AMAutoreliquiar", -1);
		}

		if(Loorbeer==true){
			Loorbeer=false;
			BuildaHQ.addToInformationVectorGlobal("AMLoorbeer", -1);
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
