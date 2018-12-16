package oc.wh40k.units.ch;

import org.omg.PortableServer.POAPackage.WrongAdapterHelper;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHWaffenkammerCD extends RuestkammerVater {

    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    //boolean psyker = false; //Daemon Prince, if not Khorne
    
    OptionsEinzelUpgrade armourofScorn;
    OptionsEinzelUpgrade theCrimsonCrown;
    OptionsEinzelUpgrade theEndlessGrimoire;
    OptionsEinzelUpgrade soulBane;
    OptionsEinzelUpgrade theImpossibleRobe;
    OptionsEinzelUpgrade hornofNurglesRot;
    OptionsEinzelUpgrade theEntropicKnell;
    OptionsEinzelUpgrade theForbiddenGem;
    OptionsEinzelUpgrade theMarkofExcess;
    OptionsEinzelUpgrade slothfulClaws;
    
    OptionsUpgradeGruppe nkwaffe;
    OptionsUpgradeGruppe fkwaffe;
    
    public CHWaffenkammerCD() {
        grundkosten = 0;
    }

    public void addRelics() {
    	if(keywords.contains(CHARACTER)) {
        	boolean hellforgedSword = false;
        	boolean bladeOfBlood = false;
        	boolean axeOfKhorne = false;
        	boolean daemonicAxe = false;
        	boolean rodOfSorcery = false;
        	boolean staffOfChange = false;
        	boolean plaguesword = false;
        	boolean witstealerSword = false;
	    	
	    	for(int i = 0; i < ogE.size(); i++) {
	    		if(ogE.get(i).getName().equals("Hellforged sword")) {
	    			hellforgedSword = true;
	    		} else if(ogE.get(i).getName().equals("Blade of blood")) {
	    			bladeOfBlood = true;
	    		} else if(ogE.get(i).getName().equals("Axe of Khorne")) {
	    			axeOfKhorne = true;
	    		} else if(ogE.get(i).getName().equals("Daemonic axe")) {
	    			daemonicAxe = true;
	    		} else if(ogE.get(i).getName().equals("Rod of sorcery")) {
	    			rodOfSorcery = true;
	    		} else if(ogE.get(i).getName().equals("Staff of change")) {
	    			staffOfChange = true;
	    		} else if(ogE.get(i).getName().equals("Plaguesword")) {
	    			plaguesword = true;
	    		} else if(ogE.get(i).getName().equals("Witstealer sword")) {
	    			witstealerSword = true;
	    		}
	    	}
	    	
	    	if(bladeOfBlood) {
        		ogE.addElement(new OptionsGruppeEintrag("A'rgath, the King of Blades", getPts("Blade of blood")).setRelic(true));
	    	} else if (hellforgedSword) {
        		ogE.addElement(new OptionsGruppeEintrag("A'rgath, the King of Blades", getPts("Hellforged sword")).setRelic(true));
	    	}
	    	
	    	
	    	if(axeOfKhorne) {
        		ogE.addElement(new OptionsGruppeEintrag("Skullreaver", getPts("Axe of Khorne")).setRelic(true));
	    	} else if(daemonicAxe) {
        		ogE.addElement(new OptionsGruppeEintrag("Skullreaver", getPts("Daemonic Axe")).setRelic(true));
	    	}
	    	
	    	if(rodOfSorcery || staffOfChange) {
        		ogE.addElement(new OptionsGruppeEintrag("The Everstave", getPts("Rod of Sorcery")).setRelic(true));
	    	}
	    	
	    	if(plaguesword) {
        		ogE.addElement(new OptionsGruppeEintrag("Corruption", getPts("Plaguesword")).setRelic(true));
	    	}
	    	
	    	if(witstealerSword) {
        		ogE.addElement(new OptionsGruppeEintrag("Soulstealer", getPts("Witstealer sword")).setRelic(true));
	    	} else if(hellforgedSword) {
        		ogE.addElement(new OptionsGruppeEintrag("Soulstealer", getPts("Hellforged sword")).setRelic(true));
	    	}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
    	add(armourofScorn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour of Scorn", 0).setRelic(true));
    	add(theCrimsonCrown = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crimson Crown", 0).setRelic(true));
    	add(theEndlessGrimoire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Endless Grimoire", 0).setRelic(true));
    	add(soulBane = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soul Bane", 0).setRelic(true));
    	add(theImpossibleRobe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Impossible Robe", 0).setRelic(true));
    	add(hornofNurglesRot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Horn of Nurgle's Rot", 0).setRelic(true));
    	add(theEntropicKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Entropic Knell", 0).setRelic(true));
    	add(theForbiddenGem = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Forbidden Gem", 0).setRelic(true));
    	add(theMarkofExcess = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Mark of Excess", 0).setRelic(true));
    	add(slothfulClaws = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Slothful Claws", 0).setRelic(true));
    	

        seperator();
    	
        if(keywords.contains(DAEMON_PRINCE_OF_CHAOS)) {
	    	ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword")));
	        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	
	        seperator();
	
	        ogE.addElement(new OptionsGruppeEintrag("Warp bolter", getPts("Warp bolter")));
	        addRelics();
	        add(fkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if(keywords.contains(BLOODMASTER) || keywords.contains(SKULLMASTER) || keywords.contains(BLOOD_THRONE)) {
	    	ogE.addElement(new OptionsGruppeEintrag("Blade of blood", getPts("Blade of blood")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	        nkwaffe.setSelected(0, true);
        } else if(type.equals("Wrath Of Khorne Bloodthirster") || type.equals("Bloodthirster of Unfettered Fury")) {
	    	ogE.addElement(new OptionsGruppeEintrag("Axe of Khorne", getPts("Axe of Khorne")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	        nkwaffe.setSelected(0, true);
        }
    	
        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
    	checkBuildaVater();
        String army = buildaVater.getFormationType();
    	boolean undivided = keywords.contains(ALLEGIANCE) && (army.equals("CHAOS") || army.equals("Chaosdaemons"));
    	boolean khorne = army.equals("Khorne") || keywords.contains(KHORNE) || undivided;
    	boolean tzeentch = army.equals("Tzeentch") || keywords.contains(TZEENTCH) || undivided;
    	boolean nurgle = army.equals("Nurgle") || keywords.contains(NURGLE) || undivided;
    	boolean slaanesh = army.equals("Slaanesh") || keywords.contains(SLAANESH) || undivided;
    	
    	armourofScorn.setAktiv((chosenRelic == null || armourofScorn.isSelected()) && khorne && keywords.contains(MONSTER));
    	theCrimsonCrown.setAktiv((chosenRelic == null || theCrimsonCrown.isSelected()) && khorne);
    	theEndlessGrimoire.setAktiv((chosenRelic == null || theEndlessGrimoire.isSelected()) && tzeentch && keywords.contains(PSYKER));
    	soulBane.setAktiv((chosenRelic == null || soulBane.isSelected()) && keywords.contains(HERALD_OF_TZEENTCH));
    	theImpossibleRobe.setAktiv((chosenRelic == null || theImpossibleRobe.isSelected()) && tzeentch);
    	hornofNurglesRot.setAktiv((chosenRelic == null || hornofNurglesRot.isSelected()) && nurgle);
    	theEntropicKnell.setAktiv((chosenRelic == null || theEntropicKnell.isSelected()) && nurgle);
    	theForbiddenGem.setAktiv((chosenRelic == null || theForbiddenGem.isSelected()) && slaanesh);
    	theMarkofExcess.setAktiv((chosenRelic == null || theMarkofExcess.isSelected()) && slaanesh);
    	slothfulClaws.setAktiv((chosenRelic == null || slothfulClaws.isSelected()) && keywords.contains(HERALD_OF_SLAANESH));
    	
    	if(nkwaffe != null) {
    		nkwaffe.setAktiv("A'rgath, the King of Blades", (chosenRelic == null || nkwaffe.isSelected("A'rgath, the King of Blades")) && khorne);
    		nkwaffe.setAktiv("Skullreaver", (chosenRelic == null || nkwaffe.isSelected("Skullreaver")) && khorne);
    		nkwaffe.setAktiv("The Everstave", (chosenRelic == null || nkwaffe.isSelected("The Everstave")) && tzeentch);
    		nkwaffe.setAktiv("Corruption", (chosenRelic == null || nkwaffe.isSelected("Corruption")) && nurgle);
    		nkwaffe.setAktiv("Soulstealer", (chosenRelic == null || nkwaffe.isSelected("Soulstealer")) && slaanesh);
    		
    		if(!keywords.contains(DAEMON_PRINCE_OF_CHAOS)) {
    			nkwaffe.alwaysSelected();
    		}
    	}
    	
    	
    	
    }

}
