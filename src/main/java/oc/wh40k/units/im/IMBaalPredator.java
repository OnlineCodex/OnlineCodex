package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMBaalPredator extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMBaalPredator() {
        name = "Baal Predator";
        grundkosten = getPts("Baal Predator");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin assault cannon", getPts("Twin assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", getPts("flamestorm cannon")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", getPts("heavy bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 heavy flamers", getPts("heavy flamer (SM)") * 2));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
