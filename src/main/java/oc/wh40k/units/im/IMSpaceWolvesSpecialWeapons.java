package oc.wh40k.units.im;

import java.util.Vector;

import oc.BuildaVater;
import oc.OptionsGruppeEintrag;
import oc.RuestkammerElement;

public class IMSpaceWolvesSpecialWeapons extends RuestkammerElement{
	
	static public Vector<OptionsGruppeEintrag> createRK(String defaultWeapon, String defaultWeaponCost, BuildaVater bv){
		Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>();
		addDefault(defaultWeapon, defaultWeaponCost, ogE, bv);
		addElement("Flamer", "Flamer (SM)", defaultWeapon, ogE, bv);
		addElement("Plasma gun", "Plasma gun (SM)", defaultWeapon, ogE, bv);
		addElement("Meltagun", "Meltagun (SM)", defaultWeapon, ogE, bv);
		return ogE;
	}
	
}


