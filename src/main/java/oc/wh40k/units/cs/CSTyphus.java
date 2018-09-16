package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;

public class CSTyphus extends Eintrag {


	public CSTyphus() {
		name = "Typhus";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/Typhus.gif"));
		addToInformationVector("CMNurgleTroops", 1);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Seuchenmarines");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Seuchenmarines");

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Seuchenzombies");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("CMNurgleTroops", -1);
		if(getCountFromInformationVector("CMNurgleTroops")<1){
			BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenmarines");
		}
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenzombies");
		super.deleteYourself();
	}

}
