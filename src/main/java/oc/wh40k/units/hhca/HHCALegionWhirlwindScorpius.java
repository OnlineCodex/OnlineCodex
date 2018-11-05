package oc.wh40k.units.hhca;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HHCALegionWhirlwindScorpius extends Eintrag {

    OptionsUpgradeGruppe o1;

    public HHCALegionWhirlwindScorpius() {
        name = "Legion Whirlwind Scorpius";
        grundkosten = 115;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
        ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

        complete();
    }

    @Override
    public void refreshen() {

    }

}
