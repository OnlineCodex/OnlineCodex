package oc.wh40k.units.ty;

import static oc.KeyWord.CHARACTER;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TYGenestealerCultRuestkammer extends RuestkammerVater {

    private OptionsUpgradeGruppe o1, o2, o3;
    private boolean character = false;
    private OptionsEinzelUpgrade amuletOfTheVoidwyrm;
    private OptionsEinzelUpgrade scourgeOfDistantStars;
    private OptionsEinzelUpgrade vockorsTalisman;
    private OptionsEinzelUpgrade markOfTheClawedOmnissiah;
    private OptionsEinzelUpgrade reliquaryOfSaintTenndarc;
    private OptionsEinzelUpgrade elixirOfThePrimeSpecimen;
    private OptionsEinzelUpgrade theCrouchling;
    private OptionsZaehlerGruppe familiars;
    private OptionsEinzelUpgrade vialOfTheGrandsiresBlood;
    
    Set<String> CHARACTERS = ImmutableSet.of("Patriarch", "Magus", "Primus", "Acolyte Iconward", "Abominant", "Jackal Alphus", "Clamavus", "Locus", "Sanctus", "Kelermorph", "Nexos", "Biophagus");
    Set<String> PSYKERS = ImmutableSet.of("Magus");


    public TYGenestealerCultRuestkammer() {
        grundkosten = 0;
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    public void setDefault1(String s) {
    }

    public void setDefault2(String s) {
    }

    public void addRelics() {
    	if(character) {
	    	boolean bonesword = false;
	    	boolean locusBlades = false;

	    	for(int i = 0; i < ogE.size(); i++) {
	    		bonesword = bonesword || ogE.get(i).getName().equals("Bonesword");
	    		locusBlades = locusBlades || ogE.get(i).getName().equals("Locus blades");

	    		if(ogE.get(i).getName().equals("Autopistol")){
	    			ogE.addElement(new OptionsGruppeEintrag("Oppressor's Bane", getPts("Autopistol")).setRelic(true));
	    		}
	    		if(ogE.get(i).getName().equals("Cultist knife") || ogE.get(i).getName().equals("Sanctus bio-dagger")){
	    			ogE.addElement(new OptionsGruppeEintrag("Dagger of Swift Sacrifice", getPts("Cultist knife")).setRelic(true));
	    		}
	    		if(ogE.get(i).getName().equals("Force stave")){
	    			if(BuildaHQ.aktBuildaVater.getFormationType().equals("The Rusted Claw")) {
	    				ogE.addElement(new OptionsGruppeEintrag("Metallophagic stave", getPts("Force stave")).setRelic(true));
	    			}
	    		}
	    		if(ogE.get(i).getName().equals("Jackal sniper rifle") || ogE.get(i).getName().equals("Silencer sniper rifle")){
	    			int points = 0;

	    			if(ogE.get(i).getName().equals("Jackal sniper rifle")) points = getPts("Jackal sniper rifle");
	    			else points = getPts("Silencer sniper rifle");

	    			ogE.addElement(new OptionsGruppeEintrag("The gift from beyond", points).setRelic(true));
	    		}
	    		if(ogE.get(i).getName().equals("Power sledgehammer")){
	    			if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Anointed Throng")) {
	    				ogE.addElement(new OptionsGruppeEintrag("Blessed Sledgehammer", getPts("Power sledgehammer")).setRelic(true));
	    			}
	    		}
	    	}

    		if(bonesword){
        		ogE.addElement(new OptionsGruppeEintrag("Sword of the void's eye", getPts("Bonesword (GSC)")).setRelic(true));
    		}

    		if(bonesword || locusBlades){
    			int points = 0;

    			if(bonesword) points = getPts("Bonesword (GSC)");
    			else points = getPts("Locus blades");

	    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Cult Of The Four-Armed Emperor")) {
	    			ogE.addElement(new OptionsGruppeEintrag("Sword of the four-armed Emperor", points).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        character = CHARACTERS.contains(type) || keywords.contains(CHARACTER);
        int offsetX = randAbstand;

        if(character) {
	       	if(type.equals("Acolyte Iconward")) {
	       		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of the Cult Ascendant", 0).setRelic(true));
	       	}

	       	add(amuletOfTheVoidwyrm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Amulet of the Voidwyrm", 0).setRelic(true));
	       	add(scourgeOfDistantStars = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scourge of distant Stars", 0).setRelic(true));
	       	add(vockorsTalisman = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vockor's Talisman", 0).setRelic(true));
	       	add(vockorsTalisman = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vockor's Talisman", 0).setRelic(true));
	       	add(markOfTheClawedOmnissiah = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mark of the clawed Omnissiah", 0).setRelic(true));
	       	add(reliquaryOfSaintTenndarc = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reliquary of Saint Tenndarc", 0).setRelic(true));
	       	add(elixirOfThePrimeSpecimen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Elixir of the Prime Specimen", 0).setRelic(true));
	       	add(vialOfTheGrandsiresBlood = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vial Of The Grandsire's Blood", 0).setRelic(true));
	       	offsetX += buttonBreite + 15;
	       	seperator();
        }

        if (type.equals("Patriarch")) {
            ogE.addElement(new OptionsGruppeEintrag("Monstrous rending claws", getPts("Monstrous rending claws (GSC)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Familiar", getPts("Familiars")));
            add(familiars = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            add(theCrouchling = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crouchling", getPts("Familiars")).setRelic(true));

            seperator();
        } else if (type.equals("Acolyte Iconward")) {
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);
        } else if (type.equals("Magus")) {
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Familiar", getPts("Familiars")));
            add(familiars = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            add(theCrouchling = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Crouchling", getPts("Familiars")).setRelic(true));
        } else if (type.equals("Primus")) {
            ogE.addElement(new OptionsGruppeEintrag("Needle pistol", getPts("Needle pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bonesword", getPts("Bonesword (GSC)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Injector claw", getPts("Injector claw")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3.setSelected(0, true);
        } else if (type.equals("Abominant")) {
            ogE.addElement(new OptionsGruppeEintrag("Rending claw", getPts("Rending claws (GSC)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Power sledgehammer", getPts("Power sledgehammer")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Mindwyrm Familiar", getPts("Familiars")));
            ogE.addElement(new OptionsGruppeEintrag("The Crouchling", getPts("Familiars")).setRelic(true));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3.setSelected(0, true);
        } else if (type.equals("Jackal Alphus")) {
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Jackal sniper rifle", getPts("Jackal sniper rifle")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);
        } else if (type.equals("Clamavus")) {
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);
        } else if (type.equals("Locus")) {
            ogE.addElement(new OptionsGruppeEintrag("Locus blades", getPts("Locus blades")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Hypermorph tail", getPts("Hypermorph tail")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);
        } else if (type.equals("Sanctus")) {
            ogE.addElement(new OptionsGruppeEintrag("Silencer sniper rifle", getPts("Silencer sniper rifle")));
            ogE.addElement(new OptionsGruppeEintrag("Sanctus bio-dagger", getPts("Sanctus bio-dagger")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Soulsight Familiar", getPts("Familiars")));
            ogE.addElement(new OptionsGruppeEintrag("The Crouchling", getPts("Familiars")).setRelic(true));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);
        } else if (type.equals("Kelermorph")) {
            ogE.addElement(new OptionsGruppeEintrag("Liberator autostub", getPts("Liberator autostub")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);
        } else if (type.equals("Nexos")) {
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);
        }  else if (type.equals("Biophagus")) {
        	ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Injector goad", getPts("Injector goad")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Alchemicus Familiar", getPts("Familiars")));
            ogE.addElement(new OptionsGruppeEintrag("The Crouchling", getPts("Familiars")).setRelic(true));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3.setSelected(0, true);
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
        }

        sizeSetzen();

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

        if (type.equals("Patriarch")) {
        	if(o1 != null) {
        		o1.alwaysSelected();
        	}

        	familiars.setMaxAnzahl(2-((theCrouchling.isSelected())? 1:0));

        } else if (type.equals("Acolyte Iconward") || type.equals("Nexos")) {
        	if(o1 != null) {
        		o1.alwaysSelected();
        	}
        } else if (type.equals("Magus") || type.equals("Primus") || type.equals("Abominant")) {
        	if(o1 != null) {
        		o1.alwaysSelected();
        	}
        	if(o2 != null) {
        		o2.alwaysSelected();
        	}
        	if(o3 != null) {
        		o3.alwaysSelected();
        	}
        } else if (type.equals("Jackal Alphus") || type.equals("Locus") || type.equals("Sanctus") || type.equals("Kelermorph") || type.equals("Biophagus")) {
        	if(o1 != null) {
        		o1.alwaysSelected();
        	}
        	if(o2 != null) {
        		o2.alwaysSelected();
        	}
        } else if (type.equals("Clamavus")) {
        	if(o1 != null) {
        		o1.alwaysSelected();
        	}
        }

        if(character) {
	        amuletOfTheVoidwyrm.setAktiv((chosenRelic == null || amuletOfTheVoidwyrm.isSelected()));
	        scourgeOfDistantStars.setAktiv((chosenRelic == null || scourgeOfDistantStars.isSelected()));
	    	vockorsTalisman.setAktiv((chosenRelic == null || vockorsTalisman.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("The Hivecult"));
	    	markOfTheClawedOmnissiah.setAktiv((chosenRelic == null || markOfTheClawedOmnissiah.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("The Bladed Cog"));
	    	reliquaryOfSaintTenndarc.setAktiv((chosenRelic == null || reliquaryOfSaintTenndarc.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("The Pauper Princes"));
	    	elixirOfThePrimeSpecimen.setAktiv((chosenRelic == null || elixirOfThePrimeSpecimen.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("The Twisted Helix"));
	    	vialOfTheGrandsiresBlood.setAktiv((chosenRelic == null || vialOfTheGrandsiresBlood.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Deliverance Broodsurge"));
        }
    }

}
