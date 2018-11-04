package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMContemptorDreadnought extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public SMContemptorDreadnought() {
        name = "Contemptor Dreadnought";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Sbolter", "Cybot-Nahkampfwaffe + Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + Schwerer Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 20));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Graviton Bl", "Cybot-Nahkampfwaffe + Graviton Blaster", 15));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Melter", "Cybot-Nahkampfwaffe + Melter", 15));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Sbolter", "Kettenfaust + Sturmbolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + SFlamer", "Kettenfaust + Schwerer Flammenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Plasma Bl", "Kettenfaust + Plasma Blaster", 30));
        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Graviton Bl", "Kettenfaust + Graviton Blaster", 25));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannon", "Kheres Pattern Assault Cannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kheres Assault Cannon", "Kheres Pattern Assault Cannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 35));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Sbolter", "Cybot-Nahkampfwaffe + Sturmbolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + SFlamer", "Cybot-Nahkampfwaffe + Schwerer Flammenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Plasma Bl", "Cybot-Nahkampfwaffe + Plasma Blaster", 25));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Graviton Bl", "Cybot-Nahkampfwaffe + Graviton Blaster", 30));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone Missile Launcher", "Carapace-mounted Cyclone Missile Launcher", 35));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
                
               /* o1.setAktiv("Cybot-Nahkampfwaffe + Plasma Blaster", o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Kettenfaust + Plasma Blaster")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Plasma Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Kettenfaust + Plasma Blaster")));
                o2.setAktiv("Kettenfaust + Plasma Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster") || o2.isSelected("Cybot-Nahkampfwaffe + Plasma Blaster")));
                
                o1.setAktiv("Cybot-Nahkampfwaffe + Graviton Blaster", o1.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || !(o2.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || o2.isSelected("Kettenfaust + Graviton Blaster")));
                o2.setAktiv("Cybot-Nahkampfwaffe + Graviton Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || o2.isSelected("Kettenfaust + Graviton Blaster")));
                o2.setAktiv("Kettenfaust + Graviton Blaster", o2.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || !(o1.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster") || o2.isSelected("Cybot-Nahkampfwaffe + Graviton Blaster")));
                */
    }

}
