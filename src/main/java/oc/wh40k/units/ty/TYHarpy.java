package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYHarpy extends Eintrag {

    OptionsUpgradeGruppe o1;

    public TYHarpy() {
        name = "Harpy";
        grundkosten = getPts("Harpy") + getPts("Scything wings") + getPts("Stinger salvo");
        power = 9;

        add(ico = new oc.Picture("oc/wh40k/images/TYHarpyie.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Stranglethorn cannons", getPts("Stranglethorn cannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy venom cannons", getPts("Heavy venom cannon") * 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);


        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
