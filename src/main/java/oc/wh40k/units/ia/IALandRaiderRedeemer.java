/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 * nicht mehr existent!
 */

package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IALandRaiderRedeemer extends Eintrag {
        OptionsUpgradeGruppe o2;

	public IALandRaiderRedeemer() {
		name = "Land Raider Redeemer";
		grundkosten = 240;
                
		add(ico = new oc.Picture("oc/wh40k/images/GKLandRaiderRedeemer.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
