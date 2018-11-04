package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCAApothecaryKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3;

    public HHCAApothecaryKammer() {
        grundkosten = 45;
    }

    public void initButtons(boolean... defaults) {


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ;
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

    }

}