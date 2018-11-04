package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMStormfangGunship extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public IMStormfangGunship() {
        name = "Stormfang Gunship";
        grundkosten = getPts("Stormfang Gunship") + getPts("Helfrost destructor");
        power = 14;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Twin heavy bolters", getPts("Twin heavy bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Skyhammer ML", "Skyhammer missile launcher", getPts("Skyhammer missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("2 Twin multi-meltas", getPts("Twin multi-melta") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stormstrike ML", "Stormstrike missile launchers", getPts("stormstrike missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("2 lascannons", getPts("Lascannon (SM)") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
        o1.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
