package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class SMSpezialausruestung extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean isTermi = false;
	boolean isKompaniemeister = false;
	boolean isTechmarine = false;
	boolean entrySwitched=false;
	boolean isWraith = false;
	boolean isRaven = false;

	public SMSpezialausruestung() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isTermi = defaults[0];
		isKompaniemeister = defaults[1];
		isTechmarine = defaults[2];
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Auspex"), 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Melterbomben"), 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Digitalwaffen"), 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "",BuildaHQ.translate("Teleportpeilsender "), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sprungmodul"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Space-Marine-Bike"), 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		setUeberschrift("Spezielle Ausrüstung");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		/*System.out.println("Termi: "+isTermi);
		System.out.println("Techmarine: "+isTechmarine);
		System.out.println("Kompaniemeister: "+isKompaniemeister);*/
		o1.setAktiv(BuildaHQ.translate("Sprungmodul"), !isTermi && !isTechmarine && !isWraith && !isRaven);
		o1.setAktiv(BuildaHQ.translate("Space-Marine-Bike"), !isTermi && !isWraith && !isRaven);
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		entrySwitched=false;
		if(name.equals( BuildaHQ.translate("Sprungmodul"))){ 
			if(isTermi!=aktiv){
				this.isTermi = aktiv;
				entrySwitched=true;
			}
		}
		if(name.equals( BuildaHQ.translate("Space-Marine-Bike"))){ 
			if(isTermi!=aktiv){
				this.isTermi = aktiv;
				entrySwitched=true;
			}
		}
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
}
