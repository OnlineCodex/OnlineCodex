package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORMekaDread extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public ORMekaDread() {
        name = "Meka-Dread (FW)";
        grundkosten = getPts("Meka-Dread") + getPts("rippa klaw");
        power = 12;

        ogE.addElement(new OptionsGruppeEintrag("Rippa Klaw", getPts("Rippa Klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Big zzappa", getPts("Big zzappa")));
        ogE.addElement(new OptionsGruppeEintrag("Shunta", getPts("Shunta")));
        ogE.addElement(new OptionsGruppeEintrag("Rattler kannon", getPts("Rattler kannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kustom Force Field", getPts("Kustom Force Field")));
        ogE.addElement(new OptionsGruppeEintrag("Mega-Charga", getPts("Mega-Charga")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
