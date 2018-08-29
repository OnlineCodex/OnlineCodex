package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IMSpaceMarinesRuestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4;
	public OptionsEinzelUpgrade oe1, oe2;
	OptionsZaehlerGruppe o5;
	String type = "";
	String default1 = "";
	String default2 = "";
    
    
	public IMSpaceMarinesRuestkammer() {
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
		
		if(type == "Captain" || type == "Captain on Bike"){
			ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master-crafted boltgun",getPts("Master-crafted boltgun")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
			if(type == "Captain"){
				ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
			}
			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected("Chainsword", true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		} else if (type == "Captain in Terminator Armour"){
			ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Stormbolter", "Stormbolter (SM)", buildaVater));
			ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected("Stormbolter", true);
			
			seperator();

			ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
			ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
			ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
			o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
			o2.setSelected("Power sword", true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			
			seperator();
			
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade launcher", "Wrist-mounted grenade launcher", getPts("Wrist-mounted grenade launcher")));
		} else if (type == "Captain in Cataphractii Armour"){
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("Combi-bolter", "Combi-bolter", buildaVater));
			ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected("Combi-bolter", true);
			
			seperator();

			ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("Power sword", "Power sword (SM)", buildaVater));
			ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
			ogE.addElement(new OptionsGruppeEintrag("Chain fist", getPts("Chain fist")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
			o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
			o2.setSelected("Power sword", true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		} else if (type == "Sanguinary Priest" || type == "Sanguinary Priest on Bike") {
			ogE.addElement(new OptionsGruppeEintrag("Boltgun",getPts("Boltgun (SM)")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(1, true);
			
			seperator();

			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		}else if(type == "Librarian" || type == "Librarian on Bike"){
			ogE.addElement(new OptionsGruppeEintrag("Boltgun",getPts("Boltgun (SM)")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("Bolt pistol", "Bolt pistol (SM)", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(1, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
			ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
			ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if(type == "Librarian in Terminator Armour"){
			ogE.addElement(new OptionsGruppeEintrag("Storm shield",getPts("Storm shield (Characters)")));
			ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Storm bolter", "Storm bolter (SM)", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(1, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
			ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
			ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		} else if (type == "Chaplain"){
			ogE.addElement(new OptionsGruppeEintrag("Bolt gun",getPts("Bolt gun (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power fist",getPts("Power fist (SM)")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(2, true);
		} else if (type == "Chaplain in Terminator Armour"){
			ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(3, true);
		} else if (type == "Company Ancient"){
			ogE.addElement(new OptionsGruppeEintrag("Bolt gun",getPts("Bolt gun (SM)")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(1, true);
		} else if(type == "Cataphractii Sergeant"){
			ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
			ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			o1.setSelected(0, true);

			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
			ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			o2.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			
			seperator();

			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade Harness", getPts("Grenade Harness")));
		} else if(type == "Tartaros Sergeant"){
			 
			ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			o1.setSelected(0, true);

			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
			ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", getPts("plasma blaster")));
			ogE.addElement(new OptionsGruppeEintrag("Volkite charger", getPts("volkite charger")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
			o2.setSelected(0, true);

			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		}else if (type == "Techmarine"){
			ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
			ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
			ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o1.setSelected(1, true);
			
			seperator();

			ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			o2.setSelected(2, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm")));
			ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", getPts("conversion beamer")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servo-harness", getPts("Servo-arm") + getPts("Plasma cutter") + getPts("Flamer (SM)")));
		}else if(type == "Librarian GK") {
			ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
			ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
			ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
			ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
			ogE.addElement(new OptionsGruppeEintrag("Two nemesis falchions", getPts("Nemesis falchions")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
			ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}else if(type == "Chaplain GK") {
			ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		
		sizeSetzen();
		
	}
	
	@Override
	public Object getSpecialValue() {
		return 0;
	}

	@Override
	public void refreshen() {
		
		if(type == "Librarian" || type == "Techmarine"){
			o1.alwaysSelected();
			o2.alwaysSelected();
		}else if(type == "Chaplain" || type == "Librarian GK" || type == "Chaplain GK"){
			o1.alwaysSelected();
		}
		
		if(type == "Captain in Terminator Armour"){
			oe1.setAktiv(o1.isSelected("Power fist") || o2.isSelected("Power fist"));
		}
		
		if(type.contains("Techmarine")){
			if(oe1.isSelected()){
				o3.setSelected(0, true);
				o3.setSelected(1, false);
			}
			o3.alwaysSelected();
		}
		
		if(type == "Tartaros Sergeant" || type == "Cataphractii Sergeant" || type.contains("Captain") || type.contains("Sanguinary Priest")){
			legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()*2 == 2;
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
			
			o1.setMaxAnzahl(o3.isSelected()?0:1);
			o2.setMaxAnzahl(o3.isSelected()?0:1);
			o3.setMaxAnzahl(o1.isSelected() || o2.isSelected()?0:1);
		}
		
		if(o1 != null){
			o1.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
			o1.setPreis("Storm shield", getPts("Storm shield (Characters)"));
		}
		
		if(o2 != null){
			o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
			o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
		}
		
		
	}
	
}
