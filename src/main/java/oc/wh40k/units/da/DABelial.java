package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DABelial extends Eintrag {

    OptionsUpgradeGruppe o1;
    boolean troopAdd = false;

    public DABelial() {
        name = "Belial, Meister des Deathwing";
        grundkosten = 190;

        add(ico = new oc.Picture("oc/wh40k/images/DABelial.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwert der Stille", "Schwert der Stille und Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", "Energiehammer und Sturmschild", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        complete();
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (!o1.isSelected()) o1.setSelected(0, true);
    }

}
