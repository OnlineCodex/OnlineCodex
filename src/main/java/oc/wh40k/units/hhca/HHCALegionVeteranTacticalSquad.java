package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionVeteranTacticalSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o4;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportDreadclaw;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportRhino;

	public HHCALegionVeteranTacticalSquad() {
		name = "Legion Veteran Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 5, 10, 15);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 25));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher (+flakk)", 35));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Veteran Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, false, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();
		rkTransportPod = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPod", "Legion Drop Pod\n");
		rkTransportPod.initKammer();
		rkTransportPod.setButtonText("Legion Drop Pod");
		add(rkTransportPod);

		seperator();
		rkTransportEagle = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerEagle", "Legion Storm Eagle Assault Gunship\n");
		rkTransportEagle.initKammer();
		rkTransportEagle.setButtonText("Legion Storm Eagle Assault Gunship");
		add(rkTransportEagle);

		seperator();
		rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPhobos", "Legion Land Raider Phobos\n");
		rkTransportPhobos.initKammer();
		rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
		add(rkTransportPhobos);

		seperator();
		rkTransportRhino = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerRhino", "Legion Rhino Armoured Carrier\n");
		rkTransportRhino.initKammer();
		rkTransportRhino.setButtonText("Legion Rhino Armoured Carrier");
		add(rkTransportRhino);

		seperator();
		rkTransportDreadclaw = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerDreadclaw", "Dreadclaw Drop Pod\n");
		rkTransportDreadclaw.initKammer();
		rkTransportDreadclaw.setButtonText("Dreadclaw Drop Pod");
		add(rkTransportDreadclaw);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        
		o2.setMaxAnzahl(squad.getModelle() - 1); // die 1 ist für den sarge
		o4.setMaxAnzahl(squad.getModelle() - 1);
		o1.setMaxAnzahl(squad.getModelle() / 5);
		
		rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected()        		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 3);
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected()        		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 1);
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected()      		
        		&& !rkTransportDreadclaw.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 2);
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected()       		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3);
        
        rkTransportDreadclaw.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected()   		
        		&& !rkTransportRhino.isSelected());
        
        rkTransportPod.getPanel().setLocation(
				(int) rkTransportPod.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
        
        rkTransportEagle.getPanel().setLocation(
				(int) rkTransportEagle.getPanel().getLocation().getX(),
				(int) rkTransportPod.getPanel().getLocation().getY() + rkTransportPod.getPanel().getSize().height + 5
		);
        
        rkTransportPhobos.getPanel().setLocation(
				(int) rkTransportPhobos.getPanel().getLocation().getX(),
				(int) rkTransportEagle.getPanel().getLocation().getY() + rkTransportEagle.getPanel().getSize().height + 5
		);
        
        rkTransportRhino.getPanel().setLocation(
				(int) rkTransportRhino.getPanel().getLocation().getX(),
				(int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
	    );
        rkTransportDreadclaw.getPanel().setLocation(
				(int) rkTransportDreadclaw.getPanel().getLocation().getX(),
				(int) rkTransportRhino.getPanel().getLocation().getY() + rkTransportRhino.getPanel().getSize().height + 5
	    );
	}

}
