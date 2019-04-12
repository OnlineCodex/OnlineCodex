package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHCSMRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade talismanOfBurningBlood;
    private OptionsEinzelUpgrade eyeOfTzeentch;
    private OptionsEinzelUpgrade intoxicatingElixir;
    private OptionsEinzelUpgrade theEyeOfNight;
    private OptionsEinzelUpgrade fleshmetalExoskeleton;
    private OptionsEinzelUpgrade brassCollarOfBhorghaster;
    private OptionsEinzelUpgrade theDaemonsEye;
    private OptionsEinzelUpgrade theInfernoTome;
    private OptionsEinzelUpgrade chiropteranWings;
    private OptionsEinzelUpgrade theGorePlate;
    private OptionsEinzelUpgrade trophiesOfSlaughter;
    private OptionsEinzelUpgrade sightlessHelm;
    private OptionsEinzelUpgrade cloakOfConquest;
    private OptionsEinzelUpgrade orbOfUnlife;
    private OptionsEinzelUpgrade bookOfUntruth;
    private OptionsEinzelUpgrade daemonfleshPlate;
    private OptionsEinzelUpgrade flawlessCloak;


    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public CHCSMRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    public void setDefault1(String s) {
    }

    public void setDefault2(String s) {
    }

    public void addRelics() {

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Puscleaver", getPts("Power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power axe")){
    			ogE.addElement(new OptionsGruppeEintrag("Axe of Blind Fury", getPts("Power axe")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power maul")){
    			ogE.addElement(new OptionsGruppeEintrag("The Black Mace", getPts("Power maul")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("The Murder Sword", getPts("Power sword")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Word Bearers"))
    		{
	    		if(ogE.get(i).getName().equals("Power maul")){
	    			ogE.addElement(new OptionsGruppeEintrag("The Cursed Crozius", getPts("Power maul")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Alpha Legion"))
    		{
	    		if(ogE.get(i).getName().equals("Power maul")){
	    			ogE.addElement(new OptionsGruppeEintrag("Blade of the Hydra", getPts("Power maul")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Night Lords"))
    		{
	    		if(ogE.get(i).getName().equals("Lightning Claw")){
	    			ogE.addElement(new OptionsGruppeEintrag("Claws of the Black Hunt", getPts("Lightning Claw")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Emperor's Children"))
    		{
	    		if(ogE.get(i).getName().equals("Bolt pistol")){
	    			ogE.addElement(new OptionsGruppeEintrag("Blissgiver", getPts("Bolt pistol")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Bringers of Despair"))
    		{
	    		if(ogE.get(i).getName().equals("Power axe")){
	    			ogE.addElement(new OptionsGruppeEintrag("Foecleaver", getPts("Power axe")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Daemonkin Ritualists"))
    		{
	    		if(ogE.get(i).getName().equals("Force stave")){
	    			ogE.addElement(new OptionsGruppeEintrag("The Burning Rod", getPts("Force stave")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Soulforged Pack"))
    		{
	    		if(ogE.get(i).getName().equals("Mechatendrils")){
	    			ogE.addElement(new OptionsGruppeEintrag("Mecha-Serpents", getPts("Mechatendrils")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Fallen Angels"))
    		{
	    		if(ogE.get(i).getName().equals("Force sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Caliban Steel Blade", getPts("Force sword")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"))
    		{
	    		if(ogE.get(i).getName().equals("Chainsword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Ghorisvex's Teeth", getPts("Chainsword")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"))
    		{
	    		if(ogE.get(i).getName().equals("Combi-bolter")){
	    			ogE.addElement(new OptionsGruppeEintrag("Angelsbane", getPts("Combi-bolter")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"))
    		{
	    		if(ogE.get(i).getName().equals("Power sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Spineshiver Blade", getPts("Power sword")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Red Corsairs"))
    		{
	    		if(ogE.get(i).getName().equals("Combi-melta")){
	    			ogE.addElement(new OptionsGruppeEintrag("Maelstrom's Bite", getPts("Combi-melta")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Crimson Slaughter"))
    		{
	    		if(ogE.get(i).getName().equals("Power sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Blade of the Relentless", getPts("Power sword")).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(talismanOfBurningBlood = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Talisman of Burning Blood", 0).setRelic(true));
       	add(eyeOfTzeentch = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eye of Tzeentch", 0).setRelic(true));
       	add(intoxicatingElixir = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Inoxicating Elixir", 0).setRelic(true));
       	add(theEyeOfNight = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of Night", 0).setRelic(true));
       	add(fleshmetalExoskeleton = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fleshmetal Exoskeleton", 0).setRelic(true));
       	add(brassCollarOfBhorghaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brass Collar of Bhorghaster", 0).setRelic(true));
       	add(theDaemonsEye = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Deamon's Eye", 0).setRelic(true));
       	add(theInfernoTome = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The inferno Tome", 0).setRelic(true));
       	add(chiropteranWings = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chiropteran Wings", 0).setRelic(true));
       	add(theGorePlate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Gore Plate", 0).setRelic(true));
       	add(trophiesOfSlaughter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Trophies of Slaughter", 0).setRelic(true));
       	add(sightlessHelm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sightless Helm", 0).setRelic(true));
       	add(cloakOfConquest = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cloak of Conquest", 0).setRelic(true));
       	add(orbOfUnlife = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Orb of Unlife", 0).setRelic(true));
       	add(bookOfUntruth = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Book of Untruth", 0).setRelic(true));
       	add(daemonfleshPlate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonflesh Plate", 0).setRelic(true));
       	add(flawlessCloak = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flawless Cloak", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


       	if(type.equals("Daemon Prince of Chaos") || type.equals("Daemon Prince of Chaos with Wings")){
            ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
            ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
            ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warp bolter", getPts("Warp bolter")));
    	} else if(type.equals("Chaos Lord")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Character)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Character)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Chaos Lord in Terminator Armour")){
    		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Sorcerer")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Sorcerer in Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Dark Apostle")){
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Exalted Champion")){
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Character)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Character)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Warpsmith")){
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Master of Possession")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Lord Discordant on Helstalker")) {
            ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
            ogE.addElement(new OptionsGruppeEintrag("Baleflamer", getPts("Baleflamer")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Impaler chainglaive", getPts("Impaler chainglaive")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Master of Executions")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Axe of dismemberment", getPts("Axe of dismemberment")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
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
        	offsetX += buttonBreite + 20;
        }

        if(o4 != null) {
        	o4.getPanel().setLocation(offsetX, 10);
        	offsetX += buttonBreite + 20;
        }

        if(o5 != null) {
        	o5.getPanel().setLocation(offsetX, 10);
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

    	if(type.equals("Chaos Lord") || type.equals("Chaos Lord in Terminator Armour") ||
    			type.equals("Sorcerer") || type.equals("Sorcerer in Terminator Armour") || type.equals("Dark Apostle") ||
    			type.equals("Exalted Champion") || type.equals("Warpsmith") || type.equals("Master of Possession") || type.equals("Master of Executions")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();

        	o1.setAktiv("Axe of Blind Fury", keywords.contains(KHORNE));
           	o2.setAktiv("Axe of Blind Fury", keywords.contains(KHORNE));
        	o1.setAktiv("Puscleaver", keywords.contains(NURGLE));
           	o2.setAktiv("Puscleaver", keywords.contains(NURGLE));
    	}

    	if(type.equals("Daemon Prince of Chaos") || type.equals("Daemon Prince of Chaos with Wings")) {
    		o1.alwaysSelected();
    	}

    	if(type.equals("Lord Discordant on Helstalker")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		o3.alwaysSelected();
    	}

    	talismanOfBurningBlood.setAktiv((chosenRelic == null || talismanOfBurningBlood.isSelected()) && keywords.contains(KHORNE));
    	eyeOfTzeentch.setAktiv(((chosenRelic == null || eyeOfTzeentch.isSelected()) && keywords.contains(TZEENTCH)));
    	intoxicatingElixir.setAktiv(((chosenRelic == null || intoxicatingElixir.isSelected()) && keywords.contains(SLAANESH)));
    	theEyeOfNight.setAktiv((chosenRelic == null || theEyeOfNight.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"));
    	fleshmetalExoskeleton.setAktiv((chosenRelic == null || fleshmetalExoskeleton.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Warriors"));
    	brassCollarOfBhorghaster.setAktiv((chosenRelic == null || brassCollarOfBhorghaster.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("World Eaters"));
    	theDaemonsEye.setAktiv((chosenRelic == null || theDaemonsEye.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Devastation Battery"));
    	theInfernoTome.setAktiv((chosenRelic == null || theInfernoTome.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Cult of the Damned"));
    	chiropteranWings.setAktiv((chosenRelic == null || chiropteranWings.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Host Raptorial"));
    	theGorePlate.setAktiv((chosenRelic == null || theGorePlate.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Legion of Skulls"));
    	trophiesOfSlaughter.setAktiv((chosenRelic == null || trophiesOfSlaughter.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"));
    	sightlessHelm.setAktiv((chosenRelic == null || sightlessHelm.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"));
    	cloakOfConquest.setAktiv((chosenRelic == null || cloakOfConquest.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"));
    	orbOfUnlife.setAktiv((chosenRelic == null || orbOfUnlife.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("The Purge"));
    	bookOfUntruth.setAktiv((chosenRelic == null || bookOfUntruth.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("The Scourged"));
    	daemonfleshPlate.setAktiv((chosenRelic == null || daemonfleshPlate.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Brazen Beasts"));
    	flawlessCloak.setAktiv((chosenRelic == null || flawlessCloak.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Flawless Host"));

    }

}
