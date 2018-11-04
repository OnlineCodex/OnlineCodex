package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DHDestruktorLord extends Eintrag {

    OptionsUpgradeGruppe o1;

    public DHDestruktorLord() {
        name = "Destruktor-Lord";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/NEDestruktorLord.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kriegssense", 0));
        ogE.addElement(new OptionsGruppeEintrag("Flammenfaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stab des Lichts", 0));
        ogE.addElement(new OptionsGruppeEintrag("Entropieklinge", 5));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Durasempisches Geflecht", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gedankenkontrollskarabäen", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tachyonenpfeil", 30));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneratorsphäre", 30));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
