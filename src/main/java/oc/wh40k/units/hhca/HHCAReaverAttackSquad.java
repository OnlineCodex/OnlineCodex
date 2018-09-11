package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCAReaverAttackSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o5;
	OptionsZaehlerGruppe o2, o3, o4a, o4;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;
	RuestkammerStarter rkTransportDreadclaw;

	public HHCAReaverAttackSquad() {
		name = "Reaver Attack Squad\n";
		grundkosten = 60;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Reavers", 5, 15, 15);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Jump packs", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", "Boltgun with Banestrike shells", 5));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", "Combi-flamer with Banestrike shells", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", "Combi-melta with Banestrike shells", 10));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", "Combi-plasma with Banestrike shells", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		add(o4a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Chain axe", 1));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Reaver Chieftain");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, true, false, false, false, false, false, false);
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
		rkTransportProteus = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerProteus", "Legion Land Raider Proteus\n");
		rkTransportProteus.initKammer();
		rkTransportProteus.setButtonText("Legion Land Raider Proteus");
		add(rkTransportProteus);

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
                
		o2.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() -1);
		o3.setMaxAnzahl(squad.getModelle() /5);
		o4a.setMaxAnzahl(squad.getModelle() - o4.getAnzahl() -1);
		o4a.setAnzahl(0, o4a.getMaxAnzahl());
		o4.setMaxAnzahl(squad.getModelle() -1);	      
        
        rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& !rkTransportDreadclaw.isSelected()  
        		&& getCountFromInformationVector("HHCARoW") == 3
        		&& !o1.isSelected());
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& !rkTransportDreadclaw.isSelected()  
        		&& getCountFromInformationVector("HHCARoW") == 1
                && !o1.isSelected());
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& !rkTransportDreadclaw.isSelected()  
        		&& getCountFromInformationVector("HHCARoW") == 2
                && !o1.isSelected());
        
        rkTransportProteus.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportRhino.isSelected()
        		&& !rkTransportDreadclaw.isSelected()  
        		&& getCountFromInformationVector("HHCARoW") == 2
                && !o1.isSelected());
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()
        		&& !rkTransportDreadclaw.isSelected()  
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3
                && !o1.isSelected());
        
        rkTransportDreadclaw.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()      		
        		&& !rkTransportRhino.isSelected()
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3
                && !o1.isSelected());
		
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
        
        rkTransportProteus.getPanel().setLocation(
				(int) rkTransportProteus.getPanel().getLocation().getX(),
				(int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
		);
        
        rkTransportRhino.getPanel().setLocation(
				(int) rkTransportRhino.getPanel().getLocation().getX(),
				(int) rkTransportProteus.getPanel().getLocation().getY() + rkTransportProteus.getPanel().getSize().height + 5
	    );
        
        rkTransportDreadclaw.getPanel().setLocation(
				(int) rkTransportDreadclaw.getPanel().getLocation().getX(),
				(int) rkTransportRhino.getPanel().getLocation().getY() + rkTransportRhino.getPanel().getSize().height + 5
	    );
		
	}

}
