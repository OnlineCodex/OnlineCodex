package oc.wh40k.units.im;

import static oc.KeyWord.WATCH_MASTER;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMDeathwatchRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade baneboltsOfEryxia;
    private OptionsEinzelUpgrade theBeaconAngelis;
    private OptionsEinzelUpgrade theOsseusKey;
    private OptionsEinzelUpgrade theTomeOfEctoclades;

    public IMDeathwatchRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    public void addRelics() {

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Storm shield")){
    			ogE.addElement(new OptionsGruppeEintrag("Dominus Aegis", getPts("Storm shield (Characters)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("The Thief of Secrets", getPts("Power sword (SM)")).setRelic(true));
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;

       	add(baneboltsOfEryxia = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Banebolts of Eryxia", 0).setRelic(true));
       	add(theBeaconAngelis = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Beacon Angelis", 0).setRelic(true));
       	add(theOsseusKey = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Osseus Key", 0).setRelic(true));
       	add(theTomeOfEctoclades = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Tome of Ectoclades", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Watch Master")) {
            ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Watch Captain")){
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Relic-blade", getPts("Relic-blade")));
            ogE.addElement(new OptionsGruppeEintrag("Xenophase blade", getPts("Xenophase blade")));
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
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Characters)")));
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
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Master crafted boltgun", getPts("Master crafted boltgun")));
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
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Characters)")));
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
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            seperator();
    	} else if(type.equals("Watch Captain in Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Relic-blade", getPts("Relic-blade")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist & meltagun", getPts("Power fist (SM)") + getPts("Meltagun (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
    	} else if(type.equals("Primaris Watch Captain")){
            ogE.addElement(new OptionsGruppeEintrag("MC Auto bolt rifle", getPts("Master crafted auto bolt rifle (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("MC Stalker bolt rifle", getPts("Master crafted stalker bolt rifle (DW)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power fist & plasma pistol", getPts("Power fist (SM)") + getPts("Plasma pistol (SM)")));
            addRelics();
            add(o4 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
    	} else if(type.equals("Librarian")){
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
    	} else if (type.equals("Librarian in Terminator Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        }

        if (type.equals("Chaplain")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("rozius arcanum")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist (SM)")));
        } else if (type.equals("Chaplain in Terminator Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("rozius arcanum")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist (SM)")));
        } else if (type.equals("Primaris Librarian")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        } else if (type.equals("Primaris Chaplain")) {
            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Absolver bolt pistol", getPts("Absolver bolt pistol (DW)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));
        }

        if(o1 != null) {
        	o1.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o2 != null) {
        	o2.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o3 != null) {
        	o3.getPanel().setLocation(offsetX, 10);
        	offsetX += buttonBreite + 20;
        }

        if(o4 != null) {
        	o4.getPanel().setLocation(offsetX, 10);
        	offsetX += buttonBreite + 20;
        }

        if(o5 != null) {
        	o5.getPanel().setLocation(offsetX, 10);
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

    	if(type.equals("Watch Master") ||
    			type.equals("Librarian in Terminator Armour")) {
    		o1.alwaysSelected();
    	}
    	if(type.equals("Watch Captain") ||
    			type.equals("Watch Captain in Terminator Armour") ||
    			type.equals("Librarian") ||
                type.equals("Chaplain") ||
                type.equals("Chaplain in Terminator Armour") ||
                type.equals("Primaris Librarian") ||
                type.equals("Primaris Chaplain")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}

    	if(type.equals("Primaris Watch Captain")){
	        o1.alwaysSelected();
	        o2.alwaysSelected();
	        o1.setActive(!o4.isSelected());
	        o2.setActive(!o4.isSelected());
    	}

    	baneboltsOfEryxia.setAktiv((chosenRelic == null || baneboltsOfEryxia.isSelected()));
    	theBeaconAngelis.setAktiv(((chosenRelic == null || theBeaconAngelis.isSelected())));
    	theOsseusKey.setAktiv(((chosenRelic == null || theOsseusKey.isSelected()) && keywords.contains(WATCH_MASTER)));
    	theTomeOfEctoclades.setAktiv((chosenRelic == null || theTomeOfEctoclades.isSelected()));
    }

}
