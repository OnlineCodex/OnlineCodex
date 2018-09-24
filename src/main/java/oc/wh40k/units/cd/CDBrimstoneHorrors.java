package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDBrimstoneHorrors extends Eintrag {

	AnzahlPanel CDRosaHorrorsdesTzeentch;

	boolean WechselbalgSelected = false;

	public CDBrimstoneHorrors() {

		name = "Brimstone Horrors";

		grundkosten = 0;

		seperator();
		
		CDRosaHorrorsdesTzeentch = new AnzahlPanel(ID, randAbstand, cnt, "Brimstone Horrors", 10, 20, 3);
		add(CDRosaHorrorsdesTzeentch);
		add(ico = new oc.Picture("oc/wh40k/images/CDRosaHorrorsdesTzeentch.gif"));
		seperator();


		complete();

	}

	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafür wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt

		super.deleteYourself();

	}

	@Override
	public void refreshen() {
	}
}
