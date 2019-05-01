package oc.wh40k.units.ae;

import static oc.KeyWord.AUTARCH;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEYnnariRuestkammer extends RuestkammerVater {

    public OptionsEinzelUpgrade oe1;
    private OptionsUpgradeGruppe o1, o2, o3, o4, o5;
    private OptionsEinzelUpgrade mirrorgaze;
    private OptionsEinzelUpgrade soulsnare;
    private OptionsEinzelUpgrade theLostShroud;
    private OptionsEinzelUpgrade coragHaisLocket;


    static final Set<String> CHARACTERS = ImmutableSet.of("Lord of Contagion", "Malignant Plaguecaster", "Daemon Prince of Nurgle", "Daemon Prince of Nurgle with Wings",
            "Chaos Lord", "Chaos Lord in Terminator Armour", "Sorcerer", "Sorcerer in Terminator Armour", "", "Necrosius the Undying [FW]", "Noxious Blightbringer", "Foul Blightspawn", "Biologus Putrifier", "Plague Surgeon", "Tallyman");

    public AEYnnariRuestkammer() {
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
    			ogE.addElement(new OptionsGruppeEintrag("Hungering Blade", getPts("Power sword")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Star glaive")){
    			ogE.addElement(new OptionsGruppeEintrag("Hungering Blade", getPts("Star glaive")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Husk blade")){
    			ogE.addElement(new OptionsGruppeEintrag("Hungering Blade", getPts("Husk blade")).setRelic(true));
    		}
    		if(ogE.get(i).getName().equals("Shuriken pistol")){
    			ogE.addElement(new OptionsGruppeEintrag("Song of Ynnead", getPts("Shuriken pistol")).setRelic(true));
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Windrider Host"))
    		{
	    		if(ogE.get(i).getName().equals("Witchblade")){
	    			ogE.addElement(new OptionsGruppeEintrag("Howling Skysword of Galaleth", getPts("Witchblade")).setRelic(true));
	    		}
    		}
    		if(BuildaHQ.aktBuildaVater.getSpecialDetachmentType().equals("Wraith Host"))
    		{
	    		if(ogE.get(i).getName().equals("Witch staff")){
	    			ogE.addElement(new OptionsGruppeEintrag("Warp-Spawn Bane", getPts("Witch staff")).setRelic(true));
	    		}
    		}
    	}
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        int offsetX = randAbstand;
        add(mirrorgaze = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mirrorgaze", 0).setRelic(true));
       	add(soulsnare = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Soulsnare", 0).setRelic(true));
       	add(theLostShroud = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Lost Shroud", 0).setRelic(true));
       	add(coragHaisLocket = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corag Hai's Locket", 0).setRelic(true));
  	
       	offsetX += buttonBreite + 15;
       	seperator();


    	if(type.equals("Farseer") ||
    			type.equals("Farseer Skyrunner") ||
    			type.equals("Warlock") ||
    			type.equals("Warlock Skyrunner")) {
            ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
            ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Autarch")) {
            ogE.addElement(new OptionsGruppeEintrag("Star glaive", getPts("Star glaive")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Autarch with Swooping Hawk Wings")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Autarch Skyrunner")) {
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Spiritseer")) {
            ogE.addElement(new OptionsGruppeEintrag("Witch staff", getPts("Witch staff")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	}
    	
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
    	
    	if(type.equals("Shadowseer")) {
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    	} else if(type.equals("Troupe Master")) {
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol (Harlequins)")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Harlequin's blade", getPts("Harlequin's blade")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Harlequins)")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's embrace", getPts("Harlequin's embrace")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
            ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
    	} else if(type.equals("Death Jester")) {
            ogE.addElement(new OptionsGruppeEintrag("Shrieker cannon", getPts("Shrieker cannon")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
    	} else if(type.equals("Solitaire")) {
    		ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
            addRelics();
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
            addRelics();
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

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

    	if(type.equals("Farseer") ||
    			type.equals("Farseer Skyrunner") ||
    			type.equals("Warlock") ||
    			type.equals("Warlock Skyrunner") ||
    			type.equals("Autarch with Swooping Hawk Wings") ||
    			type.equals("Spiritseer")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Autarch") ||
    			type.equals("Autarch Skyrunner")){
    		o1.alwaysSelected();
    	}
    	
    	if(type.equals("Archon") ||
    			type.equals("Succubus") ||
    			type.equals("Haemonculus")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Beastmaster")){
    		o1.alwaysSelected();
    	}

    	if(type.equals("Troupe Master") ||
    			type.equals("Solitaire")){
    		o1.alwaysSelected();
    		o2.alwaysSelected();
    	}
    	if(type.equals("Shadowseer") ||
    			type.equals("Death Jester")){
    		o1.alwaysSelected();
    	}
    	
    	mirrorgaze.setAktiv(chosenRelic == null || mirrorgaze.isSelected());
    	soulsnare.setAktiv(chosenRelic == null || soulsnare.isSelected());
    	theLostShroud.setAktiv(chosenRelic == null || theLostShroud.isSelected());
    	coragHaisLocket.setAktiv(chosenRelic == null || coragHaisLocket.isSelected());
    }

}
