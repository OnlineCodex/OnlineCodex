package oc.wh40k.units.cs;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CSThousandSons extends Eintrag {

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
    RuestkammerStarter chaosTransport;
	OptionsZaehlerGruppe kettenäxte;
    
	public CSThousandSons() {
		//name = "Thousand Sons\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Thousand Sons", 5, 20, 23);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone der Flammen", 15));
		
		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSChampion", "Aufstrebender Hexer");
		champion.initKammer(false, true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		champion.setGrundkosten(35);
		add(champion);
		champion.setAbwaehlbar(false);
		
		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CSTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		
        if(!champion.isSelected()) champion.setSelected(true);
		
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
	}
}
