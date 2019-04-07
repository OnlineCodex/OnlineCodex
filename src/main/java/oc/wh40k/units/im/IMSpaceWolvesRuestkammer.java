package oc.wh40k.units.im;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMSpaceWolvesRuestkammer extends RuestkammerVater {

	public boolean uniqueError = false;
    public OptionsEinzelUpgrade oe1, oe2;
    private OptionsUpgradeGruppe o1, o3;
    public OptionsUpgradeGruppe o2;
    public String type = "";
    private boolean character = false;

    Set<String> CHARACTERS = ImmutableSet.of("Primaris Battle Leader", "Iron Priest", "Primaris Ancient", "Great Company Ancient", "Great Company Champion", "Rune Priest", "Rune Priest in Terminator Armour", "Rune Priest on Bike", "Primaris Rune Priest",
    		"Wolf Priest", "Wolf Priest in Terminator Armour", "Wolf Priest on Bike", "Primaris Wolf Priest", "Wolf Lord", "Wolf Lord in Cataphractii Armour", "Wolf Lord in Gravis Armour", "Wolf Lord in Terminator Armour", "Wolf Lord on Bike",
    		"Wolf Lord on Thunderwolf", "Primaris Wolf Lord", "Wolf Guard Battle Leader", "Wolf Guard Battle Leader in Terminator Armour", "Wolf Guard Battle Leader on Bike", "Wolf Guard Battle Leader on Thunderwolf");

    public IMSpaceWolvesRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        if(CHARACTERS.contains(type)) {
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour of Russ", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of Durfast", 0).setRelic(true));
        	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Wulfen Stone", 0).setRelic(true));
        	 character = true;
        	 seperator();
        }

        if (type.equals("Wolf Lord") || type.equals("Wolf Lord in Gravis Armour") || type.equals("Wolf Lord on Bike") || type.equals("Wolf Lord on Thunderwolf")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (characters)")));
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
        } else if (type.equals("Wolf Lord in Terminator Armour") || type.equals("Wolf Lord in Cataphractii Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (characters)")));
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
        } else if (type.equals("Primaris Wolf Lord")) {
            ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", "Master-crafted auto bolt rifle",getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", "Master-crafted stalker bolt rifle",getPts("Master-crafted stalker bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Sword + Auto bolt rifle", "Power sword + Master-crafted auto bolt rifle", getPts("Power sword (SM)") + getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Sword + Stalker bolt rifle", "Power sword + Master-crafted stalker bolt rifle", getPts("Power sword (SM)") + getPts("Master-crafted stalker bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Fist + Plasma pistol", "Power fist + Plasma pistol", getPts("Power fist") + getPts("Plasma pistol (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Master-crafted auto bolt rifle", true);

        } else if (type.equals("Primaris Battle Leader")) {
        	ogE.addElement(new OptionsGruppeEintrag("Axe + Bolt carbine", "Power axe + Bolt carbine", getPts("Power axe (SM)") + getPts("Bolt carbine")));
        	ogE.addElement(new OptionsGruppeEintrag("Power Sword", getPts("Power sword (SM)")));
        	ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", "Master-crafted auto bolt rifle",getPts("Master-crafted auto bolt rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", "Master-crafted stalker bolt rifle",getPts("Master-crafted stalker bolt rifle")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Power axe + Bolt carbine", true);
        }  else if (type.contains("Great Company Ancient")) {
        	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
	        addCombiFury();
	        addMeleeRelic();
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	        o1.setSelected("Bolt pistol", true);
	    }  else if (type.contains("Wolf Guard Battle Leader")) {
            	ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (characters)")));
            if(!type.contains("Terminator") && !type.contains("Thunderwolf")){
                ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            }
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            if (type.equals("Wolf Guard Battle Leader in Terminator Armour")) {
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
            if (type.equals("Wolf Guard Battle Leader in Terminator Armour")) {
                o2.setSelected("Storm bolter", true);
            } else {
                o2.setSelected("Bolt pistol", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Wolf Priest")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type.equals("Wolf Priest in Terminator Armour")) {
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
            if (type.equals("Rune Priest in Terminator Armour")) {
                o2.setSelected("Storm bolter", true);
            } else {
                o2.setSelected("Bolt pistol", true);
            }
        } else if (type.equals("Lone Wolf")) {
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
        } else if (type.equals("Lone Wolf in Terminator Armour")) {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Storm bolter", true);
        } else if (type.equals("Swiftclaw Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Bolt pistol", true);

            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type.equals("Wolf Guard Bike Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
    		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addMeleeRelic();
            addCombiFury();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type.equals("Skyclaw Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type.equals("Wolf Guard Sky Leader") || type.equals("Wolf Guard Pack Leader")) {
    		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            addMeleeRelic();
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Wolf Guard Pack Leader (Wolf Scouts)")) {
    		ogE.addElement(new OptionsGruppeEintrag("Bolt Pistol", getPts("Bolt Pistol (SM)")));
    		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Bolt Pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            addMeleeRelic();
            addCombiFury();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Boltgun", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Long Fang Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol + Boltgun", getPts("Bolt pistol (SM)") + getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol + Boltgun", true);
        } else if (type.equals("Wolf Guard Pack Leader in Terminator Armour")) {
            addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            addCombiFury();
            ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);
        } else if (type.equals("Wolf Guard Pack Leader in Terminator Armour (Blood Claws)") || type.equals("Wolf Guard Pack Leader in Terminator Armour (Grey Hunters)")  || type.equals("Wolf Guard Pack Leader in Terminator Armour (Long Fangs)")) {
        	if(type.equals("Wolf Guard Pack Leader in Terminator Armour (Blood Claws)") || type.equals("Wolf Guard Pack Leader in Terminator Armour (Long Fangs)")) {
                ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
        	}
        	addTerminatorMeleeRelic();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

        	addTerminatorMeleeRelic();
            addCombiFury();
            if(type.equals("Wolf Guard Pack Leader in Terminator Armour (Long Fangs)")) {
            	ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
            }
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Storm bolter", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Wolf Guard in Terminator Armour")) {
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
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Wolf Guard Cataphractii Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
        	ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        	ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

        	seperator();
        	add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grenade harness", getPts("Grenade harness")));
        } else if (type.equals("Wolf Guard Tartaros Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
        	ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        	ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Power sword", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", getPts("Combi-Bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", getPts("plasma blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", getPts("volkite charger")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Combi-Bolter", true);

            seperator();

        	ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        } else if (type.equals("Blood Claw Pack Leader") || type.equals("Grey Hunter Pack Leader")) {

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (type.equals("Blood Claw Pack Leader")) {
                o1.setSelected("Chainsword", true);
            }

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt gun + Bolt pistol", getPts("Bolt pistol (SM)") +  getPts("Bolt pistol (SM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type.equals("Wolf Scout Pack Leader")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("combat knife")));
            ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("sniper rifle (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
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

        if(type.equals("Primaris Wolf Lord") || type.equals("Primaris Battle Leader") || type.equals("Great Company Ancient") || type.equals("Wolf Guard Cataphractii Pack Leader")) {
        	o1.alwaysSelected();
        } else if (type.contains("Wolf Lord") || type.contains("Wolf Guard Battle Leader") || type.equals("Wolf Guard in Terminator Armour") ||
        		type.equals("Wolf Guard Pack Leader in Terminator Armour (Blood Claws)") || type.equals("Wolf Guard Pack Leader") || type.equals("Wolf Guard Pack Leader (Wolf Scouts)")
        		|| type.equals("Wolf Guard Pack Leader in Terminator Armour (Long Fangs)") || type.equals("Wolf Guard Tartaros Pack Leader")) {

            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);
            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);
            if(type.equals("Wolf Lord in Terminator Armour")){
            	oe1.setAktiv(o1.isSelected("Power fist") || o2.isSelected("Power fist"));
            }
        } else if ((type.contains("Wolf Priest") && !type.contains("Primaris")) || type.equals("Wolf Guard Bike Leader")) {
            o1.alwaysSelected();
        } else if (type.equals("Grey Hunter Pack Leader")) {
            o2.alwaysSelected();
        } else if ((type.contains("Rune Priest") && !type.contains("Primaris")) || type.contains("Lone Wolf") || type.equals("Skyclaw Pack Leader") ||
                type.equals("Wolf Guard Sky Leader") || type.equals("Long Fang Pack Leader") ||
                type.equals("Blood Claw Pack Leader")) {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type.equals("Swiftclaw Pack Leader")) {
            legal = o1.isSelected() || o2.isSelected();
            o1.setLegal(legal);
            o2.setLegal(legal);

            o1.setMaxAnzahl(1 - o2.getAnzahl());
            o2.setMaxAnzahl(1 - o1.getAnzahl());
        } else if (type.equals("Wolf Scout Pack Leader")) {
            o1.alwaysSelected();
            o2.alwaysSelected();

            final boolean meleeSelected = o1.isSelected("Power sword") || o1.isSelected("Power axe");

            final boolean plasmaSelected = o2.isSelected("Plasma pistol");

            o2.setAktiv("Plasma pistol", !meleeSelected);

            o1.setAktiv("Power sword", !plasmaSelected);
            o1.setAktiv("Power axe", !plasmaSelected);

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
