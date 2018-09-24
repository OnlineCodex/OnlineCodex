package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class CSTerminatorwaffen extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade schriftrollen, handwaffe, kombibolter;
    OptionsEinzelUpgrade blade;
    OptionsEinzelUpgrade crozius;
    OptionsEinzelUpgrade horns;
    OptionsEinzelUpgrade balestar;
    OptionsEinzelUpgrade daemonheart;
    OptionsEinzelUpgrade prophet;
    boolean bladeBool=false;
    boolean croziusBool=false;
    boolean hornsBool=false;
    boolean balestarBool=false;
    boolean daemonheartBool=false;
    boolean prophetBool=false;
    boolean uniqueError=false;
    
	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;
	
	boolean isChaosgeneral = false; //Handwaffe, Kombibolter 
	boolean isHexer = false;        //Psiwaffe, Kombibolter

	public CSTerminatorwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[1]; 
			isHexer = defaults[2];            
		} catch(Exception e) {}
		
		if(defaults[0]){
			//Termichamp
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Geschenk der Mutation", 10));
		}
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombibolter"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 17));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 22));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 27));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setAnzahl(0, 1);
		
		seperator();
		
		if(isHexer) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiwaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psischwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psistab"), 0));
		} else{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 0));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 0));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAnzahl(0, 1);
		sizeSetzen();
		
		seperator();
		
		if(isChaosgeneral || isHexer){
			
			add(blade = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Blade of the Relentless"), 30));
			blade.setAktiv(false);
			add(crozius = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Crozius of the Dark Covenant"), 30));
			crozius.setAktiv(false);
			add(horns = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("The Slaughterers Horns"), 15));
			add(balestar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("The Balestar of Mannon"), 25));
			balestar.setAktiv(false);
			add(daemonheart = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Daemonheart"), 30));
			add(prophet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Prophet of Voices"), 30));
		}
		setUeberschrift("Termiwaffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {		
		if(isChaosgeneral){
			blade.setAktiv(true);
		}
		
		if(isHexer){
			balestar.setAktiv(true);
		}
		
		int auswahlen=o1.getAnzahl()+o2.getAnzahl();
		
		o1.setLegal(auswahlen>=2);
		o2.setLegal(auswahlen>=2);
		
		if(isChaosgeneral || isHexer){
		//Einzigartige Gegenstände
				if(crozius.isSelected()){
					if(croziusBool==false){
						croziusBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSCrozius", 1);
					}
				} else if(!crozius.isSelected()) {
					if(croziusBool==true){
						croziusBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSCrozius", -1);
					}
				}
				
				if(blade.isSelected()){
					if(bladeBool==false){
						bladeBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSBlade", 1);
					}
				} else if(!blade.isSelected()) {
					if(bladeBool==true){
						bladeBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSBlade", -1);
					}
				}
				
				if(horns.isSelected()){
					if(hornsBool==false){
						hornsBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSHorns", 1);
					}
				} else if(!horns.isSelected()) {
					if(hornsBool==true){
						hornsBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSHorns", -1);
					}
				}
				
				if(balestar.isSelected()){
					if(balestarBool==false){
						balestarBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSBalestar", 1);
					}
				} else if(!balestar.isSelected()) {
					if(balestarBool==true){
						balestarBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSBalestar", -1);
					}
				}
				
				if(daemonheart.isSelected()){
					if(daemonheartBool==false){
						daemonheartBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", 1);
					}
				} else if(!daemonheart.isSelected()) {
					if(daemonheartBool==true){
						daemonheartBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", -1);
					}
				}
				
				if(prophet.isSelected()){
					if(prophetBool==false){
						prophetBool=true;
						BuildaHQ.addToInformationVectorGlobal("CSProphet", 1);
					}
				} else if(!prophet.isSelected()) {
					if(prophetBool==true){
						prophetBool=false;
						BuildaHQ.addToInformationVectorGlobal("CSProphet", -1);
					}
				}
				
				if(BuildaHQ.getCountFromInformationVectorGlobal("CSCrozius")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("CSBlade")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("CSHorns")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("CSBalestar")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("CSDaemonheart")>1 ||
						BuildaHQ.getCountFromInformationVectorGlobal("CSProphet")>1){
						uniqueError=true;
				}else{
					uniqueError=false;
				}
		}
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
	
	@Override
	public void deleteYourself() {
		
		if(bladeBool==true){
			bladeBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSBlade", -1);
		}
					
		if(croziusBool==true){
			croziusBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSCrozius", -1);
		}
					
		if(hornsBool==true){
			hornsBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSHorns", -1);
		}
					
		if(balestarBool==true){
			balestarBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSBalestar", -1);
		}
						
		if(daemonheartBool==true){
			daemonheartBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSDaemonheart", -1);
		}
				
		if(prophetBool==true){
			prophetBool=false;
			BuildaHQ.addToInformationVectorGlobal("CSProphet", -1);
		}
				
		super.deleteYourself();
	}

}
