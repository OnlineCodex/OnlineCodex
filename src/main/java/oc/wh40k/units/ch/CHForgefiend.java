package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHForgefiend extends Eintrag {

    OptionsUpgradeGruppe o1, o2;
    RuestkammerStarter ausruestung;
    OptionsUpgradeGruppe mark;

    public CHForgefiend() {
        name = "Forgefiend";
        grundkosten = getPts("Forgefiend");

        add(ico = new oc.Picture("oc/wh40k/images/Klauenmonstrum.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Hades autocannon", getPts("Hades autocannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Ectoplasma cannon", getPts("Ecotplasma cannon") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        ogE.addElement(new OptionsGruppeEintrag("Daemon jaws", getPts("Daemon jaws")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma cannon", getPts("Ecotplasma cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        power = 10;
    }

}
