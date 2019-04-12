package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHBloodSlaughtererofKhorne extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;

    public CHBloodSlaughtererofKhorne() {
        name = "Blood Slaughterer of Khorne";
        grundkosten = getPts("Blood Slaughterer of Khorne");

        ogE.addElement(new OptionsGruppeEintrag("Slaughter blade", getPts("Slaughter blade")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Impaler harpoon", getPts("Impaler harpoon")));
        ogE.addElement(new OptionsGruppeEintrag("Slaughter blade", getPts("Slaughter blade")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
