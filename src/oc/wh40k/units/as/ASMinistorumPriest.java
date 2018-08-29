package oc.wh40k.units.as;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ASMinistorumPriest extends Eintrag {

	OptionsEinzelUpgrade mb;
	OptionsZaehlerGruppe o1;
    RuestkammerStarter waffenUndRelikte;
    
	boolean added = false;

	public ASMinistorumPriest() {
		name = "Ministorum Priest";
		grundkosten = 25;
        this.setEintragsCNT(0.0);
        
        addToInformationVector("ASPriester", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASPredigerderEkklesiarchie.jpg"));
		
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		
		seperator();
		
		waffenUndRelikte = new RuestkammerStarter(ID, randAbstand, cnt, "ASWaffenUndRelikte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndRelikte.initKammer(false, true, false, false, false);
		waffenUndRelikte.setButtonText(BuildaHQ.translate("Waffen & Relikte"));
		add(waffenUndRelikte);
		waffenUndRelikte.setAbwaehlbar(false);
		
		

		
		
		complete();
	}

	@Override
	public void refreshen() {
		int prediger = getCountFromInformationVector("ASPriester");
		if(prediger > 5) {
			setFehlermeldung("Priester > 5!");
		} else if(((ASWaffenUndRelikte)waffenUndRelikte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        addToInformationVector("ASPriester", -1);
	}

}
