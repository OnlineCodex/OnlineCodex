package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderAchilles extends Eintrag {

    OptionsUpgradeGruppe o1;

    public SMLandRaiderAchilles() {
        name = "Land Raider Achilles";
        grundkosten = 325;

        add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
