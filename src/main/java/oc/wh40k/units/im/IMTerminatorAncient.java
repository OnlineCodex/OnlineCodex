package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTerminatorAncient extends Eintrag {
    OptionsUpgradeGruppe o2;

    public IMTerminatorAncient() {
        name = "Terminator Ancient";
        grundkosten = getPts("Terminator Ancient");
        power = 6;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("lightning claw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("thunder hammer", getPts("thunder hammer (Characters)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
    }
}
