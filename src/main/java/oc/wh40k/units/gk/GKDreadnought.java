package oc.wh40k.units.gk;

import oc.*;

public class GKDreadnought extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    RuestkammerStarter rkPod;
    OptionsEinzelUpgrade vd;

    public GKDreadnought() {
        name = "Dreadnought";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected("multi-melta", true);

        seperator(8);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        seperator();

        add(vd = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Venerable Dreadnought", 25));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected("Sturmbolter", true);
        }

        if (!o2.isSelected()) {
            o2.setSelected("Multimelter", true);
        }

        if (!o3.isSelected()) {
            o3.setSelected("Energiefaust", true);
        }

        o1.setAktiv(o3.isSelected("Energiefaust"));
    }

}
