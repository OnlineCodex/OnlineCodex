package oc.wh40k.armies;

import java.io.InputStream;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VOLKNecrons extends BuildaVater {

	private static final Logger LOGGER = LoggerFactory.getLogger(VOLKNecrons.class);
	
	//Vanilla Necrons
	public String[] HQeinträge_NE = new String[] {"", "Overlord", "Lord", "Cryptek", "Destroyer Lord", "Catacomb Command Barge",};
	public String[] Standardeinträge_NE = new String[] {"", "Necron Warriors", "Immortals",};
	public String[] Eliteeinträge_NE = new String[] {"", "Lychguard", "Deathmarks", "Flayed Ones",};
	public String[] Sturmeinträge_NE = new String[] {"", "Tomb Blades", "Destroyers",};
	public String[] Unterstützungeinträge_NE = new String[] {"", "Heavy Destroyers",  "Monolith", "Annihilation Barge", "Doomsday Ark",};
	public String[] Transporteinträge_NE = new String[] {"", "Ghost Ark",};
	public String[] Fliegereinträge_NE = new String[] {"", "Doom Scythe", "Night Scythe",};
	public String[] LordofWareinträge_NE = new String[]{"", "Obelisk",};
	
	//ohne Dynasty
	public String[] HQeinträge_Vanilla_only = new String[] {"", "Illuminor Szeras", "Anrakyr the Traveller",};
	public String[] Eliteeinträge_Vanilla_only = new String[] {"", "Triarch Praetorians", "Triarch Stalker",};
	
	//Sautekh Dynasty
	public String[] HQeinträge_Sautekh = new String[] {"", "Imotekh the Stormlord", "Nemesor Zahndrekh", "Vargard Obyron", "Orikan the Diviner",};
	
	//Nihilakh Dynasty
	public String[] HQeinträge_Nihilakh = new String[] {"", "Trazyn the Infinite",};
	
	//C'tan Shards
	public String[] Eliteeinträge_Ctan_Shards = new String[] {"", "C'tan Shard of the Deceiver", "C'tan Shard of the Nightbringer",};
	public String[] Unterstützungeinträge_Ctan_Shards = new String[] {"", "Transcendent C'tan",};
	
	//C'tan Shards & Dynasty
	public String[] LordofWareinträge_Ctan_Shards_Dynasty = new String[] {"", "Tesseract Vault",};
	
	//Canoptek
	public String[] Sturmeinträge_Canoptek = new String[] {"", "Canoptek Wraiths", "Canoptek Scarabs",};
	public String[] Unterstützungeinträge_Canoptek = new String[] {"", "Canoptek Spyders",};

	//Imperial Armour Xenos Vanilla
	public String[] Unterstützungeinträge_IA_NE = new String[] {"", "Sentry Pylon", "Tesseract Ark",};
	public String[] Fliegereinträge_IA_NE = new String[] {"", "Night Shroud",};
	public String[] LordofWareinträge_IA_NE = new String[]{"", "Gauss Pylon",};
	public String[] Befestigungen_IA_NE = new String[]{"", "Tomb Citadel",};
	
	//Imperial Armour Xenos Maynarkh Dynasty
	public String[] HQeinträge_IA_Maynarkh = new String[] {"", "Kutlakh the World Killer", "Toholk the Blinded",};
	
	//Imperial Armour Xenos Canoptek
	public String[] Eliteeinträge_IA_Canoptek = new String[] {"", "Canoptek Tomb Stalker",};
	public String[] Sturmeinträge_IA_Canoptek = new String[] {"", "Canoptek Acanthrites", "Canoptek Tomb Sentinel",};
	
	public VOLKNecrons() {
		reflectionKennung = "NE";
		InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ne.csv");
		pointValues = BuildaHQ.loadindexFile(is);
		
		is = this.getClass().getResourceAsStream("/oc/wh40k/indices/iane.csv");
		appendPointList(BuildaHQ.loadindexFile(is));
		
		AdditionalInformation = new String[] {""};
		HQeinträge = new String[] {""};
		Eliteeinträge = new String[] {"", "Custodian Guard Squad"};
		Standardeinträge = new String[] {""};
		Sturmeinträge = new String[] {""};
		Unterstützungeinträge = new String[] {""};
		Transporteinträge = new String[] {""};
		Fliegereinträge = new String[] {""};
		Befestigungen = new String[] {""};
		LordofWar = new String[] {""};
		
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, AI, AdditionalInformation));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, HQ, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, TR, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, EL, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FA, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, DT, Transporteinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FL, Fliegereinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, FORT, Befestigungen));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, LOW, LordofWar));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		
		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;
		
		//Formationen
		formationen.add("NECRONS");
		formationen.add("");
		formationen.add("Sautekh");
		formationen.add("Nihilakh");
		formationen.add("Novokh");
		formationen.add("Mephrit");
		formationen.add("Nephrekh");
		formationen.add("Maynarkh");
		formationen.add("");
		formationen.add("C'tan Shards");
		formationen.add("Canoptek");
		
		complete();		
	}

	@Override
	public void volkRefresh() {
		
		if(getFormationType().equals("NECRONS")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh, HQeinträge_Nihilakh, HQeinträge_IA_Maynarkh));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_NE));
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_NE));
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Sautekh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Nihilakh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Nihilakh));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Novokh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Mephrit")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Nephrekh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("Maynarkh")){
			myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_IA_Maynarkh));
			myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge_NE);
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
			myChooserGruppen.get(DT).changeComboBoxAuswahlen(Transporteinträge_NE);
			myChooserGruppen.get(FL).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
		} else if(getFormationType().equals("C'tan Shards")){
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_Ctan_Shards);
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_Ctan_Shards);
			myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWareinträge_Ctan_Shards_Dynasty);
		} else if(getFormationType().equals("Canoptek")){
			myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge_IA_Canoptek);
			myChooserGruppen.get(FA).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
			myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge_Canoptek);
			myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
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