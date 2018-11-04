package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDSoulgrinder extends Eintrag {

    OptionsUpgradeGruppe waffe1;

    public CDSoulgrinder() {

        name = "Soulgrinder";
        grundkosten = getPts("Soulgrinder");
        power = 11;

        ogE.addElement(new OptionsGruppeEintrag("Warpsword", getPts("Warpsword")));
        ogE.addElement(new OptionsGruppeEintrag("Warpclaw", getPts("Warpclaw")));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
