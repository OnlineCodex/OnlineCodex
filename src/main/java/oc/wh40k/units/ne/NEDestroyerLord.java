package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NEDestroyerLord extends Eintrag {

    OptionsUpgradeGruppe o1;

    public NEDestroyerLord() {

        name = "Destroyer Lord";
        grundkosten = getPts("Destroyer Lord");

        add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Resurrection orb", getPts("Resurrection orb")));
        ogE.addElement(new OptionsGruppeEintrag("Phylactery", getPts("Phylactery")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        power = 7;
    }

}
