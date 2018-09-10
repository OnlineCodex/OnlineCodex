package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class EDSentryGunBattery extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe1x;
	OptionsEinzelZaehler oe2;

	public EDSentryGunBattery() {
		name = "Elysian Sentry Gun Battery";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Senty gun", "Sentry guns", 1, 3, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

		seperator();

		add(oe1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "T/L heavy bolters", "Twin-linked heavy bolters", 3, 0));
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "T/L lascannons", "Twin-linked lascannons", 3, 10));

        seperator(5);

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Camo nets", 3, 10));

        complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
		oe1x.setMaxAnzahl(squad.getModelle());
		oe1x.setAnzahl(oe1x.getMaxAnzahl() - oe1.getAnzahl());
		oe2.setMaxAnzahl(squad.getModelle());
	}

}
