package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHVenomcrawler extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public CHVenomcrawler() {
        name = "Venom Crawler";
        grundkosten = getPts("Venom Crawler") + getPts("Soulflayer tendrils") + getPts("Eviscerating claws");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Excruciator cannons", getPts("Excruciator cannon") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 7;

        o1.alwaysSelected();
    }

}
