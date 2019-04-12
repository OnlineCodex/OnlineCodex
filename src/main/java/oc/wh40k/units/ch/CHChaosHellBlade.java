package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosHellBlade extends Eintrag {

	private final OptionsUpgradeGruppe o2;
	public CHChaosHellBlade() {
        name = "Chaos Hell Blade";
        grundkosten = getPts("Chaos Hell Blade");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Helstorm cannon", getPts("Helstorm cannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannon", getPts("Lascannon") * 2));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();

        power = 8;
    }

}
