package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class AMSentinelPowerlifterSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;

	public AMSentinelPowerlifterSquadron() {
		name = "Sentinel Powerlifter Squadron";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sentinel Powerlifter", "Sentinel Powerlifters", 1, 3, 30);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGScoutSentinelSquadron.jpg"));


		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Dozer blade", 3, 1));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launcher", 0));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 0));

		complete();
	}

	@Override
	public void refreshen() {
		
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setPreis(squad.getModelle() * 5);
		oe4.setPreis(squad.getModelle() * 10);

	}

}
