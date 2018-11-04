package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.Formation;
import oc.FormationEntry;
import oc.RefreshListener;
import oc.Superformation;

public class VOLKEldarCorsairsIA112ndEd extends BuildaVater {

	public VOLKEldarCorsairsIA112ndEd() {
		reflectionKennung = "EC";

		HQeinträge = new String[] {"", "Corsair Prince", "Corsair Void Dreamer", "Corsair Baron"};
		Standardeinträge = new String[] {"", "Corsair Reaver Band", "Corsair Ghostwalker Band", "Corsair Cloud Dancer Band",}; 
		Eliteeinträge = new String[] {"", "Corsair Voidstorm Band", "Corsair Malevolent Band", "Corsair Wasp Squadron"}; 
		Sturmeinträge = new String[] {"", "Corsair Vyper Squadron" , "Corsair Nightwing", "Corsair Phoenix", "Corsair Hornet Squadron"};
		Unterstützungeinträge = new String[] {"", "Corsair Balestrike Band", "Corsair Lynx", "Corsair Warp Hunter Squadron", "Corsair Night Spinner", 
												  "Corsair Fire Storm", "Corsair Fire Prism"};
		LordofWar = new String[] {"", "Corsair Vampire Raider"};
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
        adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));
		cnt += 480;

		nameDerArtDerArmee = "Eldar Corsairs";
		nameDerArtDerArmeeDekliniert = "Eldar Corsairs";
		textAreaUeberschrift = "Eldar Corsairs Armee";

		noAllies.clear();

		noAllies.add("EL");
		noAllies.add("EC");
		noAllies.add("NE");
		noAllies.add("CD");
		noAllies.add("TY");
		
		battleBrothers.add("EC");
		battleBrothers.add("EL");
		battleBrothers.add("DE");
        battleBrothers.add("HQ");
		
        desperateAllies.add("AB");
        desperateAllies.add("AM");
        desperateAllies.add("AS");
        desperateAllies.add("BA");
        desperateAllies.add("CR");
        desperateAllies.add("DA");
        desperateAllies.add("DK");
        desperateAllies.add("DKAB");
        desperateAllies.add("ED");
        desperateAllies.add("GK");
        desperateAllies.add("IN");
        desperateAllies.add("IR");
        desperateAllies.add("MT");
        desperateAllies.add("SF");
        desperateAllies.add("SM");
        desperateAllies.add("TL");
        desperateAllies.add("TA");
        desperateAllies.add("FE");
        desperateAllies.add("DW");
		desperateAllies.add("OR");
		desperateAllies.add("DM");
		desperateAllies.add("BL");
		desperateAllies.add("CM");
		desperateAllies.add("CS");
		desperateAllies.add("DH");
		desperateAllies.add("RH");
		desperateAllies.add("SY");
		
		//TODO 1 Prince in jedem Detachment
		
		//Verschiedene Spezialkontingente
		kontingente.add("");
		kontingente.add("Corsair Fleet Raiding Band FOC");
				
		//Min/max-Auswahlen je Spezialkontingent/Formation
		minAuswahlen.put("Corsair Fleet Raiding Band FOC", new int[] {0,0,0,0,0,0,0,0});
		maxAuswahlen.put("Corsair Fleet Raiding Band FOC", new int[] {0,0,0,0,0,0,0,0});
		
		complete();
	}
	
	public void changeFormations(){
		if(getCountFromInformationVector("Corsair Fleet Raiding Band FOC")>0){
			formationBox.addItem("Command Crew");
			formationBox.addItem("Primary Cotorie");
			formationBox.addItem("Optional Cotorie");
			
			minAuswahlen.put("Command Crew",new int[] {1,0,0,0,0,0,0,0});
			maxAuswahlen.put("Command Crew",new int[] {2,1,0,0,0,0,1,0});

			minAuswahlen.put("Primary Cotorie",new int[] {1,0,1,0,0,0,0,0});
			maxAuswahlen.put("Primary Cotorie",new int[] {1,2,3,2,1,0,0,0});
			
			minAuswahlen.put("Optional Cotorie",new int[] {1,0,1,0,0,0,0,0});
			maxAuswahlen.put("Optional Cotorie",new int[] {1,2,3,2,1,0,0,0});
		}
	}
	
	@Override
	public void volkRefresh() {	

		if(getKontingentTyp().equals("Corsair Fleet Raiding Band FOC")){ //Superformation))
			setInformationVectorValue("Corsair Fleet Raiding Band FOC", 1);
			
			if(formation!=null){
				formation.controlPanel.setLocation(outOfPanel, formation.controlPanel.getLocation().y);
				panel.remove(formation.controlPanel);
				formation.controlPanel.setVisible(false);
				formation=null;
			}
			
			superformation = new Superformation(getPanel(), 0);
			superformation.reflectionKennungLokal=reflectionKennungLokal;
			superformation.volkFile=getClass().getName();
			superformation.tA=buildatextArea;
			superformation.buildaVater=this;
			
			superformation.minCommand=1;
			superformation.maxCommand=1;
			superformation.minCore=1;
			superformation.maxCore=1;
			superformation.minAuxiliary=0;
			superformation.maxAuxiliary=3;

			superformation.namenCommand.add("");
			superformation.namenCommand.add("Command Crew");

			superformation.namenCore.add("");
			superformation.namenCore.add("Primary Cotorie");

			superformation.namenAuxiliary.add("");
			superformation.namenAuxiliary.add("Optional Cotorie");

			for(int i=0;i<myChooserGruppen.size();i++){
				myChooserGruppen.get(i).getPanel().setBounds(outOfPanel, 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
			}
			
			superformation.refreshControlPanel();
			
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);

			RefreshListener.fireRefresh();
		}
		
		
		if(getKontingentTyp().equals("Command Crew"))
		{
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge);
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar);
			
			formation=new Formation(this);
			formation.infoLabel.setText("<html>Info:<br>"
					+ "Für die gesamte Corsair Fleet Raiding Company gilt:<br>"
					+ "1 Corsair Prince.<br>"
					+ "0-1 Corsair Void Dreamer.<br>"
					+ "0-1 Corsair Lynx.<br>"
					+ "0-1 Corsair Warp Hunter Squadron.<br><html>");
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Prince"},1, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Void Dreamer"},0, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Lynx"},0, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Warp Hunter Squadron"},0, 1));
			
			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else if(getKontingentTyp().equals("Primary Cotorie") || getKontingentTyp().equals("Optional Cotorie"))
		{
			clearCombo();
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge);
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge);
			
			formation.infoLabel.setText("<html>Info:<br>"
					+ "Für die gesamte Corsair Fleet Raiding Company gilt:<br>"
					+ "1 Corsair Prince.<br>"
					+ "0-1 Corsair Void Dreamer.<br>"
					+ "0-1 Corsair Lynx.<br>"
					+ "0-1 Corsair Warp Hunter Squadron.<br><html>");
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Prince"},1, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Void Dreamer"},0, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Lynx"},0, 1));
//			formation.entries.add(new FormationEntry(new String[]{"Corsair Warp Hunter Squadron"},0, 1));

			kontingentBox.setEnabled(false);
			formationBox.setEnabled(false);
		}
		else
		{
			formation=new Formation(this);
			formation.entries.add(new FormationEntry(new String[]{"Corsair Prince"},1, 1));
			formation.entries.add(new FormationEntry(new String[]{"Corsair Void Dreamer"},0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Corsair Lynx"},0, 1));
			formation.entries.add(new FormationEntry(new String[]{"Corsair Warp Hunter Squadron"},0, 1));
		}

		if(formation!=null){
			formation.refreshControlPanel();
		}
		

		fillChooserSpace();
	}

	@Override
	protected void finalize() {
		LOGGER.info("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}

}