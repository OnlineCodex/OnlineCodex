package oc.wh40k.units.am;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMTauroxPrime extends RuestkammerVater {

    OptionsEinzelUpgrade o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o2x;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public AMTauroxPrime() {
        grundkosten = 80;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Taurox Kampfgeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Taurox Sturmkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Taurox Raketenwerfer", 20));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("sync. HE Salvengewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("sync. Maschka", 0));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o3.setSelected(0, true);

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinengewehr", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schützende Reliquien", 3));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bergeausrüstung", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nebelwerfer", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Promethiumfässer", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnnetze", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Augurium", 25));
        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }

}
