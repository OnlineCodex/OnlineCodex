package oc.wh40k.units.im;

import static oc.KeyWord.COMMISSAR;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LORD_COMMISSAR;
import static oc.KeyWord.MILITARUM_TEMPESTUS;
import static oc.KeyWord.OFFICER;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMAstraMilitarumRuestkammer extends RuestkammerVater {

	private OptionsUpgradeGruppe o1, o2;
	private String type = "";
	private OptionsEinzelUpgrade theLaurelsOfCommand;
    private OptionsEinzelUpgrade theDeathmaskOfOllanius;
    private OptionsEinzelUpgrade theDaggerOfTusakh;
    private OptionsEinzelUpgrade kurvosAquila;
    private OptionsEinzelUpgrade relicOfLostCadia;
    private OptionsEinzelUpgrade theArmourOfGrafToschenko;
    private OptionsEinzelUpgrade skullMaskOfAcheron;
    private OptionsEinzelUpgrade theTacticalAutoReliquaryOfTyberius;
    private OptionsEinzelUpgrade orderOrTheIronStarOfMordian;
    private OptionsEinzelUpgrade theShieldOfMortwald;
    private OptionsEinzelUpgrade agripinaaClassOrbitalTracker;
    private OptionsEinzelUpgrade heirloomOfConquest;
    private OptionsEinzelUpgrade cypraMundiNullEmitter;
    
    public IMAstraMilitarumRuestkammer() {
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

    		if(keywords.contains(COMMISSAR) || keywords.contains(LORD_COMMISSAR))
    		{
	    		if(ogE.get(i).getName().equals("Bolt pistol")){
	    			ogE.addElement(new OptionsGruppeEintrag("The Emperor's Benediction", getPts("Bolt pistol (AM)")).setRelic(true));
	    		}
    		}
    		if(ogE.get(i).getName().equals("Power sword")){
    			ogE.addElement(new OptionsGruppeEintrag("Blade of Conquest", getPts("Power sword (AM)")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Catachan"))
    		{
	    		if(ogE.get(i).getName().equals("Power sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Mamorph Tuskblade", getPts("Power sword (AM)")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Vahallan"))
    		{
	    		if(ogE.get(i).getName().equals("Bolt pistol")){
	    			ogE.addElement(new OptionsGruppeEintrag("Pietrov's MK 45", getPts("Bolt pistol (AM)")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getFormationType().equals("Tallarn"))
    		{
	    		if(ogE.get(i).getName().equals("Power sword")){
	    			ogE.addElement(new OptionsGruppeEintrag("Claw of the Deser Tigers", getPts("Power sword (AM)")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Emperor's Fist Tank Company"))
    		{
	    		if(ogE.get(i).getName().equals("Battle cannon")){
	    			ogE.addElement(new OptionsGruppeEintrag("Hammer of Sunderance", getPts("Battle cannon")).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(theLaurelsOfCommand = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Laurels Of Command", 0).setRelic(true));
       	add(theDeathmaskOfOllanius = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Deathmask Of Ollanius", 0).setRelic(true));
       	add(theDaggerOfTusakh = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Dagger Of Tu'sakh", 0).setRelic(true));
       	add(kurvosAquila = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kurvo's Aquila", 0).setRelic(true));
       	add(relicOfLostCadia = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Relic Of Lost Cadia", 0).setRelic(true));
       	add(theArmourOfGrafToschenko = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Armour Of Graf Toschenko", 0).setRelic(true));
       	add(skullMaskOfAcheron = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skull Mask Of Acheron", 0).setRelic(true));
       	add(theTacticalAutoReliquaryOfTyberius = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Tactical Auto-Reliquary Of Tyberius", 0).setRelic(true));
       	add(orderOrTheIronStarOfMordian = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Order Or The Iron Star Of Mordian", 0).setRelic(true));
       	add(theShieldOfMortwald = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Shield Of Mortwald", 0).setRelic(true));
       	add(agripinaaClassOrbitalTracker = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Agripinaa-Class Orbital Tracker", 0).setRelic(true));
       	add(heirloomOfConquest = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heirloom of Conquest", 0).setRelic(true));
       	add(cypraMundiNullEmitter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cypra Mundi Null-Emitter", 0).setRelic(true));
       	
       	offsetX += buttonBreite + 15;
       	seperator();

        if (type == "Company Commander" || type == "Platoon Commander") {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Lord Commissar" || type == "Commissar") {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Power sword", "Power sword (AM)", buildaVater);
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Bolt pistol", "Bolt pistol (AM)", buildaVater);
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Sergeant") {

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe [INDEX]", getPts("Power axe (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul [INDEX]", getPts("Power maul (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Veteran Sergeant") {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Tempestor Prime") {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
            ogE.addElement(new OptionsGruppeEintrag("Tempestus command rod", getPts("Tempestus command rod")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Tempestor") {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
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
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void refreshen() {

        if (type == "Company Commander" || type == "Platoon Commander" || type == "Sergeant" || type == "Veteran Sergeant" || type == "Tempestor") {
            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if (type == "Lord Commissar" || type == "Commissar") {
        	o1.alwaysSelected();
            o2.alwaysSelected();

            if(type == "Lord Commissar"){
            	o1.setMaxAnzahl(2);
            } else{
            	o1.setMaxAnzahl(1);
            }

        } else if (type == "Tempestor Prime") {
            o2.alwaysSelected();
        }

        theLaurelsOfCommand.setAktiv((chosenRelic == null || theLaurelsOfCommand.isSelected()) && keywords.contains(OFFICER));
        theDeathmaskOfOllanius.setAktiv((chosenRelic == null || theDeathmaskOfOllanius.isSelected()) && keywords.contains(INFANTRY));
        theDaggerOfTusakh.setAktiv((chosenRelic == null || theDaggerOfTusakh.isSelected()) && keywords.contains(INFANTRY));
        kurvosAquila.setAktiv((chosenRelic == null || kurvosAquila.isSelected()) && keywords.contains(OFFICER));
        relicOfLostCadia.setAktiv((chosenRelic == null || relicOfLostCadia.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Cadian"));
        theArmourOfGrafToschenko.setAktiv((chosenRelic == null || theArmourOfGrafToschenko.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Vostroyan") && keywords.contains(INFANTRY));
        skullMaskOfAcheron.setAktiv((chosenRelic == null || skullMaskOfAcheron.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Armageddon"));
        theTacticalAutoReliquaryOfTyberius.setAktiv((chosenRelic == null || theTacticalAutoReliquaryOfTyberius.isSelected()) && keywords.contains(MILITARUM_TEMPESTUS));
        orderOrTheIronStarOfMordian.setAktiv((chosenRelic == null || orderOrTheIronStarOfMordian.isSelected()) && keywords.contains(INFANTRY) && BuildaHQ.aktBuildaVater.getFormationType().equals("Mordian"));
        theShieldOfMortwald.setAktiv((chosenRelic == null || theShieldOfMortwald.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Emperor's Blade Assault Company"));
        agripinaaClassOrbitalTracker.setAktiv((chosenRelic == null || agripinaaClassOrbitalTracker.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Emperor's Wrath Artillery Company"));
        heirloomOfConquest.setAktiv((chosenRelic == null || heirloomOfConquest.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Emperor's Conclave Infantry Company"));
        cypraMundiNullEmitter.setAktiv((chosenRelic == null || cypraMundiNullEmitter.isSelected()) && BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Tempestus Drop Force"));
    }

}
