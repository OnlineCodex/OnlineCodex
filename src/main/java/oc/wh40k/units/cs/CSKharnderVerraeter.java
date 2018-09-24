package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;

public class CSKharnderVerraeter extends Eintrag {

	public CSKharnderVerraeter() {
		name = "Kharn der Verräter";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/KharntheBetrayer.gif"));
		
		addToInformationVector("CMKhorneTroops", 1);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Khorne-Berserker");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Khorne-Berserker");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	
	@Override
	public void deleteYourself() {
		
		addToInformationVector("CMKhorneTroops", -1);
		if(getCountFromInformationVector("CMKhorneTroops")<1){
			BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Khorne-Berserker");
		}
		super.deleteYourself();
	}
}
