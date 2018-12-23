package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class IMDeathwatchVeterans extends Eintrag {

	AnzahlPanel veterans, terminator, biker, blackshield, sergeant, vanguard;

	Vector<RuestkammerStarter> rkVeterans;
	Vector<RuestkammerStarter> rkSergeant;
	Vector<RuestkammerStarter> rkBlackshield;
	Vector<RuestkammerStarter> rkTerminators;
	Vector<RuestkammerStarter> rkBikers;
	Vector<RuestkammerStarter> rkVanguards;

	int numVeterans = 0;
	int numSergeant = 0;
	int numBlackShield = 0;
	int numTerminators = 0;
	int numBikers = 0;
	int numVanguards = 0;

	public IMDeathwatchVeterans() {
		name = "Veterans\n";
		grundkosten = 0;
		überschriftSetzen = true;

		rkVeterans = new Vector<RuestkammerStarter>();
		rkSergeant = new Vector<RuestkammerStarter>();
		rkBlackshield = new Vector<RuestkammerStarter>();
		rkTerminators = new Vector<RuestkammerStarter>();
		rkBikers = new Vector<RuestkammerStarter>();
		rkVanguards = new Vector<RuestkammerStarter>();

		veterans = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 3, 10, 0);
		veterans.setModelle(5);
		add(veterans);

		sergeant = new AnzahlPanel(ID, randAbstand, cnt, "Sergeant", 0, 1, 0);
		add(sergeant);

		blackshield = new AnzahlPanel(ID, randAbstand, cnt, "Blackshield", 0, 1, 0);
		add(blackshield);

		terminator = new AnzahlPanel(ID, randAbstand, cnt, "Terminator", 0, 5, 0);
		add(terminator);

		biker = new AnzahlPanel(ID, randAbstand, cnt, "Biker", 0, 5, 0);
		add(biker);

		vanguard = new AnzahlPanel(ID, randAbstand, cnt, "Vanguard", 0, 5, 0);
		add(vanguard);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {

		boolean veteransChanged = numVeterans != veterans.getModelle();
		boolean sergeantChanged = numSergeant != sergeant.getModelle();
		boolean blackshieldChanged = numBlackShield != blackshield.getModelle();
		boolean termisChanged = numTerminators != terminator.getModelle();
		boolean bikerChanged = numBikers != biker.getModelle();
		boolean vanguardChanged = numVanguards != vanguard.getModelle();

		boolean somethingChanged = veteransChanged || sergeantChanged || blackshieldChanged || termisChanged
				|| bikerChanged || vanguardChanged;

		double x = randAbstand;
		double y = 0.0;
		double height = 0.0;
		
		int heavyWeapons = 0;

		//------------Veterans
		if (somethingChanged) {
			if(numVeterans > veterans.getModelle()) {
				for (int i = 0; i < numVeterans - veterans.getModelle(); i++) {
					remove(rkVeterans.lastElement());
					rkVeterans.remove(rkVeterans.lastElement());
				}
			} else {
				for (int i = 0; i < veterans.getModelle() - numVeterans; i++) {
					rkVeterans.add(new RuestkammerStarter(ID, randAbstand, cnt, new IMKillteamKammer("Veteran"), "Veteran"));
					rkVeterans.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
					rkVeterans.lastElement().setAbwaehlbar(false);
					add(rkVeterans.lastElement());
				}
			}
			numVeterans = veterans.getModelle();
			//------------Veterans
			
			//------------Sergeant
			if(numSergeant > sergeant.getModelle()) {
				remove(rkSergeant.lastElement());
				rkSergeant.remove(rkSergeant.lastElement());
			} else {
				if(sergeant.getModelle() > numSergeant) {
					rkSergeant.add(new RuestkammerStarter(ID, randAbstand, cnt, new IMKillteamKammer("Sergeant"), "Sergeant"));
					rkSergeant.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
					rkSergeant.lastElement().setAbwaehlbar(false);
					add(rkSergeant.lastElement());
				}
			}

			numSergeant = sergeant.getModelle();
			//------------Sergeant

			//------------Blackshield
			if(numBlackShield > blackshield.getModelle()) {
				remove(rkBlackshield.lastElement());
				rkBlackshield.remove(rkBlackshield.lastElement());
			} else {
				if(blackshield.getModelle() > numBlackShield) {
					rkBlackshield.add(new RuestkammerStarter(ID, randAbstand, cnt, new IMKillteamKammer("Sergeant"), "Blackshield"));
					rkBlackshield.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
					rkBlackshield.lastElement().setAbwaehlbar(false);
					add(rkBlackshield.lastElement());
				}
			}

			numBlackShield = blackshield.getModelle();
			//------------Blackshield

			//------------Terminators
			if(numTerminators > terminator.getModelle()) {
				for (int i = 0; i < numTerminators - terminator.getModelle(); i++) {
					remove(rkTerminators.lastElement());
					rkTerminators.remove(rkTerminators.lastElement());
				}
			} else {
				for (int i = 0; i < terminator.getModelle() - numTerminators; i++) {
					rkTerminators.add(new RuestkammerStarter(ID, randAbstand, cnt, new IMKillteamKammer("Terminator"), "Terminator"));
					rkTerminators.lastElement().setGrundkosten(getPts("Deathwatch Terminators"));
					rkTerminators.lastElement().setAbwaehlbar(false);
					add(rkTerminators.lastElement());
				}
			}

			numTerminators = terminator.getModelle();
			//------------Terminators

			//------------Bikers

			if(numBikers > biker.getModelle()) {
				for (int i = 0; i < numBikers - biker.getModelle(); i++) {
					remove(rkBikers.lastElement());
					rkBikers.remove(rkBikers.lastElement());
				}
			} else {
				for (int i = 0; i < biker.getModelle() - numBikers; i++) {
					rkBikers.add(new RuestkammerStarter(ID, randAbstand, cnt, new IMKillteamKammer("Biker"), "Biker"));
					rkBikers.lastElement().setGrundkosten(getPts("Deathwatch Bikers") + getPts("Twin boltgun (DW)"));
					rkBikers.lastElement().setAbwaehlbar(false);
					add(rkBikers.lastElement());
				}
			}

			numBikers = biker.getModelle();
			//------------Bikers

			if(numVanguards > vanguard.getModelle()) {
				for (int i = 0; i < numVanguards - vanguard.getModelle(); i++) {
					remove(rkVanguards.lastElement());
					rkVanguards.remove(rkVanguards.lastElement());
				}
			} else {
				for (int i = 0; i < vanguard.getModelle() - numVanguards; i++) {
					rkVanguards.add(new RuestkammerStarter(ID, randAbstand, cnt, new DeathWatchKammer("Vanguard Veteran"), "Vanguard"));
					rkVanguards.lastElement().setGrundkosten(getPts("Deathwatch Vanguard Veterans"));
					rkVanguards.lastElement().setAbwaehlbar(false);
					add(rkVanguards.lastElement());
				}
			}

			numVanguards = vanguard.getModelle();
			//-----------Vanguards

			//Positionen setzen
			y = vanguard.getPanel().getLocation().getY();
			height = vanguard.getPanel().getSize().height + 5;
			for (int i = 0; i < numVeterans; i++) {
				rkVeterans.get(i).getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkVeterans.get(i).getPanel().getLocation().getY();
				height = rkVeterans.get(i).getPanel().getSize().height + 5;
			}
			for (int i = 0; i < numSergeant; i++) {
				rkSergeant.lastElement().getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkSergeant.lastElement().getPanel().getLocation().getY();
				height = rkSergeant.lastElement().getPanel().getSize().height + 5;
			}
			for (int i = 0; i < numBlackShield; i++) {
				rkBlackshield.lastElement().getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkBlackshield.lastElement().getPanel().getLocation().getY();
				height = rkBlackshield.lastElement().getPanel().getSize().height + 5;
			}
			for (int i = 0; i < numTerminators; i++) {
				rkTerminators.lastElement().getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkTerminators.lastElement().getPanel().getLocation().getY();
				height = rkTerminators.lastElement().getPanel().getSize().height + 5;
			}
			for (int i = 0; i < numBikers; i++) {
				rkBikers.lastElement().getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkBikers.lastElement().getPanel().getLocation().getY();
				height = rkBikers.lastElement().getPanel().getSize().height + 5;
			}
			for (int i = 0; i < numVanguards; i++) {
				rkVanguards.lastElement().getPanel().setLocation(
						(int) x,
						(int) (y + height)
						);
				y = rkVanguards.lastElement().getPanel().getLocation().getY();
				height = rkVanguards.lastElement().getPanel().getSize().height + 5;
			}
		}

		for (int i = 0; i < numVeterans; i++) {
			heavyWeapons+= ((IMKillteamKammer) rkVeterans.get(i).getKammer()).getO5().getAnzahl();
		}
		
		int numTotal = numBikers + numBlackShield + numSergeant + numTerminators + numVanguards + numVeterans;
		
		if(numTotal < 5) {
			setFehlermeldung("Min. 5");
		} else if(numTotal > 10) {
			setFehlermeldung("Max. 10");
		} else if(heavyWeapons > 4) {
			setFehlermeldung("Max. 4 schwere Waffen");
		} else {
			setFehlermeldung("");
		}
		
		super.refreshAction();
	}
}