package oc.wh40k.units.im;

import static oc.KeyWord.DOMINUS;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMTechPriestRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade anzionsPseudogenetor;
    private OptionsEinzelUpgrade autocaduceusOfArkhanLand;
    private OptionsEinzelUpgrade raimentOfTheTechnomartyr;
    private OptionsEinzelUpgrade theSkullOfElderNikola;
    private OptionsEinzelUpgrade theOmniscientMask;
    private OptionsEinzelUpgrade theCerebralTechnoMitre;
    private OptionsEinzelUpgrade theSolarFlare;
    private OptionsEinzelUpgrade theAdamantineArm;
    private OptionsEinzelUpgrade theOmnissiahsHand;
    private OptionsEinzelUpgrade theEyeOfXILexum;

    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public IMTechPriestRuestkammer() {
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

    	for(int i = 0; i < ogE.size(); i++) {

    		if(ogE.get(i).getName().equals("Omnissian axe")){
    			ogE.addElement(new OptionsGruppeEintrag("Pater Cog-Tooth", getPts("Omnissian axe")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Power fist")){
    			ogE.addElement(new OptionsGruppeEintrag("The Uncreator Gauntlet", getPts("Power fist (AME)")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Phosphor serpenta")){
    			ogE.addElement(new OptionsGruppeEintrag("Phosphoenix", getPts("Phosphor serpenta")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Mars"))
    		{
    			if(ogE.get(i).getName().equals("Omnissian axe")){
    				ogE.addElement(new OptionsGruppeEintrag("The Red Axe", getPts("Omnissian axe")).setRelic(true));
    			}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Ryza"))
    		{
    			if(ogE.get(i).getName().equals("Volkite blaster")){
    				ogE.addElement(new OptionsGruppeEintrag("Weapon XCIX", getPts("Volkite blaster")).setRelic(true));
    			}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;

       	add(anzionsPseudogenetor = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Anzion's Pseudogenetor", 0).setRelic(true));
       	add(autocaduceusOfArkhanLand = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Autocaduceus of Arkhan Land", 0).setRelic(true));
       	add(raimentOfTheTechnomartyr = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Raiment of the Technomartyr", 0).setRelic(true));
       	add(theSkullOfElderNikola = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Skull of Elder Nikola", 0).setRelic(true));
       	add(theOmniscientMask = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Omniscient Mask", 0).setRelic(true));
       	add(theCerebralTechnoMitre = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Cerebral Techno-Mitre", 0).setRelic(true));
       	add(theSolarFlare = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Solar Flare", 0).setRelic(true));
       	add(theAdamantineArm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Adamantine Arm", 0).setRelic(true));
       	add(theOmnissiahsHand = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Omnissiah's Hand", 0).setRelic(true));
       	add(theEyeOfXILexum = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Eye of XI-Lexum", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Tech-Priest Dominus")) {
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Omnissian axe", getPts("Omnissian axe")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Volkite blaster", getPts("Volkite blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Eradication ray", getPts("Eradication ray")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Macrostubber", getPts("Macrostubber")));
            ogE.addElement(new OptionsGruppeEintrag("Phosphor serpenta", getPts("Phosphor serpenta")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();
    	} else if(type.equals("Tech-Priest Enginseer")){
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Omnissian axe", getPts("Omnissian axe")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol (AME)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servo-arm", getPts("Servo-arm (AME)")));
            addRelics();
            add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();
    	} else if(type.equals("Cybernetica Datasmith")){
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (AME)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Gamma pistol", getPts("Gamma pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "option", ogE, 1));

            seperator();
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

    	if(type.equals("Tech-Priest Dominus") ||
    			type.equals("Tech-Priest Enginseer")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    		o3.alwaysSelected();
    	} else if(type.equals("Cybernetica Datasmith")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}

    	anzionsPseudogenetor.setAktiv((chosenRelic == null || anzionsPseudogenetor.isSelected()));
    	autocaduceusOfArkhanLand.setAktiv(((chosenRelic == null || autocaduceusOfArkhanLand.isSelected())));
    	raimentOfTheTechnomartyr.setAktiv(((chosenRelic == null || raimentOfTheTechnomartyr.isSelected())));
    	theSkullOfElderNikola.setAktiv((chosenRelic == null || theSkullOfElderNikola.isSelected()));
    	theOmniscientMask.setAktiv((chosenRelic == null || theOmniscientMask.isSelected()));
    	theCerebralTechnoMitre.setAktiv((chosenRelic == null || theCerebralTechnoMitre.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Graia") && keywords.contains(DOMINUS));
    	theSolarFlare.setAktiv((chosenRelic == null || theSolarFlare.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Lucius"));
    	theAdamantineArm.setAktiv((chosenRelic == null || theSolarFlare.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Metalica"));
    	theOmnissiahsHand.setAktiv((chosenRelic == null || theSolarFlare.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Stygies VIII"));
    	theEyeOfXILexum.setAktiv((chosenRelic == null || theSolarFlare.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Forge World Agripinaa"));
    }

}
