package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SMChaplainDreadnought extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    RuestkammerStarter rkPod;

    public SMChaplainDreadnought() {
        name = "Chaplain Dreadnought";
        grundkosten = 135;

        add(ico = new oc.Picture("oc/wh40k/images/SMChaplainDreadnought.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Flammenkanone", "Flammensturmkanone", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 30));
        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW + Sturmbolter", "Cybot-Nahkampfwaffe + Stumbolter", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator(8);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
		rkPod.initKammer(true);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}
