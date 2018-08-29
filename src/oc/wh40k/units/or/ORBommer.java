package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORBommer extends Eintrag {

	public ORBommer() {
		name = "Bommer";
		grundkosten = 300;


		add(ico = new oc.Picture("oc/wh40k/images/Bommer.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "10 Bomms",80));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("6 Bomms", 60));
		ogE.addElement(new OptionsGruppeEintrag("4 Bomms, 2 Grotbomms", 60));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		complete();

	}

	public void refreshen() {
	}
}
