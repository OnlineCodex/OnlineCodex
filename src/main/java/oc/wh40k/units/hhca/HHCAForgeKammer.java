package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCAForgeKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3;
    OptionsZaehlerGruppe o4, o5;

    public HHCAForgeKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
        ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
        ogE.addElement(new OptionsGruppeEintrag("Master-crafted bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
        ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
        ;
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rad grenades", 10));
        ogE.addElement(new OptionsGruppeEintrag("Cyber familiar", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Servo-arm", 0));
        ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Servo-automata", 12));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Lascutter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));


        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (!o3.isSelected()) o3.setSelected(0, true);

        o5.setMaxAnzahl(o4.getAnzahl());


    }


}
