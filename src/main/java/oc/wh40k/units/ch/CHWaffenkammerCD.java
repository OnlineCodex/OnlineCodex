package oc.wh40k.units.ch;

import static com.google.common.collect.Sets.newEnumSet;
import static oc.KeyWord.*;

import com.google.common.collect.Sets;
import oc.*;

import java.util.Set;

public class CHWaffenkammerCD extends RuestkammerVater {

    private final String type;
    private final Set<KeyWord> keywords;

    private OptionsUpgradeGruppe fkwaffen;
    private OptionsEinzelUpgrade armourofScorn;
    private OptionsEinzelUpgrade theCrimsonCrown;
    private OptionsEinzelUpgrade theEndlessGrimoire;
    private OptionsEinzelUpgrade soulBane;
    private OptionsEinzelUpgrade theImpossibleRobe;
    private OptionsEinzelUpgrade hornofNurglesRot;
    private OptionsEinzelUpgrade theEntropicKnell;
    private OptionsEinzelUpgrade theForbiddenGem;
    private OptionsEinzelUpgrade theMarkofExcess;
    private OptionsEinzelUpgrade slothfulClaws;
    private OptionsUpgradeGruppe nkwaffe;
    private OptionsUpgradeGruppe fkwaffe;

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
	    		} else if(ogE.get(i).getName().equals("Staff of CHANGE")) {
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
	    	
	    	if(rodOfSorcery) {
        		ogE.addElement(new OptionsGruppeEintrag("The Everstave", getPts("Rod of Sorcery")).setRelic(true));
	    	} else if(staffOfChange) {
        		ogE.addElement(new OptionsGruppeEintrag("The Everstave", getPts("Staff of CHANGE")).setRelic(true));
	    	}
	    	
	    	if(plaguesword) {
        		ogE.addElement(new OptionsGruppeEintrag("Corruption", getPts("Plaguesword (CD)")).setRelic(true));
	    	}
	    	
	    	if(witstealerSword) {
        		ogE.addElement(new OptionsGruppeEintrag("Soulstealer", getPts("Witstealer sword")).setRelic(true));
	    	} else if(hellforgedSword) {
        		ogE.addElement(new OptionsGruppeEintrag("Soulstealer", getPts("Hellforged sword")).setRelic(true));
	    	}
    	}
    }

    public Set<KeyWord> getKeywords() {
        return keywords;
    }

    public CHWaffenkammerCD(String type, Set<KeyWord> keyWords) {
        this.type = type;
        this.keywords = newEnumSet(keyWords, KeyWord.class);

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
        } else if(keywords.contains(LORD_OF_CHANGE)) {
            ogE.addElement(new OptionsGruppeEintrag("Baleful sword", getPts("Baleful sword")));
            ogE.addElement(new OptionsGruppeEintrag("Rod of sorcery", getPts("Rod of sorcery")));
	        addRelics();
            add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if(keywords.contains(CHANGECASTER) || keywords.contains(FATESKIMMER) || keywords.contains(FLUXMASTER)) {
        	ogE.addElement(new OptionsGruppeEintrag("Staff of CHANGE", getPts("Staff of CHANGE")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if(keywords.contains(SPOILPOX_SCRIVENER)) {
        	ogE.addElement(new OptionsGruppeEintrag("Plaguesword", getPts("Plaguesword (CD)")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if(keywords.contains(KEEPER_OF_SECRETS)) {
        	ogE.addElement(new OptionsGruppeEintrag("Witstealer sword", getPts("Witstealer sword")));
	        addRelics();
	        add(nkwaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }
    	
        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
    	armourofScorn.setAktiv((chosenRelic == null || armourofScorn.isSelected()) && keywords.contains(KHORNE) && keywords.contains(MONSTER));
    	theCrimsonCrown.setAktiv((chosenRelic == null || theCrimsonCrown.isSelected()) && keywords.contains(KHORNE));
    	theEndlessGrimoire.setAktiv((chosenRelic == null || theEndlessGrimoire.isSelected()) && keywords.contains(TZEENTCH) && keywords.contains(PSYKER));
    	soulBane.setAktiv((chosenRelic == null || soulBane.isSelected()) && keywords.contains(HERALD_OF_TZEENTCH));
    	theImpossibleRobe.setAktiv((chosenRelic == null || theImpossibleRobe.isSelected()) && keywords.contains(TZEENTCH));
    	hornofNurglesRot.setAktiv((chosenRelic == null || hornofNurglesRot.isSelected()) && keywords.contains(NURGLE));
    	theEntropicKnell.setAktiv((chosenRelic == null || theEntropicKnell.isSelected()) && keywords.contains(NURGLE));
    	theForbiddenGem.setAktiv((chosenRelic == null || theForbiddenGem.isSelected()) && keywords.contains(SLAANESH));
    	theMarkofExcess.setAktiv((chosenRelic == null || theMarkofExcess.isSelected()) && keywords.contains(SLAANESH));
    	slothfulClaws.setAktiv((chosenRelic == null || slothfulClaws.isSelected()) && keywords.contains(HERALD_OF_SLAANESH));
    	
    	if(nkwaffe != null) {
    		nkwaffe.setAktiv("A'rgath, the King of Blades", (chosenRelic == null || nkwaffe.isSelected("A'rgath, the King of Blades")) && keywords.contains(KHORNE));
    		nkwaffe.setAktiv("Skullreaver", (chosenRelic == null || nkwaffe.isSelected("Skullreaver")) && keywords.contains(KHORNE));
    		nkwaffe.setAktiv("The Everstave", (chosenRelic == null || nkwaffe.isSelected("The Everstave")) && keywords.contains(TZEENTCH));
    		nkwaffe.setAktiv("Corruption", (chosenRelic == null || nkwaffe.isSelected("Corruption")) && keywords.contains(NURGLE));
    		nkwaffe.setAktiv("Soulstealer", (chosenRelic == null || nkwaffe.isSelected("Soulstealer")) && keywords.contains(SLAANESH));
    		
    		if(keywords.contains(BLOODMASTER) || type.equals("Wrath Of Khorne Bloodthirster") || type.equals("Bloodthirster of Unfettered Fury") || keywords.contains(SPOILPOX_SCRIVENER) || keywords.contains(KEEPER_OF_SECRETS)) {
    			nkwaffe.alwaysSelected();
    		}
    	}
    }
}
