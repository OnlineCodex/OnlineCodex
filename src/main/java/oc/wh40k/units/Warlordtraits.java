package oc.wh40k.units;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class Warlordtraits extends RuestkammerVater {
    OptionsUpgradeGruppe warlordtraits;
    String mandatoryChoice = "";
    String exclusiveKeyword = "";
    boolean subfactionsAllowed = true;

    public Warlordtraits() {
        grundkosten = 0;
    }

    Set<String> CRAFTWORLDS = ImmutableSet.of("ASURYANI", "Alaitoc", "Biel-Tan", "Iyanden", "Saim-Hann", "Ulthwe");
    Set<String> DRUKHARI = ImmutableSet.of("DRUKHARI", "Kabal of the Black Heart", "Kabal of the Flayed Skull", "Kabal of the Poisoned Tongue", "Kabal of the Obsidan Rose", "Cult of Strife", "Cult of the Cursed Blade", "Cult of the Red Grief", "The Prophets of Flesh", "The Dark Creed", "Coven of Twelve");
    Set<String> HARLEQUINS = ImmutableSet.of("HARLEQUINS", "Midnight Sorrow", "Veiled Path", "Frozen Stars", "Dreaming Shadow", "Soaring Spite", "Silent Shroud");
    Set<String> ADEPTUS_MECHANICUS = ImmutableSet.of("Adeptus Mechanicus", "Cult Mechanicus", "Skitarii", "Forge World Mars", "Forge World Graia", "Forge World Metalica", "Forge World Lucius", "Forge World Agripinaa", "Forge World Stygies VIII", "Forge World Ryza");
    Set<String> NECRONS = ImmutableSet.of("NECRONS", "Sautekh", "Nihilakh", "Novokh", "Mephrit", "Nephrekh", "Maynarkh", "C'tan Shards", "Canoptek");
    Set<String> ORKS = ImmutableSet.of("ORK", "Goff", "Blood Axe", "Deathskulls", "Evil Sunz", "Snakebites", "Bad Moonz", "Freebooterz");
    Set<String> SM_CHAPTERS = ImmutableSet.of("Ultramarines", "White Scars", "Imperial Fists", "Crimson Fists", "Black Templars", "Salamanders", "Raven Guard", "Iron Hands");
    Set<String> TAU = ImmutableSet.of("T'AU EMPIRE", "T'au Sept", "Vior'la Sept", "Dal'yth Sept", "Sa'cea Sept", "Bork'an Sept", "Farsight Enclaves", "Ke'lshan", "Kroot", "Vespid");
    Set<String> TYRANIDS = ImmutableSet.of("TYRANIDS", "Behemoth", "Kraken", "Leviathan", "Gorgon", "Jormungandr", "Hydra", "Kronos");
    
    private static final String KABAL = "KABAL";
    private static final String WYCH_CULT = "WYCH CULT";
    private static final String HAEMUNCULUS_COVEN = "HAEMUNCULUS COVEN";
    
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
    	
        if(army.equals("AELDARI") || CRAFTWORLDS.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Ambush of Blades", 0));
	        ogE.addElement(new OptionsGruppeEintrag("An Eye on Distant Events", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Falcon's Swiftness", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Fate's Messenger", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Mark of the Incomparable Hunter", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Seer of the Shifting Vector", 0));

	        ogE.addElement(new OptionsGruppeEintrag("Alaitoc: Puritanical Leader", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Biel-Tan: Natural Leader", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Iyanden: Enduring Resolve", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saim-Hann: Wild Rider Chieftain", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ulthwé: Fate Reader", 0));
        }
        if(army.equals("AELDARI") || DRUKHARI.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Hatred Eternal", 0)); //Kabal
	        ogE.addElement(new OptionsGruppeEintrag("Soul Thirst", 0)); //Kabal
	        ogE.addElement(new OptionsGruppeEintrag("Ancient Evil", 0)); //Kabal
	        ogE.addElement(new OptionsGruppeEintrag("Quicksilver Fighter", 0)); //Wych Cult
	        ogE.addElement(new OptionsGruppeEintrag("Stimm Addict", 0)); //Wych Cult
	        ogE.addElement(new OptionsGruppeEintrag("Precision Blows", 0)); //Wych Cult
	        ogE.addElement(new OptionsGruppeEintrag("Master Regenesist", 0));//Coven
	        ogE.addElement(new OptionsGruppeEintrag("Master Nemesine", 0));//Coven
	        ogE.addElement(new OptionsGruppeEintrag("Master Artisan", 0));//Coven
	        
	        ogE.addElement(new OptionsGruppeEintrag("Kabal of the Black Heart: Labyrinthine Cunning", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kabal of the Poisoned Tongue: Towering Arrogance", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kabal of the Obsidian Rose: Deathly Perfectionist", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Kabal of the Flayed Skull: Famed Savagery", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Cult of Strife: Blood Dancer", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Cult of Red Grief: Hyper-swift Reflexes", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Cult of the Cursed Blade: Treacherous Deceiver", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Prophets of Flesh: Diabolical Soothsayer", 0));
	        ogE.addElement(new OptionsGruppeEintrag("The Dark Creed: Fear Incarnate", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Coven of Twelve: Scarlet Epicurean", 0));
        }
        if(army.equals("AELDARI") || HARLEQUINS.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Luck of the Laughing God", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Fractal Storm", 0));
	        ogE.addElement(new OptionsGruppeEintrag("A Foot in the Future", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Player of the Light", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Player of the Dark", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Player of the Twilight", 0));

	        ogE.addElement(new OptionsGruppeEintrag("Midnight Sorrow: Nemesis of the Damned", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Veiled Path: Webway Walker", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Frozen Stars: Our Kin Shall Rise Again", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Dreaming Shadow: Warden of the Dead", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Soaring Spite: Skystrider", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Silent Shroud: The Final Joke", 0));
        }
        
        //CHAOS
        if(army.equals("CHAOS") || army.equals("Death Guard")){
        	ogE.addElement(new OptionsGruppeEintrag("Revoltingly Resilient", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Living Plague", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Tainted Regeneration", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Hulking Physique", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Rotten Constitution", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Arch-Contaminator", 0));
        }
        if(army.equals("CHAOS") || army.equals("Thousand Sons")){
        	ogE.addElement(new OptionsGruppeEintrag("Arrogance of Aeons", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Undying Form", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Aetherstride", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Lord of Forbidden Lore", 0));
        	ogE.addElement(new OptionsGruppeEintrag("Otherworldly Prescience", 0));
        	ogE.addElement(new OptionsGruppeEintrag("High Magister", 0));
        }
        
//		Astra Militarum
//        Grand Strategist
//        Old Grudges
//        Implacable Determination
//        Draconian Disciplinarian
//        Bellowing Voice
//        Master of Command
//
//        NAMED CHARACTERS AND WARLORD TRAITS
//        If a named character with a specific regiment keyword is yourWarlord, they must be
//        given the associatedWarlord Trait. For example, Colonel ‘Iron Hand’ Straken must
//        take the Catachan ‘Lead From the Front’ Warlord Trait (see opposite) as he has the
//        CATACHAN keyword.
//        If Commissar Yarrick is yourWarlord, he must have the Master of CommandWarlord
//        Trait (above).
//
//        Cadian: Superior Tactical Training 
//        Catachan Lead From the Front
//        Valhallan Tenacious
//        Vostroyan Honoured Duellist
//        Tallarn Swift Attacker
//        Militarum Tempestus Faithful Servant of the Throne
//        Mordian Iron Discipline
        
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
        if(army.equals("IMPERIUM") || army.equals("Grey Knights")) {
	        ogE.addElement(new OptionsGruppeEintrag("Daemon-Slayer (GK)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Hammer of Righteousness (GK)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Unyielding Anvil (GK)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("First to the Fray (GK)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Nemesis Lord (GK)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Lore Master (GK)", 0));
        }
        if(army.equals("IMPERIUM") || SM_CHAPTERS.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Angel of Death (SM)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("The Imperium's Sword (SM)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Iron Resolve (SM)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Storm of Fire (SM)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Rites of War (SM)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Champion of Humanity (SM)", 0));

	        ogE.addElement(new OptionsGruppeEintrag("Ultramarines: Adept of the Codex", 0));
	        ogE.addElement(new OptionsGruppeEintrag("White Scars: Deadly Hunter", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Imperial Fists: Architect of War", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Crimson Fists: Tenacious Opponent", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Black Templars: Oathkeeper", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Salamanders: Anvil of Strength", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Raven Guard: Silent Stalker", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Iron Hands: Merciless Logic", 0));
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
        } else if((army.equals("AELDARI") || DRUKHARI.contains(army)) && 
        		(exclusiveKeyword.equals(KABAL) || exclusiveKeyword.equals(WYCH_CULT) || exclusiveKeyword.equals(HAEMUNCULUS_COVEN))) {
        	warlordtraits.setAktiv("Hatred Eternal", exclusiveKeyword.equals(KABAL));
        	warlordtraits.setAktiv("Soul Thirst", exclusiveKeyword.equals(KABAL));
        	warlordtraits.setAktiv("Ancient Evil", exclusiveKeyword.equals(KABAL));
        	warlordtraits.setAktiv("Quicksilver Fighter", exclusiveKeyword.equals(WYCH_CULT));
        	warlordtraits.setAktiv("Stimm Addict", exclusiveKeyword.equals(WYCH_CULT));
        	warlordtraits.setAktiv("Precision Blows", exclusiveKeyword.equals(WYCH_CULT));
        	warlordtraits.setAktiv("Master Regenesist", exclusiveKeyword.equals(HAEMUNCULUS_COVEN));
        	warlordtraits.setAktiv("Master Nemesine", exclusiveKeyword.equals(HAEMUNCULUS_COVEN));
        	warlordtraits.setAktiv("Master Artisan", exclusiveKeyword.equals(HAEMUNCULUS_COVEN));

        	warlordtraits.setAktiv("Kabal of the Black Heart: Labyrinthine Cunning", army.equals("Kabal of the Black Heart"));
        	warlordtraits.setAktiv("Kabal of the Poisoned Tongue: Towering Arrogance", army.equals("Kabal of the Poisoned Tongue"));
        	warlordtraits.setAktiv("Kabal of the Obsidian Rose: Deathly Perfectionist", army.equals("Kabal of the Obsidian Rose"));
        	warlordtraits.setAktiv("Kabal of the Flayed Skull: Famed Savagery", army.equals("Kabal of the Flayed Skull"));
        	warlordtraits.setAktiv("Cult of Strife: Blood Dancer", army.equals("Cult of Strife"));
        	warlordtraits.setAktiv("Cult of Red Grief: Hyper-swift Reflexes", army.equals("Cult of Red Grief"));
        	warlordtraits.setAktiv("Cult of the Cursed Blade: Treacherous Deceiver", army.equals("Cult of the Cursed Blade"));
        	warlordtraits.setAktiv("Prophets of Flesh: Diabolical Soothsayer", army.equals("The Prophets of Flesh"));
        	warlordtraits.setAktiv("The Dark Creed: Fear Incarnate", army.equals("The Dark Creed"));
        	warlordtraits.setAktiv("Coven of Twelve: Scarlet Epicurean", army.equals("Coven of Twelve"));
        } else if(CRAFTWORLDS.contains(army)) {
    		warlordtraits.setAktiv("Alaitoc: Puritanical Leader", army.equals("Alaitoc"));
    		warlordtraits.setAktiv("Biel-Tan: Natural Leader", army.equals("Biel-Tan"));
    		warlordtraits.setAktiv("Iyanden: Enduring Resolve", army.equals("Iyanden"));
    		warlordtraits.setAktiv("Saim-Hann: Wild Rider Chieftain", army.equals("Saim-Hann"));
    		warlordtraits.setAktiv("Ulthwé: Fate Reader", army.equals("Ulthwe"));
        } else if(HARLEQUINS.contains(army)) {
    		warlordtraits.setAktiv("Midnight Sorrow: Nemesis of the Damned", army.equals("Midnight Sorrow"));
    		warlordtraits.setAktiv("Veiled Path: Webway Walker", army.equals("Veiled Path"));
    		warlordtraits.setAktiv("Frozen Stars: Our Kin Shall Rise Again", army.equals("Frozen Stars"));
    		warlordtraits.setAktiv("Dreaming Shadow: Warden of the Dead", army.equals("Dreaming Shadow"));
    		warlordtraits.setAktiv("Soaring Spite: Skystrider", army.equals("Soaring Spite"));
    		warlordtraits.setAktiv("Silent Shroud: The Final Joke", army.equals("Silent Shroud"));
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
        } else if(SM_CHAPTERS.contains(army)) {
        	warlordtraits.setAktiv("Ultramarines: Adept of the Codex", army.equals("Ultramarines"));
        	warlordtraits.setAktiv("White Scars: Deadly Hunter", army.equals("White Scars"));
        	warlordtraits.setAktiv("Imperial Fists: Architect of War", army.equals("Imperial Fists"));
        	warlordtraits.setAktiv("Crimson Fists: Tenacious Opponent", army.equals("Crimson Fists"));
        	warlordtraits.setAktiv("Black Templars: Oathkeeper", army.equals("Black Templars"));
        	warlordtraits.setAktiv("Salamanders: Anvil of Strength", army.equals("Salamanders"));
        	warlordtraits.setAktiv("Raven Guard: Silent Stalker", army.equals("Raven Guard"));
        	warlordtraits.setAktiv("Iron Hands: Merciless Logic", army.equals("Iron Hands"));
        } else if(TAU.contains(army)) { //TAU
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
    
    public void setExclusiveKeyword(String s) {
    	exclusiveKeyword = s;
    }
}
