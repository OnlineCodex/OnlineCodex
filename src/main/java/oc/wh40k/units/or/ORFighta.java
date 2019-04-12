package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORFighta extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public ORFighta() {
        name = "Fighta";
        grundkosten = 140;


        add(ico = new oc.Picture("oc/wh40k/images/Fighta.gif"));


        ogE.addElement(new OptionsGruppeEintrag("Bomms", "two Bomms", 0));
        ogE.addElement(new OptionsGruppeEintrag("Rokkits", "two Rokkits", 0));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();

    }

    @Override
	public void refreshen() {
        o1.alwaysSelected();
    }
}
