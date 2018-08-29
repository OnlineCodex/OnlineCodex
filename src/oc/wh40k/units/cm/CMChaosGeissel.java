package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CMChaosGeissel extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter ausruestung;

	public CMChaosGeissel() {
		name = "Chaos-Geissel";
		grundkosten = 195;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosDefiler.gif"));
		
		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfgeschütz", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energie-Peitsche", 25));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", "Zwillingsmaschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisiewrte Laserkanone", 20));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setSelected(0, true);

		seperator();
				
		ausruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMFahrzeugruestkammer", "Ausrüstung");
		ausruestung.initKammer(false);
		ausruestung.setButtonText("Ausrüstung");
		add(ausruestung);
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setSelected(true);
		if(!o2.isSelected()) o2.setSelected(0, true);
		if(!o3.isSelected()) o3.setSelected(0, true);
	}

}
