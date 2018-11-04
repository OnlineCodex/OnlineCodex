package oc.wh40k.units.dkab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKABThunderboltKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    public DKABThunderboltKammer() {
        name = "Thunderbolt";
        grundkosten = 160;
    }

    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/ABThunderbolt.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("4 Hellstrike missiles", 40));
        ogE.addElement(new OptionsGruppeEintrag("6 Tactical Bombs", 40));
        ogE.addElement(new OptionsGruppeEintrag("6 Skystrike missiles", 40));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Distinctive paint", "Distinctive paint scheme/decals", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
