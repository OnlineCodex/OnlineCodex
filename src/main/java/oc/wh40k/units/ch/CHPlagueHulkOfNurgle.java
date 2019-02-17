package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHPlagueHulkOfNurgle extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;

    public CHPlagueHulkOfNurgle() {
        name = "Plague Hulk of Nurgle";
        grundkosten = getPts("Plague Hulk of Nurgle");

        ogE.addElement(new OptionsGruppeEintrag("Iron claw", getPts("Iron claw")));
        ogE.addElement(new OptionsGruppeEintrag("Warpsword", getPts("Warpsword")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rot cannon", getPts("Rot cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rancid vomit", getPts("Rancid vomit")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}
