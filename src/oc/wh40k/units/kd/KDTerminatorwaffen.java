package oc.wh40k.units.kd;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class KDTerminatorwaffen extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3, o4;
    OptionsEinzelUpgrade handwaffe, kombibolter;
    boolean runeBool=false;
    boolean rüstungBool=false;
    boolean helmBool=false;
    boolean goreBool=false;
    boolean schwertBool=false;
    boolean axtBool=false;
    boolean uniqueError=false;
	
	boolean isChaosgeneral = false; //Handwaffe, Kombibolter 

	public KDTerminatorwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
			isChaosgeneral = defaults[0];            
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
		

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieklaue"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiefaust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kettenfaust"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt des Khorne"), 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAnzahl(0, 1);
		sizeSetzen();
		
		seperator();
		

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goredrinker"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert des ewigen Blutvergiesens"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kor'lath, die Axt der Zerstörung"), 60));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bronze Rune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelhelm des Khorne"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutgeschmiedete Rüstung"), 50));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		setUeberschrift("Termiwaffen und Artefakte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {	
		if(isChaosgeneral) {
			if(!o1.isSelected() || !o2.isSelected()){
				o3.setAktiv(true);
			} else {
				o3.setAktiv(false);
			}
		}
		int auswahlen=o1.getAnzahl()+o2.getAnzahl();
		if(o3!=null){
			auswahlen+=o3.getAnzahl();
			o3.setLegal(auswahlen>=2);
		}
		o1.setLegal(auswahlen>=2);
		o2.setLegal(auswahlen>=2);
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("Bronze Rune")){
			if(runeBool==false){
				runeBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDRune", 1);
			}
		} else if(!o1.isSelected("Bronze Rune")) {
			if(runeBool==true){
				runeBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDRune", -1);
			}
		}
		
		if(o1.isSelected("Blutgeschmiedete Rüstung")){
			if(rüstungBool==false){
				rüstungBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDRüstung", 1);
			}
		} else if(!o1.isSelected("Blutgeschmiedete Rüstung")) {
			if(rüstungBool==true){
				rüstungBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDRüstung", -1);
			}
		}
		
		if(o1.isSelected("Schädelhelm des Khorne")){
			if(helmBool==false){
				helmBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDHelm", 1);
			}
		} else if(!o1.isSelected("Schädelhelm des Khorne")) {
			if(helmBool==true){
				helmBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDHelm", -1);
			}
		}
		
		if(o4.isSelected("Goredrinker")){
			if(goreBool==false){
				goreBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDGore", 1);
			}
		} else if(!o4.isSelected("Goredrinker")) {
			if(goreBool==true){
				goreBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDGore", -1);
			}
		}
		
		if(o4.isSelected("Schwert des ewigen Blutvergiesens")){
			if(schwertBool==false){
				schwertBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDSchwert", 1);
			}
		} else if(!o4.isSelected("Schwert des ewigen Blutvergiesens")) {
			if(schwertBool==true){
				schwertBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDSchwert", -1);
			}
		}
		
		if(o4.isSelected("Bloodgeschmiedete Rüstung")){
			if(axtBool==false){
				axtBool=true;
				BuildaHQ.addToInformationVectorGlobal("KDAxt", 1);
			}
		} else if(!o4.isSelected("Bloodgeschmiedete Rüstung")) {
			if(axtBool==true){
				axtBool=false;
				BuildaHQ.addToInformationVectorGlobal("KDAxt", -1);
			}
		}
		
		o1.setAktiv(!o4.isSelected());
		o4.setAktiv(!o1.isSelected());
		
		if(BuildaHQ.getCountFromInformationVectorGlobal("KDRune")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("KDHelm")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("KDRüstung")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("KDGore")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("KDSchwert")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("KDAxt")>1) {
				uniqueError=true;
		}else{
			uniqueError=false;
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
		
		if(runeBool==true){
			runeBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDRune", -1);
		}
					
		if(helmBool==true){
			helmBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDHelm", -1);
		}
					
		if(rüstungBool==true){
			rüstungBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDRüstung", -1);
		}
					
		if(goreBool==true){
			goreBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDGore", -1);
		}
						
		if(schwertBool==true){
			schwertBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDSchwert", -1);
		}
				
		if(axtBool==true){
			axtBool=false;
			BuildaHQ.addToInformationVectorGlobal("KDAxt", -1);
		}
				
		super.deleteYourself();
	}

}
