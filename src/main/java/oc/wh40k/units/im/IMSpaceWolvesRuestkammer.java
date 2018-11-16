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

        if(type.contains("Rune Priest") || type == "Wolf Lord" ){//TODO other characters
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour of Russ", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of Durfast", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Wulfen Stone", 0).setRelic(true));
        	 character = true;
        	 seperator();
        }
        
        if (type == "Wolf Lord" || type.contains("Wolf Guard Battle Leader")) {
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
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
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
            addCombiFury();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);
        } else if (type == "Wolf Priest in Terminator Armour") {
            addCombiFury();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Storm bolter", true);
        } else if (type.contains("Rune Priest")) {
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
            ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
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
            ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            addCombiFury();
            ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);
        } else if (type == "Wolf Guard Pack Leader in Terminator Armour (Blood Claws)" || type == "Wolf Guard Pack Leader in Terminator Armour (Grey Hunters)") {
            ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);
        } else if (type == "Wolf Guard in Terminator Armour") {
            ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 0));
            o1.setSelected("Power fist", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
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

    @Override
    public void refreshen() {

        if (type == "Wolf Lord" || type.contains("Wolf Guard Battle Leader") || type == "Wolf Guard in Terminator Armour") {
            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);
        } else if (type.contains("Wolf Priest") || type == "Wolf Guard Bike Leader") {
            o1.alwaysSelected();
        } else if (type == "Grey Hunter Pack Leader") {
            o2.alwaysSelected();
        } else if (type.contains("Rune Priest") || type.contains("Lone Wolf") || type == "Skyclaw Pack Leader" ||
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
