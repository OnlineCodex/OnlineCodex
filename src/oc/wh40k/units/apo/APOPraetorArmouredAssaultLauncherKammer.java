package oc.wh40k.units.apo;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class APOPraetorArmouredAssaultLauncherKammer extends RuestkammerVater {

    OptionsZaehlerGruppe o4;
    OptionsZaehlerGruppe o4x;

    public APOPraetorArmouredAssaultLauncherKammer() {
        grundkosten = 300;
        name = "Praetor Armoured Assault Launcher";
    }

    @Override
    public void initButtons(boolean... defaults) {
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

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o4x.setAnzahl(0, o4x.getMaxAnzahl() - o4.getAnzahl());
    }
    
}
