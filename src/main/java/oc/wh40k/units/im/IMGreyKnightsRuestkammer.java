package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;

public class IMGreyKnightsRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private OptionsEinzelUpgrade bannerOfRefiningFlame;
    private OptionsEinzelUpgrade dominaLiberDaemonica;
    private OptionsEinzelUpgrade cuirassOfSacrifice;
    
    public IMGreyKnightsRuestkammer() {
        grundkosten = 0;
    }

    public void setType(String s) {
        type = s;
    }

    public void addRelics() {

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Storm bolter")){
    			ogE.addElement(new OptionsGruppeEintrag("Fury of Deimos", getPts("Storm bolter")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Nemesis daemon hammer")){
    			ogE.addElement(new OptionsGruppeEintrag("Destroyer of Crys'yllix", getPts("Nemesis Daemon hammer")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Nemesis force halberd")){
    			ogE.addElement(new OptionsGruppeEintrag("Soul Glaive", getPts("Nemesis force halberd")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
                
       	add(bannerOfRefiningFlame = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Banner of Refining Flame", 0).setRelic(true));
       	add(dominaLiberDaemonica = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Domina Liber Daemonica", 0).setRelic(true));
       	add(cuirassOfSacrifice = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cuirass of Sacrifice", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Grand Master")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
            ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
            ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
            ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if(type.equals("Grand Master in Nemesis Dreadknight")) {
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis Daemon greathammer", getPts("Nemesis Daemon greathammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis greatsword", getPts("Nemesis greatsword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Heavy incinerator", getPts("Heavy incinerator")));
            ogE.addElement(new OptionsGruppeEintrag("Gatling psilencer", getPts("Gatling psilencer")));
            ogE.addElement(new OptionsGruppeEintrag("Heavy psycannon", getPts("Heavy psycannon")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
    	} else if(type.equals("Brother Captain")){
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
            ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
            ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
            ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if (type.equals("Librarian GK")) {
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
        } else if (type.equals("Techmarine GK")) {
        	
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servo-arms", getPts("Servo-arm")*2));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Plasma cutter", getPts("Plasma cutter")));
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        } else if (type.equals("Chaplain GK")) {
            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type.equals("Brotherhood Champion")) {
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type.equals("Apothecary")) {
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis falchion", getPts("Nemesis falchion")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
        } else if (type.equals("Brotherhood Ancient")){
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis falchion", getPts("Nemesis falchion")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
        } else if (type.equals("Paladin Ancient")){
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
            ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
            ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis falchion", getPts("Nemesis falchion")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
    	
    	if(type.equals("Grand Master") ||
    			type.equals("Grand Master in Nemesis Dreadknight") ||
    			type.equals("Brother Captain") ||
    			type.equals("Chaplain GK") ||
    			type.equals("Brotherhood Champion")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if (type.equals("Librarian GK") ||
    			type.equals("Apothecary") ||
    			type.equals("Brotherhood Ancient") ||
    			type.equals("Paladin Ancient")){
    		o1.alwaysSelected();
    	}
    	if (type.equals("Techmarine GK")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		o3.alwaysSelected();
    		o4.alwaysSelected();
    	}

    	bannerOfRefiningFlame.setAktiv((chosenRelic == null || bannerOfRefiningFlame.isSelected()) && (keywords.contains(PALADIN_ANCIENT) || keywords.contains(BROTHERHOOD_ANCIENT)));   
    	dominaLiberDaemonica.setAktiv(((chosenRelic == null || dominaLiberDaemonica.isSelected())));
    	cuirassOfSacrifice.setAktiv(((chosenRelic == null || cuirassOfSacrifice.isSelected()) && keywords.contains(INFANTRY)));
    }

}
