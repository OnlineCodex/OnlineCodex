package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosHellTalon extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;
	public CHChaosHellTalon() {
        name = "Chaos Hell Talon";
        grundkosten = getPts("Chaos Hell Talon");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Helstorm cannon", getPts("Helstorm cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Pyrax incendiary bombs", getPts("Pyrax incendiary bombs")));
        ogE.addElement(new OptionsGruppeEintrag("Warp-pulse bombs", getPts("Warp-pulse bombs")));
        ogE.addElement(new OptionsGruppeEintrag("Baletalon shatter charges", getPts("Baletalon shatter charges")));
        add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

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
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        power = 12;
    }

}
