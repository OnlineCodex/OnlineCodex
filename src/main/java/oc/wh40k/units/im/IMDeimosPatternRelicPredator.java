package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDeimosPatternRelicPredator extends Eintrag {

	OptionsUpgradeGruppe o1, o2;

	public IMDeimosPatternRelicPredator() {
		name = "Deimos Pattern Relic Predator";
		grundkosten = getPts("Deimos Pattern Relic Predator");
		power = 11;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma destroyer", getPts("Plasma destroyer")));
		ogE.addElement(new OptionsGruppeEintrag("Magna-melta cannon", getPts("Magna-melta cannon")));
		ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Infernus cannon", getPts("Infernus cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Predator autocannon", getPts("Predator autocannon")));
		ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter (IA)") * 2));
		ogE.addElement(new OptionsGruppeEintrag("2 Lascannon", getPts("Lascannon (IA)") * 2));
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer") * 2));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}
}
