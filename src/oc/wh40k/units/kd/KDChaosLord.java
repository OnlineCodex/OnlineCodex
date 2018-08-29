package oc.wh40k.units.kd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class KDChaosLord extends Eintrag {

    OptionsEinzelUpgrade termi;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter spezialAusruestung;

	boolean khorneBool =false;
	boolean nurgleBool =false;
	boolean slaneshBool =false;
	
	boolean isBlackLegion = false;
	boolean isCrimsonSlaughter = false;
    
	public KDChaosLord() {
		name = "Chaos Lord";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));

		seperator();
        
        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 40));
		
        seperator();
        
		termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "KDTerminatorwaffen", "");
		termiWaffen.initKammer(true);
		termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Artefakte"));
		add(termiWaffen);
        
		seperator();

		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "KDWaffenUndArtefakte", ""); 
		waffenUndArtefakte.initKammer(true, termi.isSelected(), false, false, false);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
		
		seperator();
		
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "KDChaosbelohnungen", "");
		chaosBelohnungen.initKammer(true, termi.isSelected(), false, false, false);
		chaosBelohnungen.setButtonText("Gaben des Chaos");
		add(chaosBelohnungen);
		
		seperator();
		
		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "KDSpezialausruestung", "");
		spezialAusruestung.initKammer(termi.isSelected(), false);
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
		add(spezialAusruestung);
		
		seperator(5);
		
		complete();
	}
	
	@Override
	public void refreshen() {				       
        spezialAusruestung.getKammer().switchEntry("Sprungmodul", !termi.isSelected());
        spezialAusruestung.getKammer().switchEntry("Chaosbike", !termi.isSelected());
        
        chaosBelohnungen.getKammer().switchEntry("Moloch des Khorne", !termi.isSelected());
        
        if(termi.isSelected()) {
        	waffenUndArtefakte.setAktiv(false);
        	termiWaffen.setAbwaehlbar(false);
        	termiWaffen.setAktiv(true);
        } else {
        	waffenUndArtefakte.setAktiv(true);
        	termiWaffen.setAbwaehlbar(false);
        	termiWaffen.setAktiv(false);
        }
        		
		((KDChaosbelohnungen)chaosBelohnungen.getKammer()).bikeGesetzt=(((KDSpezialausruestung)spezialAusruestung.getKammer()).o2.isSelected() && spezialAusruestung.isSelected());
		((KDSpezialausruestung)spezialAusruestung.getKammer()).reittierGesetzt=(((KDChaosbelohnungen)chaosBelohnungen.getKammer()).o2.isSelected()&& chaosBelohnungen.isSelected());
		if(((KDWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError || ((KDTerminatorwaffen)termiWaffen.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
		
		waffenUndArtefakte.getPanel().setLocation(
				(int) waffenUndArtefakte.getPanel().getLocation().getX(),
				(int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
	    );
		
		chaosBelohnungen.getPanel().setLocation(
				(int) chaosBelohnungen.getPanel().getLocation().getX(),
				(int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
	    );
		
		spezialAusruestung.getPanel().setLocation(
				(int) spezialAusruestung.getPanel().getLocation().getX(),
				(int) chaosBelohnungen.getPanel().getLocation().getY() + chaosBelohnungen.getPanel().getSize().height + 5
	    );
    }
	
	@Override
	public void deleteYourself() {
		
		if(khorneBool==true){
			khorneBool=false;
			if(!ally){
				addToInformationVector("KDKhorneTroops", -1);
				if(getCountFromInformationVector("KDKhorneTroops")<1){
					buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
					buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
				}
			}
		}
		
		if(slaneshBool==true){
			slaneshBool=false;
			if(!ally){
				addToInformationVector("KDSlaanesTroops", -1);
				if(getCountFromInformationVector("KDSlaanesTroops")<1){
					buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
					buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
				}
			}
		}
		
		if(nurgleBool==true){
			nurgleBool=false;
			if(!ally){
				addToInformationVector("KDNurgleTroops", -1);
				if(getCountFromInformationVector("KDNurgleTroops")<1){
					buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
					buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
				}
			}
		}
		super.deleteYourself();
	}

}
