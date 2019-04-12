package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosFireRaptorAssaultGunship extends Eintrag {

	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;
	public CHChaosFireRaptorAssaultGunship() {
        name = "Chaos Fire Raptor Assault Gunship";
        grundkosten = getPts("Chaos Fire Raptor Assault Gunship");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        ogE.addElement(new OptionsGruppeEintrag("2 Quad heavy bolter", getPts("Quad heavy bolter") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Reaper batteries", getPts("Reaper battery")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles", getPts("Hellstrike missiles")));
        ogE.addElement(new OptionsGruppeEintrag("Balefire missiles", getPts("Balefire missiles")));
        ogE.addElement(new OptionsGruppeEintrag("2 twin lascannon", getPts("Twin lascannon") * 2));
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
        o2.alwaysSelected();
        o3.alwaysSelected();

        power = 18;
    }

}
