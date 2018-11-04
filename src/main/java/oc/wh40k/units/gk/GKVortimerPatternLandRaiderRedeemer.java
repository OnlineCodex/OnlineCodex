/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 * nicht mehr existent!
 */

package oc.wh40k.units.gk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class GKVortimerPatternLandRaiderRedeemer extends Eintrag {
    OptionsUpgradeGruppe o2;

    public GKVortimerPatternLandRaiderRedeemer() {
        name = "Vortimer Pattern Land Raider Redeemer";
        grundkosten = 285;

        add(ico = new oc.Picture("oc/wh40k/images/GKLandRaiderRedeemer.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
