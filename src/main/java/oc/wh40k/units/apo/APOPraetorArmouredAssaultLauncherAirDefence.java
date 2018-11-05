/* Experimentelle Regeln zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/p/preatorrules1.pdf
 */

package oc.wh40k.units.apo;

import oc.*;

/*
 * Praetor Armoured Assault Launcher 300 pkt. (Air Defence Variant, Apocalypse)

Er darf einen oder beide seiner schweren Bolter gegen folgende Waffenoptionen eintauschen:
Heavy flamers kostenlos
Autocannon 5 pkt. pro Schwerer Bolter
Lascannon 10 pkt. pro Schwerer Bolter

Darf zusätzlich eine von den folgenden Optionen erhalten:
Hunter-killer missile 10 pkt.
Dozer blade 10 pkt.
Pintle-mounted storm bolter or heavy stubber 10 pkt.
 */

public class APOPraetorArmouredAssaultLauncherAirDefence extends Eintrag {

    OptionsZaehlerGruppe o4;
    OptionsZaehlerGruppe o4x;

    public APOPraetorArmouredAssaultLauncherAirDefence() {
        name = "Praetor Armoured Assault Launcher (Air Defence)";
        grundkosten = 300;


        add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("zusätzliches Maschinengewehr", 10));
        ogE.addElement(new OptionsGruppeEintrag("zusätzlicher Sturmbolter", 10));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", "Front sponson with Heavy Bolter", 0));
        add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Front sponson with Heavy Flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", "Front sponson with Autocannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", "Front sponson with Lascannon", 10));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();

    }

    public void refreshen() {
        o4x.setAnzahl(0, o4x.getMaxAnzahl() - o4.getAnzahl());

    }
}
