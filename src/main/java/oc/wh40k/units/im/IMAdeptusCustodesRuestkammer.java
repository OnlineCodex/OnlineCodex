package oc.wh40k.units.im;

import static oc.KeyWord.*;

import java.util.Set;

import javax.sound.sampled.FloatControl.Type;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class IMAdeptusCustodesRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private String default1 = "";
    private String default2 = "";
    private boolean character = false;
    private OptionsEinzelUpgrade raimentOfSorrows;
    private OptionsEinzelUpgrade eaglesEye;
    private OptionsEinzelUpgrade auricAquilas;
    private OptionsEinzelUpgrade thePraetorianPlate;
    
    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public IMAdeptusCustodesRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Guardian spear")){
    			ogE.addElement(new OptionsGruppeEintrag("Gatekeeper", getPts("Guardian spear (AC)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Sentinel blade")){
    			ogE.addElement(new OptionsGruppeEintrag("The veiled Blade", getPts("Sentinel blade")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;
                
       	add(raimentOfSorrows = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Raiment of Sorrows", 0).setRelic(true));
       	add(eaglesEye = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Eagle's Eye", 0).setRelic(true));
       	add(auricAquilas = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auric Aquilas", 0).setRelic(true));
       	add(thePraetorianPlate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Preatorian Plate", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Shield Captain")) {
            ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear (AC)")));
            ogE.addElement(new OptionsGruppeEintrag("Sentinel blade", getPts("Sentinel blade")));
            ogE.addElement(new OptionsGruppeEintrag("Castellan axe", getPts("Castellan axe")));
            ogE.addElement(new OptionsGruppeEintrag("Sentinel blade & Storm shield", getPts("Sentinel blade") + getPts("Storm shield (AC Characters)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);
            
            seperator();
    	} else if(type.equals("Shield Captain in Allarus Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear (AC)")));
            ogE.addElement(new OptionsGruppeEintrag("Castellan axe", getPts("Castellan axe")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);
            
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Balistus grenade launcher", getPts("Balistus grenade launcher")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o2.setSelected(0, true);

            seperator();
    	} else if(type.equals("Shield Captain on Dawneagle Jetbike")){
            ogE.addElement(new OptionsGruppeEintrag("Interceptor lance", getPts("Interceptor lance")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hurricane bolter", getPts("Hurrican bolter (AC)")));
            ogE.addElement(new OptionsGruppeEintrag("Salvo launcher", getPts("Salvo launcher")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            addRelics();
            o2.setSelected(0, true);

            seperator();
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
    	
    	if(type.equals("Shield Captain")){
    		o1.alwaysSelected();
    	}
    	if(type.equals("Shield Captain in Allarus Terminator Armour") ||
    			type.equals("Shield Captain on Dawneagle Jetbike")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}

    	raimentOfSorrows.setAktiv((chosenRelic == null || raimentOfSorrows.isSelected()));   
    	eaglesEye.setAktiv(((chosenRelic == null || eaglesEye.isSelected())));
    	auricAquilas.setAktiv(((chosenRelic == null || auricAquilas.isSelected()) && keywords.contains(BIKER)));
    	thePraetorianPlate.setAktiv((chosenRelic == null || thePraetorianPlate.isSelected()) && keywords.contains(TERMINATOR));
    }

}
