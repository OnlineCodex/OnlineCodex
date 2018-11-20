package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMStormwolf extends Eintrag {
    OptionsUpgradeGruppe o2;

    public IMStormwolf() {
        name = "Stormwolf";
        grundkosten = getPts("Stormwolf") + getPts("Twin Helfrost cannon") + getPts("Lascannon (SM)") * 2;
        power = 16;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Twin heavy bolters", getPts("Twin heavy bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Skyhammer ML", "Skyhammer missile launcher", getPts("Skyhammer missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("2 Twin multi-meltas", getPts("Twin multi-melta") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
        o2.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
    }
}
