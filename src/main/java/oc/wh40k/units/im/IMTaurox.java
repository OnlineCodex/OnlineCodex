package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMTaurox extends Eintrag {

	private final OptionsEinzelUpgrade oe1;
	private final OptionsEinzelUpgrade oe2;

    public IMTaurox() {
        name = "Taurox";
        grundkosten = getPts("Taurox") + getPts("Autocannon (AM non-infantry)") * 2;
        power = 4;
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));
        complete();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }

}
