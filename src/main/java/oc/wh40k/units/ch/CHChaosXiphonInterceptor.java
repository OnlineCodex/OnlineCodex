package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosXiphonInterceptor extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe mark;

    public CHChaosXiphonInterceptor() {
        name = "Chaos Xiphon Interceptor";
        grundkosten = getPts("Chaos Xiphon Interceptor");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Twin lascannon", getPts("Twin lascannon") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Soulstalker missile launcher", getPts("Soulstalker missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
        o2.alwaysSelected();
        o1.alwaysSelected();

        power = 11;
    }

}
