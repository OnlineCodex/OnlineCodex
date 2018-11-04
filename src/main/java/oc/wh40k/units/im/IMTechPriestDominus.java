package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTechPriestDominus extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public IMTechPriestDominus() {
        name = "Tech-Priest Dominus";
        grundkosten = getPts("Tech-Priest Dominus") + getPts("Omnissian axe");
        power = 7;
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Volkite blaster", getPts("Volkite blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Eradication ray", getPts("Eradication ray")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Macrostubber", getPts("Macrostubber")));
        ogE.addElement(new OptionsGruppeEintrag("Phosphor serpenta", getPts("Phosphor serpenta")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o2.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
