package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMCorvusBlackstar extends Eintrag {

	private final OptionsUpgradeGruppe o1;
    private final OptionsUpgradeGruppe o2;
    private final OptionsUpgradeGruppe o3;

    public IMCorvusBlackstar() {
        name = "Corvus Blackstar";
        grundkosten = getPts("Corvus Blackstar");

        ogE.addElement(new OptionsGruppeEintrag("Twin assault cannon", getPts("Twin assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Stormtalon.gif"));

        ogE.addElement(new OptionsGruppeEintrag("2 Stormstrike missile launchers", getPts("Stormstrike missile launcher") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Blackstar rocket launcher", getPts("Blackstar rocket launcher") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hurricane bolter", getPts("Hurricane bolter")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Infernum halo-launcher", getPts("Infernum halo-launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Auspex array", getPts("Auspex array")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        complete();

    }

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
