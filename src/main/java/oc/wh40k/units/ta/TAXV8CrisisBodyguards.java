package oc.wh40k.units.ta;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TAXV8CrisisBodyguards extends Eintrag {

	private static final Logger LOGGER = LoggerFactory.getLogger(TAXV8CrisisBodyguards.class);

	RuestkammerStarter ob2;
	Vector<RuestkammerStarter> rk;
//	OptionsEinzelUpgrade o5;
	OptionsZaehlerGruppe o4;
	boolean warscaper = false;

	public TAXV8CrisisBodyguards() {
		name = "XV8 Crisis Bodyguards";
		überschriftSetzen = true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
		rk=new Vector<RuestkammerStarter>();
		for(int i=0;i<9;i++){
			rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Crisis Bodyguard"));
			rk.lastElement().initKammer(false, false, false, false, false, true, false);
			rk.lastElement().setGrundkosten(getPts("XV8 Crisis Bodyguards"));
			add(rk.lastElement());
		}
		

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
//		seperator();
//
//		add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Ritual des Klingenbundes", "Klingenbund", 1));
				
		addToInformationVector("Bodyguards", 1);
		
        complete();
	}

    @Override
	public void refreshen() {
    	int krisisNumber = 0;
    	for(int i=0;i<9;i++){
    		LOGGER.info(i);
    		krisisNumber+=(rk.get(i).isSelected() && rk.get(i).isAktiv() ? 1 : 0);
    	}
    			
//        o5.setPreis(krisisNumber); 
        
        o4.setMaxAnzahl(krisisNumber*2);
		
//        if(getCountFromInformationVector("Farsight Enclave")>0){
//			o5.setSelected(true);
//		}
        
		o4.getPanel().setLocation(
				(int) o4.getPanel().getLocation().getX(),
				(int) rk.get(8).getPanel().getLocation().getY() + rk.get(8).getPanel().getSize().height + 5
	    );
		
		
//		o5.getPanel().setLocation(
//				(int) o5.getPanel().getLocation().getX(),
//				(int) o4.getPanel().getLocation().getY() + o4.getPanel().getSize().height + 5
//	    );
		
		
		boolean error = false;
		for(int i=0;i<9;i++){
			((TAKampfanzugKammer)rk.get(i).getKammer()).farsight=getCountFromInformationVector("Farsight Enclave")>0;
			if(!rk.get(i).isSelected()){
				((TAKampfanzugKammer)rk.get(i).getKammer()).clearEntries();
			}
			if(((TAKampfanzugKammer)rk.get(i).getKammer()).uniqueError){
				error=true;
			}
    	}
				
		if(getCountFromInformationVector("Contingent Headquarters")>0 && getCountFromInformationVector("Bodyguards")>2){
        	setFehlermeldung("1-2 Bodyguards");  	
        }else if(error){
			setFehlermeldung("Ausrüstung doppelt!");
		}else if(getCountFromInformationVector("FEWarscaper")>1){
			setFehlermeldung("Warscaper doppelt!");
		}else{
			setFehlermeldung("");
		}
		
		
	}
    
    @Override
    public void deleteYourself() {
		addToInformationVector("Bodyguards", -1);
        super.deleteYourself();
    }
}
