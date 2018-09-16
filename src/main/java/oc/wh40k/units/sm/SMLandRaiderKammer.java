package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class SMLandRaiderKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade chronus;

	boolean[] defaults;
	boolean chronusSelected = false;
	boolean isBefehl;
	boolean ultra;
	boolean chronosError = false;

	public SMLandRaiderKammer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		this.defaults = defaults;
		if(defaults.length > 0) isBefehl = defaults[0];

		if (isBefehl) add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 0));
		if (isBefehl) seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderGross.jpg"));


		ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant Chronus", 0));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		if (isBefehl) o2.setSelected(true);

		// Unique entry: Sergeant Chronus
		if(chronus.isSelected() && !chronusSelected) {
			chronusSelected = true;
			BuildaHQ.addToInformationVectorGlobal("SMChronusAdded", 1);
			RefreshListener.fireRefresh();
		} else if(!chronus.isSelected() && chronusSelected){
			chronusSelected = false;
			BuildaHQ.addToInformationVectorGlobal("SMChronusAdded", -1);
			RefreshListener.fireRefresh();
		}

		int chronusGlobal = BuildaHQ.getCountFromInformationVectorGlobal("SMChronusAdded");

		if(chronusGlobal>1 && chronusSelected){
			chronosError=true;
		}else{
			chronosError=false;
		}
	}

	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.addToInformationVectorGlobal("SMChronusAdded", -1);
		}
		super.deleteYourself();
	}

}
