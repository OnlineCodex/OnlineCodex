package oc.wh40k.units.ed;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class EDLordCommissar extends Eintrag {

	public EDLordCommissar() {
		name = "Lord Commissar";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/IGLordCommissar.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Melta bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Carapace Armour", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Tracking Beacon", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
