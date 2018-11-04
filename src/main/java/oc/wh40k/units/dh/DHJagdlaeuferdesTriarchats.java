package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DHJagdlaeuferdesTriarchats extends Eintrag {

    OptionsUpgradeGruppe o1;

    public DHJagdlaeuferdesTriarchats() {
        name = "Jagdläufer des Triarchats";
        grundkosten = 150;

        add(ico = new oc.Picture("oc/wh40k/images/NEJagdlaeuferdesTriarchats.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hitzestrahler", 0));
        ogE.addElement(new OptionsGruppeEintrag("Partikelkanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Gauss-Kanone", "Synchronisierte Schwere Gauss-Kanone", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
