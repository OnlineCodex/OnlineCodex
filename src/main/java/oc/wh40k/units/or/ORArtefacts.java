package oc.wh40k.units.or;

import oc.*;

public class ORArtefacts extends Eintrag {
	private final OptionsUpgradeGruppe fk1;

    public ORArtefacts() {
        name = "Armiger Helverin";
        grundkosten = 0;
        power = 0;

        ogE.addElement(new OptionsGruppeEintrag("Headwoppa's Killchoppa", getPts("")));
        add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        this.eintragsCNT = 0;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.alwaysSelected();
    }
}
