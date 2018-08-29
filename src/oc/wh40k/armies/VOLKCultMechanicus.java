package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKCultMechanicus extends BuildaVater {

  public VOLKCultMechanicus() {
    reflectionKennung = "CU";

    HQeinträge = new String[] {"", "Tech-Priest Dominus", "Belisarius Cawl", "Celestine", "Inquisitor Greyfax"};
    Eliteeinträge = new String[] {"", "Fulgurite Electro-Priests", "Corpuscarii Electro-Priests"};
    Standardeinträge = new String[] {"", "Kataphron Breachers", "Kataphron Destroyers"};
    Sturmeinträge = new String[] {""};
    Unterstützungeinträge = new String[] {"", "Kastelan Robot Maniple"};
    LordofWar = new String[] {"", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan"};
    
	adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 1, HQeinträge));
	cnt += CHOOSERGRUPPEN_X_ABSTAND;
    adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Eliteeinträge));
    cnt += CHOOSERGRUPPEN_X_ABSTAND;
    adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 3, Standardeinträge));
    cnt += CHOOSERGRUPPEN_X_ABSTAND;
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 4, Sturmeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
	cnt += CHOOSERGRUPPEN_X_ABSTAND;
	adden(new ChooserGruppe(this,"FO", cnt, 0, 6, Befestigungen));
	cnt += CHOOSERGRUPPEN_X_ABSTAND;
	adden(new ChooserGruppe(this,"APO", cnt, 0, 7, LordofWar));
	cnt += 480;

    cnt += CHOOSERGRUPPEN_X_ABSTAND;
    cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

    nameDerArtDerArmee = "Cult Mechanicus";
    nameDerArtDerArmeeDekliniert = "Cult Mechanicus";
    textAreaUeberschrift = BuildaHQ.translate("Cult Mechanicus");

    noAllies.clear();
	noAllies.add("MT");
	noAllies.add("AM");
	noAllies.add("ED");
	noAllies.add("AB");
	noAllies.add("DK");
	noAllies.add("DKAB");

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
	
	//Verschiedene Spezialkontingente der Skitarii
	kontingente.add("");
	kontingente.add("Battle Congregation");
	kontingente.add("");
	kontingente.add("Adeptus Mechanicus War Convocation");
	
	//Formationen
	formationen.add("Holy Requisitioner");
	formationen.add("Numinous Conclave");
	formationen.add("Elimination Maniple");
	formationen.add("Cohort Cybernetica");
	
	//Min/max-Auswahlen je Spezialkontingent/Formation
	int[] arr1 = {1,0,2,0,0,0,0,0};
	minAuswahlen.put("Battle Congregation",arr1);
	int[] arr2 = {1,4,8,0,2,1,0,0};
	maxAuswahlen.put("Battle Congregation", arr2);
	
	int[] arr3 = {1,0,2,0,0,0,0,0};
	minAuswahlen.put("Holy Requisitioner",arr3);
	int[] arr4 = {1,0,3,0,0,0,0,0};
	maxAuswahlen.put("Holy Requisitioner", arr4);
	
	int[] arr5 = {0,4,0,0,0,0,0,0};
	minAuswahlen.put("Numinous Conclave",arr5);
	int[] arr6 = {0,6,0,0,0,0,0,0};
	maxAuswahlen.put("Numinous Conclave", arr6);
    
	int[] arr7 = {0,0,2,0,1,0,0,0};
	minAuswahlen.put("Elimination Maniple",arr7);
	int[] arr8 = {0,0,3,0,1,0,0,0};
	maxAuswahlen.put("Elimination Maniple", arr8);
	
	int[] arr9 = {1,0,0,0,2,0,0,0};
	minAuswahlen.put("Cohort Cybernetica",arr9);
	maxAuswahlen.put("Cohort Cybernetica", arr9);
	
	int[] arr10 = {0,0,0,0,0,0,0,0};
	minAuswahlen.put("Adeptus Mechanicus War Convocation",arr10);
	minAuswahlen.put("Adeptus Mechanicus War Convocation",arr10);
	
    complete();
  }

  @Override
	public void volkRefresh() {
		
	  if(getKontingentTyp().equals("Adeptus Mechanicus War Convocation")){ //Superformation))
			setInformationVectorValue("Adeptus Mechanicus War Convocation", 1);
			superformation = new Superformation(getPanel(), 1);
			superformation.reflectionKennungLokal="";
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.createKategorieDynamisch(1,1);
			superformation.addEintragDynamisch("", "");
			superformation.addEintragDynamisch("CU", "Battle Congregation"); //1
			
			superformation.createKategorieDynamisch(1,1);
			superformation.addEintragDynamisch("", "");
			superformation.addEintragDynamisch("SK", "Battle Maniple"); //1
			
			superformation.createKategorieDynamisch(1,1);
			superformation.addEintragDynamisch("", "");
			superformation.addEintragDynamisch("IR", "Eidgebundenen-Kontingent"); //1

			

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}

			superformation.refreshControlPanel();

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);

			RefreshListener.fireRefresh();
		}else if(getKontingentTyp().contains("Holy Requisitioner")){
			if(!isLoading){
				addUnitNotLocked(0,"Tech-Priest Dominus");
				
				addUnit(2,"Kataphron Breachers");
				addUnit(2,"Kataphron Breachers");
				
				myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tech-Priest Dominus", "Belisarius Cawl"});
				myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Kataphron Breachers"});
				myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			}
		}
		else if(getKontingentTyp().contains("Numinous Conclave")){
			if(!isLoading){
				addUnit(1,"Fulgurite Electro-Priests");
				addUnit(1,"Fulgurite Electro-Priests");
				addUnit(1,"Corpuscarii Electro-Priests");
				addUnit(1,"Corpuscarii Electro-Priests");
				
				myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Fulgurite Electro-Priests", "Corpuscarii Electro-Priests"});
				myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			}
		} else if(getKontingentTyp().contains("Elimination Maniple")){
			if(!isLoading){
				addUnit(2,"Kataphron Destroyers");
				addUnit(2,"Kataphron Destroyers");
				addUnit(4,"Kastelan Robot Maniple");
				
				myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Kataphron Destroyers"});
				myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Kastelan Robot Maniple"});
				myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			}
		} else if(getKontingentTyp().contains("Cohort Cybernetica")){
			if(!isLoading){
				addUnitNotLocked(0,"Tech-Priest Dominus");
				addUnit(4,"Kastelan Robot Maniple");
				addUnit(4,"Kastelan Robot Maniple");
				
				myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Tech-Priest Dominus", "Belisarius Cawl"});
				myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Kastelan Robot Maniple"});
				myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
				myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
			}
		}
		fillChooserSpace();
  }
  
  @Override
  protected void finalize() {
    System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
  }
}
