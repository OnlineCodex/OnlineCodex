package oc.wh40k.units.ch;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHWaffenkammerCD extends RuestkammerVater {

    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    private String allegiance;
    //boolean psyker = false; //Daemon Prince, if not Khorne
    
    OptionsEinzelUpgrade armourofScorn;
    OptionsEinzelUpgrade theCrimsonCrown;
    OptionsEinzelUpgrade argaththeKingofBlades;
    OptionsEinzelUpgrade skullreaver;
    OptionsEinzelUpgrade theEndlessGrimoire;
    OptionsEinzelUpgrade soulBane;
    OptionsEinzelUpgrade theImpossibleRobe;
    OptionsEinzelUpgrade theEverstave;
    OptionsEinzelUpgrade hornofNurglesRot;
    OptionsEinzelUpgrade theEntropicKnell;
    OptionsEinzelUpgrade corruption;
    OptionsEinzelUpgrade theForbiddenGem;
    OptionsEinzelUpgrade theMarkofExcess;
    OptionsEinzelUpgrade soulstealer;
    OptionsEinzelUpgrade slothfulClaws;

    Set<String> MONSTER = ImmutableSet.of("Bloodthirster of Insensate Rage", "Wrath of Khorne Bloodthirster", "Bloodthirster of Unfetted Fury", 
    									  "Lord of Change", "Great Unclean One", "Keeper of Secrets", 
    									  "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings");
    Set<String> PSYKER = ImmutableSet.of("Lord of Change", "Changecaster", "Fateskimmer", "Fluxmaster",
    									 "Great Unclean One", "Poxbringer", "Keeper of Secrets", "Herald of Slaanesh", 
    									 "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings");
    Set<String> BLADEOFBLOOD = ImmutableSet.of("Bloodmaster", "Skullmaster", "Blood Throne", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings");
    Set<String> AXEOFKHORNE = ImmutableSet.of("Wrath of Khorne Bloodthirster", "Bloodthirster of Unfetted Fury", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings");
    Set<String> ROD = ImmutableSet.of("Lord of Change", "Changecaster", "Fateskimmer");
    Set<String> PLAGUESWORD = ImmutableSet.of("Spoilpox Scrivener");
    Set<String> WITSTEALER = ImmutableSet.of("Keeper of Secrets", "Daemon Prince of Chaos", "Daemon Prince of Chaos with Wings");
    Set<String> HERALD_OF_TZEENTCH = ImmutableSet.of("Changecaster", "Fateskimmer", "Fluxmaster"); 
    
    public CHWaffenkammerCD() {
        grundkosten = 0;
    }

    public void setAllegiance(String s) {
    	allegiance = s;
    }

    @Override
    public void initButtons(boolean... defaults) {
    	add(armourofScorn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour of Scorn", 0).setRelic(true));
    	add(theCrimsonCrown = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crimson Crown", 0).setRelic(true));
    	add(argaththeKingofBlades = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "A'rgath, the King of Blades", 0).setRelic(true));
    	add(skullreaver = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skullreaver", 0).setRelic(true));
    	add(theEndlessGrimoire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Endless Grimoire", 0).setRelic(true));
    	add(soulBane = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soul Bane", 0).setRelic(true));
    	add(theImpossibleRobe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Impossible Robe", 0).setRelic(true));
    	add(theEverstave = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Everstave", 0).setRelic(true));
    	add(hornofNurglesRot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Horn of Nurgle's Rot", 0).setRelic(true));
    	add(theEntropicKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Entropic Knell", 0).setRelic(true));
    	add(corruption = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corruption", 0).setRelic(true));
    	add(theForbiddenGem = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Forbidden Gem", 0).setRelic(true));
    	add(theMarkofExcess = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Mark of Excess", 0).setRelic(true));
    	add(soulstealer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soulstealer", 0).setRelic(true));
    	add(slothfulClaws = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Slothful Claws", 0).setRelic(true));
    	
        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
    	checkBuildaVater();
        String army = buildaVater.getFormationType();
    	boolean undivided = allegiance.equals(ALLEGIANCE) && (army.equals("CHAOS") || army.equals("Chaosdaemons"));
    	boolean khorne = army.equals("Khorne") || allegiance.equals(KHORNE) || undivided;
    	boolean tzeentch = army.equals("Tzeentch") || allegiance.equals(TZEENTCH) || undivided;
    	boolean nurgle = army.equals("Nurgle") || allegiance.equals(NURGLE) || undivided;
    	boolean slaanesh = army.equals("Slaanesh") || allegiance.equals(SLAANESH) || undivided;
    	
    	armourofScorn.setAktiv((chosenRelic == null || armourofScorn.isSelected()) && khorne && MONSTER.contains("type"));
    	theCrimsonCrown.setAktiv((chosenRelic == null || theCrimsonCrown.isSelected()) && khorne);
    	argaththeKingofBlades.setAktiv((chosenRelic == null || argaththeKingofBlades.isSelected()) && khorne && BLADEOFBLOOD.contains("type"));
    	skullreaver.setAktiv((chosenRelic == null || skullreaver.isSelected()) && khorne && AXEOFKHORNE.contains("type"));
    	theEndlessGrimoire.setAktiv((chosenRelic == null || theEndlessGrimoire.isSelected()) && tzeentch && PSYKER.contains("type"));
    	soulBane.setAktiv((chosenRelic == null || soulBane.isSelected()) && HERALD_OF_TZEENTCH.contains("type"));
    	theImpossibleRobe.setAktiv((chosenRelic == null || theImpossibleRobe.isSelected()) && tzeentch);
    	theEverstave.setAktiv((chosenRelic == null || theEverstave.isSelected()) && tzeentch  && ROD.contains("type"));
    	hornofNurglesRot.setAktiv((chosenRelic == null || hornofNurglesRot.isSelected()) && nurgle);
    	theEntropicKnell.setAktiv((chosenRelic == null || theEntropicKnell.isSelected()) && nurgle);
    	corruption.setAktiv((chosenRelic == null || corruption.isSelected()) && nurgle && PLAGUESWORD.contains(type));
    	theForbiddenGem.setAktiv((chosenRelic == null || theForbiddenGem.isSelected()) && slaanesh);
    	theMarkofExcess.setAktiv((chosenRelic == null || theMarkofExcess.isSelected()) && slaanesh);
    	soulstealer.setAktiv((chosenRelic == null || soulstealer.isSelected()) && slaanesh && WITSTEALER.contains(type));
    	slothfulClaws.setAktiv((chosenRelic == null || slothfulClaws.isSelected()) && type.equals("Herald of Slaanesh"));
    	
    	
//      A'rgath, the King of Blades - KHORNE with blade of blood or hellforged sword. Replace //TODO check if option
//      Skullreaver - KHORNE with axe of khorne or daemonic axe. Replace //TODO check if option   	
//      The Everstave - TZEENTCH with rod of sorcery or staff of change //TODO check if option
//      Corruption - NURGLE with plaguesword. Replace //TODO check if option	
//      Soulstealer - SLAANESH with witstealer sword or hellforged sword. Replace //TODO check if option
    	
    }

}
