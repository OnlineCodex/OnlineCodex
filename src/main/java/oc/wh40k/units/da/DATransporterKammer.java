package oc.wh40k.units.da;


import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DATransporterKammer extends RuestkammerVater {

	boolean rhino = false;
	boolean razorback = false;
	boolean droppod = false;
	boolean landraider = false;
	boolean deathwing = false;
	boolean nurdroppod = false;
	boolean sturmfahrzeug = false;
	int mod = 1;
	
	OptionsUpgradeGruppe razorweapon, droppodweapon, trooptrans;
	OptionsEinzelUpgrade peilsender, deathwingvehicle, multimelter;
	OptionsEinzelUpgrade o1, o2, o3, o4;

	public DATransporterKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		rhino = defaults[0];
		razorback = defaults[1];
		droppod = defaults[2];
		landraider = defaults[3];
		deathwing = defaults[4];
		sturmfahrzeug = defaults[5];

		nurdroppod=droppod && !rhino && !razorback && !landraider;
		
		seperator();
		
		if(rhino){
			ogE.addElement(new OptionsGruppeEintrag("Rhino", 35*mod));
		}
		
		if(razorback){
			ogE.addElement(new OptionsGruppeEintrag("Razorback", 55*mod));
			ogE.addElement(new OptionsGruppeEintrag("Infernum Razorback", 65));
		}
		
		if(droppod){
			ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", 35*mod));
		}
		
		if(landraider){
		ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
		}
		add(trooptrans = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		if(razorback){
			seperator();
			ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Flamer", "Syncronisierter Schwerer Flammenwerfer", 0));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Syncronisierte Sturmkanone", 20));
			ogE.addElement(new OptionsGruppeEintrag("Sync. Laser", "Syncronisierte Laserkanone", 20));
			ogE.addElement(new OptionsGruppeEintrag("Laser/sync.Plasma", "Laserkanone und synchronisierter Plasmawerfer", 20));
			add(razorweapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			razorweapon.setSelected(0, true);
			razorweapon.setAktiv(false);
		}
		
		if(droppod){
			seperator();
			ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
			ogE.addElement(new OptionsGruppeEintrag("Deathwind", "Deathwind-Raketenwerfer", 15));
			add(droppodweapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			droppodweapon.setSelected(0, true);
			droppodweapon.setAktiv(false);
			
			add(peilsender = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10));
			peilsender.setAktiv(false);
		}
		
		if(landraider){
			seperator();
			add(multimelter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
			multimelter.setAktiv(false);
			
//			if(deathwing) {
//	        	add(deathwingvehicle = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwing-Fahrzeug", 30));
//	        	deathwingvehicle.setSelected(deathwing);
//	        }
//			deathwingvehicle.setAktiv(false);
		}
		
		seperator();
		
		if(!nurdroppod){
	        if(!landraider)add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
			add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
	        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
	        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
	        if(!landraider)o1.setAktiv(false);
			o2.setAktiv(false);
			o3.setAktiv(false);
			o4.setAktiv(false);
		}
        
		sizeSetzen();

	}

	@Override
	public void refreshen() {
		if(rhino){
			trooptrans.setPreis("Rhino", 35 * mod);
		}
		
		if(razorback){
			trooptrans.setPreis("Razorback", 55 * mod);
			razorweapon.setAktiv(trooptrans.isSelected("Razorback"));
		} 
		if(droppod){
			trooptrans.setPreis("Landungskapsel", 35 * mod);
			droppodweapon.setAktiv(trooptrans.isSelected("Landungskapsel"));
			peilsender.setAktiv(trooptrans.isSelected("Landungskapsel"));
		} 
		if(landraider){
			boolean lrselect = trooptrans.isSelected("Land Raider") || trooptrans.isSelected("Land Raider Crusader") || trooptrans.isSelected("Land Raider Redeemer");
			multimelter.setAktiv(lrselect);
//			deathwingvehicle.setAktiv(lrselect);
//			deathwingvehicle.setSelected(deathwing);
		} 
			
		if(!trooptrans.isSelected()){
			trooptrans.setSelected(0, true);
		}
		
		if(!nurdroppod){
			if((razorback && trooptrans.isSelected("Razorback")) || (rhino && trooptrans.isSelected("Rhino")) || (landraider && (trooptrans.isSelected("Land Raider") || trooptrans.isSelected("Land Raider Crusader") || trooptrans.isSelected("Land Raider Redeemer")))){
				if(!landraider)o1.setAktiv(true);
				o2.setAktiv(true);
				o3.setAktiv(true);
				o4.setAktiv(true);
			} else {
				if(!landraider)o1.setAktiv(false);
				o2.setAktiv(false);
				o3.setAktiv(false);
				o4.setAktiv(false);
			}
		}
		
	}

}

