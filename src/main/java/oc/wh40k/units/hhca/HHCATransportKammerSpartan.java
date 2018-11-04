package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCATransportKammerSpartan extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3, o4;

    public HHCATransportKammerSpartan() {
        grundkosten = 295;
    }

    public void initButtons(boolean... defaults) {


        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Quad lascannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("Laser destroyers", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
        ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
        ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
        ogE.addElement(new OptionsGruppeEintrag("Flare shield", 25));
        ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);
    }

}