package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HHCARaiderKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3, o4, o5;

    public HHCARaiderKammer() {
        grundkosten = 0;
    }

    public void initButtons(boolean... defaults) {


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Phobos pattern", 250));
        ogE.addElement(new OptionsGruppeEintrag("Proteus pattern", 200));
        ogE.addElement(new OptionsGruppeEintrag("Achilles pattern", 300));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
        ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
        ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
        ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
        ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
        ogE.addElement(new OptionsGruppeEintrag("Explorator Augury Web", 50));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 20));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy flamer", 20));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        o2.setAktiv(4, !o1.isSelected(2));
        o2.setAktiv(5, o1.isSelected(0));
        o2.setAktiv(6, o1.isSelected(1));
        o5.setAktiv(o1.isSelected(1));

    }

}