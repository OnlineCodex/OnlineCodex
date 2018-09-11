package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceWolvesCombiWeapons extends RuestkammerElement{
	
	static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv){
		Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
		addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
		addElement("Combi-flamer", "Combi-flamer", defaultWeapon, ogE, bv);
		addElement("Combi-melta", "Combi-melta", defaultWeapon, ogE, bv);
		addElement("Combi-plasma", "Combi-plasma", defaultWeapon, ogE, bv);
		addElement("Storm bolter", "Storm bolter (SM)", defaultWeapon, ogE, bv);
		return ogE;
	}
	
}


