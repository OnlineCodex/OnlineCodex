package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionTerminatorSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2, o4, o7a, o7aStandard, o7b, o7bStandard, o7c, o8;
	OptionsUpgradeGruppe o1, o0;
	OptionsZaehlerGruppe o7aStandard2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportSpartan;

	public HHCALegionTerminatorSquad() {
		name = "Legion Terminator Squad\n";
		grundkosten = 25;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminators", 5, 10, 30);
		add(squad);

		seperator();	
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", "Cataphractii Terminator armour", 0));
		add(o0 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
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
		add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Terminator Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, true, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();
		rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerPhobos", "Legion Land Raider Phobos\n");
		rkTransportPhobos.initKammer();
		rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
		add(rkTransportPhobos);

		seperator();
		rkTransportSpartan = new RuestkammerStarter(ID, randAbstand, cnt, "HHCATransportKammerSpartan", "Spartan Assault Tank\n");
		rkTransportSpartan.initKammer();
		rkTransportSpartan.setButtonText("Spartan Assault Tank");
		add(rkTransportSpartan);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        int subtractor = 1; // boss
		int nksubractor=(o7a.getAnzahl()>o8.getAnzahl()?o7a.getAnzahl():o8.getAnzahl());
        
        o7b.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl()-o8.getAnzahl());
		o7a.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7a.getAnzahl()-o7c.getAnzahl());
		o7bStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7b.getAnzahl()-o7c.getAnzahl()-o8.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
		o7bStandard.setAnzahl(0,o7bStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-subtractor-(nksubractor>o7b.getAnzahl()?nksubractor:o7b.getAnzahl()));
		
		if(squad.getModelle() >= 5) {
			o8.setAktiv(true);
		} else {
			o8.setAktiv(false);
		}
		
		int maxAnzahl=squad.getModelle()/5;
		
		o8.setMaxAnzahl(maxAnzahl);
		
		int offeneFKOptionen=squad.getModelle()-1-o7b.getAnzahl()-o7c.getAnzahl();
		if(maxAnzahl>0 && offeneFKOptionen<2){
		o8.setMaxAnzahl(offeneFKOptionen);
		}
		
		rkTransportPhobos.setAktiv(squad.getModelle() <=5 && !rkTransportSpartan.isSelected()
	        	&& getCountFromInformationVector("HHCARoW") != 1);
	        
		rkTransportSpartan.setAktiv(squad.getModelle() <=10 && !rkTransportPhobos.isSelected()
	        	&& getCountFromInformationVector("HHCARoW") != 1);
	        
		rkTransportPhobos.getPanel().setLocation(
				(int) rkTransportPhobos.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	        
		rkTransportSpartan.getPanel().setLocation(
				(int) rkTransportSpartan.getPanel().getLocation().getX(),
				(int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
		);
	        
		
		
	}

}
