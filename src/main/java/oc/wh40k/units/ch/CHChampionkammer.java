package oc.wh40k.units.ch;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHChampionkammer extends RuestkammerVater {

    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    
    public boolean uniqueError=false;

	boolean melee = false; 
	boolean range = false;
	boolean rangeForMelee = false; 
	boolean meleeForRange = false;
	
	String defaultNK = "";
	String defaultFK = "";
	
	public boolean terminator = false;
	public boolean sorcerer = false;
	
    //BP/NK gg RNG/NK
    
	public CHChampionkammer() {
		grundkosten = 0;
	}
	
	public void setDefaultNK(String s){
		defaultNK = s;
	}
	
	public void setDefaultFK(String s){
		defaultFK = s;
	}
	
	public void setTerminatorArmour(boolean s){
		terminator = s;
	}
	
	public void setSorcerer(boolean s){
		sorcerer = s;
	}
	
	@Override
	public void initButtons(boolean... defaults) {
		try {
			melee = defaults[0]; 
			range = defaults[1];        
			rangeForMelee = defaults[2];
			meleeForRange = defaults[3];
		} catch(Exception e) {}
		
		if(!defaultFK.equals("no weapon")) {
		    if(defaultFK.equals("")){
		    	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
		    } else {
		    	ogE.addElement(new OptionsGruppeEintrag(defaultFK, getPts(defaultFK)));
		    }
		}
	    if(range) {
	    	if(!terminator)
	    		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
	        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
	        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
	        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
	        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
	    } 
	    if(rangeForMelee) {
    		if(!terminator){
    			ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
    			ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
    		}
    		else
    			ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
	    	ogE.addElement(new OptionsGruppeEintrag("Ligthning claw", getPts("Lightning claw single")));
	    	ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
	    	ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
	    	ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
	    	ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
	    } 
		if(ogE.size() > 0){
		    add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		    if(!defaultFK.equals("no weapon")) {
		    	fkwaffen.setSelected(0, true);
		    }
		}
		
		seperator();
		
		if(!defaultNK.equals("no weapon")) {
			if(defaultNK.equals("")){
				ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
			} else {
				ogE.addElement(new OptionsGruppeEintrag(defaultNK, getPts(defaultNK)));
			}
		}
	    if(meleeForRange) {
	    	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
	    	ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
	    } 
		if(melee) {
			if(!sorcerer)
			{
				if(!terminator)
				{
	    			ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
					ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
				}
	    		else
	    			ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
		    	ogE.addElement(new OptionsGruppeEintrag("Ligthning claw", getPts("Lightning claw single")));
		    	ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
		    	ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
		    	ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
		    	ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
			}
			else
			{
				ogE.addElement(new OptionsGruppeEintrag("Force staff", getPts("Force staff")));
				ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
			}
	    }
		if(ogE.size() > 0) {
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			if(!defaultNK.equals("no weapon")) {
				handwaffen.setSelected(0, true);
			}
		}
		
		seperator();

		setUeberschrift("Waffen");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!defaultFK.equals("no weapon")) {
			fkwaffen.alwaysSelected();
		}
		if(!defaultNK.equals("no weapon")) {
			handwaffen.alwaysSelected();
		}
		
		if(fkwaffen.isSelected("Ligthning claw") && handwaffen.isSelected("Ligthning claw"))
		{
			fkwaffen.setPreis("Ligthning claw", getPts("Lightning claw pair")/2+1);
			handwaffen.setPreis("Ligthning claw", getPts("Lightning claw pair")/2);
		}
		else
		{
			fkwaffen.setPreis("Ligthning claw", getPts("Lightning claw single"));
			handwaffen.setPreis("Ligthning claw", getPts("Lightning claw single"));
		}
		

	}
	
}
