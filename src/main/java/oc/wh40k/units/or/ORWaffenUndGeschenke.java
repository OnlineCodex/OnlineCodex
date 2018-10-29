package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
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
	boolean character = false;
	boolean psyker = false;
	
	String defaultNK = "";
	String defaultFK = "";
	
	public boolean megaruestung = false;
	
	OptionsEinzelUpgrade daLuckyStikk;
	OptionsEinzelUpgrade morgogsFinkinCap;
	OptionsEinzelUpgrade rezmekkasRedderArmour;
	OptionsEinzelUpgrade daFixxerUpperz;
	OptionsEinzelUpgrade broggsBuzzbom;
	OptionsEinzelUpgrade daBadskullBanner;
	OptionsEinzelUpgrade gitstoppaShells;
	
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
			character = defaults[6];
			psyker = defaults[7];
		} catch(Exception e) {}
		
		if(character) {
	        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Super Cyborg Body", 0).setRelic(true));
	        add(daLuckyStikk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Lucky Stikk", 0).setRelic(true));
	        add(morgogsFinkinCap = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Morgogs Finkin Cap", 0).setRelic(true));
	        add(rezmekkasRedderArmour = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rezmekkas Redder Armour", 0).setRelic(true));
	        add(daFixxerUpperz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Fixxer Upperz", 0).setRelic(true));
	        add(broggsBuzzbom = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Broggs Buzzbom", 0).setRelic(true));
	        add(daBadskullBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Da Badskull Banner", 0).setRelic(true));
	        if(psyker){
		        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scorched Gitbonez", 0).setRelic(true));
	        }
	        add(gitstoppaShells = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gitstoppa Shells", 0).setRelic(true));
	        seperator();
		}
		
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
	        if(character){
	        	ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kustom shoota")).setRelic(true)); //TODO Kosten? allgemein für range abhandeln?
	        }
	    }
	    if(range) {
	    	ogE.addElement(new OptionsGruppeEintrag("Shoota", getPts("Shoota")));
	    	if(defaultFK != "Kustom shoota"){
	    		ogE.addElement(new OptionsGruppeEintrag("Kustom shoota", getPts("Kustom shoota")));
	    	}
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit","Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
	        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
    		ogE.addElement(new OptionsGruppeEintrag("Da Ded Shiny Shoota", getPts("Kustom shoota")).setRelic(true));
	    	if(character){
	    		ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kustom shoota")).setRelic(true));//TODO Kosten? allgemein für range abhandeln?
	    	}
	    } 
	    if(meleeForRange) {
	    	ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
	    	ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
	    	if(character) {
	    		ogE.addElement(new OptionsGruppeEintrag("Headwoppa's Killchoppa", getPts("Big choppa")).setRelic(true)); //TODO Generell am Ende prüfen
	    		ogE.addElement(new OptionsGruppeEintrag("Da Killa Klaw", getPts("Power klaw")).setRelic(true)); //TODO Generell am Ende prüfen
	    	}
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
	        if(character){
	        	ogE.addElement(new OptionsGruppeEintrag("Da Gobshot Thunderbuss", getPts("Kustom shoota")).setRelic(true)); 
	        }
	    }
		if(melee) {
	        ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
	    	if(defaultNK != "Big choppa"){
	    		ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
	    	}
	    	if(character) {
	    		ogE.addElement(new OptionsGruppeEintrag("Headwoppa's Killchoppa", getPts("Big choppa")).setRelic(true)); //TODO Generell am Ende prüfen
	    		ogE.addElement(new OptionsGruppeEintrag("Da Killa Klaw", getPts("Power klaw")).setRelic(true)); //TODO Generell am Ende prüfen
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
		
		if(character){
			daLuckyStikk.setAktiv((chosenRelic == null || daLuckyStikk.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Goff"));
			morgogsFinkinCap.setAktiv((chosenRelic == null || morgogsFinkinCap.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Blood Axe"));
			rezmekkasRedderArmour.setAktiv((chosenRelic == null || rezmekkasRedderArmour.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Evil Sunz"));
			daFixxerUpperz.setAktiv((chosenRelic == null || daFixxerUpperz.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Deathskullz"));
			broggsBuzzbom.setAktiv((chosenRelic == null || broggsBuzzbom.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Snakebites"));
			daBadskullBanner.setAktiv((chosenRelic == null || daBadskullBanner.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Freebooterz"));
			if(fkwaffen != null){
				fkwaffen.setAktiv("Da Gobshot Thunderbuss", (chosenRelic == null || fkwaffen.isSelected("Da Gobshot Thunderbuss")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Bad Moonz"));
			}
			if(handwaffen != null){
				handwaffen.setAktiv("Da Gobshot Thunderbuss", (chosenRelic == null || handwaffen.isSelected("Da Gobshot Thunderbuss")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Bad Moonz"));
			}
			if(handwaffen != null && fkwaffen != null){//TODO auftrennen
				gitstoppaShells.setAktiv((chosenRelic == null || gitstoppaShells.isSelected()) &&
										(fkwaffen.isSelected("Kombi-weapon with rokkit-launcha") || fkwaffen.isSelected("Kombi-weapon with skorcha") || fkwaffen.isSelected("Kustom shoota") ||
										handwaffen.isSelected("Kombi-weapon with rokkit-launcha") || handwaffen.isSelected("Kombi-weapon with skorcha") || handwaffen.isSelected("Kustom shoota")));
			}
		}
	}
	
}
