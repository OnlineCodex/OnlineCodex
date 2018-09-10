package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CMAhriman extends Eintrag {


	public CMAhriman() {
		name = "Ahriman";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));
		addToInformationVector("CMTzeentchTroops", 1);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Disc of Tzeentch", 30));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(getCountFromInformationVector("CMTzeentchTroops")>0){
			buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Rubric Marines");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Rubric Marines");
		}else{
			buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rubric Marines");
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Rubric Marines");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("CMTzeentchTroops", -1);
		if(getCountFromInformationVector("CMTzeentchTroops")<1){
			buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rubric Marines");
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Rubric Marines");
		}
		super.deleteYourself();
	}
}
