package oc.wh40k.units.im;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class IMSpaceMarinesRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1, oe2;
    OptionsUpgradeGruppe o1, o2, o3, o4;
    OptionsZaehlerGruppe o5;
    String type = "";
    String default1 = "";
    String default2 = "";
    boolean character = false;
    boolean psyker = false;
    boolean jump = false;
    boolean captain = false;
    OptionsEinzelUpgrade theSalamandersMantle;
    OptionsEinzelUpgrade ravensFury;
    OptionsEinzelUpgrade mantleoftheStormseer;
    OptionsEinzelUpgrade theSancticHalo;
    OptionsEinzelUpgrade theCrusadersHelm;

    Set<String> CHARACTERS = ImmutableSet.of("Captain", "Captain in Terminator Armour", "Captain in Cataphractii Armour",
            "Captain in Gravis Armour", "Captain on Bike", "Librarian", "Librarian in Terminator Armour", "Librarian on Bike",
            "Techmarine", "Techmarine on Bike", "Chaplain", "Chaplain in Terminator Armour", "Master", "Master in Terminator Armour", "Master in Cataphractii Armour", "Master in Gravis Armour",
            "Chaplain on Bike", "Lieutenants", "Primaris Chaplain", "Primaris Librarian", "Primaris Lieutenants", "Primaris Master", "Primaris Captain", 
            "Apothecary", "Apothecary on Bike", "Primaris Apothecary",
            "Company Ancient", "Company Ancient on Bike",
            "Primaris Ancient", "Company Champion", "Company Champion on Bike",
            "Imperial Space Marine", "Chapter Ancient", "Chapter Champion");
    Set<String> PSYKERS = ImmutableSet.of("Librarian", "Librarian in Terminator Armour", "Librarian on Bike", "Primaris Librarian");
    Set<String> COMBATSHIELD = ImmutableSet.of("Company Champion");
    

    public IMSpaceMarinesRuestkammer() {
        grundkosten = 0;
    }

    public void setType(String s) {
        type = s;
    }

    public void setDefault1(String s) {
        default1 = s;
    }

    public void setDefault2(String s) {
        default2 = s;
    }
    
    public void addRelics() {
    	if(character) {
	    	boolean boltgun = false;
	    	boolean mcBoltgun = false;
	    	boolean powersword = false;
	    	boolean mcPowersword = false;
	    	
	    	for(int i = 0; i < ogE.size(); i++) {
	    		boltgun = ogE.get(i).getName().equals("Boltgun");
	    		mcBoltgun = ogE.get(i).getName().equals("Master-crafted boltgun");
	    		powersword = ogE.get(i).getName().equals("Power sword");
	    		mcPowersword = ogE.get(i).getName().equals("Master-crafted power sword");
	    	
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
	    		}
	    	}
    		
    		if(boltgun){
        		ogE.addElement(new OptionsGruppeEintrag("The Primarch's Wrath", getPts("Boltgun (SM)")).setRelic(true));
    		} else if(mcBoltgun){
        		ogE.addElement(new OptionsGruppeEintrag("The Primarch's Wrath", getPts("Master-crafted boltgun")).setRelic(true));
    		}
    		
    		if(powersword){
        		ogE.addElement(new OptionsGruppeEintrag("The Burning Blade", getPts("Power sword (SM)")).setRelic(true));
    		} else if(mcPowersword){
        		ogE.addElement(new OptionsGruppeEintrag("The Burning Blade", getPts("Master-crafted power sword")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        psyker = PSYKERS.contains(type);
        character = CHARACTERS.contains(type);
        captain = type.startsWith("Captain");
        
        if(character) {
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour Indomitus", 0).setRelic(true));
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
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Shield Eternal", 0).setRelic(true));
	       	}
	       	
	       	seperator();
        }

        if (type == "Captain" || type == "Captain on Bike") {
            ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master-crafted boltgun", getPts("Master-crafted boltgun")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            if (type == "Captain") {
                ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            }
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Captain in Terminator Armour") {
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Stormbolter", "Stormbolter (SM)", buildaVater));
            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Stormbolter", true);

            seperator();

            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade launcher", "Wrist-mounted grenade launcher", getPts("Wrist-mounted grenade launcher")));
        } else if (type == "Captain in Cataphractii Armour") {
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("Combi-bolter", "Combi-bolter", buildaVater));
            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o1.setSelected("Combi-bolter", true);

            seperator();

            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Sanguinary Priest" || type == "Sanguinary Priest on Bike") {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Librarian" || type == "Librarian on Bike") {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("Bolt pistol", "Bolt pistol (SM)", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Librarian in Terminator Armour") {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Storm bolter", "Storm bolter (SM)", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Chaplain") {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(2, true);
        } else if (type == "Chaplain in Terminator Armour") {
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(3, true);
        } else if (type == "Company Ancient") {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);
        } else if (type == "Cataphractii Sergeant") {
            ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade Harness", getPts("Grenade Harness")));
        } else if (type == "Tartaros Sergeant") {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", getPts("plasma blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", getPts("volkite charger")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Techmarine") {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(2, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm")));
            ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", getPts("conversion beamer")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servo-harness", getPts("Servo-arm") + getPts("Plasma cutter") + getPts("Flamer (SM)")));
        } else if (type == "Librarian GK") {
            ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Two nemesis falchions", getPts("Nemesis falchions")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Chaplain GK") {
            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

        if (type == "Librarian" || type == "Techmarine") {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type == "Chaplain" || type == "Librarian GK" || type == "Chaplain GK") {
            o1.alwaysSelected();
        }

        if (type == "Captain in Terminator Armour") {
            oe1.setAktiv(o1.isSelected("Power fist") || o2.isSelected("Power fist"));
        }

        if (type.contains("Techmarine")) {
            if (oe1.isSelected()) {
                o3.setSelected(0, true);
                o3.setSelected(1, false);
            }
            o3.alwaysSelected();
        }

        if (type == "Tartaros Sergeant" || type == "Cataphractii Sergeant" || (type.contains("Captain") && !type.equals("Captain in Gravis Armour")) || type.contains("Sanguinary Priest")) {
            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);
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
        	theSalamandersMantle.setAktiv((chosenRelic == null || theSalamandersMantle.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Salamanders"));
        	ravensFury.setAktiv((chosenRelic == null || ravensFury.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Raven Guard") && jump);
        	theCrusadersHelm.setAktiv((chosenRelic == null || theCrusadersHelm.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Templars"));

        	if(psyker) {
        		mantleoftheStormseer.setAktiv((chosenRelic == null || mantleoftheStormseer.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("White Scars"));
        	}	
        	
        	if(captain){
        		theSancticHalo.setAktiv((chosenRelic == null || theSancticHalo.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Ultramarines"));
        	}
        	
        	if(o1 != null) {
        		o1.setAktiv("The Axe of Medusa", (chosenRelic == null || o1.isSelected("The Axe of Medusa")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Hands"));
        		o1.setAktiv("The Fist of Vengeance", (chosenRelic == null || o1.isSelected("The Fist of Vengeance")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Crimson Fists"));
        		o1.setAktiv("The Spartean", (chosenRelic == null || o1.isSelected("The Spartean")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Imperial Fists"));
        	}
        	
        	if(o2 != null) {
        		o2.setAktiv("The Axe of Medusa", (chosenRelic == null || o2.isSelected("The Axe of Medusa")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Hands"));
        		o2.setAktiv("The Fist of Vengeance", (chosenRelic == null || o2.isSelected("The Fist of Vengeance")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Crimson Fists"));
        		o2.setAktiv("The Spartean", (chosenRelic == null || o2.isSelected("The Spartean")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Imperial Fists"));
        	}

        }
        
    }

}
