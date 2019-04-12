package oc.wh40k.units.ty;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TYWolfquad extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2;

    public TYWolfquad() {
        grundkosten = getPts("Wolfquad");
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Mining laser", getPts("Mining laser")));
        ogE.addElement(new OptionsGruppeEintrag("Atalan incinerator", getPts("Atalan incinerator")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
        ogE.addElement(new OptionsGruppeEintrag("Improvised weapon", getPts("Improvised weapon")));
        ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}