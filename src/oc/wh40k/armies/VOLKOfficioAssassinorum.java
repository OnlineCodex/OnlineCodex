package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKOfficioAssassinorum extends BuildaVater {

  public VOLKOfficioAssassinorum() {
    reflectionKennung = "OA";

    HQeinträge = new String[] {""};
    Eliteeinträge = new String[] {"", "Vindicare Assassine", "Callidus Assassine", "Eversor Assassine", "Culexus Assassine"};
    Standardeinträge = new String[] {""};
    Sturmeinträge = new String[] {""};
    Unterstützungeinträge = new String[] {""};
    Befestigungen = new String[]{""};
    LordofWar = new String[] {""};
    
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 1, HQeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Eliteeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 3, Standardeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 4, Sturmeinträge));
    adden(new ChooserGruppe(this,reflectionKennung, outOfPanel, 0, 5, Unterstützungeinträge));
    adden(new ChooserGruppe(this,"FO", outOfPanel, 0, 6, Befestigungen));
    adden(new ChooserGruppe(this,"APO", outOfPanel, 0, 7, LordofWar));
    

    cnt += CHOOSERGRUPPEN_X_ABSTAND;
    cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

    nameDerArtDerArmee = "Officio Assassinorum";
    nameDerArtDerArmeeDekliniert = "Officio Assassinorum";
    textAreaUeberschrift = BuildaHQ.translate("Officio Assassinorum");

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
	
	//Verschiedene Spezialkontingente des AM
	formationen.add("Assassinorum Execution Force");
    
	//Min/max-Auswahlen je Spezialkontingent
	int[] arr1 = {0,4,0,0,0,0,0,0};
	minAuswahlen.put("Assassinorum Execution Force",arr1);
	maxAuswahlen.put("Assassinorum Execution Force", arr1);
	
	//Es gibt nur das Officio Assassinorum Detachment
	kontingente.add("");
	kontingente.add("Officio Assassinorum Detachment");
	
	//Min/max-Auswahlen je Spezialkontingent
	int[] arr2 = {0,1,0,0,0,0,0,0};
	minAuswahlen.put("Officio Assassinorum Detachment", arr2);
	maxAuswahlen.put("Officio Assassinorum Detachment", arr2);
	
    complete();
  }

  @Override
	public void volkRefresh() {
	  
		if(getKontingentTyp().equals("Assassinorum Execution Force")){
			setInformationVectorValue("Execution Force", 1);
			if(!isLoading){
				addUnit(1,"Eversor Assassine");
				addUnit(1,"Callidus Assassine");
				addUnit(1,"Culexus Assassine");
				addUnit(1,"Vindicare Assassine");
			}
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}else{
			setInformationVectorValue("Execution Force", 0);
		}
		
		fillChooserSpace();
  }
  
  @Override
  protected void finalize() {
    System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
  }
}
