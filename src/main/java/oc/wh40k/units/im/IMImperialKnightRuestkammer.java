package oc.wh40k.units.im;

import static oc.KeyWord.*;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class IMImperialKnightRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
    private String default1 = "";
    private String default2 = "";
    boolean character = false;
    private OptionsEinzelUpgrade sanctuary;
    private OptionsEinzelUpgrade armourOfTheSaintedIon;
    private OptionsEinzelUpgrade helmOfTheNamelessWarrior;
    private OptionsEinzelUpgrade bannerOfMachariusTriumphant;
    private OptionsEinzelUpgrade markOfTheOmnissiah;
    private OptionsEinzelUpgrade theHelmDominatus;
    private OptionsEinzelUpgrade markOfTheLance;
    private OptionsEinzelUpgrade angelsGrace;
    private OptionsEinzelUpgrade theHuntersEye;
    private OptionsEinzelUpgrade theBannerInviolate;
    private OptionsEinzelUpgrade theHeadsmansMark;
    private OptionsEinzelUpgrade theAuricMask;
    
    Set<String> CHARACTERS = ImmutableSet.of("Armiger Helverin", "Armiger Warglaive", "Knight Preceptor", "Knight Paladin", "Knight Errant", "Knight Gallant", "Knight Warden", "Knight Crusader", "Canis Rex", "Knight Castellan", "Knight Valiant");

    public IMImperialKnightRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Reaper chainsword")){
    			ogE.addElement(new OptionsGruppeEintrag("Ravager", getPts("Reaper chainsword")).setRelic(true));
    			if(BuildaHQ.aktBuildaVater.getFormationType().equals("Mortan"))
    				ogE.addElement(new OptionsGruppeEintrag("Honour's Bite", getPts("Reaper chainsword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Thunderstrike gauntlet")){
    			ogE.addElement(new OptionsGruppeEintrag("The Paragon Gauntlet", getPts("Thunderstrike gauntlet")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Avenger gatling cannon")){
    			ogE.addElement(new OptionsGruppeEintrag("Endless fury", getPts("Avenger gatling cannon")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Stormspear rocket pod")){
    			ogE.addElement(new OptionsGruppeEintrag("Judgement", getPts("Stormspear rocket pod")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Twin icarus autocannon")){
    			ogE.addElement(new OptionsGruppeEintrag("Skyshield", getPts("Twin icarus autocannon")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Conflagration cannon")){
    			ogE.addElement(new OptionsGruppeEintrag("Traitor's Pyre", getPts("Conflagration cannon")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Plasma decimator")){
    			ogE.addElement(new OptionsGruppeEintrag("Cawl's wrath", getPts("Plasma decimator")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Rapid-fire battle cannon")){
    			if(BuildaHQ.aktBuildaVater.getFormationType().equals("Terryn"))
    				ogE.addElement(new OptionsGruppeEintrag("Thunder of voltoris", getPts("Rapid-fire battle cannon")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Thermal cannon")){
    			if(BuildaHQ.aktBuildaVater.getFormationType().equals("Taranis"))
    				ogE.addElement(new OptionsGruppeEintrag("Fury of Mars", getPts("Thermal cannon")).setRelic(true));
    		}
    	}
    }
    
    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;
                
       	add(sanctuary = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sanctuary", 0).setRelic(true));
       	add(armourOfTheSaintedIon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour of the Sainted Ion", 0).setRelic(true));
       	add(helmOfTheNamelessWarrior = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of the Nameless Warrior", 0).setRelic(true));
       	add(bannerOfMachariusTriumphant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Banner of Macharius Triumphant", 0).setRelic(true));
       	add(markOfTheOmnissiah = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mark of the Omnissiah", 0).setRelic(true));
    	add(theHelmDominatus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Helm Dominatus", 0).setRelic(true));
    	add(markOfTheLance = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mark of the Lance", 0).setRelic(true));
    	add(angelsGrace = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Angel's Grace", 0).setRelic(true));
    	add(theHuntersEye = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Hunter's Eye", 0).setRelic(true));
    	add(theBannerInviolate = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Banner Inviolate", 0).setRelic(true));
    	add(theHeadsmansMark = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Headman's Mark", 0).setRelic(true));
    	add(theAuricMask = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Auric Mask", 0).setRelic(true));
    	
       	offsetX += buttonBreite + 15;
       	oe1Offset = cnt;
       	seperator();


    	if(type.equals("Knight Gallant")) {
            ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper Chainsword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            
            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike Gauntlet")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
            ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
            addRelics();
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if(type.equals("Knight Crusader")) {
            ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon", getPts("Avenger gatling cannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (QI)")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Battle cannon + stubber", "Rapid-fire battle cannon + Heavy stubber", getPts("Rapid-fire battle cannon") + getPts("Heavy stubber (QI)")));
            addRelics();
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
            ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
            addRelics();
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    	} else if(type.equals("Knight Errant")) {
	        ogE.addElement(new OptionsGruppeEintrag("Thermal cannon", getPts("Thermal cannon")));
            addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
	        seperator();
	
	        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
            addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
	        seperator();
	
	        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike Gauntlet")));
            addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
	        seperator();
	
	        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
	        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
            addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
	        seperator();
	    } else if(type.equals("Knight Paladin")) {
	        ogE.addElement(new OptionsGruppeEintrag("Rapid-fire battle cannon", getPts("Rapid-fire battle cannon")));
            addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
            addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Reaper Chainsword", getPts("Reaper Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike Gauntlet", getPts("Thunderstrike Gauntlet")));
            addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
	        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
            addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	    } else if(type.equals("Knight Preceptor")) {
	        ogE.addElement(new OptionsGruppeEintrag("Las-impulsor", getPts("Las-impulsor")));
            addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
            addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike Gauntlet")));
            addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
	        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
	        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser (QI)")));
            addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	    } else if(type.equals("Knight Valiant")) {
	        ogE.addElement(new OptionsGruppeEintrag("Thundercoil harpoon", getPts("Thundercoil harpoon")));
	        addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Conflagration cannon", getPts("Conflagration cannon")));
	        addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
	        addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Two twin meltaguns", getPts("Twin meltaguns") * 2));
	        addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
	        addRelics();
	        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
	        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
	        addRelics();
	        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();
	    } else if(type.equals("Knight Warden")) {
	        ogE.addElement(new OptionsGruppeEintrag("Avenger gatling cannon", getPts("Avenger gatling cannon")));
	        addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE = IMQuestorImperialisCarapaceWeapons.createRK("", "", buildaVater);
	        addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Reaper chainsword", getPts("Reaper Chainsword")));
	        ogE.addElement(new OptionsGruppeEintrag("Thunderstrike gauntlet", getPts("Thunderstrike Gauntlet")));
	        addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber (QI)")));
	        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun (QI)")));
	        addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	    } else if(type.equals("Knight Castellan")) {
	        ogE.addElement(new OptionsGruppeEintrag("Plasma decimator", getPts("Plasma decimator")));
	        addRelics();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Volcano lance", getPts("Volcano lance")));
	        addRelics();
	        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
	        addRelics();
	        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Two twin meltaguns", getPts("Twin meltaguns") * 2));
	        addRelics();
	        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
	        addRelics();
	        add(o5= new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
	        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
	        addRelics();
	        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
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
    	
    	if(type.equals("Knight Gallant") || type.equals("Knight Errant") || type.equals("Knight Paladin") || type.equals("Knight Preceptor") || type.equals("Knight Warden")){
    		o1.alwaysSelected();
    		o3.alwaysSelected();
    		o4.alwaysSelected();
    	} else if(type.equals("Knight Crusader")){
    		o1.alwaysSelected();
    		o3.alwaysSelected();
    		o4.alwaysSelected();
    		o5.alwaysSelected();
    	} else if(type.equals("Knight Valiant") || type.equals("Knight Castellan")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		o3.alwaysSelected();
    		o4.alwaysSelected();
    		o5.alwaysSelected();
    		o6.alwaysSelected();
    	}

        sanctuary.setAktiv((chosenRelic == null || sanctuary.isSelected()));   
        armourOfTheSaintedIon.setAktiv((chosenRelic == null || armourOfTheSaintedIon.isSelected()));
        helmOfTheNamelessWarrior.setAktiv((chosenRelic == null || helmOfTheNamelessWarrior.isSelected()));
        bannerOfMachariusTriumphant.setAktiv((chosenRelic == null || bannerOfMachariusTriumphant.isSelected()));
        markOfTheOmnissiah.setAktiv((chosenRelic == null || markOfTheOmnissiah.isSelected()));
        theHelmDominatus.setAktiv((chosenRelic == null || theHelmDominatus.isSelected()));
        
        markOfTheLance.setAktiv((chosenRelic == null || markOfTheLance.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Griffith"));
        angelsGrace.setAktiv((chosenRelic == null || angelsGrace.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Hawkshroud"));
        theHuntersEye.setAktiv((chosenRelic == null || theHuntersEye.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Cadmus"));
        theBannerInviolate.setAktiv((chosenRelic == null || theBannerInviolate.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Raven"));
        theHeadsmansMark.setAktiv((chosenRelic == null || theHeadsmansMark.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Krast"));
        theAuricMask.setAktiv((chosenRelic == null || theAuricMask.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Vulker"));
    }

}
