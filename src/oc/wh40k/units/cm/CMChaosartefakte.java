package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CMChaosartefakte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean malDesKhorne = false;
	boolean malDesTzeentch = false;
	boolean malDesNurgle = false;
	boolean malDesSlaanesh = false;

	public CMChaosartefakte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		malDesKhorne = defaults[0];
		malDesTzeentch = defaults[1];
		malDesNurgle = defaults[2];
		malDesSlaanesh = defaults[3];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dimensionsschlüssel"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brandfackel von Skalathrax"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt der blinden Wut"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Mordschwert"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der schwarze Streikolben"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schriftrollen des Magnus"), 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Artefakte des Chaos");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(BuildaHQ.translate("Schriftrollen des Magnus"), malDesTzeentch);
		o1.setAktiv(BuildaHQ.translate("Axt der blinden Wut"), malDesKhorne);
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals( BuildaHQ.translate("Axt der blinden Wut"))) this.malDesKhorne = aktiv;
		if(name.equals( BuildaHQ.translate("Schriftrollen des Magnus"))) this.malDesTzeentch = aktiv;
		
		refreshen();
	}
}
