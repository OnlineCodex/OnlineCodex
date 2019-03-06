package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import java.util.Set;

import javax.sound.sampled.FloatControl.Type;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class AECraftworldRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private String default1 = "";
    private String default2 = "";
    private boolean character = false;
    private OptionsEinzelUpgrade thePhoenixGem;
    private OptionsEinzelUpgrade falchusWing;
    private OptionsEinzelUpgrade theSpiritStoneOfAnathlan;
    private OptionsEinzelUpgrade shiftshroudOfAlanssair;
    private OptionsEinzelUpgrade psytronomeOfIyanden;
    private OptionsEinzelUpgrade ghosthelmOfAlishazier;
    private OptionsEinzelUpgrade shimmerplumeOfAchillrial;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public AECraftworldRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Shuriken pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Kurnous' Bow", getPts("Shuriken pistol")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Shuriken pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Blazing Star of Vaul", getPts("Shuriken pistol")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Shuriken catapult")){
    			ogE.addElement(new OptionsGruppeEintrag("Blazing Star of Vaul", getPts("Shuriken catapult")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Shard of Anaris", getPts("Power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Firesabre", getPts("Power sword")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Biel-Tan"))
    		{
	    		if(ogE.get(i).getName().equals("Power sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("The burnished Blade of Eliarna", getPts("Power sword")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Saim-Hann"))
    		{
	    		if(ogE.get(i).getName().equals("Laser lance")){
	    			ogE.addElement(new OptionsGruppeEintrag("The Novalance of Saim-Hann", getPts("Laser lance")).setRelic(true));
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
                
       	add(thePhoenixGem = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Phoenix Gem", 0).setRelic(true));
       	add(falchusWing = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Falchus Wing", 0).setRelic(true));
       	add(theSpiritStoneOfAnathlan = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Spirit Stone Of Anathlan", 0).setRelic(true));
       	add(shiftshroudOfAlanssair = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shiftshroud Of Alanssair", 0).setRelic(true));
       	add(psytronomeOfIyanden = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psytronome Of Iyanden", 0).setRelic(true));
       	add(ghosthelmOfAlishazier = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ghosthelm Of Alishazier", 0).setRelic(true));
       	add(shimmerplumeOfAchillrial = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shimmerplume Of Achillrial", 0).setRelic(true));
       	
       	offsetX += buttonBreite + 15;
       	oe1Offset = cnt;
       	seperator();


    	if(type.equals("Farseer") || 
    			type.equals("Farseer Skyrunner") ||
    			type.equals("Warlock") ||
    			type.equals("Warlock Skyrunner")) {
            ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
            ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            
            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            
            seperator();
    	} else if(type.equals("Autarch")) {
            ogE.addElement(new OptionsGruppeEintrag("Star glaive", getPts("Star glaive")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));  
    	} else if(type.equals("Autarch with Swooping Hawk Wings")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Autarch Skyrunner")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Spiritseer")) {
            ogE.addElement(new OptionsGruppeEintrag("Witch staff", getPts("Witch staff")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
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
    	
    	if(type.equals("Farseer") || 
    			type.equals("Farseer Skyrunner") ||
    			type.equals("Warlock") ||
    			type.equals("Warlock Skyrunner") ||
    			type.equals("Autarch with Swooping Hawk Wings") ||
    			type.equals("Spiritseer")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Autarch") ||
    			type.equals("Autarch Skyrunner")){
    		o1.alwaysSelected();
    	}


    	thePhoenixGem.setAktiv((chosenRelic == null || thePhoenixGem.isSelected()));   
    	falchusWing.setAktiv(((chosenRelic == null || falchusWing.isSelected()) && keywords.contains(INFANTRY)));
    	theSpiritStoneOfAnathlan.setAktiv(((chosenRelic == null || theSpiritStoneOfAnathlan.isSelected()) && keywords.contains(PSYKER) && BuildaHQ.aktBuildaVater.getFormationType().equals("Biel-Tan")));
    	shiftshroudOfAlanssair.setAktiv((chosenRelic == null || shiftshroudOfAlanssair.isSelected()) && keywords.contains(INFANTRY) && BuildaHQ.aktBuildaVater.getFormationType().equals("Alaitoc"));
    	psytronomeOfIyanden.setAktiv((chosenRelic == null || psytronomeOfIyanden.isSelected()) && keywords.contains(PSYKER) && BuildaHQ.aktBuildaVater.getFormationType().equals("Iyanden"));
    	ghosthelmOfAlishazier.setAktiv((chosenRelic == null || ghosthelmOfAlishazier.isSelected()) && keywords.contains(PSYKER) && BuildaHQ.aktBuildaVater.getFormationType().equals("Ulthwe"));
    	shimmerplumeOfAchillrial.setAktiv((chosenRelic == null || shimmerplumeOfAchillrial.isSelected()) && keywords.contains(AUTARCH));
    }

}
