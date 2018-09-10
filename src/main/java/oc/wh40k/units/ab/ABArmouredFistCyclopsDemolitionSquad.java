package oc.wh40k.units.ab;

import oc.Eintrag;

public class ABArmouredFistCyclopsDemolitionSquad extends Eintrag {

    

	public ABArmouredFistCyclopsDemolitionSquad() {
		
		name = "Armoured Fist Cyclops Demolition Squad";
		grundkosten = 115;
		überschriftSetzen=true;

		add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistPlatoonCommandSquad.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        
	}

}
