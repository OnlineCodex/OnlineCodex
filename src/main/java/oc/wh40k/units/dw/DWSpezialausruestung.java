package oc.wh40k.units.dw;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class DWSpezialausruestung extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean isTermi = false;
	boolean isKompaniemeister = false;
	boolean isTechmarine = false;
	boolean entrySwitched=false;
	boolean isWraith = false;
	boolean isRaven = false;

	public DWSpezialausruestung() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isTermi = defaults[0];
		isKompaniemeister = defaults[1];
		isTechmarine = defaults[2];
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Auspex"), 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Combat shield"), 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Melterbomben"), 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Teleportpeilsender "), 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Digitalwaffen "), 10));
		
		setUeberschrift("Spezielle Ausrüstung");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		/*System.out.println("Termi: "+isTermi);
		System.out.println("Techmarine: "+isTechmarine);
		System.out.println("Kompaniemeister: "+isKompaniemeister);*/
	}
}
