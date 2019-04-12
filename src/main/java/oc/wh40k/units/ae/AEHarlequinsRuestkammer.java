package oc.wh40k.units.ae;

import static oc.KeyWord.SHADOWSEER;
import static oc.KeyWord.TROUPE_MASTER;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEHarlequinsRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade theMaskOfSecrets;
    private OptionsEinzelUpgrade suitOfHiddenKnives;
    private OptionsEinzelUpgrade starmistRaiment;
    private OptionsEinzelUpgrade theLaughingGodsEye;
    private OptionsEinzelUpgrade theMidnightChime;
    private OptionsEinzelUpgrade theGhoulMask;
    private OptionsEinzelUpgrade faolchusTalon;
    private OptionsEinzelUpgrade scintillantVeil;

    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public AEHarlequinsRuestkammer() {
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

    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("The Storied Sword", getPts("Power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Shuriken pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Crescendo", getPts("Shuriken pistol")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Harlequin's kiss")){
    			ogE.addElement(new OptionsGruppeEintrag("Cegorach's Rose", getPts("Harlequin's kiss")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Veiled Path"))
    		{
        		if(ogE.get(i).getName().equals("Miststave")){
        			ogE.addElement(new OptionsGruppeEintrag("Mirrorstave", getPts("Miststave")).setRelic(true));
        		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dreaming Shadow"))
    		{
        		if(ogE.get(i).getName().equals("Shrieker cannon")){
        			ogE.addElement(new OptionsGruppeEintrag("Curtainfall", getPts("Shrieker cannon")).setRelic(true));
        		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(theMaskOfSecrets = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Mask Of Secrets", 0).setRelic(true));
       	add(suitOfHiddenKnives = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suit Of Hidden Knives", 0).setRelic(true));
       	add(starmistRaiment = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Starmist Raiment", 0).setRelic(true));
       	add(theLaughingGodsEye = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Laughing God's Eye", 0).setRelic(true));
       	add(theMidnightChime = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Midnight Sorrow", 0).setRelic(true));
       	add(theGhoulMask = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Ghoul Mask", 0).setRelic(true));
       	add(faolchusTalon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Faolchus Talon", 0).setRelic(true));
       	add(scintillantVeil = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scintillant Veil", 0).setRelic(true));

       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Shadowseer")) {
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

    	} else if(type.equals("Troupe Master")) {
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol (Harlequins)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Harlequin's blade", getPts("Harlequin's blade")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's embrace", getPts("Harlequin's embrace")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Death Jester")) {
            ogE.addElement(new OptionsGruppeEintrag("Shrieker cannon", getPts("Shrieker cannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Solitaire")) {
    		ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

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

    	if(type.equals("Troupe Master") ||
    			type.equals("Solitaire")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Shadowseer") ||
    			type.equals("Death Jester")){
    		o1.alwaysSelected();
    	}


    	theMaskOfSecrets.setAktiv((chosenRelic == null || theMaskOfSecrets.isSelected()));
    	suitOfHiddenKnives.setAktiv((chosenRelic == null || suitOfHiddenKnives.isSelected()));
    	starmistRaiment.setAktiv((chosenRelic == null || starmistRaiment.isSelected()));
    	theLaughingGodsEye.setAktiv((chosenRelic == null || theLaughingGodsEye.isSelected()));
    	theMidnightChime.setAktiv((chosenRelic == null || theMidnightChime.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Midhnight Sorrow"));
    	theGhoulMask.setAktiv((chosenRelic == null || theGhoulMask.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Frozen Stars"));
    	faolchusTalon.setAktiv((chosenRelic == null || faolchusTalon.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Soaring Spite"));
    	scintillantVeil.setAktiv((chosenRelic == null || scintillantVeil.isSelected()) && (keywords.contains(TROUPE_MASTER) || (keywords.contains(SHADOWSEER) && BuildaHQ.aktBuildaVater.getFormationType().equals("Silten Shroud"))));
    }

}
