package oc.wh40k.units.ia;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class IASergeant extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade armour;
    OptionsUpgradeGruppe handwaffen = null;
    OptionsUpgradeGruppe fkwaffen = null;
    OptionsEinzelUpgrade am;
    boolean amBool=false;
	boolean uniqueError=false;
    
    boolean isTac = false; 
	boolean isScout = false;    
	boolean isKreuz = false;   
	boolean isLegion = false; 
	boolean isBike = false;
	boolean isScoutBike = false;   
	boolean isDevastor = false; 
	boolean LotDDetachment = false;
    
	public IASergeant() {
		grundkosten = 0;
		name="Sergeant";
	}
	
	@Override
	public void initButtons(boolean... defaults) {
		
		isTac = defaults[0]; 
		isScout = defaults[1];
		isKreuz = defaults[2];
		isLegion = defaults[3];  
		isBike = defaults[4]; 
		isScoutBike = defaults[5];  
		isDevastor = defaults[6];     
		
		if(isTac || isScout || isBike || isScoutBike || isDevastor){
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Veteranensergeant"), 10));
		}
		
		seperator();
		
    	ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
    	if(isTac || isBike){
    		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
    	}
		add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		fkwaffen.setSelected(0, true);
		
		seperator();
		if(!isBike && !isScoutBike){
			ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		
			if(isTac || isKreuz || isDevastor){
				ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
			}else if(isScout){
				ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
				ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", 0));
				ogE.addElement(new OptionsGruppeEintrag("Scharfschützengew.", "Scharfschützengewehr", 1));
				ogE.addElement(new OptionsGruppeEintrag("[WZK] Nihilus", "Nihilus (WZ Kauyon - Sons of Corax)", 15));
			}else if(isLegion){
				ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
				ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
				ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
				ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
				ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
				ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
				ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
			}
			add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			handwaffen.setSelected(0, true);
		}
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
		if(isTac || isScout || isKreuz || isBike || isScoutBike || isDevastor){
			ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
			ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
			ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		}
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		if(!isLegion) {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Melterbomben"), 5));
		}
		
		if(isScoutBike){
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Peilsender "), 10));
		}
		if(isTac || isScout){
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Teleportpeilsender "), 5));
		}
		
		if(isLegion) {
			add(am = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Animus Malorum"), 35));
		}
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		if(isTac || isKreuz || isScout || isLegion || isDevastor){
			o2.setMaxAnzahl(2 - (fkwaffen.isSelected()?1:0)-(handwaffen.isSelected()?1:0));
			handwaffen.setMaxAnzahl((o2.getAnzahl()==2 || (o2.getAnzahl()==1 && fkwaffen.isSelected()))?0:1);
			fkwaffen.setMaxAnzahl((o2.getAnzahl()==2 || (o2.getAnzahl()==1 && handwaffen.isSelected()))?0:1);
			
				
			legal = (o2.getAnzahl() + (fkwaffen.isSelected()?1:0) + (handwaffen.isSelected()?1:0))==2;
			o2.setLegal(legal);
			fkwaffen.setLegal(legal);
			handwaffen.setLegal(legal);
		}else{
			fkwaffen.setMaxAnzahl(o2.isSelected()?0:1);
			o2.setMaxAnzahl(fkwaffen.isSelected()?0:1);
				
			legal = o2.isSelected() || fkwaffen.isSelected();
			o2.setLegal(legal);
		}
		
		if(isLegion){
		}
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	public void setKosten(int kosten) {
		grundkosten=kosten;		
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
	
	public void deleteYourself() {
		
		super.deleteYourself();
	}
	
}
