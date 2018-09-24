package oc.wh40k.units.kd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class KDChaosbelohnungen extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean isLord = false;
	boolean isTermi = false;
	boolean isDaemonPrince = false;
	boolean isHerald = false;
	boolean isBloodThrone = false;
	boolean bikeGesetzt = false;

	public KDChaosbelohnungen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isLord = defaults[0];
		isTermi = defaults[1];
		isDaemonPrince = defaults[2];
		isHerald = defaults[3];
		isBloodThrone = defaults[4];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpblut"), 5));
		if(isLord)
		{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Aura dunkler Pracht"), 15));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Halsband des Khorne"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampf-Homunkulus"), 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE ,1));
		o1.setMaxAnzahl(o1.getNumberOfOptions());
		setUeberschrift("Gaben des Chaos");
		sizeSetzen();
		
		seperator();
		
		if(!isTermi && (isLord || isHerald))
		{
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Moloch des Khorne"), 45));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			//setUeberschrift("Reittiere");
			sizeSetzen();
		}
		
	}

	@Override
	public void refreshen() {
		if(!isTermi && (isLord || isHerald))
		{
			o2.setAktiv(BuildaHQ.translate("Moloch des Khorne"), !bikeGesetzt);
		}
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		boolean entrySwitched=false;
		
		if(name.equals( BuildaHQ.translate("Moloch des Khorne"))){ 
			o2.setAktiv(aktiv);
		} 
		
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
}
