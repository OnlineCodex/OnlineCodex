package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import java.util.Set;

import javax.sound.sampled.FloatControl.Type;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class CHDeathGuardRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    String default1 = "";
    String default2 = "";
    boolean character = false;
    OptionsEinzelUpgrade theSuppuratingPlate;
    OptionsEinzelUpgrade thePandemicStaff;
    OptionsEinzelUpgrade dolorousKnell;
    OptionsEinzelUpgrade fugarisHelm;
    OptionsEinzelUpgrade thePlagueSkullOfGlothila;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public CHDeathGuardRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Plague knife")){
    			ogE.addElement(new OptionsGruppeEintrag("Plaguebringer", getPts("Plague knife")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Balesword")){
    			ogE.addElement(new OptionsGruppeEintrag("Plaguebringer", getPts("Balesword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Plaguebringer", getPts("Power sword")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;
                
       	add(theSuppuratingPlate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Suppurating Plate", 0).setRelic(true));
       	add(thePandemicStaff = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Pandemic Staff", 0).setRelic(true));
       	add(dolorousKnell = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dolorous Knell", 0).setRelic(true));
       	add(fugarisHelm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fugaris' Helm", 0).setRelic(true));
       	add(thePlagueSkullOfGlothila = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Plague Skull of Glothila", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	oe1Offset = cnt;
       	seperator();


    	if(type.equals("Lord of Contagion")) {
            ogE.addElement(new OptionsGruppeEintrag("Plaguereaper", getPts("Plaguereaper")));
            ogE.addElement(new OptionsGruppeEintrag("Manreaper", getPts("Manreaper")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if(type.equals("Daemon Prince of Nurgle") || type.equals("Daemon Prince of Nurgle with Wings")){
            ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
            ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
            ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plague spewer", getPts("Plague spewer")));
    	} else if(type.equals("Malignant Plaguecaster")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Corrupted staff", getPts("Corrupted staff")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Noxious Blightbringer")) {
            ogE.addElement(new OptionsGruppeEintrag("Cursed plague bell", getPts("Cursed plague bell") * 2));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Foul Blightspawn")){
            ogE.addElement(new OptionsGruppeEintrag("Plague sprayer", getPts("Plague sprayer")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Biologus Putrifier")){
            ogE.addElement(new OptionsGruppeEintrag("Injector pistol", getPts("Injector pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Plague knife", getPts("Plague knife")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Plague Surgeon")){
    		
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Tallyman")){
             ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
             addRelics();
             add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Chaos Lord")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
	        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
	        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
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
            ogE.addElement(new OptionsGruppeEintrag("Balesword", getPts("Balesword")));
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
    	
    	if(type.equals("Lord of Contagion") || type.equals("Daemon Prince of Nurgle") || type.equals("Daemon Prince of Nurgle with Wings")
    			|| type.equals("Foul Blightspawn") || type.equals("Tallyman")){
    		o1.alwaysSelected();
    	}
    	if(type.equals("Malignant Plaguecaster") || type.equals("Noxious Blightbringer") || type.equals("Biologus Putrifier") ||
    			type.equals("Plague Surgeon") || type.equals("Chaos Lord") || type.equals("Chaos Lord in Terminator Armour") ||
    			type.equals("Sorcerer") || type.equals("Sorcerer in Terminator Armour")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}

    	theSuppuratingPlate.setAktiv((chosenRelic == null || theSuppuratingPlate.isSelected()));   
    	thePandemicStaff.setAktiv(((chosenRelic == null || thePandemicStaff.isSelected()) && keywords.contains(PSYKER)));
    	dolorousKnell.setAktiv(((chosenRelic == null || dolorousKnell.isSelected()) && keywords.contains(NOXIOUS_BLIGHTBRINGER)));
    	fugarisHelm.setAktiv((chosenRelic == null || fugarisHelm.isSelected()));
    	thePlagueSkullOfGlothila.setAktiv((chosenRelic == null || thePlagueSkullOfGlothila.isSelected()));
    }

}
