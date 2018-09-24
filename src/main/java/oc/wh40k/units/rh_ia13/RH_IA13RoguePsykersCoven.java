package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;

public class RH_IA13RoguePsykersCoven extends Eintrag {

	AnzahlPanel squad;
	
	public RH_IA13RoguePsykersCoven() {
		name = "Rogue Psykers Coven";
		grundkosten = 0;
		überschriftSetzen=true;

		addToInformationVector("RHRoguePsykersCoven", +1);
		
		add(ico = new oc.Picture("oc/wh40k/images/RHRoguePsyker.gif"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rogue Psyker", 1, 5, 35);
		add(squad);

		complete();
	}

	@Override
	public void refreshen() {
		if(getCountFromInformationVector("RHRoguePsykersCoven") > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("RHRoguePsykersCoven", -1);
	}

}
