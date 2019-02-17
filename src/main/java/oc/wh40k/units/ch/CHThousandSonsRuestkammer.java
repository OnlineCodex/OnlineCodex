package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class CHThousandSonsRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private String default1 = "";
    private String default2 = "";
    private boolean character = false;
    private OptionsEinzelUpgrade darkMatterCrystal;
    private OptionsEinzelUpgrade helmOfTheThirdEye;
    private OptionsEinzelUpgrade athenaenScrolls;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public CHThousandSonsRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Force sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Seer's Bane", getPts("Force sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Seer's Bane", getPts("Power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Inferno bolt pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Coruscator", getPts("Inferno bolt pistol")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Force stave")){
    			ogE.addElement(new OptionsGruppeEintrag("The Prismatic Staff", getPts("Force stave")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;
                
       	add(darkMatterCrystal = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dark Matter Crystal", 0).setRelic(true));
       	add(helmOfTheThirdEye = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of the third Eye", 0).setRelic(true));
       	add(athenaenScrolls = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Athenaean Scrolls", 0).setRelic(true));
       	
       	offsetX += buttonBreite + 15;
       	oe1Offset = cnt;
       	seperator();


       	if(type.equals("Daemon Prince of Tzeentch") || type.equals("Daemon Prince of Tzeentch with Wings")){
            ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
            ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
            ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);

            seperator();
    	} else if(type.equals("Thousand Sons Sorcerer")){
            ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

    	} else if(type.equals("Exalted Sorcerer") ||
    			type.equals("Exalted Sorcerer on Disk")){
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("2 Power swords", getPts("Power sword") * 2));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));

    	} else if(type.equals("Sorcerer in Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Inferno combi-bolter", getPts("Inferno combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Familiar", getPts("Familiar")));

            seperator();
    	} else if(type.equals("Tzaangor Shaman")) {
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
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
    	
    	if(type.equals("Daemon Prince of Tzeentch") || type.equals("Daemon Prince of Tzeentch with Wings") ||
    			type.equals("Tzaangor Shaman")){
    		o1.alwaysSelected();
    	}
    	if( type.equals("Thousand Sons Sorcerer") || type.equals("Exalted Sorcerer") || type.equals("Exalted Sorcerer on Disk") ||
    			type.equals("Sorcerer in Terminator Armour")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}

    	darkMatterCrystal.setAktiv((chosenRelic == null || darkMatterCrystal.isSelected()));   
    	helmOfTheThirdEye.setAktiv(((chosenRelic == null || helmOfTheThirdEye.isSelected()) && keywords.contains(PSYKER)));
    	athenaenScrolls.setAktiv((chosenRelic == null || athenaenScrolls.isSelected()));
    }

}
