package oc.wh40k.units.hhca;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class HHCALegionJetbikeSkyHunterSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o1, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public HHCALegionJetbikeSkyHunterSquadron() {
		name = "Legion Jetbike Sky Hunter Squadron Squad\n";
		grundkosten = 30;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sky Hunter", 3, 10, 35);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Culvarin", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HHCASergeant", "Sky Hunter Sergeant");
		rkBoss.setGrundkosten(15);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, true, false, false, false, false, false, false, false, false, false, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
        
		o1.setPreis(0, squad.getModelle()*5);
		
		o2.setMaxAnzahl(squad.getModelle()/3);
	}

}
