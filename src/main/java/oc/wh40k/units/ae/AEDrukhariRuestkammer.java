package oc.wh40k.units.ae;

import static oc.KeyWord.ARCHON;
import static oc.KeyWord.HAEMONCULUS;
import static oc.KeyWord.SUCCUBUS;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEDrukhariRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade animusVitae;
    private OptionsEinzelUpgrade helmOfSpite;
    private OptionsEinzelUpgrade nightmareDoll;
    private OptionsEinzelUpgrade theArmourOfMisery;
    private OptionsEinzelUpgrade writeOfTheLivingMuse;
    private OptionsEinzelUpgrade obsidianVeil;
    private OptionsEinzelUpgrade phialBouquet;
    private OptionsEinzelUpgrade traitorsEmbrace;
    private OptionsEinzelUpgrade vexatorMask;

    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public AEDrukhariRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Huskblade")){
    			ogE.addElement(new OptionsGruppeEintrag("Djin Blade", getPts("Huskblade")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Splinter pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Parasite's Kiss", getPts("Splinter pistol")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Agoniser")){
    			ogE.addElement(new OptionsGruppeEintrag("Triptych Whip", getPts("Agoniser")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Kabal of the Poisoned Tongue"))
    		{
    			if(keywords.contains(ARCHON)){
    				if(ogE.get(i).getName().equals("Splinter pistol")){
    					ogE.addElement(new OptionsGruppeEintrag("Soul-Seeker", getPts("Splinter pistol")).setRelic(true));
    				}
    			}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Cult of the Red Grief"))
    		{
	    		if(ogE.get(i).getName().equals("Archite glaive")){
	    			ogE.addElement(new OptionsGruppeEintrag("Blood Glaive", getPts("Archite glaive")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dark Creed"))
    		{
	    		if(ogE.get(i).getName().equals("Stinger pistol")){
	    			ogE.addElement(new OptionsGruppeEintrag("Spirit Sting", getPts("Stinger pistol")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Coven of Twelve"))
    		{
	    		if(ogE.get(i).getName().equals("Haemonculus tools")){
	    			ogE.addElement(new OptionsGruppeEintrag("Flensing blade", getPts("Haemonculus tools")).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(animusVitae = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Animus Vitae", 0).setRelic(true));
       	add(helmOfSpite = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Helm of Spite", 0).setRelic(true));
       	add(nightmareDoll = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nightmare Doll", 0).setRelic(true));
       	add(theArmourOfMisery = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour Of Misery", 0).setRelic(true));
       	add(writeOfTheLivingMuse = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Write Of The LivingMuse", 0).setRelic(true));
       	add(obsidianVeil = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Obsidian Veil", 0).setRelic(true));
       	add(phialBouquet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phial Bouquet", 0).setRelic(true));
       	add(traitorsEmbrace = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Traitors Embrace", 0).setRelic(true));
       	add(vexatorMask = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vexator Mask", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Archon")) {
            ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast Pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Blaster (Index)", getPts("Blaster")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Huskblade", getPts("Huskblade")));
            ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
            ogE.addElement(new OptionsGruppeEintrag("Venom blade", getPts("Venom blade")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if(type.equals("Succubus")) {
            ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
            ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("Impaler")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Archite glaive", getPts("Archite glaive")));
            ogE.addElement(new OptionsGruppeEintrag("Hydra gauntlets", getPts("Hydra gauntlets")));
            ogE.addElement(new OptionsGruppeEintrag("Razorflails", getPts("Razorflails")));
            ogE.addElement(new OptionsGruppeEintrag("Shardnet and impaler", getPts("Shardnet and impaler")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
    	} else if(type.equals("Haemonculus")){
            ogE.addElement(new OptionsGruppeEintrag("Stinger pistol", getPts("Stinger pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Hexrifle", getPts("Hexrifle")));
            ogE.addElement(new OptionsGruppeEintrag("Liquifier gun", getPts("Liquifier gun")));
            ogE.addElement(new OptionsGruppeEintrag("Splinter pistol (Index)", getPts("Splinter pistol")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Haemonculus tools", getPts("Haemonculus tools")));
            ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
            ogE.addElement(new OptionsGruppeEintrag("Electrocorrosive whip", getPts("Electrocorrosive whip")));
            ogE.addElement(new OptionsGruppeEintrag("Flesh gauntlet", getPts("Flesh gauntlet")));
            ogE.addElement(new OptionsGruppeEintrag("Mindphase gauntlet", getPts("Mindphase gauntlet")));
            ogE.addElement(new OptionsGruppeEintrag("Scissorhand", getPts("Scissorhand")));
            ogE.addElement(new OptionsGruppeEintrag("Venom blade", getPts("Venom blade")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Beastmaster")) {
            ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
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

    	if(type.equals("Archon") ||
    			type.equals("Succubus") ||
    			type.equals("Haemonculus")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Beastmaster")){
    		o1.alwaysSelected();
    	}

    	animusVitae.setAktiv((chosenRelic == null || animusVitae.isSelected()));
    	helmOfSpite.setAktiv(((chosenRelic == null || helmOfSpite.isSelected())));
    	nightmareDoll.setAktiv(((chosenRelic == null || nightmareDoll.isSelected())) && keywords.contains(HAEMONCULUS));
    	theArmourOfMisery.setAktiv((chosenRelic == null || theArmourOfMisery.isSelected()) && keywords.contains(ARCHON) && BuildaHQ.aktBuildaVater.getFormationType().equals("Kabal of the Obsidian Rose"));
    	writeOfTheLivingMuse.setAktiv((chosenRelic == null || writeOfTheLivingMuse.isSelected()) && keywords.contains(ARCHON) && BuildaHQ.aktBuildaVater.getFormationType().equals("Kabal of the Black Heart"));
    	obsidianVeil.setAktiv((chosenRelic == null || obsidianVeil.isSelected()) && keywords.contains(ARCHON) && BuildaHQ.aktBuildaVater.getFormationType().equals("Kabal of the Flayed Skull"));
    	phialBouquet.setAktiv((chosenRelic == null || phialBouquet.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Cult of Strife"));
    	traitorsEmbrace.setAktiv((chosenRelic == null || traitorsEmbrace.isSelected()) && keywords.contains(SUCCUBUS) && BuildaHQ.aktBuildaVater.getFormationType().equals("Cult of the Cursed Blade"));
    	vexatorMask.setAktiv((chosenRelic == null || vexatorMask.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Prophets of Flesh"));
    }

}
