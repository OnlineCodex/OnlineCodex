package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class HHCALegionHeavySupportSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;

	public HHCALegionHeavySupportSquad() {
		name = "Legion Heavy Support Squad\n";
		grundkosten = 35;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 20);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hardened armour", 25));
		ogE.addElement(new OptionsGruppeEintrag("Flakk missiles", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auto-cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Culverin", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, true, false, false, false, false, false, false, false);
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

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        if(!o2.isSelected()) o2.setSelected(0, true);
        
        o1.setAktiv(1, o2.isSelected(3));
        
        o2.setPreis(2, (squad.getModelle()-1) * 5);
        o2.setPreis(3, (squad.getModelle()-1) * 5);
        o2.setPreis(4, (squad.getModelle()-1) * 10);
        o2.setPreis(5, (squad.getModelle()-1) * 15);
        o2.setPreis(6, (squad.getModelle()-1) * 10);
        o2.setPreis(7, (squad.getModelle()-1) * 20);
        
        rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 3);
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 1);
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 2);
        
        rkTransportProteus.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportRhino.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 2);
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3);
        
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
	}

}
