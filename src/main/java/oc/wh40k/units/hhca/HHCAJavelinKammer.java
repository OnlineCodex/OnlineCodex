package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCAJavelinKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3;
    OptionsZaehlerGruppe o4;

    public HHCAJavelinKammer() {
        grundkosten = 75;
    }

    public void initButtons(boolean... defaults) {


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin-linked cyclone", "Twin-linked cyclone missile launcher", 0));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Searchlight", 1));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 5));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        seperator();

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);


    }

}