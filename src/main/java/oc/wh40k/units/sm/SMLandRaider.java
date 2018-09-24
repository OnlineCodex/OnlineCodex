package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public class SMLandRaider extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMLandRaider() {
		name = "Land Raider";
		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaider.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant Chronus", 0));

		complete();
	}

	@Override
	public void refreshen() {
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
			setFehlermeldung("Max 1 Chronus");
		}else{
			setFehlermeldung("");
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
