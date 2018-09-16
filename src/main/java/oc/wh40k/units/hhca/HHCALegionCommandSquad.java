package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionCommandSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o1b, o2, o4, o5, o6, o8;
	OptionsZaehlerGruppe o3, o4a, o4b;
	OptionsZaehlerGruppe o7a;
	OptionsZaehlerGruppe o7aStandard;
	OptionsZaehlerGruppe o7b;
	OptionsZaehlerGruppe o7bStandard;
	OptionsZaehlerGruppe o7c;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportDreadclaw;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;

	public HHCALegionCommandSquad() {
		name = "Legion Command Squad";
		grundkosten = 40;
		this.setEintragsCNT(0);
		        
		addToInformationVector("HHCALegionCommandSquad", 1);

		seperator();
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chosen", 3, 5, 20);
		add(squad);

		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Legion Standard Bearer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Grenade harness", 10));
		add(o1b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 5));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o4a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o4b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 15));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 20));
		ogE.addElement(new OptionsGruppeEintrag("Legion Jetbike", 35));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 15));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", "Cataphractii Terminator armour", 15));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Power weapon"), 0));
		add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 5));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 10));
		add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		add(o7bStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
		ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 15));
		add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();			
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", 15));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
		
		if(!o1.isSelected()) o1.setSelected(0, true);
		o1b.setAktiv(o6.isSelected());
		o2.setAktiv(0, !o6.isSelected());
		o3.setAktiv(!o6.isSelected());
		o4a.setAktiv(!o6.isSelected());
		o4b.setAktiv(!o6.isSelected());
		o5.setAktiv(!o6.isSelected());
		
		o7a.setAktiv(o6.isSelected());
		o7aStandard.setAktiv(o6.isSelected());
		o7b.setAktiv(o6.isSelected());
		o7bStandard.setAktiv(o6.isSelected());
		o7c.setAktiv(o6.isSelected());
		o8.setAktiv(o6.isSelected());
		
		o3.setMaxAnzahl(squad.getModelle());
		o4a.setMaxAnzahl(squad.getModelle());
		o4b.setMaxAnzahl(squad.getModelle()-1);
		
		o5.setPreis(0, squad.getModelle() * 15);
        o5.setPreis(1, squad.getModelle() * 20);
        o5.setPreis(2, squad.getModelle() * 35);
        o6.setPreis(0, squad.getModelle() * 15);
        o6.setPreis(1, squad.getModelle() * 15);
		
		int nksubractor=(o7a.getAnzahl()>o8.getAnzahl()?o7a.getAnzahl():o8.getAnzahl());
        
        o7b.setMaxAnzahl(squad.getModelle()-o7c.getAnzahl()-o8.getAnzahl());
		o7a.setMaxAnzahl(squad.getModelle()-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-o7a.getAnzahl()-o7c.getAnzahl());
		o7bStandard.setMaxAnzahl(squad.getModelle()-o7b.getAnzahl()-o7c.getAnzahl()-o8.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
		o7bStandard.setAnzahl(0,o7bStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-(nksubractor>o7b.getAnzahl()?nksubractor:o7b.getAnzahl()));
		
		
		
		int maxAnzahl=1;
		
		o8.setMaxAnzahl(maxAnzahl);
		
		int offeneFKOptionen=squad.getModelle()-o7b.getAnzahl()-o7c.getAnzahl();
		if(maxAnzahl>0 && offeneFKOptionen<2){
			o8.setMaxAnzahl(offeneFKOptionen);
		}


		int selectedSquads = getCountFromInformationVector("HHCALegionCommandSquad");
		int possibleSquads = getCountFromInformationVector("HHCAPraetor");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Command Squads > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
		
		rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()         		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 3);
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()         		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 1);
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportProteus.isSelected()        		
        		&& !rkTransportDreadclaw.isSelected() 
        		&& getCountFromInformationVector("HHCARoW") == 2);
        
        rkTransportProteus.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportRhino.isSelected()        		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") == 2);
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()        		
        		&& !rkTransportDreadclaw.isSelected()
        		&& getCountFromInformationVector("HHCARoW") != 1
        		&& getCountFromInformationVector("HHCARoW") != 3);
        
        rkTransportDreadclaw.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()        		
        		&& !rkTransportRhino.isSelected());
        
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

	@Override
	public void deleteYourself() {
		addToInformationVector("HHCALegionCommandSquad", -1);
		super.deleteYourself();
	}

}
