package oc.wh40k.units.hhca;

import oc.*;

public class HHCATransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe rhinoWeapons;
    OptionsPanelSwitcher switcher;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    boolean offerRhino = false;
    boolean offerDropPod = false;
    boolean offerDread = false;
    boolean offerRaider = false;
    boolean offerSpartan = false;

    public HHCATransporterKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        this.offerRhino = defaults[0];
        this.offerDropPod = defaults[1];
        this.offerDread = defaults[2];
        this.offerRaider = defaults[3];
        this.offerSpartan = defaults[4];

        if (this.offerRhino) {
            ogE.addElement(new OptionsGruppeEintrag("Rhino", 35));
        }
        if (this.offerDropPod) {
            ogE.addElement(new OptionsGruppeEintrag("Drop Pod", 35));
        }
        if (this.offerDread) {
            ogE.addElement(new OptionsGruppeEintrag("Dreadclaw", 85));
        }
        if (this.offerRaider) {
            ogE.addElement(new OptionsGruppeEintrag("Land Raider Phobos", 250));
        }
        if (this.offerSpartan) {
            ogE.addElement(new OptionsGruppeEintrag("Spartan Assault Tank", 295));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        OptionsVater[] rhino = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10)
        };


        OptionsVater[] pod = new OptionsVater[]{
        };


        OptionsVater[] dread = new OptionsVater[]{
        };


        OptionsVater[] raider = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 20),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag assault launchers", 10)
        };


        OptionsVater[] spartan = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Laser destroyers", 0),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked heavy flamer", 0),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 20),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare shield", 25),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag assault launchers", 10)
        };

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, pod, dread, raider, spartan));

        // If Rhino should be available, offer weapons for selection
        if (offerRhino || offerRaider || offerSpartan) {
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
            ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
            add(rhinoWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (typ.isSelected("Rhino")) {
            switcher.forceSwitchPanel(0);
        } else if (typ.isSelected("Drop Pod")) {
            switcher.forceSwitchPanel(1);
        } else if (typ.isSelected("Dreadclaw")) {
            switcher.forceSwitchPanel(2);
        } else if (typ.isSelected("Land Raider Phobos")) {
            switcher.forceSwitchPanel(3);
        } else {
            switcher.forceSwitchPanel(4);
        }

        if (offerRhino || offerRaider || offerSpartan) {
            rhinoWeapons.setAktiv(typ.isSelected("Rhino") || typ.isSelected("Land Raider Phobos") || typ.isSelected("Spartan Assault Tank"));

            rhinoWeapons.getPanel().setLocation(
                    (int) switcher.getPanel().getLocation().getX(),
                    (int) switcher.getPanel().getLocation().getY() + switcher.getPanel().getSize().height + 8
            );

            if (typ.isSelected("Land Raider Phobos") || typ.isSelected("Spartan Assault Tank")) {
                rhinoWeapons.setAktiv("Multi-melta", true);
            } else {
                rhinoWeapons.setAktiv("Multi-melta", false);
            }

        }


    }

}
