package oc.wh40k.units.im;

import java.util.Iterator;
import java.util.Vector;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class IMDeathwatchVeterans extends Eintrag {//Sternguard

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

		rkVeterans=new Vector<RuestkammerStarter>();
		rkSergeant=new Vector<RuestkammerStarter>();
		rkBlackshield=new Vector<RuestkammerStarter>();
		rkTerminators=new Vector<RuestkammerStarter>();
		rkBikers=new Vector<RuestkammerStarter>();
		rkVanguards=new Vector<RuestkammerStarter>();
		
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
		
		//System.out.println("numVeterans" + numVeterans + "squad.getModelle()" + squad.getModelle() + "rk.size()" + rk.size());
		
		boolean veteransChanged = numVeterans != veterans.getModelle();
		boolean sergeantChanged = numSergeant != sergeant.getModelle();
		boolean blackshieldChanged = numBlackShield != blackshield.getModelle();
		boolean termisChanged = numTerminators != terminator.getModelle();
		boolean bikerChanged = numBikers != biker.getModelle();
		boolean vanguardChanged = numVanguards != vanguard.getModelle();
		
		boolean somethingChanged = veteransChanged || sergeantChanged || blackshieldChanged || termisChanged
				|| bikerChanged || vanguardChanged;
		
		//------------Veterans
		if(somethingChanged)
		{
		
			if(rkVeterans.size()>0)
			{
				for(int i=rkVeterans.size();i>0;i--)
				{
					remove(rkVeterans.get(i-1));
					rkVeterans.remove(i-1);
				}
			}
			
			for(int i=0;i<veterans.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(i == 0)
				{
					y = vanguard.getPanel().getLocation().getY();
					height =  vanguard.getPanel().getSize().height + 5;
				}
				else
				{
					if(rkVeterans.size() > 0)
					{
						y = rkVeterans.lastElement().getPanel().getLocation().getY();
						height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
					}
				}
				
				rkVeterans.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Veteran"));
				((IMKillteamKammer)rkVeterans.lastElement().getKammer()).setType("Veteran");
				rkVeterans.lastElement().initKammer();
				rkVeterans.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
				add(rkVeterans.lastElement());	
				rkVeterans.lastElement().setAbwaehlbar(false);

				rkVeterans.lastElement().getPanel().setLocation(
					(int) rkVeterans.lastElement().getPanel().getLocation().getX(),
					(int) (y + height)
				);
			}
		
			numVeterans = veterans.getModelle();
			//------------Veterans
			
			//------------Sergeant	
			if(rkSergeant.size()>0)
			{
				for(int i=rkSergeant.size();i>0;i--)
				{
					remove(rkSergeant.get(i-1));
					rkSergeant.remove(i-1);
				}
			}
			
			for(int i=0;i<sergeant.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(rkVeterans.size() > 0)
				{
					y = rkVeterans.lastElement().getPanel().getLocation().getY();
					height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
				}
				
				rkSergeant.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Sergeant"));
				((IMKillteamKammer)rkSergeant.lastElement().getKammer()).setType("Sergeant");
				rkSergeant.lastElement().initKammer();
				rkSergeant.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
				add(rkSergeant.lastElement());	
				rkSergeant.lastElement().setAbwaehlbar(false);
				
				rkSergeant.lastElement().getPanel().setLocation(
					(int) rkSergeant.lastElement().getPanel().getLocation().getX(),
					(int) (y + height)
				);
			}
			
			numSergeant = sergeant.getModelle();
			//------------Sergeant
			
			//------------Blackshield	
			if(rkBlackshield.size()>0)
			{
				for(int i=rkBlackshield.size();i>0;i--)
				{
					remove(rkBlackshield.get(i-1));
					rkBlackshield.remove(i-1);
				}
			}
			
			for(int i=0;i<blackshield.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(rkVeterans.size() > 0)
				{
					y = rkVeterans.lastElement().getPanel().getLocation().getY();
					height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
				}
				
				if(rkSergeant.size() > 0)
				{
					y = rkSergeant.lastElement().getPanel().getLocation().getY();
					height =  rkSergeant.lastElement().getPanel().getSize().height + 5;
				}
				
				rkBlackshield.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Blackshield"));
				((IMKillteamKammer)rkBlackshield.lastElement().getKammer()).setType("Veteran");
				rkBlackshield.lastElement().initKammer();
				rkBlackshield.lastElement().setGrundkosten(getPts("Deathwatch Veterans"));
				add(rkBlackshield.lastElement());	
				rkBlackshield.lastElement().setAbwaehlbar(false);
				
				rkBlackshield.lastElement().getPanel().setLocation(
					(int) rkBlackshield.lastElement().getPanel().getLocation().getX(),
					(int) (y + height)
				);
			}
			
			numBlackShield = blackshield.getModelle();
			//------------Blackshield
			
			//------------Terminators
			if(rkTerminators.size()>0)
			{
				for(int i=rkTerminators.size();i>0;i--)
				{
					remove(rkTerminators.get(i-1));
					rkTerminators.remove(i-1);
				}
			}
			
			for(int i=0;i<terminator.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(rkVeterans.size() > 0)
				{
					y = rkVeterans.lastElement().getPanel().getLocation().getY();
					height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
				}
				
				if(rkSergeant.size() > 0)
				{
					y = rkSergeant.lastElement().getPanel().getLocation().getY();
					height =  rkSergeant.lastElement().getPanel().getSize().height + 5;
				}

				if(rkBlackshield.size() > 0)
				{
					y = rkBlackshield.lastElement().getPanel().getLocation().getY();
					height =  rkBlackshield.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkTerminators.size() > 0)
				{
					y = rkTerminators.lastElement().getPanel().getLocation().getY();
					height =  rkTerminators.lastElement().getPanel().getSize().height + 5;
				}
				
				rkTerminators.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Terminator"));
				((IMKillteamKammer)rkTerminators.lastElement().getKammer()).setType("Terminator");
				rkTerminators.lastElement().initKammer();
				rkTerminators.lastElement().setGrundkosten(getPts("Terminator Squad"));
				add(rkTerminators.lastElement());	
				rkTerminators.lastElement().setAbwaehlbar(false);
				
				rkTerminators.lastElement().getPanel().setLocation(
						(int) rkTerminators.lastElement().getPanel().getLocation().getX(),
						(int) (y + height)
					);
			}
			
			numTerminators = terminator.getModelle();
			//------------Terminators
			
			//------------Bikers
			if(rkBikers.size()>0)
			{
				for(int i=rkBikers.size();i>0;i--)
				{
					remove(rkBikers.get(i-1));
					rkBikers.remove(i-1);
				}
			}

			for(int i=0;i<biker.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(rkVeterans.size() > 0)
				{
					y = rkVeterans.lastElement().getPanel().getLocation().getY();
					height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
				}
				
				if(rkSergeant.size() > 0)
				{
					y = rkSergeant.lastElement().getPanel().getLocation().getY();
					height =  rkSergeant.lastElement().getPanel().getSize().height + 5;
				}

				if(rkBlackshield.size() > 0)
				{
					y = rkBlackshield.lastElement().getPanel().getLocation().getY();
					height =  rkBlackshield.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkTerminators.size() > 0)
				{
					y = rkTerminators.lastElement().getPanel().getLocation().getY();
					height =  rkTerminators.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkBikers.size() > 0)
				{
					y = rkBikers.lastElement().getPanel().getLocation().getY();
					height =  rkBikers.lastElement().getPanel().getSize().height + 5;
				}	
				
				rkBikers.add(new RuestkammerStarter(ID, randAbstand, cnt, "IMKillteamKammer", "Biker"));
				((IMKillteamKammer)rkBikers.lastElement().getKammer()).setType("Biker");
				rkBikers.lastElement().initKammer();
				rkBikers.lastElement().setGrundkosten(getPts("Deathwatch Bikers"));
				add(rkBikers.lastElement());	
				rkBikers.lastElement().setAbwaehlbar(false);
				
				rkBikers.lastElement().getPanel().setLocation(
						(int) rkBikers.lastElement().getPanel().getLocation().getX(),
						(int) (y + height)
					);
			}
			
			numBikers = biker.getModelle();
			//------------Bikers
			
			//------------Vanguards
			if(rkVanguards.size()>0)
			{
				for(int i=rkVanguards.size();i>0;i--)
				{
					remove(rkVanguards.get(i-1));
					rkVanguards.remove(i-1);
				}
			}
			
			for(int i=0;i<vanguard.getModelle();i++)
			{
				double y = 0;
				double height = 0;
				
				if(rkVeterans.size() > 0)
				{
					y = rkVeterans.lastElement().getPanel().getLocation().getY();
					height =  rkVeterans.lastElement().getPanel().getSize().height + 5;
				}
				
				if(rkSergeant.size() > 0)
				{
					y = rkSergeant.lastElement().getPanel().getLocation().getY();
					height =  rkSergeant.lastElement().getPanel().getSize().height + 5;
				}

				if(rkBlackshield.size() > 0)
				{
					y = rkBlackshield.lastElement().getPanel().getLocation().getY();
					height =  rkBlackshield.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkTerminators.size() > 0)
				{
					y = rkTerminators.lastElement().getPanel().getLocation().getY();
					height =  rkTerminators.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkBikers.size() > 0)
				{
					y = rkBikers.lastElement().getPanel().getLocation().getY();
					height =  rkBikers.lastElement().getPanel().getSize().height + 5;
				}	
				
				if(rkVanguards.size() > 0)
				{
					y = rkVanguards.lastElement().getPanel().getLocation().getY();
					height =  rkVanguards.lastElement().getPanel().getSize().height + 5;
				}	
				
				rkVanguards.add(new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "Vanguard"));
				((DeathWatchKammer)rkVanguards.lastElement().getKammer()).setType("Vanguard Veteran");
				rkVanguards.lastElement().initKammer();
				rkVanguards.lastElement().setGrundkosten(getPts("Deathwatch Vanguard Veterans"));
				add(rkVanguards.lastElement());	
				rkVanguards.lastElement().setAbwaehlbar(false);
				
				rkVanguards.lastElement().getPanel().setLocation(
						(int) rkVanguards.lastElement().getPanel().getLocation().getX(),
						(int) (y + height)
					);
			}

			
			numVanguards = vanguard.getModelle();
			//-----------Vanguards
		}
		
		super.refreshAction();
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
