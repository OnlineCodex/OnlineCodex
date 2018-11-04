package oc.wh40k.units.hhca;

import oc.*;

public class HHCATechmarineKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o3, o4;
    OptionsZaehlerGruppe o5, o6;
    RuestkammerStarter rkTransportEagle;
    RuestkammerStarter rkTransportPhobos;
    RuestkammerStarter rkTransportPod;
    RuestkammerStarter rkTransportProteus;
    RuestkammerStarter rkTransportRhino;

    public HHCATechmarineKammer() {
        grundkosten = 45;
    }

    public void initButtons(boolean... defaults) {


        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 15));
        ;
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
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
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rad grenades", 10));
        ogE.addElement(new OptionsGruppeEintrag("Cyber familiar", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Servo-arm", 0));
        ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", 35));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Servo-automata", 12));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        ogE.addElement(new OptionsGruppeEintrag("Lascutter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
        add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        seperator();
        rkTransportPod = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPod", "Legion Drop Pod\n");
        rkTransportPod.initKammer();
        rkTransportPod.setButtonText("Legion Drop Pod");
        add(rkTransportPod);

        seperator();
        rkTransportEagle = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerEagle", "Legion Storm Eagle Assault Gunship\n");
        rkTransportEagle.initKammer();
        rkTransportEagle.setButtonText("Legion Storm Eagle Assault Gunship");
        add(rkTransportEagle);

        seperator();
        rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPhobos", "Legion Land Raider Phobos\n");
        rkTransportPhobos.initKammer();
        rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
        add(rkTransportPhobos);

        seperator();
        rkTransportProteus = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerProteus", "Legion Land Raider Proteus\n");
        rkTransportProteus.initKammer();
        rkTransportProteus.setButtonText("Legion Land Raider Proteus");
        add(rkTransportProteus);

        seperator();
        rkTransportRhino = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerRhino", "Legion Rhino Armoured Carrier\n");
        rkTransportRhino.initKammer();
        rkTransportRhino.setButtonText("Legion Rhino Armoured Carrier");
        add(rkTransportRhino);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o4.isSelected()) o4.setSelected(0, true);

        o6.setMaxAnzahl(o5.getAnzahl());

        rkTransportPod.setAktiv(!rkTransportRhino.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") == 3);

        rkTransportEagle.setAktiv(!rkTransportPod.isSelected()
                && !rkTransportRhino.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") == 1);

        rkTransportPhobos.setAktiv(!rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportRhino.isSelected()
                && !rkTransportProteus.isSelected()
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") == 2);

        rkTransportProteus.setAktiv(!rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportRhino.isSelected()
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") == 2);

        rkTransportRhino.setAktiv(!rkTransportPod.isSelected()
                && !rkTransportEagle.isSelected()
                && !rkTransportPhobos.isSelected()
                && !rkTransportProteus.isSelected()
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") != 1
                && BuildaHQ.aktBuildaVater.getCountFromInformationVector("HHCARoW") != 3);

        rkTransportEagle.getPanel().setLocation(
                (int) rkTransportEagle.getPanel().getLocation().getX(),
                (int) rkTransportPod.getPanel().getLocation().getY() + rkTransportPod.getPanel().getSize().height + 5
        );

        rkTransportPhobos.getPanel().setLocation(
                (int) rkTransportPhobos.getPanel().getLocation().getX(),
                (int) rkTransportEagle.getPanel().getLocation().getY() + rkTransportEagle.getPanel().getSize().height + 5
        );

        rkTransportProteus.getPanel().setLocation(
                (int) rkTransportProteus.getPanel().getLocation().getX(),
                (int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
        );

        rkTransportRhino.getPanel().setLocation(
                (int) rkTransportRhino.getPanel().getLocation().getX(),
                (int) rkTransportProteus.getPanel().getLocation().getY() + rkTransportProteus.getPanel().getSize().height + 5
        );
    }

}