package oc.wh40k.units;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ALLEGIANCE;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.MINISTORUM_PRIEST;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.SLAANESH;
import static oc.KeyWord.TZEENTCH;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.KeyWord;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;
import static oc.KeyWord.*;

public class Warlordtraits extends RuestkammerVater {
	private OptionsUpgradeGruppe warlordtraits;
	private OptionsUpgradeGruppe warlordtraits2;
	private OptionsUpgradeGruppe warlordtraits3;
	private String mandatoryChoice = "";
	private KeyWord exclusiveKeyword = null;
	private boolean subfactionsAllowed = true;

    public Warlordtraits() {
        grundkosten = 0;
    }

    Set<String> CHAOS_GODS = ImmutableSet.of("Chaosdaemons", "Khorne", "Tzeentch", "Nurgle", "Slaanesh");
	Set<String> LEGIONS = ImmutableSet.of("Chaos Space Marines", "Alpha Legion", "Black Legion", "Emperor's Children", "Iron Warriors", "Night Lords", "World Eaters", "Word Bearers");
	Set<String> ASTRA_MILITARUM = ImmutableSet.of("ASTRA MILITARUM", "Cadian", "Catachan", "Valhallan", "Vostroyan", "Armageddon", "Tallarn", "Militarum Tempestus", "Mordian");
    Set<String> CRAFTWORLDS = ImmutableSet.of("ASURYANI", "Alaitoc", "Biel-Tan", "Iyanden", "Saim-Hann", "Ulthwe");
    Set<String> DRUKHARI = ImmutableSet.of("DRUKHARI", "Kabal of the Black Heart", "Kabal of the Flayed Skull", "Kabal of the Poisoned Tongue", "Kabal of the Obsidan Rose", "Cult of Strife", "Cult of the Cursed Blade", "Cult of the Red Grief", "The Prophets of Flesh", "The Dark Creed", "Coven of Twelve");
    Set<String> HARLEQUINS = ImmutableSet.of("HARLEQUINS", "Midnight Sorrow", "Veiled Path", "Frozen Stars", "Dreaming Shadow", "Soaring Spite", "Silent Shroud");
    Set<String> ADEPTUS_MECHANICUS = ImmutableSet.of("Adeptus Mechanicus", "Cult Mechanicus", "Skitarii", "Forge World Mars", "Forge World Graia", "Forge World Metalica", "Forge World Lucius", "Forge World Agripinaa", "Forge World Stygies VIII", "Forge World Ryza");
    Set<String> NECRONS = ImmutableSet.of("NECRONS", "Sautekh", "Nihilakh", "Novokh", "Mephrit", "Nephrekh", "Maynarkh", "C'tan Shards", "Canoptek");
    Set<String> ORKS = ImmutableSet.of("ORK", "Goff", "Blood Axe", "Deathskulls", "Evil Sunz", "Snakebites", "Bad Moonz", "Freebooterz");
    Set<String> SM_CHAPTERS = ImmutableSet.of("Ultramarines", "White Scars", "Imperial Fists", "Crimson Fists", "Black Templars", "Salamanders", "Raven Guard", "Iron Hands");
    Set<String> TAU = ImmutableSet.of("T'AU EMPIRE", "T'au Sept", "Vior'la Sept", "Dal'yth Sept", "Sa'cea Sept", "Bork'an Sept", "Farsight Enclaves", "Ke'lshan", "Kroot", "Vespid");
    Set<String> TYRANIDS = ImmutableSet.of("TYRANIDS", "Behemoth", "Kraken", "Leviathan", "Gorgon", "Jormungandr", "Hydra", "Kronos");
    Set<String> GENESTEALER = ImmutableSet.of("GENESTEALER CULTS", "Cult Of The Four-Armed Emperor", "The Hivecult", "The Bladed Cog", "The Rusted Claw", "The Pauper Princes", "The Twisted Helix");
    Set<String> QUESTOR_IMPERIALIS  = ImmutableSet.of("QUESTOR IMPERIALIS", "Terryn", "Griffith", "Hawkshroud", "Cadmus", "Mortan", "Raven", "Taranis", "Krast", "Vulker");

    private static final String KABAL = "KABAL";
    private static final String WYCH_CULT = "WYCH CULT";
    private static final String HAEMUNCULUS_COVEN = "HAEMUNCULUS COVEN";

	@Override
	public void initButtons(boolean... b) {
		warlord = true;
    	checkBuildaVater();
    	final String army = buildaVater.getFormationType();

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
	        
	        ogE.addElement(new OptionsGruppeEintrag("Windrider Host: Wild Rider", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Wraith Host: Revered by the Dead", 0));
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
        if(army.equals("Ynnari")) {
	        ogE.addElement(new OptionsGruppeEintrag("Lord of Rebirth", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Warden of Souls", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Walker of many Paths", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Fear of the Grave", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Favoured of Ynnead", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Master of Death", 0));
        }

        //CHAOS
        if(army.equals("CHAOS") || CHAOS_GODS.contains(army)){
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Aspect of Death", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Glory of Battle", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Oblivious to Pain", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Immense Power", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Devastating Blow", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Khorne: Rage Incarnate", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Born of Sorcery", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Incorporeal Form", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Warp Tehter", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Lorekeeper of Tzeentch", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Tyrant of the Warp", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Tzeentch: Daemonspark", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Blessed with Corpulence", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Acidic Ichor", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Plaguefly Hive", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Virulent Touch", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Impenetrable Hide", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Nurgle: Pestilent Miasma", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: Celerity of Slaanesh", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: Quicksilver Duelist", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: The Murderdance", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: Fatal Caress", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: Savage Hedonist", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Slaanesh: Bewitching Aura", 0));
	    }
        if(army.equals("CHAOS")) {
        	add(warlordtraits2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));
        }
        if(army.equals("CHAOS") || LEGIONS.contains(army)){
	    	ogE.addElement(new OptionsGruppeEintrag("Eternal Vendetta", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Flames of Spite", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Unholy Fortitude", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Hatred Incarnate", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Lord of Terror", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Exalted Champion", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Alpha Legion: I am Alpharius", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: Veteran Raider", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: Indomitable", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: Black-Clad Brute", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: Soul-Eater", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: Trusted War-Leader", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Black Legion: First Amongst Traitors", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Emperor's Children: Stimulated by Pain", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Iron Warriors: Cold and Bitter", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Night Lords: Night Haunter's Curse", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("World Eaters: Slaughterborn", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Word Bearers: The Voice of Lorgar", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Bringers of Despair: Chosen of the Warmaster", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Devastation Battery: Armour Bane", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Cult of the Damned: Exultant Preacher", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Daemonkin Ritualists: Shepherd of the true Faith", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Soulforged Pack: Master of the Soulforges", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Host Raptorial: The tip of the Claw", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Legion of Skulls: Bloodblessed", 0));

	    	ogE.addElement(new OptionsGruppeEintrag("Red Corsairs: Reaver Lord", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Crimson Slaughter: Maelstrom of Torment", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("The Purge: Blessed Mission", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("The Scourged: Shattering Truth", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Brazen Beasts: Carve the Runes", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Flawless Host: Ultimate Confidence", 0));
	    }
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
      //Imperium
        if(army.equals("IMPERIUM") || ASTRA_MILITARUM.contains(army)) {
	        ogE.addElement(new OptionsGruppeEintrag("Grand Strategist", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Old Grudges", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Implacable Determination", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Draconian Disciplinarian", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Bellowing Voice", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Master of Command", 0));

	        ogE.addElement(new OptionsGruppeEintrag("Cadian: Superior Tactical Training", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Catachan: Lead From the Front", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Valhallan: Tenacious", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Vostroyan: Honoured Duellist", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Armageddon: Ex-gang Leader", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Tallarn: Swift Attacker", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Militarum Tempestus: Faithful Servant of the Throne", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Mordian: Iron Discipline", 0));
	        
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Blade Assault Company: Mechanised Commander", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Wrath Artillery Company: Lord of Ordnance", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Conclave Infantry Company: Fiery Denouncer", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Fist Tank Company: Unflinching Resolve", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Tempestus Drop Force", 0));
        }

        if(army.equals("IMPERIUM") || army.equals("Adeptus Custodes")) {
	        ogE.addElement(new OptionsGruppeEintrag("Champion of the Imperium (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Peerless Warrior (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Superior Creation (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Impregnable Mind (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Radiant Mantle (AC)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Emperor's Companion (AC)", 0));
        }
        if(army.equals("IMPERIUM")) {
        	add(warlordtraits3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));
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
	        
	        ogE.addElement(new OptionsGruppeEintrag("Cybernetica Cohort: Adept of the Legio Cybernetica", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Servitor Maniple: Master of Biosplicing", 0));
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
        if(army.equals("IMPERIUM")) {
        	add(warlordtraits2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));
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
	        
	    	ogE.addElement(new OptionsGruppeEintrag("Indomitus Crusaders: Grey Shield", 0));
	    	if(army.equals("Ultramarines"))
	    		ogE.addElement(new OptionsGruppeEintrag("UM Victrix Guard: Warden of Ultramar", 0));
	    	if(army.equals("Imperial Fists"))
	    		ogE.addElement(new OptionsGruppeEintrag("IF Siegebreaker Cohort: Indomitable", 0));
	    	if(army.equals("Crimson Fists"))
	    		ogE.addElement(new OptionsGruppeEintrag("CF Liberator Strike Force: Expert Instructor", 0));
	    	if(army.equals("Black Templars"))
	    		ogE.addElement(new OptionsGruppeEintrag("BT Sword Brethren: Master Swordsman", 0));
	    	if(army.equals("Raven Guard"))
	    		ogE.addElement(new OptionsGruppeEintrag("RW Attack Squadron: Ligthning Fast Reactions", 0));
        }
        if(army.equals("IMPERIUM") || army.equals("Space Wolves")) {
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Warrior Born (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Wolfkin (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of Majesty (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Beastslayer (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Hunter (SW)", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Saga of the Bear (SW)", 0));
	        
	        ogE.addElement(new OptionsGruppeEintrag("SW Stalker Pack: Saga of the Savage", 0));
        }
        if(keywords.contains(ADEPTA_SORORITAS)) {
	        ogE.addElement(new OptionsGruppeEintrag("Inspiring Orator", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Righteous Rage", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Executioner of Heretics", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Beacon of Faith", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Indomitable Belief", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Pure of Will", 0));
        } else if(keywords.contains(MINISTORUM_PRIEST)) {
	        ogE.addElement(new OptionsGruppeEintrag("Righteous Rage", 0));
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
	    	ogE.addElement(new OptionsGruppeEintrag("Stompa Mob: Gork's One", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Kult of Speed: Quick, Ladz!", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Dread Waaagh!: Dread Mek", 0));
	    	ogE.addElement(new OptionsGruppeEintrag("Blitz Brigade: Back-Seat Driver", 0));
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
    	} else if(GENESTEALER.contains(army)) { //GENESTEALER
	    	ogE.addElement(new OptionsGruppeEintrag("Focus of Adoration", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Shadow Stalker", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Biomorph Adaption", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Born Survivor", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Alien Majesty", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Preternatural Speed", 0));
	        ogE.addElement(new OptionsGruppeEintrag("CotfaE: Inscrutable Cunning", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Hivecult: Hivelord", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Bladed Cog: Single-Minded Obsession", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Rusted Claw: Entropic Touch", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Pauper Pinces: Beloved Grandsire", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Twisted Helix: Bio-Alchemis", 0));
	        
	        ogE.addElement(new OptionsGruppeEintrag("Anointed Throng: Insidious Mindwyrm", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Deliveranmce Broodsurge", 0));
    	} else if(QUESTOR_IMPERIALIS.contains(army)) { //Imperial Knights
	    	ogE.addElement(new OptionsGruppeEintrag("Cunning Commander", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ion Bulwark", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Knight Seneschal", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Landstrider", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Blessed by the Sacristans", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Fearsome Reputation", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Terryn: Champion of the Household", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Grffith: Master of the Jous", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Hawkshroud: Duty of the Forsworn", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Cadmus: Veteran of Gryphonne IV", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Mortan: Legacy of the Black Pall", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Raven: Master of the Trial", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Taranis: Knight of Mars", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Krast: First Knight", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Vulker: Adamantium Knight", 0));
    	} else if(keywords.contains(INQUISITION)) {
	    	ogE.addElement(new OptionsGruppeEintrag("Radical", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Puritan", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Formidable Resolve", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ordo Hereticus: No Escape", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ordo Xenos: Esoteric Law", 0));
	        ogE.addElement(new OptionsGruppeEintrag("Ordo Malleus: Psychic Mastery", 0));
    	}
        
        add(warlordtraits = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1, false));

        if(warlordtraits3 != null) {
        	warlordtraits2.getPanel().setLocation(
                    (int) warlordtraits3.getPanel().getLocation().getX() + warlordtraits3.getPanel().getSize().width + 5 ,
                    (int) warlordtraits3.getPanel().getLocation().getY()
            );
        }

        if(warlordtraits2 != null) {
        	warlordtraits.getPanel().setLocation(
                    (int) warlordtraits2.getPanel().getLocation().getX() + warlordtraits2.getPanel().getSize().width + 5 ,
                    (int) warlordtraits2.getPanel().getLocation().getY()
            );
        }



        setUeberschrift("Warlord Traits");
        sizeSetzen();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        final String army= buildaVater.getFormationType();
        final String specialDetachement= buildaVater.getSpecialDetachmentType();
        if(warlordtraits3 != null) {
        	warlordtraits.setLegal(warlordtraits.getAnzahl() + warlordtraits2.getAnzahl() + warlordtraits3.getAnzahl() == 1);
        	warlordtraits2.setLegal(warlordtraits.getAnzahl() + warlordtraits2.getAnzahl() + warlordtraits3.getAnzahl() == 1);
        	warlordtraits3.setLegal(warlordtraits.getAnzahl() + warlordtraits2.getAnzahl() + warlordtraits3.getAnzahl() == 1);
        } else if(warlordtraits2 != null) {
        	warlordtraits.setLegal(warlordtraits.getAnzahl() + warlordtraits2.getAnzahl() == 1);
        	warlordtraits2.setLegal(warlordtraits.getAnzahl() + warlordtraits2.getAnzahl() == 1);
        } else {
        	warlordtraits.alwaysSelected();
        }
        //CHAOS
        if(army.equals("CHAOS") || CHAOS_GODS.contains(army)){
        	final boolean undivided = ALLEGIANCE.equals(exclusiveKeyword) && (army.equals("CHAOS") || army.equals("Chaosdaemons"));
        	final boolean khorne = army.equals("Khorne") || KHORNE.equals(exclusiveKeyword) || undivided;
        	final boolean tzeentch = army.equals("Tzeentch") || TZEENTCH.equals(exclusiveKeyword) || undivided;
        	final boolean nurgle = army.equals("Nurgle") || NURGLE.equals(exclusiveKeyword) || undivided;
        	final boolean slaanesh = army.equals("Slaanesh") || SLAANESH.equals(exclusiveKeyword) || undivided;
        	if(warlordtraits2 != null) {
	        	warlordtraits2.setAktiv("Khorne: Aspect of Death", khorne);
	        	warlordtraits2.setAktiv("Khorne: Glory of Battle", khorne);
	        	warlordtraits2.setAktiv("Khorne: Oblivious to Pain", khorne);
	        	warlordtraits2.setAktiv("Khorne: Immense Power", khorne);
	        	warlordtraits2.setAktiv("Khorne: Devastating Blow", khorne);
	        	warlordtraits2.setAktiv("Khorne: Rage Incarnate", khorne);

	        	warlordtraits2.setAktiv("Tzeentch: Born of Sorcery", tzeentch);
	        	warlordtraits2.setAktiv("Tzeentch: Incorporeal Form", tzeentch);
	        	warlordtraits2.setAktiv("Tzeentch: Warp Tehter", tzeentch);
	        	warlordtraits2.setAktiv("Tzeentch: Lorekeeper of Tzeentch", tzeentch);
	        	warlordtraits2.setAktiv("Tzeentch: Tyrant of the Warp", tzeentch);
	        	warlordtraits2.setAktiv("Tzeentch: Daemonspark", tzeentch);

	        	warlordtraits2.setAktiv("Nurgle: Blessed with Corpulence", nurgle);
	        	warlordtraits2.setAktiv("Nurgle: Acidic Ichor", nurgle);
	        	warlordtraits2.setAktiv("Nurgle: Plaguefly Hive", nurgle);
	        	warlordtraits2.setAktiv("Nurgle: Virulent Touch", nurgle);
	        	warlordtraits2.setAktiv("Nurgle: Impenetrable Hide", nurgle);
	        	warlordtraits2.setAktiv("Nurgle: Pestilent Miasma", nurgle);

	        	warlordtraits2.setAktiv("Slaanesh: Celerity of Slaanesh", slaanesh);
	        	warlordtraits2.setAktiv("Slaanesh: Quicksilver Duelist", slaanesh);
	        	warlordtraits2.setAktiv("Slaanesh: The Murderdance", slaanesh);
	        	warlordtraits2.setAktiv("Slaanesh: Fatal Caress", slaanesh);
	        	warlordtraits2.setAktiv("Slaanesh: Savage Hedonist", slaanesh);
	        	warlordtraits2.setAktiv("Slaanesh: Bewitching Aura", slaanesh);
        	} else {
	        	warlordtraits.setAktiv("Khorne: Aspect of Death", khorne);
	        	warlordtraits.setAktiv("Khorne: Glory of Battle", khorne);
	        	warlordtraits.setAktiv("Khorne: Oblivious to Pain", khorne);
	        	warlordtraits.setAktiv("Khorne: Immense Power", khorne);
	        	warlordtraits.setAktiv("Khorne: Devastating Blow", khorne);
	        	warlordtraits.setAktiv("Khorne: Rage Incarnate", khorne);

	        	warlordtraits.setAktiv("Tzeentch: Born of Sorcery", tzeentch);
	        	warlordtraits.setAktiv("Tzeentch: Incorporeal Form", tzeentch);
	        	warlordtraits.setAktiv("Tzeentch: Warp Tehter", tzeentch);
	        	warlordtraits.setAktiv("Tzeentch: Lorekeeper of Tzeentch", tzeentch);
	        	warlordtraits.setAktiv("Tzeentch: Tyrant of the Warp", tzeentch);
	        	warlordtraits.setAktiv("Tzeentch: Daemonspark", tzeentch);

	        	warlordtraits.setAktiv("Nurgle: Blessed with Corpulence", nurgle);
	        	warlordtraits.setAktiv("Nurgle: Acidic Ichor", nurgle);
	        	warlordtraits.setAktiv("Nurgle: Plaguefly Hive", nurgle);
	        	warlordtraits.setAktiv("Nurgle: Virulent Touch", nurgle);
	        	warlordtraits.setAktiv("Nurgle: Impenetrable Hide", nurgle);
	        	warlordtraits.setAktiv("Nurgle: Pestilent Miasma", nurgle);

	        	warlordtraits.setAktiv("Slaanesh: Celerity of Slaanesh", slaanesh);
	        	warlordtraits.setAktiv("Slaanesh: Quicksilver Duelist", slaanesh);
	        	warlordtraits.setAktiv("Slaanesh: The Murderdance", slaanesh);
	        	warlordtraits.setAktiv("Slaanesh: Fatal Caress", slaanesh);
	        	warlordtraits.setAktiv("Slaanesh: Savage Hedonist", slaanesh);
	        	warlordtraits.setAktiv("Slaanesh: Bewitching Aura", slaanesh);
        	}
	    } else if(LEGIONS.contains(army)) {
    		warlordtraits.setAktiv("Alpha Legion: I am Alpharius", army.equals("Alpha Legion"));
    		warlordtraits.setAktiv("Black Legion: Veteran Raider", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Black Legion: Indomitable", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Black Legion: Black-Clad Brute", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Black Legion: Soul-Eater", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Black Legion: Trusted War-Leader", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Black Legion: First Amongst Traitors", army.equals("Black Legion"));
    		warlordtraits.setAktiv("Emperor's Children: Stimulated by Pain", army.equals("Emperor's Children"));
    		warlordtraits.setAktiv("Iron Warriors: Cold and Bitter", army.equals("Iron Warriors"));
    		warlordtraits.setAktiv("Night Lords: Night Haunter's Curse", army.equals("Night Lords"));
    		warlordtraits.setAktiv("World Eaters: Slaughterborn", army.equals("World Eaters"));
    		warlordtraits.setAktiv("Word Bearers: The Voice of Lorgar", army.equals("Word Bearers"));

    		warlordtraits.setAktiv("Bringers of Despair: Chosen of the Warmaster", specialDetachement.equals("Bringers of Despair"));
    		warlordtraits.setAktiv("Devastation Battery: Armour Bane", specialDetachement.equals("Devastation Battery"));
    		warlordtraits.setAktiv("Cult of the Damned: Exultant Preacher", specialDetachement.equals("Cult of the Damned"));
    		warlordtraits.setAktiv("Daemonkin Ritualists: Shepherd of the true Faith", specialDetachement.equals("Daemonkin Ritualists"));
    		warlordtraits.setAktiv("Soulforged Pack: Master of the Soulforges", specialDetachement.equals("Soulforged Pack"));
    		warlordtraits.setAktiv("Host Raptorial: The tip of the Claw", specialDetachement.equals("Host Raptorial"));
    		warlordtraits.setAktiv("Legion of Skulls: Bloodblessed", specialDetachement.equals("Legion of Skulls"));

    		warlordtraits.setAktiv("Red Corsairs: Reaver Lord", army.equals("Red Corsairs"));
    		warlordtraits.setAktiv("Crimson Slaughter: Maelstrom of Torment", army.equals("Crimson Slaughter"));
    		warlordtraits.setAktiv("The Purge: Blessed Mission", army.equals("The Purge"));
    		warlordtraits.setAktiv("The Scourged: Shattering Truth", army.equals("The Scourged"));
    		warlordtraits.setAktiv("Brazen Beasts: Carve the Runes", army.equals("Brazen Beasts"));
    		warlordtraits.setAktiv("Flawless Host: Ultimate Confidence", army.equals("Flawless Host"));
        } else if(ASTRA_MILITARUM.contains(army)) {
        	if(warlordtraits3 != null) {
        		warlordtraits3.setAktiv("Cadian: Superior Tactical Training", army.equals("Cadian"));
        		warlordtraits3.setAktiv("Catachan: Lead From the Front", army.equals("Catachan"));
        		warlordtraits3.setAktiv("Valhallan: Tenacious", army.equals("Valhallan"));
        		warlordtraits3.setAktiv("Vostroyan: Honoured Duellist", army.equals("Vostroyan"));
        		warlordtraits3.setAktiv("Armageddon: Ex-gang Leader", army.equals("Armageddon"));
        		warlordtraits3.setAktiv("Tallarn: Swift Attacker", army.equals("Tallarn"));
        		warlordtraits3.setAktiv("Militarum Tempestus: Faithful Servant of the Throne", army.equals("Militarum Tempestus"));
        		warlordtraits3.setAktiv("Mordian: Iron Discipline", army.equals("Mordian"));
        		
        		warlordtraits.setAktiv("Emperor's Blade Assault Company: Mechanised Commander", specialDetachement.equals("Emperor's Blade Assault Company"));
	    		warlordtraits.setAktiv("Emperor's Wrath Artillery Company: Lord of Ordnance", specialDetachement.equals("Emperor's Wrath Artillery Company"));
	    		warlordtraits.setAktiv("Emperor's Conclave Infantry Company: Fiery Denouncer", specialDetachement.equals("Emperor's Conclave Infantry Company"));
	    		warlordtraits.setAktiv("Emperor's Fist Tank Company: Unflinching Resolve", specialDetachement.equals("Emperor's Fist Tank Company"));
	    		warlordtraits.setAktiv("Tempestus Drop Force: Grave-Chute Commando", specialDetachement.equals("Tempestus Drop Force"));
        	} else {
	    		warlordtraits.setAktiv("Cadian: Superior Tactical Training", army.equals("Cadian"));
	    		warlordtraits.setAktiv("Catachan: Lead From the Front", army.equals("Catachan"));
	    		warlordtraits.setAktiv("Valhallan: Tenacious", army.equals("Valhallan"));
	    		warlordtraits.setAktiv("Vostroyan: Honoured Duellist", army.equals("Vostroyan"));
	    		warlordtraits.setAktiv("Armageddon: Ex-gang Leader", army.equals("Armageddon"));
	    		warlordtraits.setAktiv("Tallarn: Swift Attacker", army.equals("Tallarn"));
	    		warlordtraits.setAktiv("Militarum Tempestus: Faithful Servant of the Throne", army.equals("Militarum Tempestus"));
	    		warlordtraits.setAktiv("Mordian: Iron Discipline", army.equals("Mordian"));
	    		
	    		warlordtraits.setAktiv("Emperor's Blade Assault Company: Mechanised Commander", specialDetachement.equals("Emperor's Blade Assault Company"));
	    		warlordtraits.setAktiv("Emperor's Wrath Artillery Company: Lord of Ordnance", specialDetachement.equals("Emperor's Wrath Artillery Company"));
	    		warlordtraits.setAktiv("Emperor's Conclave Infantry Company: Fiery Denouncer", specialDetachement.equals("Emperor's Conclave Infantry Company"));
	    		warlordtraits.setAktiv("Emperor's Fist Tank Company: Unflinching Resolve", specialDetachement.equals("Emperor's Fist Tank Company"));
        	}
        } else if(ADEPTUS_MECHANICUS.contains(army)) {
        	if(warlordtraits2 != null) {
        		warlordtraits2.setAktiv("Mars: Static Psalm-code (AdMech)", army.equals("Forge World Mars"));
        		warlordtraits2.setAktiv("Graia: Emotionless Clarity (AdMech)", army.equals("Forge World Graia"));
        		warlordtraits2.setAktiv("Metalica: Ordered Efficiency (AdMech)", army.equals("Forge World Metalica"));
        		warlordtraits2.setAktiv("Lucius: Masterwork Bionics (AdMech)", army.equals("Forge World Lucius"));
        		warlordtraits2.setAktiv("Agripinaa: Reinforced Exoskeleton (AdMech)", army.equals("Forge World Agripinaa"));
        		warlordtraits2.setAktiv("Stygies VIII: Xenarite Studies (AdMech)", army.equals("Forge World Stygies VIII"));
        		warlordtraits2.setAktiv("Ryza: First-hand Field Testing (AdMech)", army.equals("Forge World Ryza"));
        	} else {
        		warlordtraits.setAktiv("Mars: Static Psalm-code (AdMech)", army.equals("Forge World Mars"));
        		warlordtraits.setAktiv("Graia: Emotionless Clarity (AdMech)", army.equals("Forge World Graia"));
        		warlordtraits.setAktiv("Metalica: Ordered Efficiency (AdMech)", army.equals("Forge World Metalica"));
        		warlordtraits.setAktiv("Lucius: Masterwork Bionics (AdMech)", army.equals("Forge World Lucius"));
        		warlordtraits.setAktiv("Agripinaa: Reinforced Exoskeleton (AdMech)", army.equals("Forge World Agripinaa"));
        		warlordtraits.setAktiv("Stygies VIII: Xenarite Studies (AdMech)", army.equals("Forge World Stygies VIII"));
        		warlordtraits.setAktiv("Ryza: First-hand Field Testing (AdMech)", army.equals("Forge World Ryza"));
        		
        		warlordtraits.setAktiv("Cybernetica Cohort: Adept of the Legio Cybernetica", specialDetachement.equals("Cybernetica Cohort"));
        		warlordtraits.setAktiv("Servitor Maniple: Master of Biosplicing", specialDetachement.equals("Servitor Maniple"));
        	}
        } else if((army.equals("AELDARI") || DRUKHARI.contains(army)) &&
        		(KABAL.equals(exclusiveKeyword) || WYCH_CULT.equals(exclusiveKeyword) || HAEMUNCULUS_COVEN.equals(exclusiveKeyword))) {
        	warlordtraits.setAktiv("Hatred Eternal", KABAL.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Soul Thirst", KABAL.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Ancient Evil", KABAL.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Quicksilver Fighter", WYCH_CULT.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Stimm Addict", WYCH_CULT.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Precision Blows", WYCH_CULT.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Master Regenesist", HAEMUNCULUS_COVEN.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Master Nemesine", HAEMUNCULUS_COVEN.equals(exclusiveKeyword));
        	warlordtraits.setAktiv("Master Artisan", HAEMUNCULUS_COVEN.equals(exclusiveKeyword));

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
    		
    		warlordtraits.setAktiv("Windrider Host: Wild Rider", specialDetachement.equals("Windrider Host"));
        	warlordtraits.setAktiv("Wraith Host: Revered by the Dead", specialDetachement.equals("Wraith Host"));
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
    		
    		warlordtraits.setAktiv("Stompa Mob: Gork's One", specialDetachement.equals("Stompa Mob"));
    		warlordtraits.setAktiv("Kult of Speed: Quick, Ladz!", specialDetachement.equals("Kult of Speed"));
    		warlordtraits.setAktiv("Dread Waaagh!: Dread Mek", specialDetachement.equals("Dread Waaagh"));
    		warlordtraits.setAktiv("Blitz Brigade: Back-Seat Driver", specialDetachement.equals("Blitz Brigade"));
        } else if(SM_CHAPTERS.contains(army)) {
        	warlordtraits.setAktiv("Ultramarines: Adept of the Codex", army.equals("Ultramarines"));
        	warlordtraits.setAktiv("White Scars: Deadly Hunter", army.equals("White Scars"));
        	warlordtraits.setAktiv("Imperial Fists: Architect of War", army.equals("Imperial Fists"));
        	warlordtraits.setAktiv("Crimson Fists: Tenacious Opponent", army.equals("Crimson Fists"));
        	warlordtraits.setAktiv("Black Templars: Oathkeeper", army.equals("Black Templars"));
        	warlordtraits.setAktiv("Salamanders: Anvil of Strength", army.equals("Salamanders"));
        	warlordtraits.setAktiv("Raven Guard: Silent Stalker", army.equals("Raven Guard"));
        	warlordtraits.setAktiv("Iron Hands: Merciless Logic", army.equals("Iron Hands"));
        	
        	warlordtraits.setAktiv("Indomitus Crusaders: Grey Shield", specialDetachement.equals("Indomitus Crusaders"));
        	warlordtraits.setAktiv("UM Victrix Guard: Warden of Ultramar", specialDetachement.equals("Ultramarines Victrix Guard"));
        	warlordtraits.setAktiv("IF Siegebreaker Cohort: Indomitable", specialDetachement.equals("Imperial Fists Siegebreaker Cohort"));
        	warlordtraits.setAktiv("CF Liberator Strike Force: Expert Instructor", specialDetachement.equals("Crimson Fists Liberator Strike Force"));
        	warlordtraits.setAktiv("BT Sword Brethren: Master Swordsman", specialDetachement.equals("Black Templar Sword Brethren"));
        	warlordtraits.setAktiv("RW Attack Squadron: Ligthning Fast Reactions", specialDetachement.equals("Ravenwing Attack Squadron"));
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
        } else if(army.equals("Space Wolves")) {
        	warlordtraits.setAktiv("SW Stalker Pack: Saga of the Savage", specialDetachement.equals("Space Wolves Stalker Pack"));
        } else if(GENESTEALER.contains(army)) {
        	warlordtraits.setAktiv("Anointed Throng: Insidious Mindwyrm", specialDetachement.equals("Anointed Throng"));
        	warlordtraits.setAktiv("Deliveranmce Broodsurge", specialDetachement.equals("Deliverance Broodsurge"));
        } else if(keywords.contains(INQUISITION)) {
        	warlordtraits.setAktiv("Ordo Hereticus: No Escape", keywords.contains(ORDO_HERETICUS));
        	warlordtraits.setAktiv("Ordo Xenos: Esoteric Law", keywords.contains(ORDO_XENOS));
        	warlordtraits.setAktiv("Ordo Malleus: Psychic Mastery", keywords.contains(ORDO_MALLEUS));
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

    public void setExclusiveKeyword(KeyWord s) {
    	exclusiveKeyword = s;
    }
    
    public String getSelectedTrait() {
    	return warlordtraits.getCurrentName();
    }
}
