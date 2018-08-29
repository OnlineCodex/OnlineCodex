package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IMAdeptusMechanicusRuestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe;

	boolean vanguard = false;
	boolean ranger = false;
    String type = "";
    
	public IMAdeptusMechanicusRuestkammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		checkBuildaVater();
		vanguard = defaults[0];
		ranger = defaults[1];
		
		//special 
		if(ranger)
		{
			ogE = IMAdeptusMechanicusMeleeWeapons.createRK("", "", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE = IMAdeptusMechanicusPistolWeapons.createRK("Galvanic rifle", "Galvanic rifle", buildaVater);
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} 
		else if (vanguard)
		{
			ogE = IMAdeptusMechanicusMeleeWeapons.createRK("", "", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE = IMAdeptusMechanicusPistolWeapons.createRK("Radium carbine", "Radium carbine", buildaVater);
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		
		if(type.equals("Ruststalker Princeps"))
		{
			add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chordclaw", getPts("chordclaw")));
			
			ogE.addElement(new OptionsGruppeEintrag("Transonic razor", getPts("Transonic razor")));
			ogE.addElement(new OptionsGruppeEintrag("Transonic blades", getPts("Transonic blades")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		if(type.equals("Ruststalker Princeps"))
		{
			o1.alwaysSelected();
			oe.setSelected(true);
		}
		else
		{
			o2.alwaysSelected();
		}
	}
	
	public void setType(String s) {
		type = s;
	}
}
