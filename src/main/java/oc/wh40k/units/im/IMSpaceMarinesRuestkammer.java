package oc.wh40k.units.im;

import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.JUMP_PACK;
import static oc.KeyWord.PSYKER;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;
import oc.wh40k.armies.VOLKImperium;

public class IMSpaceMarinesRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3;
    private boolean character = false;
    private boolean psyker = false;
    public boolean jump = false;
    private boolean captain = false;
    private OptionsEinzelUpgrade theSalamandersMantle;
    private OptionsEinzelUpgrade ravensFury;
    private OptionsEinzelUpgrade mantleoftheStormseer;
    private OptionsEinzelUpgrade theSancticHalo;
    private OptionsEinzelUpgrade theCrusadersHelm;
    private OptionsEinzelUpgrade theShieldEternal;
    private OptionsEinzelUpgrade theArmourIndomitus;
    private OptionsEinzelUpgrade theAngelsWing;
    private OptionsEinzelUpgrade theVeritasVitae;
    private OptionsEinzelUpgrade standardofSacrifice;

    Set<String> CHARACTERS = ImmutableSet.of("Captain", "Captain in Terminator Armour", "Captain in Cataphractii Armour",
            "Captain in Gravis Armour", "Captain in Phobos Armour", "Captain on Bike", "Librarian", "Librarian in Terminator Armour", "Librarian on Bike",
            "Techmarine", "Techmarine on Bike", "Chaplain", "Chaplain in Terminator Armour", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour", "Master in Gravis Armour",
            "Chaplain on Bike", "Lieutenants", "Primaris Chaplain", "Primaris Librarian", "Primaris Lieutenants", "Primaris Master", "Primaris Captain",
            "Apothecary", "Apothecary on Bike", "Primaris Apothecary",
            "Company Ancient", "Company Ancient on Bike",
            "Primaris Ancient", "Company Champion", "Company Champion on Bike",
            "Imperial Space Marine", "Chapter Ancient", "Chapter Champion");
    Set<String> PSYKERS = ImmutableSet.of("Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Primaris Librarian", "Librarian in Phobos Armour");
    Set<String> COMBATSHIELD = ImmutableSet.of("Company Champion");


    public IMSpaceMarinesRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    public void addRelics() {
    	if(character) {
	    	boolean boltgun = false;
	    	boolean mcBoltgun = false;
	    	boolean powersword = false;
	    	boolean mcPowersword = false;

	    	for(int i = 0; i < ogE.size(); i++) {
	    		boltgun = boltgun || ogE.get(i).getName().equals("Boltgun");
	    		mcBoltgun = mcBoltgun || ogE.get(i).getName().equals("Master-crafted boltgun");
	    		powersword = powersword || ogE.get(i).getName().equals("Power sword");
	    		mcPowersword = mcPowersword || ogE.get(i).getName().equals("Master-crafted power sword");

	    		if(ogE.get(i).getName().equals("Storm shield")){
	        		ogE.addElement(new OptionsGruppeEintrag("The Shield Eternal", getPts("Storm shield (Characters)")).setRelic(true));
	    		} else if(ogE.get(i).getName().equals("Chainsword")){
	        		ogE.addElement(new OptionsGruppeEintrag("Teeth of Terra", getPts("Chainsword (SM)")).setRelic(true));
	    		} else if(ogE.get(i).getName().equals("Power axe")){
	        		ogE.addElement(new OptionsGruppeEintrag("The Axe of Medusa", getPts("Power axe (SM)")).setRelic(true)); //Iron Hands
	    		} else if(ogE.get(i).getName().equals("Power fist")){
	        		ogE.addElement(new OptionsGruppeEintrag("The Fist of Vengeance", getPts("Power fist (SM)")).setRelic(true)); //Crimson Fists
	    		} else if(ogE.get(i).getName().equals("Bolt pistol")){
	        		ogE.addElement(new OptionsGruppeEintrag("The Spartean", getPts("Bolt pistol (SM)")).setRelic(true)); //Imperial Fists
	    		} else if(ogE.get(i).getName().equals("Thunder hammer")){
	        		ogE.addElement(new OptionsGruppeEintrag("The Hammer of Baal", getPts("Thunder Hammer (Characters)")).setRelic(true)); //Imperial Fists
	    		} else if(ogE.get(i).getName().equals("Force Stave")){
	        		ogE.addElement(new OptionsGruppeEintrag("Gallian's Staff", getPts("Force stave")).setRelic(true)); //Imperial Fists
	    		}
	    	}

    		if(boltgun){
        		ogE.addElement(new OptionsGruppeEintrag("The Primarch's Wrath", getPts("Boltgun (SM)")).setRelic(true));
    		} else if(mcBoltgun){
        		ogE.addElement(new OptionsGruppeEintrag("The Primarch's Wrath", getPts("Master-crafted boltgun")).setRelic(true));
    		}

    		if(powersword){
        		ogE.addElement(new OptionsGruppeEintrag("The Burning Blade", getPts("Power sword (SM)")).setRelic(true));
        		ogE.addElement(new OptionsGruppeEintrag("Archangel's Shard", getPts("Power sword (SM)")).setRelic(true));
    		} else if(mcPowersword){
        		ogE.addElement(new OptionsGruppeEintrag("The Burning Blade", getPts("Master-crafted power sword")).setRelic(true));
        		ogE.addElement(new OptionsGruppeEintrag("Archangel's Shard", getPts("Master-crafted power sword")).setRelic(true));
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        psyker = PSYKERS.contains(type) || keywords.contains(PSYKER);
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        captain = type.startsWith("Captain");
        int offsetX = randAbstand;
        int oe1Offset = cnt;

        if(type.contains("Master")) {
        	type = type.replace("Master", "Captain");
        }

        if(character) {
	       	add(theArmourIndomitus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour Indomitus", 0).setRelic(true));
	       	if(type.equals("Company Ancient") || type.equals("Chapter Ancient") || type.equals("Primaris Ancient")) {
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Standard of the Emperor Ascendant", 0).setRelic(true));
	       	}

	       	if(psyker) {
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tome of Malcador", 0).setRelic(true));
	       		add(mantleoftheStormseer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mantle of the Stormseer", 0).setRelic(true)); //White Scars
	       	}

	       	add(theSalamandersMantle = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Salamander's Mantle", 0).setRelic(true)); //Salamanders

	       	add(ravensFury = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Raven's Fury", 0).setRelic(true)); //Raven Guard

	       	if(captain){
	       		add(theSancticHalo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Sanctic Halo", 0).setRelic(true)); //Ultramarines
	       	}

	       	add(theCrusadersHelm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crusader's Helm", 0).setRelic(true)); //Black Templars

	       	if(COMBATSHIELD.contains(type)){
	       		add(theShieldEternal = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Shield Eternal", 0).setRelic(true));
	       	}

	        add(theAngelsWing = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Angel's Wing", 0).setRelic(true));

	       	add(theVeritasVitae = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Veritas Vitae", 0).setRelic(true));

	       	if(type.contains("Ancient")){
	       		add(standardofSacrifice = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Standard of Sacrifice", 0).setRelic(true));
	       	}

	       	offsetX += buttonBreite + 15;
	       	oe1Offset = cnt;
	       	seperator();
        }

        if (type.equals("Captain") || type.equals("Captain on Bike")) {
            ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master-crafted boltgun", getPts("Master-crafted boltgun")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            if (type.equals("Captain")) {
                ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            }
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Captain in Terminator Armour")) {
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Stormbolter", "Stormbolter (SM)", buildaVater));
            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Stormbolter", true);

            seperator();

            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade launcher", "Wrist-mounted grenade launcher", getPts("Wrist-mounted grenade launcher")));
        } else if (type.equals("Captain in Cataphractii Armour")) {
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("Combi-bolter", "Combi-bolter", buildaVater));
            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Combi-bolter", true);

            seperator();

            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Captain in Gravis Armour")) {
        	ogE.addElement(new OptionsGruppeEintrag("Boltstorm gauntlet", getPts("Boltstorm gauntlet")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("MC Auto bolt rifle", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Master-crafted power sword", getPts("Master-crafted power sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected("Power sword", true);
        } else if (type.equals("Captain in Phobos Armour")) {
        	ogE.addElement(new OptionsGruppeEintrag("Master-crafted instigator bolt carbine", getPts("Master-crafted instigator bolt carbine")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);
        } else if (type.equals("Primaris Captain")) {
        	ogE.addElement(new OptionsGruppeEintrag("MC Auto bolt rifle", "Master-cafted auto bolt rifle", getPts("Master crafted auto bolt rifle")));
        	ogE.addElement(new OptionsGruppeEintrag("MC Stalker bolt rifle", "Master-cafted stalker bolt rifle", getPts("Master crafted stalker bolt rifle")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("MC Auto bolt rifle", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected("Power sword", true);
        } else if (type.equals("Sanguinary Priest") || type.equals("Sanguinary Priest on Bike")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Librarian") || type.equals("Librarian on Bike")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("Bolt pistol", "Bolt pistol (SM)", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        } else if (type.equals("Primaris Librarian") || type.equals("Librarian in Phobos Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected("Force sword", true);
        } else if (type.equals("Librarian in Terminator Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Storm bolter", "Storm bolter (SM)", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        } else if (type.equals("Chaplain")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(2, true);
        } else if (type.equals("Chaplain in Terminator Armour")) {
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(3, true);
        } else if (type.equals("Company Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);
        } else if (type.equals("Chapter Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Power sword", true);
        } else if (type.equals("Primaris Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt rifle", getPts("Bolt rifle")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected("Bolt rifle", true);
        }  else if (type.equals("Chapter Champion")) {
        	ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Champion's blade", getPts("Champion's blade")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Champion's blade", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power lance", getPts("power lance (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Characters)")));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("relic blade")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Power sword", true);
        }  else if (type.equals("Apothecary") || type.equals("Apothecary on Bike") || type.equals("Sanguinary Novitiate")) {
        	ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

        	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type.equals("Company Champion") || type.equals("Company Champion on Bike") || type.equals("Company Champion with Jump Pack")) {
        	ogE.addElement(new OptionsGruppeEintrag("Master-crafted power sword", getPts("Master-crafted power sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Master-crafted power sword", true);

            seperator();

        	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
    	} else if (type.equals("Cataphractii Sergeant")) {

            ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade Harness", getPts("Grenade Harness")));
        } else if (type.equals("Tartaros Sergeant")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", getPts("plasma blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", getPts("volkite charger")));
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 0));
        } else if (type.contains("Techmarine")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected(2, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm")));
            ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", getPts("conversion beamer")));
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servo-harness", getPts("Servo-arm") + getPts("Plasma cutter") + getPts("Flamer (SM)")));
        } else if (type.equals("Librarian GK")) {
            ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Two nemesis falchions", getPts("Nemesis falchions")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        } else if (type.equals("Chaplain GK")) {
            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        } else if (type.equals("Terminator Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("thunder hammer (Characters)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected("Lightning claw", true);
        }

        if(oe1 != null) {
        	oe1.getPanel().setLocation(randAbstand, oe1Offset + 20);
        }

        if(o1 != null) {
        	o1.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o2 != null) {
        	o2.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o3 != null) {
        	o3.getPanel().setLocation(offsetX, 10);
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

        if (type.equals("Librarian") || type.equals("Primaris Librarian") || type.equals("Techmarine") || type.equals("Captain in Gravis Armour") ||
        		type.equals("Primaris Captain") || type.equals("Primaris Ancient") || type.equals("Chapter Champion") || type.equals("Apothecary") ||
        		type.equals("Apothecary on Bike") || type.equals("Company Champion") || type.equals("Company Champion on Bike") || type.equals("Company Champion with Jump Pack") ||
        		type.equals("Sanguinary Novitiate") || type.equals("Captain in Phobos Armour") || type.equals("Librarian in Phobos Armour")) {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type.equals("Chaplain") || type.equals("Librarian GK") || type.equals("Chaplain GK") || type.equals("Chapter Ancient") || type.equals("Terminator Ancient")) {
            o1.alwaysSelected();
        }

        if (type.equals("Captain in Terminator Armour")) {
            oe1.setAktiv(o1.isSelected("Power fist") || o2.isSelected("Power fist"));
        }

        if (type.contains("Techmarine")) {
            if (oe1.isSelected()) {
                o3.setSelected(0, true);
                o3.setSelected(1, false);
            }
            o3.alwaysSelected();
        }

        if (type.equals("Tartaros Sergeant") || type.equals("Cataphractii Sergeant") || (type.contains("Captain") && !type.equals("Captain in Gravis Armour") && !type.equals("Captain in Phobos Armour") && !type.equals("Primaris Captain")) || type.contains("Sanguinary Priest")) {
            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setMaxAmount(o3.isSelected() ? 0 : 1);
            o2.setMaxAmount(o3.isSelected() ? 0 : 1);
            o3.setMaxAmount(o1.isSelected() || o2.isSelected() ? 0 : 1);
        }

        if (o1 != null) {
            o1.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o1.setPreis("Storm shield", getPts("Storm shield (Characters)"));
        }

        if (o2 != null) {
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
        }

        if(character){
        	final boolean sm = (VOLKImperium.getSmChapters().contains(buildaVater.getFormationType()) ||
        				 buildaVater.getFormationType().equals("IMPERIUM") ||
        				 buildaVater.getFormationType().equals("Adeptus Astartes")) &&
        				 !keywords.contains(BLOOD_ANGELS);

        	final boolean ba = buildaVater.getFormationType().equals("Blood Angels") ||
   				 (buildaVater.getFormationType().equals("IMPERIUM") && (keywords.contains(BLOOD_ANGELS) || keywords.contains(CHAPTER))) ||
   				 (buildaVater.getFormationType().equals("Adeptus Astartes") && (keywords.contains(BLOOD_ANGELS) || keywords.contains(CHAPTER)));

        	//SM Relics
        	if(COMBATSHIELD.contains(type)){
        		theShieldEternal.setAktiv((chosenRelic == null || theShieldEternal.isSelected()) && sm);
        	}

        	theArmourIndomitus.setAktiv((chosenRelic == null || theArmourIndomitus.isSelected()) && sm);
        	theSalamandersMantle.setAktiv((chosenRelic == null || theSalamandersMantle.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Salamanders"));
        	ravensFury.setAktiv((chosenRelic == null || ravensFury.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Raven Guard") && jump || keywords.contains(JUMP_PACK));
        	theCrusadersHelm.setAktiv((chosenRelic == null || theCrusadersHelm.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Templars"));

        	if(psyker) {
        		mantleoftheStormseer.setAktiv((chosenRelic == null || mantleoftheStormseer.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("White Scars"));
        	}

        	if(captain){
        		theSancticHalo.setAktiv((chosenRelic == null || theSancticHalo.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Ultramarines"));
        	}

        	//BA Relics
        	theAngelsWing.setAktiv((chosenRelic == null || theAngelsWing.isSelected()) && ba && jump);

        	theVeritasVitae.setAktiv((chosenRelic == null || theVeritasVitae.isSelected()) && ba);

	       	if(type.contains("Ancient")){
	       		standardofSacrifice.setAktiv((chosenRelic == null || standardofSacrifice.isSelected()) && ba);
	       	}

        	if(o1 != null) {
        		//SM Relics
        		o1.setAktiv("The Axe of Medusa", (chosenRelic == null || o1.isSelected("The Axe of Medusa")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Hands"));
        		o1.setAktiv("The Fist of Vengeance", (chosenRelic == null || o1.isSelected("The Fist of Vengeance")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Crimson Fists"));
        		o1.setAktiv("The Spartean", (chosenRelic == null || o1.isSelected("The Spartean")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Imperial Fists"));

        		o1.setAktiv("The Shield Eternal", (chosenRelic == null || o1.isSelected("The Shield Eternal")) && sm);
        		o1.setAktiv("Teeth of Terra", (chosenRelic == null || o1.isSelected("Teeth of Terra")) && sm);
        		o1.setAktiv("The Primarch's Wrath", (chosenRelic == null || o1.isSelected("The Primarch's Wrath")) && sm);
        		o1.setAktiv("The Burning Blade", (chosenRelic == null || o1.isSelected("The Burning Blade")) && sm);

        		//BA Relics
        		o1.setAktiv("The Hammer of Baal", (chosenRelic == null || o1.isSelected("The Hammer of Baal")) && ba);
        		o1.setAktiv("Gallian's Staff", (chosenRelic == null || o1.isSelected("Gallian's Staff")) && ba);
        		o1.setAktiv("Archangel's Shard", (chosenRelic == null || o1.isSelected("Archangel's Shard")) && ba);
        	}

        	if(o2 != null) {
        		//SM Relics
        		o2.setAktiv("The Axe of Medusa", (chosenRelic == null || o2.isSelected("The Axe of Medusa")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Hands"));
        		o2.setAktiv("The Fist of Vengeance", (chosenRelic == null || o2.isSelected("The Fist of Vengeance")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Crimson Fists"));
        		o2.setAktiv("The Spartean", (chosenRelic == null || o2.isSelected("The Spartean")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Imperial Fists"));

        		o2.setAktiv("The Shield Eternal", (chosenRelic == null || o2.isSelected("The Shield Eternal")) && sm);
        		o2.setAktiv("Teeth of Terra", (chosenRelic == null || o2.isSelected("Teeth of Terra")) && sm);
        		o2.setAktiv("The Primarch's Wrath", (chosenRelic == null || o2.isSelected("The Primarch's Wrath")) && sm);
        		o2.setAktiv("The Burning Blade", (chosenRelic == null || o2.isSelected("The Burning Blade")) && sm);

        		//BA Relics
        		o2.setAktiv("The Hammer of Baal", (chosenRelic == null || o2.isSelected("The Hammer of Baal")) && ba);
        		o2.setAktiv("Gallian's Staff", (chosenRelic == null || o2.isSelected("Gallian's Staff")) && ba);
        		o2.setAktiv("Archangel's Shard", (chosenRelic == null || o2.isSelected("Archangel's Shard")) && ba);
        	}
        }

    }

}
