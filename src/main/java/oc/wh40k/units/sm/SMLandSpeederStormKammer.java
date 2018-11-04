package oc.wh40k.units.sm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMLandSpeederStormKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    public SMLandSpeederStormKammer() {
        name = "Land Speeder Storm";
        grundkosten = 40;
    }

    @Override
    public void initButtons(boolean... defaults) {

        add(ico = new oc.Picture("oc/wh40k/images/SMLandSpeederStorm.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected("Schwerer Bolter", true);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected("Schwerer Bolter", true);
        }
    }

}
