package oc.wh40k.units.im;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMJusticar extends RuestkammerVater {

	private OptionsUpgradeGruppe o1;
	private OptionsUpgradeGruppe o3;

    public IMJusticar() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
        ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        //o1.setActive(!o2.isSelected());

        o3.alwaysSelected();
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
    }

}
