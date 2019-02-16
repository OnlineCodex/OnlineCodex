package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;
import oc.wh40k.armies.VOLKChaos;
import oc.wh40k.armies.VOLKImperium;

public class CHWaffenkammer extends RuestkammerVater {

    public boolean uniqueError = false;
    public boolean terminator = false;
    public boolean sorcerer = false;
    public boolean champion = false;
    public boolean nurgle = false;
    public boolean biker = false;
    public boolean noise = false;
    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    boolean melee = false;
    boolean range = false;
    boolean rangeForMelee = false;
    boolean meleeForRange = false;
    String defaultNK = "";
    String defaultFK = "";
    String type = "";
    
    boolean character;
    
    OptionsEinzelUpgrade theSuppuratingPlate;
    OptionsEinzelUpgrade thePandemicStaff;
    OptionsEinzelUpgrade dolorousKnell;
    OptionsEinzelUpgrade fugarisHelm;
    OptionsEinzelUpgrade thePlagueSkullofGlothila;
    OptionsEinzelUpgrade talismanofBurningBlood;
    OptionsEinzelUpgrade eyeofTzeentch;
    OptionsEinzelUpgrade intoxicatingElixir;
    OptionsEinzelUpgrade theEyeofNight;
    OptionsEinzelUpgrade fleshmetalExoskeleton;
    OptionsEinzelUpgrade brassCollarofBhorghaster;

    //BP/NK gg RNG/NK

    public CHWaffenkammer() {
        grundkosten = 0;
    }

    public void setDefaultCloceCombat(String s) {
        defaultNK = s;
    }

    public void setDefaultRanged(String s) {
        defaultFK = s;
    }

    public void setTerminatorArmour(boolean s) {
        terminator = s;
    }

    public void setSorcerer(boolean s) {
        sorcerer = s;
    }

    public void setChampion(boolean s) {
        champion = s;
    }

    public void setNurgle(boolean s) {
        nurgle = s;
    }

    public void setBiker(boolean s) {
        biker = s;
    }

    public void setNoiseMarine(boolean s) {
        noise = s;
    }
    
    static public Vector<OptionsGruppeEintrag> getChampionEquipmentOneHanded(BuildaVater buildaVater) {
    	//The champion can take up to two weapons chosen from the following list:
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", buildaVater.getPts("Bolt pistol")));
    	ogE.addElement(new OptionsGruppeEintrag("Chainaxe", buildaVater.getPts("Chainaxe")));
    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", buildaVater.getPts("Chainsword")));
    	ogE.addElement(new OptionsGruppeEintrag("Lightning claw", buildaVater.getPts("Lightning claw single")));
    	ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", buildaVater.getPts("Plasma pistol")));
    	ogE.addElement(new OptionsGruppeEintrag("Power axe", buildaVater.getPts("Power axe")));
    	ogE.addElement(new OptionsGruppeEintrag("Power fist", buildaVater.getPts("Power fist")));
    	ogE.addElement(new OptionsGruppeEintrag("Power maul", buildaVater.getPts("Power maul")));
    	ogE.addElement(new OptionsGruppeEintrag("Power sword", buildaVater.getPts("Power sword")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getChampionEquipmentTwoHanded(BuildaVater buildaVater) {
    	//Alternatively, the champion can take one weapon chosen from the following list:
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Boltgun", buildaVater.getPts("Boltgun")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", buildaVater.getPts("Combi-bolter")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", buildaVater.getPts("Combi-flamer")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-melta", buildaVater.getPts("Combi-melta")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", buildaVater.getPts("Combi-plasma")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getCombiWeapons(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", buildaVater.getPts("Combi-bolter")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", buildaVater.getPts("Combi-flamer")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-melta", buildaVater.getPts("Combi-melta")));
    	ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", buildaVater.getPts("Combi-plasma")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getPistols(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", buildaVater.getPts("Bolt pistol")));
    	ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", buildaVater.getPts("Plasma pistol")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getHeavyWeapons(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Autocannon", buildaVater.getPts("Autocannon")));
    	ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", buildaVater.getPts("Heavy bolter")));
    	ogE.addElement(new OptionsGruppeEintrag("Lascannon", buildaVater.getPts("Lascannon")));
    	ogE.addElement(new OptionsGruppeEintrag("Missile launcher", buildaVater.getPts("Missile launcher")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getSpecialWeapons(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Flamer", buildaVater.getPts("Flamer")));
    	ogE.addElement(new OptionsGruppeEintrag("Meltagun", buildaVater.getPts("Meltagun")));
    	ogE.addElement(new OptionsGruppeEintrag("Plasma gun", buildaVater.getPts("Plasma gun")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getMeleeWeapons(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Chainaxe", buildaVater.getPts("Chainaxe")));
    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", buildaVater.getPts("Chainsword")));
    	ogE.addElement(new OptionsGruppeEintrag("Lightning claw", buildaVater.getPts("Lightning claw single")));
    	ogE.addElement(new OptionsGruppeEintrag("Power axe", buildaVater.getPts("Power axe")));
    	ogE.addElement(new OptionsGruppeEintrag("Power fist", buildaVater.getPts("Power fist")));
    	ogE.addElement(new OptionsGruppeEintrag("Power maul", buildaVater.getPts("Power maul")));
    	ogE.addElement(new OptionsGruppeEintrag("Power sword", buildaVater.getPts("Power sword")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getTerminatorMeleeWeapons(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Chainfist", buildaVater.getPts("Chainfist")));
    	ogE.addElement(new OptionsGruppeEintrag("Lightning claw", buildaVater.getPts("Lightning claw single")));
    	ogE.addElement(new OptionsGruppeEintrag("Power axe", buildaVater.getPts("Power axe")));
    	ogE.addElement(new OptionsGruppeEintrag("Power fist", buildaVater.getPts("Power fist")));
    	ogE.addElement(new OptionsGruppeEintrag("Power maul", buildaVater.getPts("Power maul")));
    	ogE.addElement(new OptionsGruppeEintrag("Power sword", buildaVater.getPts("Power sword")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getSpecialWeaponsDeathGuard(BuildaVater buildaVater) {
    	return getSpecialWeapons(buildaVater);
    }
    
    static public Vector<OptionsGruppeEintrag> getMeleeWeaponsDeathGuard(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
    	ogE.addElement(new OptionsGruppeEintrag("Balesword", buildaVater.getPts("Balesword")));
    	ogE.addElement(new OptionsGruppeEintrag("Chainaxe", buildaVater.getPts("Chainaxe")));
    	ogE.addElement(new OptionsGruppeEintrag("Lightning claw", buildaVater.getPts("Lightning claw")));
    	ogE.addElement(new OptionsGruppeEintrag("Power axe", buildaVater.getPts("Power axe")));
    	ogE.addElement(new OptionsGruppeEintrag("Power fist", buildaVater.getPts("Power fist")));
    	ogE.addElement(new OptionsGruppeEintrag("Power maul", buildaVater.getPts("Power maul")));
    	ogE.addElement(new OptionsGruppeEintrag("Power sword", buildaVater.getPts("Power sword")));
    	return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getTerminatorMeleeWeaponsDeathGuard(BuildaVater buildaVater) {
    	Vector<OptionsGruppeEintrag> ogE = getTerminatorMeleeWeapons(buildaVater);
    	ogE.insertElementAt(new OptionsGruppeEintrag("Balesword", buildaVater.getPts("Balesword")), 0);
    	return ogE;
    }

    public void addRelics() {
    	if(keywords.contains(CHARACTER)) {
	    	boolean powersword = false;
	    	boolean balesword = false;
	    	boolean plagueknife = false;
	    	boolean poweraxe = false;
	    	boolean powermaul = false;
	    	boolean chainsword = false;
	    	boolean twolightningClaws = false;
	    	boolean boltpistol = false;
	    	
	    	for(int i = 0; i < ogE.size(); i++) {
	    		powersword = powersword || ogE.get(i).getName().equals("Power sword");
	    		balesword = balesword || ogE.get(i).getName().equals("Balesword");
	    		plagueknife = plagueknife || ogE.get(i).getName().equals("Plague knife");
	    		poweraxe = poweraxe || ogE.get(i).getName().equals("Power axe");
	    		powermaul = powermaul || ogE.get(i).getName().equals("Power maul");
	    		chainsword = chainsword || ogE.get(i).getName().equals("Chainsword");
	    		twolightningClaws = twolightningClaws || ogE.get(i).getName().equals("Two lightning claws");
	    		boltpistol = boltpistol || ogE.get(i).getName().equals("Bolt pistol");
	    	}
    		
    		if(powersword || balesword || plagueknife){
    			int p = 9999;
    			if(powersword){
    				p = Math.min(p, getPts("Power sword"));
    			}
    			if(balesword){
    				p = Math.min(p, getPts("Balesword"));
    			}
    			if(plagueknife){
    				p = Math.min(p, getPts("Plague knife"));
    			}
        		ogE.addElement(new OptionsGruppeEintrag("Plaguebringer", p).setRelic(true)); //DG
    		} 
    		
    		if(powersword){
        		ogE.addElement(new OptionsGruppeEintrag("The Murder Sword", getPts("Power sword")).setRelic(true)); //CSM
        		ogE.addElement(new OptionsGruppeEintrag("Puscleaver", getPts("Power sword")).setRelic(true)); //CSM NURGLE
    		} 
    		
    		if(poweraxe){
        		ogE.addElement(new OptionsGruppeEintrag("Axe of Blind Fury", getPts("Power axe")).setRelic(true)); //CSM KHORNE
    		}
    		
    		if(powermaul){
        		ogE.addElement(new OptionsGruppeEintrag("The Black Mace", getPts("Power maul")).setRelic(true)); //CSM
        		ogE.addElement(new OptionsGruppeEintrag("The Cursed Crozius", getPts("Power maul")).setRelic(true)); //WORD BEARERS
    		}
    		
    		if(chainsword){
        		ogE.addElement(new OptionsGruppeEintrag("Blade of the Hydra", getPts("Chainsword")).setRelic(true)); //ALPHA LEGION
    		} 
    		
    		if(twolightningClaws){
        		ogE.addElement(new OptionsGruppeEintrag("Claws of the Black Hunt", getPts("Two lightning claws")).setRelic(true)); //NIGHT LORDS
    		} 
    		
    		if(boltpistol){
        		ogE.addElement(new OptionsGruppeEintrag("Blissgiver", getPts("Bolt pistol")).setRelic(true)); //EMPEROR'S CHILDREN
    		} 
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            melee = defaults[0];
            range = defaults[1];
            rangeForMelee = defaults[2];
            meleeForRange = defaults[3];
        } catch (Exception e) {
        }
        
        character = keywords.contains(CHARACTER);
        
        if(character){
        	add(theSuppuratingPlate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Suppurating Plate", 0).setRelic(true)); //DG
        	add(fugarisHelm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fugaris' Helm", 0).setRelic(true)); //DG
        	add(thePlagueSkullofGlothila = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Plague Skull of Glothila", 0).setRelic(true)); //DG
        	add(thePandemicStaff = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Pandemic Staff", 0).setRelic(true)); //DG PSYKER
        	add(talismanofBurningBlood = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Talisman of Burning Blood", 0).setRelic(true)); // CSM KHORNE
        	add(eyeofTzeentch = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eye of Tzeentch", 0).setRelic(true)); // CSM TZEENTCH PSYKER
        	add(intoxicatingElixir = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Intoxicating Elixir", 0).setRelic(true)); // CSM SLAANESH
        	add(theEyeofNight = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of Night", 0).setRelic(true)); // BLACK LEGION
        	add(fleshmetalExoskeleton = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fleshmetal Exoskeleton", 0).setRelic(true)); // IRON WARRIORS
        	add(brassCollarofBhorghaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brass Collar of Bhorghaster", 0).setRelic(true)); // WORLD EATERS
        	
        	if(type.equals("Noxious Blightbringer")){
        		add(dolorousKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "DolorousKnell", 0).setRelic(true)); //DG
        	}
        }

        if (type == "Scarab Occult Sorcerer") {
            ogE.addElement(new OptionsGruppeEintrag("Inferno combi-bolter", getPts("Inferno combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else {
            if (!defaultFK.equals("no weapon")) {
                if (defaultFK.equals("")) {
                    ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
                } else {
                    ogE.addElement(new OptionsGruppeEintrag(defaultFK, getPts(defaultFK)));
                }
            }
            if (range) {

                if (noise)
                    ogE.addElement(new OptionsGruppeEintrag("Sonic blaster", getPts("Sonic blaster")));
                if (!terminator && !sorcerer) {
                	ogE.addAll(getPistols(buildaVater));

                    if (nurgle) {
                        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
                    }
                }
                if (champion) {
                    if (terminator) {
                    	ogE.addAll(getCombiWeapons(buildaVater));
                    } else if (sorcerer) {
                        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
                        if (type == "Aspiring Sorcerer TS") ;
                        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
                    } else if (nurgle) {
                        // no combi weapons
                    } else {
                    	ogE.addAll(getCombiWeapons(buildaVater));
                    }
                }
            }
            if (rangeForMelee) {
                if (terminator) {
                	ogE.addAll(getTerminatorMeleeWeapons(buildaVater));
                } else {
                	ogE.addAll(getMeleeWeapons(buildaVater));
                }
            }
            if (ogE.size() > 0) {
                addRelics();
                add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                if (!defaultFK.equals("no weapon")) {
                    fkwaffen.setSelected(0, true);
                }
            }

            seperator();

            if (!defaultNK.equals("no weapon")) {
                if (defaultNK.equals("")) {
                    ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
                } else {
                    ogE.addElement(new OptionsGruppeEintrag(defaultNK, getPts(defaultNK)));
                }
            }
            if (meleeForRange) {
            	ogE.addAll(getPistols(buildaVater));
            }
            if (melee) {
                if (sorcerer) {
                    ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
                    ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
                } else {
                    if (nurgle) {
                        ogE.addElement(new OptionsGruppeEintrag("Plague sword", getPts("Plague sword")));
                    } else {
                        if (terminator) {
                        	ogE.addAll(getTerminatorMeleeWeapons(buildaVater));
                        } else {
                        	ogE.addAll(getMeleeWeapons(buildaVater));
                        }
                    }
                }
            }
            if (ogE.size() > 0) {
                addRelics();
                add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                if (!defaultNK.equals("no weapon")) {
                    handwaffen.setSelected(0, true);
                }
            }

            seperator();

            if (noise) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Doom siren", getPts("Doom siren")));
            }

            if (nurgle) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist")));
            }

        }

        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (type == "Scarab Occult Sorcerer") {
            handwaffen.alwaysSelected();
            fkwaffen.alwaysSelected();
        } else {

            if (!defaultFK.equals("no weapon")) {
            	if(fkwaffen != null)
            		fkwaffen.alwaysSelected();
            }

            if (!defaultNK.equals("no weapon")) {
                if(handwaffen != null)
                	handwaffen.alwaysSelected();
            }

            if (!defaultFK.equals("no weapon") && !defaultNK.equals("no weapon")) {
                if (fkwaffen.isSelected("Lightning claw") && handwaffen.isSelected("Lightning claw")) {
                    fkwaffen.setPreis("Lightning claw", getPts("Lightning claw pair") / 2 + 1);
                    handwaffen.setPreis("Lightning claw", getPts("Lightning claw pair") / 2);
                } else {
                    fkwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                    handwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                }
            }

        }
        
        if(character) {
        	boolean csm = (VOLKChaos.getLegions().contains(buildaVater.getFormationType()) ||
   				 buildaVater.getFormationType().equals("CHAOS") ||
   				 buildaVater.getFormationType().equals("Heretic Astartes")) && 
   				 !keywords.contains(DEATH_GUARD); 
        	
        	boolean dg = buildaVater.getFormationType().equals("Death Guard") ||
      				 (buildaVater.getFormationType().equals("CHAOS") && (keywords.contains(DEATH_GUARD) || keywords.contains(LEGION))) ||
      				 (buildaVater.getFormationType().equals("Heretic Astartes") && (keywords.contains(DEATH_GUARD) || keywords.contains(LEGION))); 
        	
        	theSuppuratingPlate.setAktiv((chosenRelic == null || theSuppuratingPlate.isSelected()) && dg);
        	fugarisHelm.setAktiv((chosenRelic == null || fugarisHelm.isSelected()) && dg);
        	thePlagueSkullofGlothila.setAktiv((chosenRelic == null || thePlagueSkullofGlothila.isSelected()) && dg);
        	thePandemicStaff.setAktiv((chosenRelic == null || thePandemicStaff.isSelected()) && dg && keywords.contains(PSYKER));
        	theSuppuratingPlate.setAktiv((chosenRelic == null || theSuppuratingPlate.isSelected()) && dg);
        	talismanofBurningBlood.setAktiv((chosenRelic == null || talismanofBurningBlood.isSelected()) && csm && keywords.contains(KHORNE));
        	eyeofTzeentch.setAktiv((chosenRelic == null || eyeofTzeentch.isSelected()) && csm && keywords.contains(PSYKER) && keywords.contains(TZEENTCH));
        	intoxicatingElixir.setAktiv((chosenRelic == null || intoxicatingElixir.isSelected()) && csm && keywords.contains(SLAANESH));
        	theEyeofNight.setAktiv((chosenRelic == null || theEyeofNight.isSelected()) && csm && keywords.contains(BLACK_LEGION) || keywords.contains(LEGION) && buildaVater.getFormationType().equals("Black Legion"));
        	talismanofBurningBlood.setAktiv((chosenRelic == null || talismanofBurningBlood.isSelected()) && csm);
        	talismanofBurningBlood.setAktiv((chosenRelic == null || talismanofBurningBlood.isSelected()) && csm);
        	talismanofBurningBlood.setAktiv((chosenRelic == null || talismanofBurningBlood.isSelected()) && csm);

//        	add(theEyeofNight = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of Night", 0).setRelic(true)); // BLACK LEGION
//        	add(fleshmetalExoskeleton = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fleshmetal Exoskeleton", 0).setRelic(true)); // IRON WARRIORS
//        	add(brassCollarofBhorghaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brass Collar of Bhorghaster", 0).setRelic(true)); // WORLD EATERS
//        	
//        	if(type.equals("Noxious Blightbringer")){
//        		add(dolorousKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "DolorousKnell", 0).setRelic(true)); //DG
//        	}
        	
        	


//        	ogE.addElement(new OptionsGruppeEintrag("Plaguebringer", p).setRelic(true)); //DG
//    		} 
//    		
//    		if(powersword){
//        		ogE.addElement(new OptionsGruppeEintrag("The Murder Sword", getPts("Power sword")).setRelic(true)); //CSM
//        		ogE.addElement(new OptionsGruppeEintrag("Puscleaver", getPts("Power sword")).setRelic(true)); //CSM NURGLE
//    		} 
//    		
//    		if(poweraxe){
//        		ogE.addElement(new OptionsGruppeEintrag("Axe of Blind Fury", getPts("Power axe")).setRelic(true)); //CSM KHORNE
//    		}
//    		
//    		if(powermaul){
//        		ogE.addElement(new OptionsGruppeEintrag("The Black Mace", getPts("Power maul")).setRelic(true)); //CSM
//        		ogE.addElement(new OptionsGruppeEintrag("The Cursed Crozius", getPts("Power maul")).setRelic(true)); //WORD BEARERS
//    		}
//    		
//    		if(chainsword){
//        		ogE.addElement(new OptionsGruppeEintrag("Blade of the Hydra", getPts("Chainsword")).setRelic(true)); //ALPHA LEGION
//    		} 
//    		
//    		if(twolightningClaws){
//        		ogE.addElement(new OptionsGruppeEintrag("Claws of the Black Hunt", getPts("Two lightning claws")).setRelic(true)); //NIGHT LORDS
//    		} 
//    		
//    		if(boltpistol){
//        		ogE.addElement(new OptionsGruppeEintrag("Blissgiver", getPts("Bolt pistol")).setRelic(true)); //EMPEROR'S CHILDREN
//    		} 
        }
        
    }

}
