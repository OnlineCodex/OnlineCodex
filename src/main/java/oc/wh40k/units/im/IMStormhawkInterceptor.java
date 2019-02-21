package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMStormhawkInterceptor extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public IMStormhawkInterceptor() {
        name = "Stormhawk Interceptor";
        grundkosten = getPts("Stormhawk Interceptor") + getPts("Assault cannon") * 2;
        power = 10;


        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Skyhammer missile launcher", getPts("Skyhammer missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Icarus stormcannon", getPts("Icarus stormcannon")));
        ogE.addElement(new OptionsGruppeEintrag("Las-talon", getPts("Las-talon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
