package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosbrut extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe mal;
	
	public CMChaosbrut() {
		//name = "Chaosbrut";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaosbrut", 1, 5, 30);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpawn.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 1));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 1));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
		int count = squad.getModelle();
		
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 4 * count);
		mal.setPreis("Mal des Nurgle", 6 * count);
		mal.setPreis("Mal des Slaanesh", 3 * count);
	}

}
