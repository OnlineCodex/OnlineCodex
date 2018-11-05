package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHellforgedDreadclawDropPod extends Eintrag {

    OptionsUpgradeGruppe o1, o2;
    OptionsUpgradeGruppe mark;

    public CHHellforgedDreadclawDropPod() {
        name = "Hellforged Dreadclaw Drop Pod";
        grundkosten = getPts("Hellforged Dreadclaw Drop Pod");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Blade struts", getPts("Blade struts")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thermal jets", getPts("Thermal jets")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


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
        o1.alwaysSelected();
        o2.alwaysSelected();

        power = 10;
    }

}
