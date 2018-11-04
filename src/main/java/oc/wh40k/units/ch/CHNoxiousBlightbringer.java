package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHNoxiousBlightbringer extends Eintrag {

    OptionsUpgradeGruppe bell, pp;

    public CHNoxiousBlightbringer() {

        name = "Noxious Blightbringer";
        grundkosten = getPts("Noxious Blightbringer");
        power = 4;

        ogE.addElement(new OptionsGruppeEintrag("Cursed plague bell", getPts("Cursed plague bell") * 2));
        add(bell = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        add(pp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();

    }

    @Override
    public void refreshen() {
        bell.setSelected(0, true);
        pp.setSelected(0, true);
    }
}
