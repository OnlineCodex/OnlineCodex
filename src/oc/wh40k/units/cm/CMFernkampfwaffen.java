package oc.wh40k.units.cm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CMFernkampfwaffen extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	//int maxCosts = 0;
	//boolean keinZauberer = false;
	//boolean Preis = false;

	public CMFernkampfwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		//keinZauberer = defaults[0];
		//Preis = defaults[1];

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Bolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Fernkampfwaffen");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		//o1.setAktiv(BuildaHQ.translate("Kampftänzer-Sippe"), keinZauberer);
		//o1.setAktiv(BuildaHQ.translate("Wilde Jäger-Sippe"), keinZauberer);
		//o1.setAktiv(BuildaHQ.translate("Waldläufer-Sippe"), keinZauberer);
		//o1.setAktiv(BuildaHQ.translate("Wandler-Sippe"), keinZauberer);
		//o1.setAktiv(BuildaHQ.translate("Kundschafter-Sippe"), keinZauberer);
		//o1.setAktiv(BuildaHQ.translate("Ewigkeit-Sippe"), keinZauberer);

		//if(Preis) {
		//	o1.setPreis(BuildaHQ.translate("Kampftänzer-Sippe"), 30);
		//	o1.setPreis(BuildaHQ.translate("Wilde Jäger-Sippe"), 35);
		//	o1.setPreis(BuildaHQ.translate("Waldläufer-Sippe"), 35);
		//	o1.setPreis(BuildaHQ.translate("Wandler-Sippe"), 25);
		//	o1.setPreis(BuildaHQ.translate("Kundschafter-Sippe"), 15);
		//	o1.setPreis(BuildaHQ.translate("Ewigkeit-Sippe"), 5);
		//}
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
}
