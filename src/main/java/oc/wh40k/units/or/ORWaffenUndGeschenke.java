package oc.wh40k.units.or;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORWaffenUndGeschenke extends RuestkammerVater {

    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    
    public boolean uniqueError=false;

	boolean melee = false; 
	boolean range = false; 
	boolean souped = false; 
	boolean bigmek = false; 
	boolean meleeForRange = false;
	boolean meleeForSouped = false;
	boolean killsawFK = false;
	boolean killsawNK = false;
	
	String defaultNK = "";
	String defaultFK = "";
	
	public boolean megaruestung = false;
	
    //BP/NK gg RNG/NK
    
	public ORWaffenUndGeschenke() {
		grundkosten = 0;
	}
	
	public void setDefaultNK(String s){
		defaultNK = s;
	}
	
	public void setDefaultFK(String s){
		defaultFK = s;
	}
	
	public void setKillsawFK(boolean b){
		killsawFK = b;
	}
	
	public void setKillsawNK(boolean b){
		killsawNK = b;
	}
	
	@Override
	public void initButtons(boolean... defaults) {
		try {
			melee = defaults[0]; 
			range = defaults[1];        
			souped = defaults[2];       
			bigmek = defaults[3]; 
			meleeForRange = defaults[4];
			meleeForSouped = defaults[5];
		} catch(Exception e) {}
		
		if(!defaultFK.equals("no weapon")) {
		    if(defaultFK.equals("")){
		    	ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
		    } else {
		    	ogE.addElement(new OptionsGruppeEintrag(defaultFK, getPts(defaultFK)));
		    }
		}
	    if(souped) {
	    	ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta",getPts("Kustom mega-blasta"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha",getPts("Rokkit launcha"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
	        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-slugga",getPts("Kustom mega-slugga")));  
	    }
	    if(range) {
	    	ogE.addElement(new OptionsGruppeEintrag("Shoota", getPts("Shoota")));
	    	if(defaultFK != "Kustom shoota"){
	    		ogE.addElement(new OptionsGruppeEintrag("Kustom shoota", getPts("Kustom shoota")));
	    	}
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
	    } 
	    if(meleeForRange) {
	    	ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
	    	ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
	    } 
	    if(bigmek){
			ogE.addElement(new OptionsGruppeEintrag("Kustom force field", getPts("Kustom force field"))); 
			ogE.addElement(new OptionsGruppeEintrag("Shokk attack gun", getPts("Shokk attack gun"))); 
	    }
		if(killsawFK){
			ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
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
				ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
			} else {
				ogE.addElement(new OptionsGruppeEintrag(defaultNK, getPts(defaultNK)));
			}
		}
		if(meleeForSouped) {
	    	ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta",getPts("Kustom mega-blasta"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha",getPts("Rokkit launcha"))); 
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
	        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-slugga",getPts("Kustom mega-slugga")));  
	    }
		if(melee) {
	        ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
	    	if(defaultNK != "Big choppa"){
	    		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
	    	}
	    }
		if(killsawNK){
			ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
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
		
		System.out.print("");
	}
	
}
