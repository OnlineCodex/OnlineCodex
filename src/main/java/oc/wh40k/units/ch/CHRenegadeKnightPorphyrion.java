package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHRenegadeKnightPorphyrion extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3;

    public CHRenegadeKnightPorphyrion() {
        name = "Renegade Knight Porphyrion";
        grundkosten = getPts("Renegade Knight Porphyrion");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin magna lascannon", getPts("Twin magna lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Autocannon", getPts("Autocannon") * 2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ironstorm missile pod", getPts("Ironstorm missile pod")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        power = 40;
    }

}
