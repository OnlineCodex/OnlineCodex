package oc.wh40k.units.im;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMJusticar extends RuestkammerVater {

    private final OptionsUpgradeGruppe o1;
    private final OptionsUpgradeGruppe o3;

    public IMJusticar() {
        ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
        ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o3.alwaysSelected();
    }
}