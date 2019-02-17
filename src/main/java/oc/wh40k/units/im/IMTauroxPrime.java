package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTauroxPrime extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

	private final OptionsEinzelUpgrade oe1;
	private final OptionsEinzelUpgrade oe2;

    public IMTauroxPrime() {
        name = "Taurox Prime";
        grundkosten = getPts("Taurox Prime");
        power = 6;
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Taurox battle cannon", getPts("Taurox battle cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Taurox gatling cannon", getPts("Taurox gatling cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Taurox missile launcher", getPts("Taurox missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 HEAVY_SUPPORT volley gun", getPts("Hot-shot volley gun") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Autocannons", getPts("Autocannon") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }

}
