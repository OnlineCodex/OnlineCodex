package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import java.util.Set;

import javax.sound.sampled.FloatControl.Type;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class CHCSMRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private String default1 = "";
    private String default2 = "";
    private boolean character = false;
    private OptionsEinzelUpgrade talismanOfBurningBlood;
    private OptionsEinzelUpgrade eyeOfTzeentch;
    private OptionsEinzelUpgrade intoxicatingElixir;
    private OptionsEinzelUpgrade theEyeOfNight;
    private OptionsEinzelUpgrade fleshmetalExoskeleton;
    private OptionsEinzelUpgrade brassCollarOfBhorghaster;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public CHCSMRuestkammer() {
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
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;
                
       	add(talismanOfBurningBlood = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Talisman of Burning Blood", 0).setRelic(true));
       	add(eyeOfTzeentch = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eye of Tzeentch", 0).setRelic(true));
       	add(intoxicatingElixir = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Inoxicating Elixir", 0).setRelic(true));
       	add(theEyeOfNight = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of Night", 0).setRelic(true));
       	add(fleshmetalExoskeleton = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fleshmetal Exoskeleton", 0).setRelic(true));
       	add(brassCollarOfBhorghaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brass Collar of Bhorghaster", 0).setRelic(true));
       	
       	offsetX += buttonBreite + 15;
       	oe1Offset = cnt;
       	seperator();


       	if(type.equals("Daemon Prince of Chaos") || type.equals("Daemon Prince of Chaos with Wings")){
            ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
            ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
            ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected(0, true);

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
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
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
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Sorcerer")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Sorcerer in Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Dark Apostle")){
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
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
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

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
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Warpsmith")){
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Master of Possession")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
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
    	
    	if(type.equals("Daemon Prince of Chaos") || type.equals("Daemon Prince of Chaos with Wings") || type.equals("Chaos Lord") || type.equals("Chaos Lord in Terminator Armour") ||
    			type.equals("Sorcerer") || type.equals("Sorcerer in Terminator Armour") || type.equals("Dark Apostle") ||
    			type.equals("Exalted Champion") || type.equals("Warpsmith") || type.equals("Master of Possession")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		
        	o1.setAktiv("Axe of Blind Fury", keywords.contains(KHORNE));
           	o2.setAktiv("Axe of Blind Fury", keywords.contains(KHORNE));
        	o1.setAktiv("Puscleaver", keywords.contains(NURGLE));
           	o2.setAktiv("Puscleaver", keywords.contains(NURGLE));
    	}
    	
    	talismanOfBurningBlood.setAktiv((chosenRelic == null || talismanOfBurningBlood.isSelected()) && keywords.contains(KHORNE));   
    	eyeOfTzeentch.setAktiv(((chosenRelic == null || eyeOfTzeentch.isSelected()) && keywords.contains(TZEENTCH)));
    	intoxicatingElixir.setAktiv(((chosenRelic == null || intoxicatingElixir.isSelected()) && keywords.contains(NURGLE)));
    	theEyeOfNight.setAktiv((chosenRelic == null || theEyeOfNight.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Black Legion"));
    	fleshmetalExoskeleton.setAktiv((chosenRelic == null || fleshmetalExoskeleton.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iron Warriors"));
    	brassCollarOfBhorghaster.setAktiv((chosenRelic == null || brassCollarOfBhorghaster.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("World Eaters"));
    }

}
