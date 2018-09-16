package oc.wh40k.units.kd;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class KDDaemonPrince extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter chaosBelohnungen;
	RuestkammerStarter waffenUndArtefakte;

	boolean isBlackLegion = false;
	boolean isCrimsonSlaughter = false;
	
	public KDDaemonPrince() {
		name = "Daemon Prince";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/DaemonPrince.gif"));
		
		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flügel", 40));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servorüstung", 20));

		seperator();
		
		// lord, termi, dp, herald, bloodthrone
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "KDChaosbelohnungen", "");
		chaosBelohnungen.initKammer(false, false, true, false, false);
		chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(chaosBelohnungen);
		
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "KDWaffenUndArtefakte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndArtefakte.initKammer(false, false, true, false, false);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void refreshen() {
        
        if(((KDWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
    }

}
