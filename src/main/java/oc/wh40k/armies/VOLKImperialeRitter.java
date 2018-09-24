package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKImperialeRitter extends BuildaVater {

  public VOLKImperialeRitter() {
    reflectionKennung = "IR";
    
    HQeinträge = new String[] {""};
    Eliteeinträge = new String[] {""};
    Standardeinträge = new String[] {""};
    Sturmeinträge = new String[] {""};
    Unterstützungeinträge = new String[] {""};
    LordofWar = new String[] {"", "Knight Paladin", "Knight Errant", "Knight Warden", "Knight Crusader", "Knight Gallant",
    		"","[WDW] Gerantinus",
    		"","[FW] Cerastus Knight-Acheron","[FW] Cerastus Knight-Castigator","[FW] Cerastus Knight-Lancer","[FW] Questoris Knight Magaera"};
    
    
    
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 1, HQeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 2, Eliteeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 3, Standardeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 4, Sturmeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 5, Unterstützungeinträge));
    adden(new ChooserGruppe(this,"FO", outOfPanel, 0, 6, Befestigungen));
    adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));

    cnt += CHOOSERGRUPPEN_X_ABSTAND;
    cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

    nameDerArtDerArmee = "Imperiale Ritter";
    nameDerArtDerArmeeDekliniert = "Imperiale Ritter";
    textAreaUeberschrift = BuildaHQ.translate("Imperiale Ritter");

    noAllies.clear();
    noAllies.add("IR");

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
	battleBrothers.add("CU");
	battleBrothers.add("SK");
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
    
	//Verschiedene Spezialkontingente der IR
		kontingente.add("");
		kontingente.add("Hausverband-Kontingent");//Lord Baron: darf 1 Erbstück haben
		kontingente.add("Eidgebundenen-Kontingent");//Nicht als Hauptkontingent
		kontingente.add("");
		kontingente.add("Adeptus Mechanicus War Convocation");
	
		minAuswahlen.put("Hausverband-Kontingent", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Hausverband-Kontingent", new int[]{0,0,0,0,0,0,5,0});
		
		minAuswahlen.put("Eidgebundenen-Kontingent", new int[]{0,0,0,0,0,0,1,0});
		maxAuswahlen.put("Eidgebundenen-Kontingent", new int[]{0,0,0,0,0,0,3,0});
		
		formationen.add("Adamantine Lance (Sanctus Reach)");
	
		minAuswahlen.put("Adamantine Lance (Sanctus Reach)", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Adamantine Lance (Sanctus Reach)", new int[]{0,0,0,0,0,0,3,0});
		
		formationen.add("");
		formationen.add("Royal Court");//5 Ritter alle dürfen Erbstücke haben
		formationen.add("Baronial Court");//3-5 Lord Baron: darf 1 Erbstück haben
		formationen.add("Tripartite Lance");//Warden, Gallant, Crusader
		formationen.add("Gallant Lance");//3 Gallant
		formationen.add("Skyreaper Lance");//3 Ritter //alle müssen Icarus wählen
		
		minAuswahlen.put("Royal Court", new int[]{0,0,0,0,0,0,5,0});
		maxAuswahlen.put("Royal Court", new int[]{0,0,0,0,0,0,5,0});
		
		minAuswahlen.put("Baronial Court", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Baronial Court", new int[]{0,0,0,0,0,0,5,0});
		
		minAuswahlen.put("Tripartite Lance", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Tripartite Lance", new int[]{0,0,0,0,0,0,3,0});

		minAuswahlen.put("Gallant Lance", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Gallant Lance", new int[]{0,0,0,0,0,0,3,0});
		
		minAuswahlen.put("Skyreaper Lance", new int[]{0,0,0,0,0,0,3,0});
		maxAuswahlen.put("Skyreaper Lance", new int[]{0,0,0,0,0,0,3,0});
		
		int[] arr10 = {0,0,0,0,0,0,0,0};
		minAuswahlen.put("Adeptus Mechanicus War Convocation",arr10);
		minAuswahlen.put("Adeptus Mechanicus War Convocation",arr10);
		
    complete();
  }

  public void changeFormations(){
		if(getCountFromInformationVector("Conclave Aquisitorius")>0){
			formationBox.addItem("Imperial Knights");
			
			minAuswahlen.put("Imperial Knights",new int[] {0,0,0,0,0,0,1,0});
			maxAuswahlen.put("Imperial Knights",new int[] {0,0,0,0,0,0,2,0});
			myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
		}
	}
  
  @Override
	public void volkRefresh() {
		setInformationVectorValue("Lord Baron", 0);
		setInformationVectorValue("Skyreaper", 0);
		Hauptkontingent.setEnabled(true);
	  
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
		}else if(getKontingentTyp().equals("Adamantine Lance (Sanctus Reach)")){
			//oc.BuildaHQ.getChooserGruppe(7).addSpezialAuswahl("Ritter");
//			if(!isLoading){
//				addUnit(6,"Ritter");
//				addUnit(6,"Ritter");
//				addUnit(6,"Ritter");
//			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Royal Court")){
			setInformationVectorValue("Lord Baron", 5);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Baronial Court")){
			setInformationVectorValue("Lord Baron", 1);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Tripartite Lance")){
			if(!isLoading){
				addUnit(6,"Knight Warden");
				addUnit(6,"Knight Gallant");
				addUnit(6,"Knight Crusader");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Gallant Lance")){
			if(!isLoading){
				addUnit(6,"Knight Gallant");
				addUnit(6,"Knight Gallant");
				addUnit(6,"Knight Gallant");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Skyreaper Lance")){
			setInformationVectorValue("Skyreaper", 1);
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else if(getKontingentTyp().equals("Hausverband-Kontingent")){
			setInformationVectorValue("Lord Baron", 1);
		}else if(getKontingentTyp().equals("Eidgebundenen-Kontingent")){
			Hauptkontingent.setEnabled(false);
		}
		
		fillChooserSpace();
}
  
  @Override
  protected void finalize() {
    System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
  }
}
