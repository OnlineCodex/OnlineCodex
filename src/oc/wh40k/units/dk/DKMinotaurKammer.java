package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DKMinotaurKammer extends RuestkammerVater {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o3;

	public DKMinotaurKammer() {}
	
	public void initButtons(boolean... b) {
		name = "Minotaur\n";
		grundkosten = 275;


		add(ico = new oc.Picture("oc/wh40k/images/MinotaurArtilleryTank.gif"));
		
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enclosed Crew Compartment", 15));
                
		sizeSetzen();

	}

	public void refreshen() {
        o3.setAktiv(!o1.isSelected());
        o1.setAktiv(!o3.isSelected());
	}
}
