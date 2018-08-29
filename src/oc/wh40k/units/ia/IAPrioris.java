package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IAPrioris extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade boltpistole = null;
    boolean veteran = false;

	public IAPrioris() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
	    veteran = defaults[0];
	    
		add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
		boltpistole.setSelected(true);
		add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
		bolter.setSelected(true);
		
	    seperator();
	   
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		
		if(veteran)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteranen Prioris", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int nahkampfwaffen = 0;
		int fernkampfwaffen = 0;
		int substractor = 0;
		
		if(bolter.isSelected() && boltpistole.isSelected()) { substractor = 2; }
		else if(bolter.isSelected() || boltpistole.isSelected()) { substractor = 1; }
		else if(!bolter.isSelected() && !boltpistole.isSelected()) { substractor = 0; }
		
		nahkampfwaffen = 2 - substractor - o2.getAnzahl();
		fernkampfwaffen = 2 - substractor - o1.getAnzahl();
			
		if(nahkampfwaffen < 0) nahkampfwaffen = 0;
		if(fernkampfwaffen < 0) fernkampfwaffen = 0;
			
		o1.setMaxAnzahl(nahkampfwaffen);
		o2.setMaxAnzahl(fernkampfwaffen);

		legal = ((boltpistole.isSelected()?1:0) + (bolter.isSelected()?1:0) + o1.getAnzahl() + o2.getAnzahl()) == 2;
		boltpistole.setLegal(legal);
		bolter.setLegal(legal);
		o1.setLegal(legal);
		o2.setLegal(legal);
	}

}
