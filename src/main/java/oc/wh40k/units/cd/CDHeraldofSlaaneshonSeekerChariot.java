package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDHeraldofSlaaneshonSeekerChariot extends Eintrag {

    OptionsUpgradeGruppe waffe1;

    public CDHeraldofSlaaneshonSeekerChariot() {
        name = "Herald of Slaanesh on Seeker Chariot";
        grundkosten = getPts("Herald of Slaanesh on Seeker Chariot");
        power = 6;

        ogE.addElement(new OptionsGruppeEintrag("Piercing claws", getPts("Piercing claws")));
        ogE.addElement(new OptionsGruppeEintrag("Lashes of torment", getPts("Lashes of torment")));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
