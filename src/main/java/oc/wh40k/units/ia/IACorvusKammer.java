package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsSeperator;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class IACorvusKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

    public IACorvusKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

		name = "Corvus Blackstar";
		grundkosten = 180;

		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		add(ico = new oc.Picture("oc/wh40k/images/Stormtalon.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("4 Sturmschlagraketen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blackstar-Raketenwerfer", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hurricane Bolter", 15));
		
		seperator();
			
		ogE.addElement(new OptionsGruppeEintrag("Infernum Halo Launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Auspex array", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
        sizeSetzen();
    }

    @Override
    public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
    }
    
}
