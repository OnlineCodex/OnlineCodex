package oc.wh40k.units;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class Warlordtraits extends RuestkammerVater {
    OptionsUpgradeGruppe warlordtraits;
    String mandatoryChoice = "";
    boolean subfactionsAllowed = true;

    public Warlordtraits() {
        grundkosten = 0;
    }

    
    Set<String> ADEPTUS_MECHANICUS = ImmutableSet.of("Adeptus Mechanicus", "Cult Mechanicus", "Skitarii", "Forge World Mars", "Forge World Graia", "Forge World Metalica", "Forge World Lucius", "Forge World Agripinaa", "Forge World Stygies VIII", "Forge World Ryza");
    Set<String> NECRONS = ImmutableSet.of("NECRONS", "Sautekh", "Nihilakh", "Novokh", "Mephrit", "Nephrekh", "Maynarkh", "C'tan Shards", "Canoptek");
    Set<String> ORKS = ImmutableSet.of("ORK", "Goff", "Blood Axe", "Deathskulls", "Evil Sunz", "Snakebites", "Bad Moonz", "Freebooterz");
    Set<String> TAU = ImmutableSet.of("T'AU EMPIRE", "T'au Sept", "Vior'la Sept", "Dal'yth Sept", "Sa'cea Sept", "Bork'an Sept", "Farsight Enclaves", "Ke'lshan", "Kroot", "Vespid");
    Set<String> TYRANIDS = ImmutableSet.of("TYRANIDS", "Behemoth", "Kraken", "Leviathan", "Gorgon", "Jormungandr", "Hydra", "Kronos");
    
	@Override
	public void initButtons(boolean... b) {
		warlord = true;
    	checkBuildaVater();
    	String army = buildaVater.getFormationType();

    	//ALL
    	ogE.addElement(new OptionsGruppeEintrag("Legendary Fighter (BRB p.186)", 0));
        ogE.addElement(new OptionsGruppeEintrag("Inspiring Leader (BRB p.186)", 0));
        ogE.addElement(new OptionsGruppeEintrag("Tenacious Survivor (BRB p.186)", 0));
        ogE.addElement(new OptionsGruppeEintrag("Insane Bravado (BRB p.253)", 0));
    	
        //Imperium
        if(army.equals("IMPERIUM") || army.equals("Adeptus Custodes")) {
	        ogE.addElement(new OptionsGruppeEintrag("Champion of the Imperium (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Peerless Warrior (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Superior Creation (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Impregnable Mind (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Radiant Mantle (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Companion (AC)", 0));
        }
        if(army.equals("IMPERIUM") || ADEPTUS_MECHANICUS.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Monitor Malevolus (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Magos Biologis (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Mechadominator (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Necromechanic (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Chorister Technis (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Prime Hermeticon (AdMech)", 0));

	        ogE.addElement(new OptionsGruppeEintrag("Mars: Static Psalm-code (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Graia: Emotionless Clarity (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Metalica: Ordered Efficiency (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Lucius: Masterwork Bionics (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Agripinaa: Reinforced Exoskeleton (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Stygies VIII: Xenarite Studies (AdMech)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ryza: First-hand Field Testing (AdMech)", 0));
        }
        if(army.equals("IMPERIUM") || army.equals("Blood Angels")) {
	        ogE.addElement(new OptionsGruppeEintrag("Speed of the Primarch (BA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Artisan of War (BA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Soulwarden (BA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Heroic Bearing (BA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Gift of Foresight (BA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Selfless Valour (BA)", 0));
        }
        if(army.equals("IMPERIUM") || army.equals("Dark Angels")) {
	        ogE.addElement(new OptionsGruppeEintrag("Fury of the Lion (DA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Courage of the First Legion (DA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Brilliant Strategist (DA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Huntsman (DA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Master of Manoeuvre (DA)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Stubborn Tenacity (DA)", 0));
        }
        if(army.equals("IMPERIUM") || army.equals("Deathwatch")) {
	        ogE.addElement(new OptionsGruppeEintrag("Bane of Monstrosities (DW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Lord of Hidden Knowledge (DW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Castellan of the Black Vault (DW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("The Watch Eternal (DW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Vigilance Incarnate (DW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Nowhere to Hide (DW)", 0));
        }
        if(army.equals("IMPERIUM") || army.equals("Space Wolves")) {
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Warrior Born (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Wolfkin (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of Majesty (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Beastslayer (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Hunter (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Bear (SW)", 0));
        }
        
        if(NECRONS.contains(army)) { //NECRONS
	        ogE.addElement(new OptionsGruppeEintrag("Enduring Will", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Eternal Madness", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Immortal Pride", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Thrall of the Silent King", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Implacable Conqueror", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Honourable Combatant", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Sautekh: Hyperlogical Strategist", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Mephrit: Merciless Tyrant", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nihilakh: Precognitive Strike", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nephrekh: Skin of Living Gold", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Novokh: Crimson Haze", 0));
    	} else if(ORKS.contains(army)) { //ORKS
	        ogE.addElement(new OptionsGruppeEintrag("Follow me Ladz", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Big Killa Boss", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ard as Nails", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Brutal but Kunnin", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kunnin but Brutal", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Might is Right", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Bad Moons: Da best armout teef can buy", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Blood Axes: I've got a plan, Ladz", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Deathskull: Opportunist", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Evil Sunz: Speed Freak", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Freebooterz: Killa Reputation", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Goffs: Proper Killy", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Snakebites: Surly as a Squiggoth", 0));
    	} else if(TAU.contains(army)) { //TAU
	    	ogE.addElement(new OptionsGruppeEintrag("Precision of the Hunter", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Through Unity, Devastation", 0));
	        ogE.addElement(new OptionsGruppeEintrag("A Ghost Walks Among Us", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Through Boldness, Victory", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Exemplar of the Kauyon", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Exemplar of the Mont'ka", 0));
	        
	        ogE.addElement(new OptionsGruppeEintrag("T'au: Strength of Belief", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Vior'la: Academy Luminary", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Dal'yth: Gunship Diplomat", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Sa'cea: Beacon of Honour", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Bork'an: Seeker of Perfection", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Farsight Enclaves: Hero of the Enclaves", 0));
    	} else if(TYRANIDS.contains(army)) { //TYRANIDS
	    	ogE.addElement(new OptionsGruppeEintrag("Alien Cunning", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Heightened Senses", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Synaptic Lynchpin", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Mind Eater", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Instinctive Killer", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Adaptive Biology", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Behemoth: Monstrous Hunger", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kraken: One Step Ahead", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Leviathan: Perfectly Adapted", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Gorgon: Lethal Miasma", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Jormungandr: Insidious Threat", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Hydra: Endless Regeneration", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kronos: Soul hunger", 0));
    	}
        add(warlordtraits = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));

        setUeberschrift("Warlord Traits");
        sizeSetzen();
    }

    //@OVERRIDE
    public void refreshen() {
        String army= buildaVater.getFormationType();
    	warlordtraits.alwaysSelected();
    	if(ADEPTUS_MECHANICUS.contains(army)) {
    		warlordtraits.setAktiv("Mars: Static Psalm-code (AdMech)", army.equals("Forge World Mars"));
    		warlordtraits.setAktiv("Graia: Emotionless Clarity (AdMech)", army.equals("Forge World Graia"));
    		warlordtraits.setAktiv("Metalica: Ordered Efficiency (AdMech)", army.equals("Forge World Metalica"));
    		warlordtraits.setAktiv("Lucius: Masterwork Bionics (AdMech)", army.equals("Forge World Lucius"));
    		warlordtraits.setAktiv("Agripinaa: Reinforced Exoskeleton (AdMech)", army.equals("Forge World Agripinaa"));
    		warlordtraits.setAktiv("Stygies VIII: Xenarite Studies (AdMech)", army.equals("Forge World Stygies VIII"));
    		warlordtraits.setAktiv("Ryza: First-hand Field Testing (AdMech)", army.equals("Forge World Ryza"));
        } else if(NECRONS.contains(army)) {
	        warlordtraits.setAktiv("Sautekh: Hyperlogical Strategist", army.equals("Sautekh") && subfactionsAllowed);
	        warlordtraits.setAktiv("Mephrit: Merciless Tyrant", army.equals("Mephrit") && subfactionsAllowed);
	        warlordtraits.setAktiv("Nihilakh: Precognitive Strike", army.equals("Nihilakh") && subfactionsAllowed);
	        warlordtraits.setAktiv("Nephrekh: Skin of Living Gold", army.equals("Nephrekh") && subfactionsAllowed);
	        warlordtraits.setAktiv("Novokh: Crimson Haze", army.equals("Novokh") && subfactionsAllowed);
        }else if(ORKS.contains(army)) {
	        warlordtraits.setAktiv("Bad Moons: Da best armout teef can buy", army.equals("Bad Moonz"));
	    	warlordtraits.setAktiv("Blood Axes: I've got a plan, Ladz", army.equals("Blood Axe"));
    		warlordtraits.setAktiv("Deathskull: Opportunist", army.equals("Deathskulls"));
    		warlordtraits.setAktiv("Evil Sunz: Speed Freak", army.equals("Evil Sunz"));
    		warlordtraits.setAktiv("Freebooterz: Killa Reputation", army.equals("Freebooterz"));
    		warlordtraits.setAktiv("Goffs: Proper Killy", army.equals("Goff"));
    		warlordtraits.setAktiv("Snakebites: Surly as a Squiggoth", army.equals("Snakebites"));
        }else if(TAU.contains(army)) { //TAU
        	warlordtraits.setAktiv("T'au: Strength of Belief", army.equals("T'au Sept"));
        	warlordtraits.setAktiv("Vior'la: Academy Luminary", army.equals("Vior'la Sept"));
        	warlordtraits.setAktiv("Dal'yth: Gunship Diplomat", army.equals("Dal'yth Sept"));
        	warlordtraits.setAktiv("Sa'cea: Beacon of Honour", army.equals("Sa'cea Sept"));
        	warlordtraits.setAktiv("Bork'an: Seeker of Perfection", army.equals("Bork'an Sept"));
        	warlordtraits.setAktiv("Farsight Enclaves: Hero of the Enclaves", army.equals("Farsight Enclaves"));
    	} else if(TYRANIDS.contains(army)) {
	        warlordtraits.setAktiv("Behemoth: Monstrous Hunger", army.equals("Behemoth"));
	    	warlordtraits.setAktiv("Kraken: One Step Ahead", army.equals("Kraken"));
    		warlordtraits.setAktiv("Leviathan: Perfectly Adapted", army.equals("Leviathan"));
    		warlordtraits.setAktiv("Gorgon: Lethal Miasma", army.equals("Gorgon"));
    		warlordtraits.setAktiv("Jormungandr: Insidious Threat", army.equals("Jormungandr"));
    		warlordtraits.setAktiv("Hydra: Endless Regeneration", army.equals("Hydra"));
    		warlordtraits.setAktiv("Kronos: Soul hunger", army.equals("Kronos"));
        }
        if(!mandatoryChoice.equals("")) {
        	warlordtraits.deselectAll();
        	warlordtraits.setSelected(mandatoryChoice, true);
        }
    }
    
    public void setMandatoryChoice(String s) {
    	mandatoryChoice = s;
    }
    
    public void allowSubfactions(boolean b) {
    	subfactionsAllowed = b;
    }
}
