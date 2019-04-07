package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMDarkAngelsRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade shroudOfHeroes;
    private OptionsEinzelUpgrade theEyeOfTheUnseen;

    public IMDarkAngelsRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    public void addRelics() {

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Haevenfall Blade", getPts("Power sword (SM)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("MC Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Haevenfall Blade", getPts("Master crafted power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Storm bolter")){
    			ogE.addElement(new OptionsGruppeEintrag("Foe-Smiter", getPts("Storm bolter (SM)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power maul")){
    			ogE.addElement(new OptionsGruppeEintrag("Mace of Redemption", getPts("Power maul (SM)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Combi-Plasma")){
    			ogE.addElement(new OptionsGruppeEintrag("Lion's Roar", getPts("Combi-plasma")).setRelic(true));
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;

       	add(shroudOfHeroes = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shroud of Heroes", 0).setRelic(true));
       	add(theEyeOfTheUnseen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of the Unseen", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();

    	if(type.equals("Interrogator-Chaplain")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Crozius arcanum", getPts("Crozius arcanum")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Ravenwing Talonmaster")){
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();
    	} else if(type.equals("Interrogator-Chaplain in Terminator Armour")){
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if (type.equals("Chaplain")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(2, true);
        } else if (type.equals("Librarian") || type.equals("Librarian on Bike")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("Bolt pistol", "Bolt pistol (SM)", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }else if (type.equals("Primaris Librarian")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Force sword", true);
        } else if (type.equals("Librarian in Terminator Armour")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("Storm bolter", "Storm bolter (SM)", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } if (type.equals("Master")) {
            ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master-crafted boltgun", getPts("Master-crafted boltgun")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type.contains("Techmarine")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(2, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm")));
            ogE.addElement(new OptionsGruppeEintrag("Conversion beamer", getPts("conversion beamer")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servo-harness", getPts("Servo-arm") + getPts("Plasma cutter") + getPts("Flamer (SM)")));
        } else if (type.equals("Apothecary")) {
        	ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected("Chainsword", true);

            seperator();

        	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected("Bolt pistol", true);
        } else if (type.equals("Company Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(1, true);
        } else if (type.equals("Primaris Ancient")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected("Bolt pistol", true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt rifle", getPts("Bolt rifle")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected("Bolt rifle", true);
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

    	if(type.equals("Interrogator-Chaplain") ||
    			type.equals("Librarian") ||
				type.equals("Librarian on Bike") ||
				type.equals("Primaris Librarian") ||
				type.equals("Librarian in Terminator Armour") ||
				type.equals("Apothecary") ||
				type.equals("Primaris Ancient")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Ravenwing Talonmaster") ||
    			type.equals("Interrogator-Chaplain in Terminator Armour") ||
    			type.equals("Chaplain") ||
    			type.equals("Company Ancient")){
    		o1.alwaysSelected();
    	}
    	if(type.equals("Master")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		o1.setAktiv(!o3.isSelected());
    		o2.setAktiv(!o3.isSelected());
    	}

        if (type.contains("Techmarine")) {
            if (oe1.isSelected()) {
                o3.setSelected(0, true);
                o3.setSelected(1, false);
            }
            o3.alwaysSelected();
        }

    	shroudOfHeroes.setAktiv((chosenRelic == null || shroudOfHeroes.isSelected()));
    	theEyeOfTheUnseen.setAktiv(((chosenRelic == null || theEyeOfTheUnseen.isSelected())));
    }

}
