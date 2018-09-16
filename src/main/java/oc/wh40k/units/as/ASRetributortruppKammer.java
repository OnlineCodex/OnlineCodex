package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class ASRetributortruppKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkBoss;
	OptionsEinzelUpgrade immo;
	OptionsUpgradeGruppe immoWeapons;

	public ASRetributortruppKammer() {}

	public void initButtons(boolean... defaults) {
		name = "Retributortrupp\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Retributor-Schwestern", 5, 10, 12);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASRetributortrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("4 Schwerer Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("4 Multimelter", 40));
		ogE.addElement(new OptionsGruppeEintrag("4 Schwerer Flamer", "Schwerer Flammenwerfer", 80));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", 20));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASPrioris", "Upgrade zur Prioris");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		add(immo=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Immolator", 65));
		
		seperator(10);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
				
		seperator(10);

		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter mit Brandgeschossen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter", "Synchronisierte Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
		add(immoWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        if(!immo.isSelected()) immo.setSelected(true);
        
        if(!o1.isSelected()) o1.setSelected(0,true);
        
        immoWeapons.setSelected(0, false);
        immoWeapons.setSelected(1, false);
        immoWeapons.setSelected(2, false);
        immoWeapons.setSelected(o1.getSelectedIndex(), true);
        
        
        
	}

}
