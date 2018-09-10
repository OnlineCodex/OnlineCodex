package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public class SMLandRaiderRedeemer extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMLandRaiderRedeemer() {
		name = "Land Raider Redeemer";
		grundkosten = 240;

		addToInformationVector("Land Raider Redeemer", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderRedeemer.jpg"));

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

		//Detachments
		boolean max1Error=false;
		if(getCountFromInformationVector("Strike Force Ultra")>0){
			int i =getCountFromInformationVector("Land Raider Crusader") + getCountFromInformationVector("Land Raider Redeemer");
			if(i>1){
				max1Error=true;
			}
		}

		//Errors
		if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(chronusGlobal>1 && chronusSelected){
			setFehlermeldung("Max 1 Chronus");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {

		addToInformationVector("Land Raider Redeemer", -1);

		if(chronusSelected) {
			BuildaHQ.addToInformationVectorGlobal("SMChronusAdded", -1);
		}
		super.deleteYourself();
	}

}
