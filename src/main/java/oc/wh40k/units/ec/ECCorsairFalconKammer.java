package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECCorsairFalconKammer extends RuestkammerVater {

    OptionsUpgradeGruppe weapons1;
    OptionsUpgradeGruppe weapons2;

    public ECCorsairFalconKammer() {
        grundkosten = 130;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairFalconKammer.jpg"));

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
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bright lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dark lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Eldar missile launcher", 15));
        add(weapons2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair void burners", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair kinetic shroud", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 15));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        weapons1.alwaysSelected();
        weapons2.alwaysSelected();
    }

}
