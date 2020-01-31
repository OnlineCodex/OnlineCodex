package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMInquistionRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2;
    private boolean character = false;

    public IMInquistionRuestkammer() {
        grundkosten = 0;
    }

    public void addRelics() {
    	if(keywords.contains(CHARACTER)) {
	    	for(int i = 0; i < ogE.size(); i++) {
	    		if(ogE.get(i).getName().equals("Bolt pistol")){
	        		ogE.addElement(new OptionsGruppeEintrag("Wrath of the Emperor", getPts("Bolt pistol (AMI)")).setRelic(true));
	    		} else if(ogE.get(i).getName().equals("Blessed blade")){
	        		ogE.addElement(new OptionsGruppeEintrag("Blade of Admonition", getPts("Blessed blade")).setRelic(true));
	    		}
	    	}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        keywords.contains(PSYKER);
        character = keywords.contains(CHARACTER);
        int offsetX = randAbstand;
        int oe1Offset = cnt;

        if(character) {
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Book of St. Lucius", 0).setRelic(true));
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brazier of EternaL Flame", 0).setRelic(true));
	       	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Litanies of Faith", 0).setRelic(true));

	       	if(keywords.contains(CANONESS)) {
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mantle of Ophelia", 0).setRelic(true));
	       	}

	       	offsetX += buttonBreite + 15;
	       	oe1Offset = cnt;
	       	seperator();
        }

        if (type.equals("Inquisitor")) {

        	ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        	ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (IN)")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        	ogE.addElement(new OptionsGruppeEintrag("Condemnor boltgun", getPts("Condemnor boltgun (AMI)")));
        	ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        	ogE.addElement(new OptionsGruppeEintrag("Hot-Shot lasgun", getPts("Hot-Shot lasgun")));
        	ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator (IN)")));
        	ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        	ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AMI)")));
        	ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (IN)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type.equals("Ordo Malleus Inquisitor in Terminator Armour")) {
        	ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        	ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        	ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave (IN)")));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword (IN)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if(oe1 != null) {
        	oe1.getPanel().setLocation(randAbstand, oe1Offset + 20);
        }

        if(o1 != null) {
        	o1.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        if(o2 != null) {
        	o2.getPanel().setLocation(offsetX, 10);
	       	offsetX += buttonBreite + 20;
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {

    	if (type.equals("Inquisitor") || type.equals("Ordo Malleus Inquisitor in Terminator Armour")) {
            o1.alwaysSelected();
            o2.alwaysSelected();
                        
        } 

        if(character){
        	if(o1 != null) {
        		o1.setAktiv("Wrath of the Emperor", (chosenRelic == null || o1.isSelected("Wrath of the Emperor")));
        		o1.setAktiv("Blade of Admonition", (chosenRelic == null || o1.isSelected("Blade of Admonition")));
        	}

        	if(o2 != null) {
        		o2.setAktiv("Wrath of the Emperor", (chosenRelic == null || o2.isSelected("Wrath of the Emperor")));
        		o2.setAktiv("Blade of Admonition", (chosenRelic == null || o2.isSelected("Blade of Admonition")));
        	}

        }
    }
}
