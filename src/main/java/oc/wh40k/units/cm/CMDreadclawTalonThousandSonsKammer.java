package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMDreadclawTalonThousandSonsKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
	OptionsZaehlerGruppe kettenäxte;

	public CMDreadclawTalonThousandSonsKammer() {}
	
	public void initButtons(boolean... defaults) {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Thousand Sons", 5, 20, 23);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Flammen", 15));
		
		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Aufstrebender Hexer");
		champion.initKammer(false, true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		champion.setGrundkosten(35);
		add(champion);
		champion.setAbwaehlbar(false);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!champion.isSelected()) champion.setSelected(true);
	}

}
