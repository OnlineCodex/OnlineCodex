package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionDestroyerSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;

	public HHCALegionDestroyerSquad() {
		name = "Legion Destroyer Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Destroyer Marines", 5, 10, 20);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		ogE.addElement(new OptionsGruppeEintrag("Jump packs", 75));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher (rad)", 25));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Destroyer Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, true, false, false, false, false, false, false, false, false);
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
        if(!rkBoss.isSelected()) {rkBoss.setSelected(true);}       
                
        rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 3
        		&& !o3.isSelected("Jump packs"));
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 1
                && !o3.isSelected("Jump packs"));
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 2
                && !o3.isSelected("Jump packs"));
        
        rkTransportProteus.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportRhino.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 2
                && !o3.isSelected("Jump packs"));
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3
                && !o3.isSelected("Jump packs"));
        
		o1.setMaxAnzahl(squad.getModelle() / 5);
		
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
