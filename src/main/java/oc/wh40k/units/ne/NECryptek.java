package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NECryptek extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public NECryptek() {

        name = "Cryptek";
        grundkosten = getPts("Cryptek");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chronometron", getPts("Chronometron")));
        ogE.addElement(new OptionsGruppeEintrag("Canoptek cloak", getPts("Canoptek cloak")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }
}
