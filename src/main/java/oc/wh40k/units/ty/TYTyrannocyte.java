package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTyrannocyte extends Eintrag {

    private final OptionsUpgradeGruppe o1;

    public TYTyrannocyte() {
        grundkosten = getPts("Tyrannocyte");
        name = "Tyrannocyte";
        power = 7;
        add(ico = new oc.Picture("oc/wh40k/images/TYLandungsspore.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("5 Deathspitters", getPts("Deathspitter") * 5));
        ogE.addElement(new OptionsGruppeEintrag("5 Barbed Stranglers", getPts("Barbed Strangler") * 5));
        ogE.addElement(new OptionsGruppeEintrag("5 Venom cannons", getPts("Venom cannon") * 5));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
