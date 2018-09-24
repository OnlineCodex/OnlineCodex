package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class IMKillteamKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o6, o7;
	OptionsZaehlerGruppe o3, o4, o5;
	OptionsEinzelUpgrade thunderhammer;
	String type;
	
	public IMKillteamKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
			    
	    seperator();

	    if(type.equals("Veteran") || type.equals("Sergeant"))
	    {	    
	    	ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (DW)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
	    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
			ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
			ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
			ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
			add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Deathwatch shotgun", getPts("Deathwatch shotgun")));
			ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Grav-gun", getPts("Grav-gun")));
			ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Stalker pattern boltgun", getPts("Stalker pattern boltgun")));
			ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
			add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Deathwatch frag cannon", getPts("Deathwatch frag cannon")));
			ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Infernus heavy bolter", getPts("Infernus heavy bolter")));
			ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM)")));
			add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
	    	ogE.addElement(new OptionsGruppeEintrag("Heavy thunder hammer", getPts("Heavy thunder hammer")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			if(type.equals("Sergeant"))
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat shield", getPts("Combat shield")));
	    }
	    
	    if(type.equals("Terminator"))
	    {
	    	ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
	    	ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
	    	ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
			ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power fist & meltagun", getPts("Power fist (SM)") + getPts("Meltagun (SM)")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
			ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Cyclone & Storm bolter", getPts("Cyclone missile launcher") + getPts("Storm bolter (DW)")));
			add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Two lightning claws", getPts("Lightning claw (pair)")));
			ogE.addElement(new OptionsGruppeEintrag("Hammer & Shield", getPts("Thunder hammer (others)") + getPts("Storm shield (others)")));
			add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	    }
	    
	    if(type.equals("Biker"))
	    {
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
	    	ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
						
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwatch teleport homer", getPts("Deathwatch teleport homer")));
	    }
	    
	    if(type.equals("Intercessor"))
	    {
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Bolt rifle", getPts("Bolt rifle (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", getPts("Auto bolt rifle (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", getPts("Stalker bolt rifle (DW)")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected(0, true);
			
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary grenade launcher", getPts("Auxiliary grenade launcher")));
	    }
	    
	    if(type.equals("Intercessor Sergeant"))
	    {
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Bolt rifle", getPts("Bolt rifle (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", getPts("Auto bolt rifle (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", getPts("Stalker bolt rifle (DW)")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	    }
	    
	    if(type.equals("Hellblaster"))
	    {
	    	ogE.addElement(new OptionsGruppeEintrag("Plasma incinerator", getPts("Plasma incinerator")));
			ogE.addElement(new OptionsGruppeEintrag("Assault plasma incinerator", getPts("Assault plasma incinerator")));
			ogE.addElement(new OptionsGruppeEintrag("Heavy plasma incinerator", getPts("Heavy plasma incinerator")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
	    }
		
	    if(type.equals("Inceptor"))
	    {
		    ogE.addElement(new OptionsGruppeEintrag("Assault bolters", getPts("Assault bolter")*2));
			ogE.addElement(new OptionsGruppeEintrag("Plasma exterminator", getPts("Plasma exterminator")*2));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
	    }
	    
	    if(type.equals("Reiver"))
	    {
			ogE.addElement(new OptionsGruppeEintrag("Bolt carbines", getPts("Bolt carbine (DW)")));
			ogE.addElement(new OptionsGruppeEintrag("Combat knifes", getPts("Combat knife")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
			add( new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grapnel launcher", getPts("Grapnel launcher")));
	    }
	    
	    if(type.equals("Aggressor"))
	    {
			ogE.addElement(new OptionsGruppeEintrag("Boltstorm gauntlets/Fragstorm", "Auto boltstorm gauntlets & Fragstorm grenade launcher", getPts("Auto boltstorm gauntlets") + getPts("Fragstorm grenade launcher")));
			ogE.addElement(new OptionsGruppeEintrag("Flamestorm gauntlets", getPts("Flamestorm gauntlets")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
	    }
	    
		cnt=randAbstand;
		
		setUeberschrift("");
		sizeSetzen();
		
		seperator();
		
	}

	@Override
	public void refreshen() {
		
	    if(type.equals("Veteran"))
	    {	
	    	int maxWeapons = 2;
	    	
	    	if(o1.isSelected()) maxWeapons = maxWeapons - 2;
	    	if(o2.isSelected()) maxWeapons = maxWeapons - 2;
	    	if(o5.isSelected()) maxWeapons = maxWeapons - 2;
	    	maxWeapons = maxWeapons - o3.getAnzahl();
	    	maxWeapons = maxWeapons - o4.getAnzahl();
	    		    		
	    	if(maxWeapons == 0)
	    		o3.setMaxAnzahl(o3.getAnzahl());
	    	else
	    		o3.setMaxAnzahl(o3.getAnzahl()+maxWeapons);
	    	
	    	if(maxWeapons == 0)
	    		o4.setMaxAnzahl(o4.getAnzahl());
	    	else
	    		o4.setMaxAnzahl(1);
	    	
	    	if(maxWeapons == 0)
	    		o5.setMaxAnzahl(o5.getAnzahl());
	    	else
	    		o5.setMaxAnzahl(1);
	    }
	    
	    if(type.equals("Terminator"))
	    {
	    	o1.setAktiv(!o6.isSelected() && !o7.isSelected());
	    	o2.setAktiv(!o7.isSelected());
	    }
	    
	    if(type.equals("Biker"))
	    {
	    	o1.alwaysSelected();
	    }
	    
	    if(type.equals("Intercessor"))
	    {
	    	o1.alwaysSelected();
	    	o2.alwaysSelected();
	    }
	    
	    if(type.equals("Intercessor Sergeant"))
	    {
	    	o1.alwaysSelected();
	    	o2.alwaysSelected();
	    }
	    
	    if(type.equals("Hellblaster"))
	    {
	    	o1.alwaysSelected();
	    }
	    
	    if(type.equals("Inceptor"))
	    {
	    	o1.alwaysSelected();
	    }
	    
	    if(type.equals("Reiver"))
	    {
	    	o1.alwaysSelected();
	    }
	    
	    if(type.equals("Aggressor"))
	    {
	    	o1.alwaysSelected();
	    }
	}

	public void setType(String s) {
		type = s;
	}
	
	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
	    boolean entrySwitched=false;
		
		if(entrySwitched){
			//Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
			//Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet, 
			//der Text aber nicht aktualisiert.
			RefreshListener.fireRefresh();
		}
	}
	
	@Override
	public void deleteYourself() {				
		super.deleteYourself();
	}
	
}
