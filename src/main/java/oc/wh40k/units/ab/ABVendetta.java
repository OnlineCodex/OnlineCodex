package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABVendetta extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    public ABVendetta() {
        grundkosten = 130;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("3 T/L Lascannons", "3 Twin-linked lascannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("T/L Lascan & Hellfuries", "Twin-linked lascannon and 2 Hellfury missiles", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Heavy bolters", "Pair of heavy bolters", 10));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured cockpit", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Distinctive paint", "Distinctive paint scheme/decals", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
