package oc.wh40k.units.ec;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECWaspAssaultWalkerKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    boolean added = false;

    public ECWaspAssaultWalkerKammer() {
        grundkosten = 70;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bright lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dark lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Eldar missile launcher", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bright lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dark lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Eldar missile launcher", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}
