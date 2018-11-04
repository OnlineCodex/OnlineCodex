package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYSporocyst extends Eintrag {

    OptionsUpgradeGruppe o1;

    public TYSporocyst() {
        grundkosten = getPts("Sporocyst");
        name = "Sporocyst";
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/TYLandungsspore.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("5 Deathspitters", getPts("Deathspitter") * 5));
        ogE.addElement(new OptionsGruppeEintrag("5 Barbed Stranglers", getPts("Barbed Strangler") * 5));
        ogE.addElement(new OptionsGruppeEintrag("5 Venom cannons", getPts("Venom cannon") * 5));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
