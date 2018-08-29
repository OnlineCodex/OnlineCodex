package oc.wh40k.units.ty;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class TYRuestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;
	OptionsEinzelUpgrade oe1, oe2;
	String type = "";
	String default1 = "";
	String default2 = "";
	
	
	public TYRuestkammer() {
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

		seperator();
		
		
		if(type == "Hive Tyrant" || type == "Carnifex" || type == "Screamer-Killer"){
			ogE.addElement(new OptionsGruppeEintrag("2 Pairs of m. scything talons", getPts("Monstrous scything talons (two pairs)("+ type + ")")));
			add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			o3.setSelected(0, true);
		}
		
		seperator();
		
		if(type == "Hive Tyrant" || type == "Carnifex" || type == "Thornback"){
			ogE.addElement(new OptionsGruppeEintrag("Pair of m. scything talons", "Pair of monstrous scything talons", getPts("Monstrous scything talons (" + type +")")));
		}
		if(type == "Hive Tyrant"){
			ogE.addElement(new OptionsGruppeEintrag("Monstrous rending claws", getPts("Monstrous rending claws"))); //Monstrous Bioweapons
			ogE.addElement(new OptionsGruppeEintrag("Monstrous boneswords", getPts("Monstrous boneswords"))); //Monstrous Bioweapons
			ogE.addElement(new OptionsGruppeEintrag("Lash whip and m. b.", getPts("Lash whip and monstrous bonesword"))); //Monstrous Bioweapons
		}
		if(type == "Hive Tyrant" || type == "Carnifex"){
			ogE.addElement(new OptionsGruppeEintrag("Two deathsp. with maggots","Two deathspitters with slimer maggots", getPts("Deathspitter with slimer maggots")*2)); //Monstrous Bio-Cannons
			ogE.addElement(new OptionsGruppeEintrag("Two devourers with worms","Two devourers with brainleech worms", getPts("Devourer with brainleech worms")*2)); //Monstrous Bio-Cannons
			ogE.addElement(new OptionsGruppeEintrag("Stranglethorn cannon", getPts("Stranglethorn cannon"))); //Monstrous Bio-Cannons
			ogE.addElement(new OptionsGruppeEintrag("Heavy venom cannon", getPts("Heavy venom cannon"))); //Monstrous Bio-Cannons
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		}
		if(type == "Thornback")
		{
			ogE.addElement(new OptionsGruppeEintrag("Stranglethorn cannon", getPts("Stranglethorn cannon"))); //Monstrous Bio-Cannons
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			o1.setSelected(0, true);
		}
		
		seperator();
		
		if(type == "Hive Tyrant" || type == "Carnifex"){
			ogE.addElement(new OptionsGruppeEintrag("Pair of m. scything talons", "Pair of monstrous scything talons", getPts("Monstrous scything talons (" + type +")")));
		}
		if(type == "Hive Tyrant"){
			ogE.addElement(new OptionsGruppeEintrag("M. rending claws", "Monstrous rending claws", getPts("Monstrous rending claws"))); //Monstrous Bioweapons
			ogE.addElement(new OptionsGruppeEintrag("Monstrous boneswords", getPts("Monstrous boneswords"))); //Monstrous Bioweapons
			ogE.addElement(new OptionsGruppeEintrag("Lash whip and m. bonesw.", "Lash whip and monstrous bonesword", getPts("Lash whip and monstrous bonesword"))); //Monstrous Bioweapons
		}
		if(type == "Hive Tyrant" || type == "Carnifex" || type == "Thornback"){
			ogE.addElement(new OptionsGruppeEintrag("Two deathsp. with maggots","Two deathspitters with slimer maggots", getPts("Deathspitter with slimer maggots")*2)); //Monstrous Bio-Cannons
			ogE.addElement(new OptionsGruppeEintrag("Two devourers with worms","Two devourers with brainleech worms", getPts("Devourer with brainleech worms")*2)); //Monstrous Bio-Cannons
			if(type == "Carnifex"){
				ogE.addElement(new OptionsGruppeEintrag("Monstrous crushing claws", getPts("Monstrous crushing claws")));
			}
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			if(type == "Thornback") o2.setSelected(1, true);
		}
		
		seperator();
		
		if(type == "Carnifex"){
			ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
			ogE.addElement(new OptionsGruppeEintrag("Bone mace", getPts("Bone mace")));
			add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();

			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
			add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Bio plasma", getPts("Bio plasma")));
			ogE.addElement(new OptionsGruppeEintrag("Enhanced Senses", getPts("Enhanced Senses")));
			ogE.addElement(new OptionsGruppeEintrag("Acid maw", getPts("Monstrous acid maw")));
			ogE.addElement(new OptionsGruppeEintrag("Tusks", getPts("Tusks")));
			ogE.addElement(new OptionsGruppeEintrag("Chitin thorns", getPts("Chitin thorns")));
			add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Spine banks", getPts("Spine banks")));
			ogE.addElement(new OptionsGruppeEintrag("Spore cysts", getPts("Spore cysts")));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		}
		
		if(type == "Thornback"){
			ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
			add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();

			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
			add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));
			
			seperator();
			
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enhanced Senses", getPts("Enhanced Senses")));
			
			ogE.addElement(new OptionsGruppeEintrag("Spine banks", getPts("Spine banks")));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		}
		
		if(type == "Screamer-Killer")
		{
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
			add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));
			
			seperator();
			ogE.addElement(new OptionsGruppeEintrag("Spore cysts", getPts("Spore cysts")));
			add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		}
		
		if(type == "Tyranid Prime"){
			ogE.addElement(new OptionsGruppeEintrag("Devourer", getPts("Devourer")));
			ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons"))); //Basic Bio-Weapons
			ogE.addElement(new OptionsGruppeEintrag("Spinefists", getPts("Spinefists (Ravener)"))); //Basic Bio-Weapons
			ogE.addElement(new OptionsGruppeEintrag("Deathspitter", getPts("Deathspitter"))); //Basic Bio-Weapons
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons")));
			ogE.addElement(new OptionsGruppeEintrag("Rending Claws", getPts("Rending Claws"))); //Melee Bio-Weapons
			ogE.addElement(new OptionsGruppeEintrag("Boneswords", getPts("Boneswords"))); //Melee Bio-Weapons
			ogE.addElement(new OptionsGruppeEintrag("Lash whip and bonesword", getPts("Lash whip and bonesword"))); //Melee Bio-Weapons
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		}
		
		if (type == "Stonecrusher Carnifex"){
			ogE.addElement(new OptionsGruppeEintrag("Wrecker claw", getPts("Wrecker claws (pair)")));
			ogE.addElement(new OptionsGruppeEintrag("Bio-flail", getPts("Bio-flail") + getPts("Wrecker claws (single)")));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			o1.setSelected(0, true);
			
			seperator();
			
			ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
			ogE.addElement(new OptionsGruppeEintrag("Bone mace", getPts("Bone mace")));
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
			o2.setSelected(0, true);
			
			seperator();
			
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bio plasma", getPts("Bio plasma")));
			
		}
		sizeSetzen();
		
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
			RefreshListener.fireRefresh();
		}
	}

	@Override
	public void refreshen() {
		
		if(type == "Hive Tyrant" || type == "Carnifex"){
			int cnt = (o3.isSelected()?2:0) + (o1.isSelected()?1:0)  + (o2.isSelected()?1:0);
			boolean legal = cnt == 2; 
			o1.setAktiv("Pair of monstrous scything talons", !o2.isSelected("Pair of monstrous scything talons"));
			o2.setAktiv("Pair of monstrous scything talons", !o1.isSelected("Pair of monstrous scything talons"));
			o3.setAktiv(!o1.isSelected() && !o2.isSelected());
			o3.setSelected(0, !o1.isSelected() && !o2.isSelected());
			o1.setLegal(legal);
			o2.setLegal(legal);
			o3.setLegal(legal);
		}
		
//		if(type == "Carnifex"){
//			o4.alwaysSelected();
//		}
		
		if(type == "Tyranid Prime"){
			o1.alwaysSelected();
			o2.alwaysSelected();
		}
		
		if (type == "Stonecrusher Carnifex"){
			o1.alwaysSelected();
			o2.alwaysSelected();
		}
	}
	
}
