package oc.wh40k.units.kd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class KDBerzerkers extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe ikone;
	OptionsZaehlerGruppe o7;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
	OptionsZaehlerGruppe kettenäxte;
    
	public KDBerzerkers() {
		//name = "Khorne-Berserker\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Berzerkers", 8, 20, 19);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
			
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ikone des Zorns", 15));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kettenäxte", "Kettenäxte", 3));
		add(kettenäxte = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "KDAspiringChampion", "Berzerker Champion",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		champion.initKammer(false,false,false, false, false, true);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		champion.setGrundkosten(10);
		add(champion);
		champion.setAbwaehlbar(false);
		seperator();
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "KDTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}

	@Override
    public void deleteYourself() {
        super.deleteYourself();
    }
	
	@Override
	public void refreshen() {
        if(!champion.isSelected()) champion.setSelected(true);

		chaosTransport.getPanel().setLocation(
			(int) chaosTransport.getPanel().getLocation().getX(),
			(int) chaosTransport.getPanel().getLocation().getY() + chaosTransport.getPanel().getSize().height + 5
		);
		
		chaosTransport.getPanel().setLocation(
				(int) chaosTransport.getPanel().getLocation().getX(),
				(int) champion.getPanel().getLocation().getY() + champion.getPanel().getSize().height + 5
	    );
		
		int subtractor = 1; // Schädelchampion
		kettenäxte.setMaxAnzahl(squad.getModelle() - subtractor);
	}
}
