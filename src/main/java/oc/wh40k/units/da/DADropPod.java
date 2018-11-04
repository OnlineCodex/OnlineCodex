package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DADropPod extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public DADropPod() {
        name = "Drop Pod";
        grundkosten = 35;

        add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
        o2.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o2.isSelected()) o2.setSelected(0, true);
    }
}
