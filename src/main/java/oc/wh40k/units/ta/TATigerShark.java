package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

//[APO 2]

public class TATigerShark extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final RuestkammerStarter rk;

    public TATigerShark() {
        name = "Tiger Shark";
        grundkosten = 520;

        add(ico = new oc.Picture("oc/wh40k/images/TigerShark.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("14 Gun drones", 0));
        ogE.addElement(new OptionsGruppeEintrag("6 Seeker missiles", 0));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        rk = new RuestkammerStarter(ID, randAbstand, cnt, TAFahrzeugKammer.class, "Rüstkammer");
        rk.initKammer(true, false);
        rk.setButtonText("Rüstkammer");
        add(rk);

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        o1.alwaysSelected();
    }

}
