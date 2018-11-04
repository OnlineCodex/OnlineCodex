package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHBloodSlaughtererofKhorne extends Eintrag {
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    AnzahlPanel squad;

    public CHBloodSlaughtererofKhorne() {
        name = "Blood Slaughterer of Khorne";
        grundkosten = getPts("Blood Slaughterer of Khorne");

        ogE.addElement(new OptionsGruppeEintrag("Slaughter blade", getPts("Slaughter blade")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Impaler harpoon", getPts("Impaler harpoon")));
        ogE.addElement(new OptionsGruppeEintrag("Slaughter blade", getPts("Slaughter blade")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
