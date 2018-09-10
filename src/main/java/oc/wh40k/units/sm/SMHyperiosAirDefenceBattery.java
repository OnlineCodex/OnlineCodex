package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class SMHyperiosAirDefenceBattery extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;

	public SMHyperiosAirDefenceBattery() {
		name = "Hyperios Air Defence Battery";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hyperios Platform", "Hyperios Platforms", 1, 4, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGScoutSentinelSquadron.jpg"));
		
		seperator();
		
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hyperios Command Platform", 1, 10));
		

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
	}

}
