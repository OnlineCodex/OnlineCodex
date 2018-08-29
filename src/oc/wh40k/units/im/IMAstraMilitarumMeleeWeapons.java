package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMAstraMilitarumMeleeWeapons extends RuestkammerElement{
	
	static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv){
		Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
		addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
		addElement("Power axe", "Power axe (AM)", defaultWeapon, ogE, bv);
		addElement("Power maul", "Power maul (AM)", defaultWeapon, ogE, bv);
		addElement("Power sword", "Power sword (AM)", defaultWeapon, ogE, bv);
		addElement("Power fist", "Power fist (AM)", defaultWeapon, ogE, bv);
		return ogE;
	}
	
}


