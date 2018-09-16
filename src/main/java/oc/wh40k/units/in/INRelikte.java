package oc.wh40k.units.in;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class INRelikte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
    boolean liberBool=false;
    boolean tomeBool=false;
    boolean grimoireBool=false;
    boolean SkullofPetronella=false;
    boolean BladeoftheWorthy=false;
    boolean Castigator=false;
    boolean TheFontofFury=false;
    boolean ShroudoftheAntiMartyr=false;
    boolean DesvallessHolyCircle=false;
    boolean uniqueError=false;
	
	public INRelikte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
	    ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Grimoire of True Names"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Liber Heresius"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Tome of Vethric"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Relikte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics")>0;
		
		o1.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
		o1.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
		o1.setAktiv("Castigator (GS)", EcclesiarchyRelics);
		o1.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
		o1.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
		o1.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("The Grimoire of True Names")){
			if(grimoireBool==false){
				grimoireBool=true;
				BuildaHQ.addToInformationVectorGlobal("INGrimoire", 1);
			}
		} else if(!o1.isSelected("The Grimoire of True Names")) {
			if(grimoireBool==true){
				grimoireBool=false;
				BuildaHQ.addToInformationVectorGlobal("INGrimoire", -1);
			}
		}
		
		if(o1.isSelected("The Tome of Vethric")){
			if(tomeBool==false){
				tomeBool=true;
				BuildaHQ.addToInformationVectorGlobal("INTome", 1);
			}
		} else if(!o1.isSelected("The Tome of Vethric")) {
			if(tomeBool==true){
				tomeBool=false;
				BuildaHQ.addToInformationVectorGlobal("INTome", -1);
			}
		}
		
		if(o1.isSelected("The Liber Heresius")){
			if(liberBool==false){
				liberBool=true;
				BuildaHQ.addToInformationVectorGlobal("INLiber", 1);
			}
		} else if(!o1.isSelected("The Liber Heresius")) {
			if(liberBool==true){
				liberBool=false;
				BuildaHQ.addToInformationVectorGlobal("INLiber", -1);
			}
		}
		
		if(o1.isSelected("Skull of Petronella the Pious (GS)")){
			if(SkullofPetronella==false){
				SkullofPetronella=true;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
			}
		} else if(!o1.isSelected("Skull of Petronella the Pious (GS)")) {
			if(SkullofPetronella==true){
				SkullofPetronella=false;
				BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
			}
		}
		
		if(o1.isSelected("Blade of the Worthy (GS)")){
			if(BladeoftheWorthy==false){
				BladeoftheWorthy=true;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
			}
		} else if(!o1.isSelected("Blade of the Worthy (GS)")) {
			if(BladeoftheWorthy==true){
				BladeoftheWorthy=false;
				BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
			}
		}
		
		if(o1.isSelected("Castigator (GS)")){
			if(Castigator==false){
				Castigator=true;
				BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
			}
		} else if(!o1.isSelected("Castigator (GS)")) {
			if(Castigator==true){
				Castigator=false;
				BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
			}
		}
		
		if(o1.isSelected("The Font of Fury (GS)")){
			if(TheFontofFury==false){
				TheFontofFury=true;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
			}
		} else if(!o1.isSelected("The Font of Fury (GS)")) {
			if(TheFontofFury==true){
				TheFontofFury=false;
				BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
			}
		}
		
		if(o1.isSelected("Shroud of the Anti-Martyr (GS)")){
			if(ShroudoftheAntiMartyr==false){
				ShroudoftheAntiMartyr=true;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
			}
		} else if(!o1.isSelected("Shroud of the Anti-Martyr (GS)")) {
			if(ShroudoftheAntiMartyr==true){
				ShroudoftheAntiMartyr=false;
				BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
			}
		}
		//Desvalles's Holy Circle - 35
		if(o1.isSelected("Desvalles's Holy Circle (GS)")){
			if(DesvallessHolyCircle==false){
				DesvallessHolyCircle=true;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
			}
		} else if(!o1.isSelected("Desvalles's Holy Circle (GS)")) {
			if(DesvallessHolyCircle==true){
				DesvallessHolyCircle=false;
				BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
			}
		}
		
		if(BuildaHQ.getCountFromInformationVectorGlobal("INGrimoire")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("INTome")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("INLiber")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("SkullofPetronella")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("BladeoftheWorthy")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("Castigator")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("TheFontofFury")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("ShroudoftheAntiMartyr")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("DesvallessHolyCircle")>1){
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
	public void deleteYourself() {
		
		if(grimoireBool==true){
			grimoireBool=false;
			BuildaHQ.addToInformationVectorGlobal("INGrimoire", -1);
		}
					
		if(tomeBool==true){
			tomeBool=false;
			BuildaHQ.addToInformationVectorGlobal("INTome", -1);
		}
					
		if(liberBool==true){
			liberBool=false;
			BuildaHQ.addToInformationVectorGlobal("INLiber", -1);
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
