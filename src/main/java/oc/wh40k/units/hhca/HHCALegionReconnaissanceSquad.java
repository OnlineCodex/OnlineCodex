package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionReconnaissanceSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o2Standard;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;

	public HHCALegionReconnaissanceSquad() {
		name = "Legion Reconnaissance Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chameleoline", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Recon armour", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(o2Standard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, true, false, false, false, false, false);
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
        
		o1.setPreis(1, squad.getModelle()*5);
		o1.setPreis(2, squad.getModelle()*5);
		
		int subtractor = 1; // boss        
        o2.setMaxAnzahl(squad.getModelle()-subtractor);
        o2Standard.setMaxAnzahl(squad.getModelle()-subtractor-o2.getAnzahl());
		o2Standard.setAnzahl(0,o2Standard.getMaxAnzahl());
		
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
