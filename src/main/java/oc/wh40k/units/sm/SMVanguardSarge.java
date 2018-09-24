package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class SMVanguardSarge extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade armour;
    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
   
    
	public SMVanguardSarge() {
		grundkosten = 0;
		name="Veteranen-Sergeant";
	}
	
	@Override
	public void initButtons(boolean... defaults) {
		
    	ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		fkwaffen.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		handwaffen.setSelected(0, true);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
			
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Melterbombe"), 5));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int selected = 0;
		
		selected = (handwaffen.getAnzahl()+fkwaffen.getAnzahl()+o2.getAnzahl());
		handwaffen.setMaxAnzahl((selected<2 || handwaffen.isSelected())?1:0);
		fkwaffen.setMaxAnzahl((selected<2 || fkwaffen.isSelected())?1:0);
		o2.setMaxAnzahl(2-selected+o2.getAnzahl());
			
		legal = selected == 2;
		o2.setLegal(legal);
		
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
	    boolean entrySwitched=false;
	    	
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
}