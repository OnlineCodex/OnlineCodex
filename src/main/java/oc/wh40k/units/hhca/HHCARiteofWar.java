package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.Eintrag;

public class HHCARiteofWar extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public HHCARiteofWar() {
		name = "Rite of War Orbital assault";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		setInformationVectorValue("HHCARoW", 3);

		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Black Reaving");
		
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Deathstorm Drop Pod");
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Deathstorm Drop Pod");

		
		complete();
	}

	
	@Override
	public void refreshen() {		
						
		int possibleSquads = getCountFromInformationVector("HHCAPraetor");
		if(1 > possibleSquads) {
			setFehlermeldung("Requirements not met!");
		} else {
			setFehlermeldung("");
		}
						
		setUnikat(true);				
	}
	
	@Override
	public void deleteYourself() {
		
		setInformationVectorValue("HHCARoW", 0);
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		//BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Black Reaving");
		
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Deathstorm Drop Pod");
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Deathstorm Drop Pod");
		super.deleteYourself();
	}

}
