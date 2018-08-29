package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IMAstraMilitarumRuestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4;
	OptionsEinzelUpgrade oe1, oe2;
	OptionsZaehlerGruppe o5;
	String type = "";
	String default1 = "";
	String default2 = "";
	
	
	public IMAstraMilitarumRuestkammer() {
		grundkosten = 0;
	}

	public void setType(String s){
		type = s;
	}
	
	public void setDefault1(String s){
		default1 = s;
	}
	
	public void setDefault2(String s){
		default2 = s;
	}
	
	@Override
	public void initButtons(boolean... defaults) {
		checkBuildaVater();
		
		if(type == "Company Commander" || type == "Platoon Commander"){
			ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
			ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if(type == "Lord Commissar" || type == "Commissar"){
			ogE = IMAstraMilitarumMeleeWeapons.createRK("Power sword", "Power sword (AM)", buildaVater);
			add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE , 2));
			if(type == "Lord Commissar"){
				o5.setAnzahl(0, 1);
			}
			seperator();
			
			ogE = IMAstraMilitarumRangedWeapons.createRK("Bolt pistol", "Bolt pistol (AM)", buildaVater);
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if(type == "Sergeant"){

			ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (AM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (AM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AM)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if(type == "Veteran Sergeant"){
			ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if (type == "Temperstor Prime"){
			ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
			ogE.addElement(new OptionsGruppeEintrag("Tempestus command rod", getPts("Tempestus command rod")));
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if(type == "Tempestor"){
			ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
			ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
			ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		
		
		sizeSetzen();
		
	}
	
	@Override
	public Object getSpecialValue() {
		return 0;
	}

	@Override
	public void refreshen() {
		
		if(type == "Company Commander" || type == "Platoon Commander" || type == "Sergeant" || type == "Veteran Sergeant" || type == "Tempestor"){
			o1.alwaysSelected();
			o2.alwaysSelected();
		}else if(type == "Lord Commissar" || type == "Commissar"){
			if(type == "Lord Commissar"){
				o5.setLegal(o5.getAnzahl()>0);
			}
			o2.alwaysSelected();
		}else if(type == "Temperstor Prime"){
			o2.alwaysSelected();
		}
		
	}
	
}
