package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECCorsairVenomKammer extends RuestkammerVater {

    OptionsUpgradeGruppe weapons1;
    OptionsUpgradeGruppe weapons2;

    public ECCorsairVenomKammer() {
        grundkosten = 50;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairVenomKammer.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Lasblasters", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Splinter rifles", 10));
        ogE.addElement(new OptionsGruppeEintrag("TL Shuriken catapults", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 20));
        add(weapons1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", 0));
        add(weapons2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair void burners", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair kinetic shroud", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chain snares", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        weapons1.alwaysSelected();
        weapons2.alwaysSelected();
    }

}
