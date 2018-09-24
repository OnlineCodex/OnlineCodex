package oc.wh40k.units.da;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DASergeant extends RuestkammerVater {

    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade kettenschwert = null;
	OptionsZaehlerGruppe o2, o1;
	
	boolean isScout = false;
	boolean isSturmSarge = false;//Bolter Kettenschwert
	boolean isRavenSarge = false;//Bolter
	//Normal Boltpistole + Bolter

	public DASergeant() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isScout = defaults[0];
		isSturmSarge = defaults[1];
		isRavenSarge = defaults[2];
		
		if(isScout){
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Upgrade zum Veteranensergeant-Scoutsergeant", "Veteranensergeant", 10));
		} else {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Upgrade zum Veteranensergeant", "Veteranensergeant", 10));
		}
		
	    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Melterbomben", "Melterbomben", 5));
	    
	    
	    if(isSturmSarge){
	    	add(kettenschwert = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
	    	kettenschwert.setSelected(true);
	    } else if(isRavenSarge){
	    	
	    }else{
		    add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
		    bolter.setSelected(true);
	    }
	    
	    add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
	    boltpistole.setSelected(true);
	    
	    seperator();
	    if(isScout){
	    	ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", "Space-Marine-Schrotflinte", 0));
			ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", "Kampfmesser", 0));
			ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Scharfschützengewehr", 1));
	    }
	    ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int substractor = 0;
		if(isRavenSarge){
			nahkampfwaffen = 1 - o2.getAnzahl() - (boltpistole.isSelected()?1:0);
			fernkampfwaffen = 1 - o1.getAnzahl() - (boltpistole.isSelected()?1:0);
		}else{
			if((isSturmSarge?kettenschwert.isSelected():bolter.isSelected()) && boltpistole.isSelected()) { substractor = 2; }
			else if((isSturmSarge?kettenschwert.isSelected():bolter.isSelected()) || boltpistole.isSelected()) { substractor = 1; }
			else if(!(isSturmSarge?kettenschwert.isSelected():bolter.isSelected()) && !boltpistole.isSelected()) { substractor = 0; }
		
			nahkampfwaffen = 2 - substractor - o2.getAnzahl();
			fernkampfwaffen = 2 - substractor - o1.getAnzahl();
			
		}
		
		if(nahkampfwaffen < 0) nahkampfwaffen = 0;
		if(fernkampfwaffen < 0) fernkampfwaffen = 0;
		
		o1.setMaxAnzahl(nahkampfwaffen);
		o2.setMaxAnzahl(fernkampfwaffen);
				
		if(isRavenSarge){
			legal= (o1.getAnzahl() + o2.getAnzahl() + (boltpistole.isSelected()?1:0)) ==1;
		}else{
			legal = ((boltpistole.isSelected()?1:0) + ((isSturmSarge?kettenschwert.isSelected():bolter.isSelected())?1:0) + o1.getAnzahl() + o2.getAnzahl() )==2;
		}
		boltpistole.setLegal(legal);
		if(!isRavenSarge){
			if(isSturmSarge){
				kettenschwert.setLegal(legal);
			} else {
				bolter.setLegal(legal);
			}
		}
		o1.setLegal(legal);
		o2.setLegal(legal);
		
	}

}
