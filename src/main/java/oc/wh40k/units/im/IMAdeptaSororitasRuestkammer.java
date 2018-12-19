package oc.wh40k.units.im;

import static oc.KeyWord.*;

import java.util.Vector;

import oc.*;

public class IMAdeptaSororitasRuestkammer extends RuestkammerVater {
	
    public OptionsEinzelUpgrade oe1;
    OptionsUpgradeGruppe o1, o2, o3;
    boolean psyker = false;
    boolean character = false;
    OptionsEinzelUpgrade relic1;
    
    static public Vector<OptionsGruppeEintrag> getRangedWeapons(BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", bv.getPts("Boltgun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", bv.getPts("Combi-flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", bv.getPts("Combi-melta (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", bv.getPts("Combi-plasma (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Condemnor boltgun", bv.getPts("Condemnor boltgun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", bv.getPts("Storm bolter (AMI)")));
        return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getSpecialWeapons(BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", bv.getPts("Storm bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", bv.getPts("Flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", bv.getPts("Meltagun (AMI)")));
        return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getPistols(BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", bv.getPts("Bolt pistol (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", bv.getPts("Plasma pistol (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Inferno Pistol", bv.getPts("Inferno Pistol (AMI)")));
        return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getMeleeWeapons(BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", bv.getPts("Chainsword (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", bv.getPts("Power maul (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", bv.getPts("Power sword (AMI)")));
        return ogE;
    }
    
    static public Vector<OptionsGruppeEintrag> getHeavyWeapons(BuildaVater bv) {
        Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", bv.getPts("Heavy bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", bv.getPts("Heavy flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", bv.getPts("Multi-melta (AMI)")));
        return ogE;
    }
    
    public IMAdeptaSororitasRuestkammer() {
        grundkosten = 0;
    }
    
    public void addRelics() {
    	if(keywords.contains(CHARACTER)) {
	    	for(int i = 0; i < ogE.size(); i++) {
	    		if(ogE.get(i).getName().equals("Bolt pistol")){
	        		ogE.addElement(new OptionsGruppeEintrag("Wrath of the Emperor", getPts("Bolt pistol (AMI)")).setRelic(true));
	    		} else if(ogE.get(i).getName().equals("Power sword")){
	        		ogE.addElement(new OptionsGruppeEintrag("Blade of Admonition", getPts("Power sword (AMI)")).setRelic(true));
	    		}
	    	}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        psyker = keywords.contains(PSYKER);
        character = keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;
        
        if(character) {
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Book of St. Lucius", 0).setRelic(true));
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brazier of EternaL Flame", 0).setRelic(true));
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Litanies of Faith", 0).setRelic(true));
       	
	       	if(keywords.contains(CANONESS)) {
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mantle of Ophelia", 0).setRelic(true));
	       	}

	       	offsetX += buttonBreite + 15;
	       	oe1Offset = cnt;
	       	seperator();
        }

        if (type.equals("Canoness")) {
        	ogE.addAll(getPistols(buildaVater));
            ogE.addAll(getRangedWeapons(buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addAll(getMeleeWeapons(buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if(type.equals("Sister Superior")){
        	ogE.addAll(getPistols(buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();
            
        	ogE.addAll(getRangedWeapons(buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Boltgun", true);
            
            seperator();
            
            ogE.addAll(getMeleeWeapons(buildaVater));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
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
    public void refreshen() {

        if (type.equals("X")) {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type.equals("Canoness")) {
            o1.alwaysSelected();
        } else if(type.equals("Sister Superior")){
        	o1.alwaysSelected();
        	
        	if(o3.isSelected()){
        		o2.deactivateOthers("Boltgun");
        		o2.setSelected("Boltgun", true);
        	} else {
        		o2.setAktiv(true);
        	}
        }

        if(character){
        	if(o1 != null) {
        		o1.setAktiv("Wrath of the Emperor", (chosenRelic == null || o1.isSelected("Wrath of the Emperor")));
        		o1.setAktiv("Blade of Admonition", (chosenRelic == null || o1.isSelected("Blade of Admonition")));
        	}
        	
        	if(o2 != null) {
        		o2.setAktiv("Wrath of the Emperor", (chosenRelic == null || o2.isSelected("Wrath of the Emperor")));
        		o2.setAktiv("Blade of Admonition", (chosenRelic == null || o2.isSelected("Blade of Admonition")));
        	}

        }
    }
}
