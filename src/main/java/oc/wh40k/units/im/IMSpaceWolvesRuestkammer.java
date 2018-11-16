package oc.wh40k.units.im;

import oc.*;

public class IMSpaceWolvesRuestkammer extends RuestkammerVater {

	public boolean uniqueError = false;
    public OptionsEinzelUpgrade oe1, oe2;
    OptionsUpgradeGruppe o1, o2, o3, o4;
    OptionsZaehlerGruppe o5;
    String type = "";
    String default1 = "";
    String default2 = "";
    boolean character = false;
    
    public IMSpaceWolvesRuestkammer() {
        grundkosten = 0;
    }

    public void setType(String s) {
        type = s;
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        if(type.contains("Rune Priest") || type.contains("Wolf Priest") || type.contains("Wolf Lord") 
        		|| type.contains("Wolf Guard Battle Leader") || type == "Primaris Battle Leader"
        		|| type == "Iron Priest"){//TODO other characters
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour of Russ", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of Durfast", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Wulfen Stone", 0).setRelic(true));
        	 character = true;
        	 seperator();
        }
        if (type.contains("Wolf Lord") && !type.contains("Terminator") && !type.contains("Cataphractii")&& !type.contains("Primaris")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield")));
            if(type.contains("Thunderwolf")){
                ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            }
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Chainsword", true);

            seperator();

            if(!type.contains("Thunderwolf")){
            	ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master-crafted boltgun", getPts("Master-crafted boltgun")));
            }
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            addCombiFury();
            addMeleeRelic();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if(type.contains("Thunderwolf")){
            	o2.setSelected("Bolt pistol", true);
            } else{
            	o2.setSelected("Master-crafted boltgun", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Wolf Lord in Terminator Armour" || type == "Wolf Lord in Cataphractii Armour") {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield")));
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if(type.contains("Cataphractii")){
            	o1.setSelected("Chain fist", true);
            } else if(type.contains("Terminator")){
            	o1.setSelected("Power sword", true);
            }

            seperator();
            if(type.contains("Cataphractii")){
                ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
            }
            addCombiFury();
            addTerminatorMeleeRelic();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if(type.contains("Cataphractii")){
            	o2.setSelected("Combi-bolter", true);
            } else if(type.contains("Terminator")){
            	o2.setSelected("Storm bolter", true);
            }

            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
            
            if(type.contains("Terminator")){
            	seperator();
            	add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade launcher", "Wrist-mounted grenade launcher", getPts("Wrist-mounted grenade launcher")));
            }
        } else if (type == "Primaris Wolf Lord") {
            ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", "Master-crafted auto bolt rifle",getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", "Master-crafted stalker bolt rifle",getPts("Master-crafted stalker bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Sword + Auto bolt rifle", "Power sword + Master-crafted auto bolt rifle", getPts("Power sword (SM)") + getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Sword + Stalker bolt rifle", "Power sword + Master-crafted stalker bolt rifle", getPts("Power sword (SM)") + getPts("Master-crafted stalker bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Fist + Plasma pistol", "Power fist + Plasma pistol", getPts("Power fist") + getPts("Plasma pistol (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Master-crafted auto bolt rifle", true);

        } else if (type == "Primaris Battle Leader") {
        	ogE.addElement(new OptionsGruppeEintrag("Axe + Bolt carbine", "Power axe + Bolt carbine", getPts("Power axe (SM)") + getPts("Bolt carbine")));
        	ogE.addElement(new OptionsGruppeEintrag("Power Sword", getPts("Power sword (SM)")));
        	ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", "Master-crafted auto bolt rifle",getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", "Master-crafted stalker bolt rifle",getPts("Master-crafted stalker bolt rifle")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Power axe + Bolt carbine", true);
        }  else if (type.contains("Wolf Guard Battle Leader")) {
            	ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield")));
            if(!type.contains("Terminator") && !type.contains("Thunderwolf")){
                ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            }
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if (type == "Wolf Guard Battle Leader in Terminator Armour") {
                o1.setSelected("Power sword", true);
            } else {
                o1.setSelected("Chainsword", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            addCombiFury();
            addMeleeRelic();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if (type == "Wolf Guard Battle Leader in Terminator Armour") {
                o2.setSelected("Storm bolter", true);
            } else {
                o2.setSelected("Bolt pistol", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type == "Wolf Priest") {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Wolf Priest in Terminator Armour") {
            addCombiFury();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Storm bolter", true);
        } else if (type.contains("Rune Priest") && !type.contains("Primaris")) {
            ogE.addElement(new OptionsGruppeEintrag("Runic axe", getPts("Runic axe")));
            ogE.addElement(new OptionsGruppeEintrag("Runic stave", getPts("Runic stave")));
            ogE.addElement(new OptionsGruppeEintrag("Runic sword", getPts("Runic sword")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Chainsword", true);

            seperator();

            if (type != "Rune Priest in Terminator Armour") {
                ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
                ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            }
            if (type != "Rune Priest") {
            	addCombiFury();
            }
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if (type == "Rune Priest in Terminator Armour") {
                o2.setSelected("Storm bolter", true);
            } else {
                o2.setSelected("Bolt pistol", true);
            }
        } else if (type == "Lone Wolf") {
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Bolt pistol", true);
        } else if (type == "Lone Wolf in Terminator Armour") {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Storm bolter", true);
        } else if (type == "Swiftclaw Pack Leader") {

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Bolt pistol", true);

            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type == "Wolf Guard Bike Leader") {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addMeleeRelic();
            addCombiFury();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type == "Skyclaw Pack Leader") {
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type == "Wolf Guard Sky Leader" || type == "Wolf Guard Pack Leader") {
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type == "Long Fang Pack Leader") {
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol + Boltgun", getPts("Bolt pistol (SM)") + getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol + Boltgun", true);
        } else if (type == "Wolf Guard Pack Leader in Terminator Armour") {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            addCombiFury();
            ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);
        } else if (type == "Wolf Guard Pack Leader in Terminator Armour (Blood Claws)" || type == "Wolf Guard Pack Leader in Terminator Armour (Grey Hunters)") {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);
        } else if (type == "Wolf Guard in Terminator Armour") {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 0));
            o1.setSelected("Power fist", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addTerminatorMeleeRelic();
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 0));
            o2.setSelected("Storm bolter", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 0));
        } else if (type == "Blood Claw Pack Leader" || type == "Grey Hunter Pack Leader") {
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (type == "Blood Claw Pack Leader") {
                o1.setSelected("Chainsword", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type == "Wolf Scout Pack Leader") {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("combat knife")));
            ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("sniper rifle (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Boltgun", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo cloaks", getPts("Camo cloak")));
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }
    
    public void addCombiFury(){
    	ogE.addAll(IMSpaceWolvesCombiWeapons.createRK("", "", buildaVater));
    	if(character){
    		ogE.addElement(new OptionsGruppeEintrag("Frostfury", getPts("Storm bolter (SM)")).setRelic(true));
    	}
    }
    
    public void addMeleeRelic(){
        ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
        if(character){
    		ogE.addElement(new OptionsGruppeEintrag("Krakenbone Sword", getPts("Frost sword")).setRelic(true));
    		ogE.addElement(new OptionsGruppeEintrag("Black Death", getPts("Frost axe")).setRelic(true));
    	}
    }
    
    public void addTerminatorMeleeRelic(){
    	ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
        if(character){
    		ogE.addElement(new OptionsGruppeEintrag("Krakenbone Sword", getPts("Frost sword")).setRelic(true));
    		ogE.addElement(new OptionsGruppeEintrag("Black Death", getPts("Frost axe")).setRelic(true));
    	}
    }

    @Override
    public void refreshen() {

        if(type == "Primaris Wolf Lord" || type == "Primaris Battle Leader") {
        	o1.alwaysSelected();
        } else if (type.contains("Wolf Lord") || type.contains("Wolf Guard Battle Leader") || type == "Wolf Guard in Terminator Armour") {
        
            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);
            if(type == "Wolf Lord in Terminator Armour"){
            	oe1.setAktiv(o1.isSelected("Power fist") || o2.isSelected("Power fist"));
            }
        } else if ((type.contains("Wolf Priest") && !type.contains("Primaris")) || type == "Wolf Guard Bike Leader") {
            o1.alwaysSelected();
        } else if (type == "Grey Hunter Pack Leader") {
            o2.alwaysSelected();
        } else if ((type.contains("Rune Priest") && !type.contains("Primaris")) || type.contains("Lone Wolf") || type == "Skyclaw Pack Leader" ||
                type == "Wolf Guard Sky Leader" || type == "Wolf Guard Pack Leader" || type == "Long Fang Pack Leader" ||
                type.contains("Wolf Guard Pack Leader in Terminator Armour") || type == "Blood Claw Pack Leader") {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type == "Swiftclaw Pack Leader") {
            legal = o1.isSelected() || o2.isSelected();
            o1.setLegal(legal);
            o2.setLegal(legal);

            o1.setMaxAnzahl(1 - o2.getAnzahl());
            o2.setMaxAnzahl(1 - o1.getAnzahl());
        } else if (type == "Wolf Scout Pack Leader") {
            o1.alwaysSelected();
            o2.alwaysSelected();

            boolean meleeSelected = o1.isSelected("Frost sword") ||
                    o1.isSelected("Frost axe") ||
                    o1.isSelected("Power sword") ||
                    o1.isSelected("Power axe") ||
                    o1.isSelected("Power maul") ||
                    o1.isSelected("Power fist") ||
                    o1.isSelected("Lightning claw") ||
                    o1.isSelected("Wolf claw") ||
                    o1.isSelected("Thunder hammer");

            boolean plasmaSelected = o2.isSelected("Plasma pistol");

            o2.setAktiv("Plasma pistol", !meleeSelected);

            o1.setAktiv("Frost sword", !plasmaSelected);
            o1.setAktiv("Frost axe", !plasmaSelected);
            o1.setAktiv("Power sword", !plasmaSelected);
            o1.setAktiv("Power axe", !plasmaSelected);
            o1.setAktiv("Power maul", !plasmaSelected);
            o1.setAktiv("Power fist", !plasmaSelected);
            o1.setAktiv("Lightning claw", !plasmaSelected);
            o1.setAktiv("Wolf claw", !plasmaSelected);
            o1.setAktiv("Thunder hammer", !plasmaSelected);

        }

        if (o1 != null) {
            o1.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o1.setPreis("Storm shield", getPts("Storm shield (Characters)"));
        }

        if (o2 != null) {
            o2.setPreis("Thunder hammer", getPts("Thunder hammer (Characters)"));
            o2.setPreis("Storm shield", getPts("Storm shield (Characters)"));
        }


    }

}
