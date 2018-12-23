package oc.wh40k.units.ty;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.*;

public class TYRuestkammer extends RuestkammerVater {

    private static final Set<String> CHARACTERS = ImmutableSet.of("Broodlord", "Hive Tyrant", "Tyranid Prime", "Tervigon", "Neurothrope", "Trygon Prime");
    private static final Set<String> MONSTER = ImmutableSet.of("Hive Tyrant", "Tervigon", "Trygon Prime");

    private final String type;

    private OptionsUpgradeGruppe o1;
    private OptionsUpgradeGruppe o2;
    private OptionsUpgradeGruppe o3;

    private boolean character;

	private OptionsEinzelUpgrade chamelonicMutation;
	private OptionsEinzelUpgrade hyperadaptiveBiology;
	private OptionsEinzelUpgrade infrasonicRoar;
	private OptionsEinzelUpgrade theReaperofObliterax;
	private OptionsEinzelUpgrade theMawClawsofThyrax;

    public TYRuestkammer(String type) {
        this.type = type;
    	
    	if(CHARACTERS.contains(type)) {
       	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Ymgarl Factor", 0).setRelic(true));
       	 add(chamelonicMutation = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chameleonic Mutation", 0).setRelic(true));
       	 add(hyperadaptiveBiology = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hyper-adaptive Biology", 0).setRelic(true));
       	 add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Norn Crown", 0).setRelic(true));
       	 if(MONSTER.contains(type)) {
       		 add(infrasonicRoar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Infrasonic Roar", 0).setRelic(true));
       	 }
       	 add(theReaperofObliterax = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Reaper of Obliterax", 0).setRelic(true));
       	 add(theMawClawsofThyrax = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "The Maw-Claws of Thyrax", 0).setRelic(true));
       	 character = true;
       	 seperator();
       }

        if ("Hive Tyrant".equals(type) ||
                "Carnifex".equals(type) ||
                "Screamer-Killer".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("2 Pairs of m. scything talons", getPts("Monstrous scything talons (two pairs)(" + type + ")")));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o3.setSelected(0, true);
        }

        seperator();

        if ("Hive Tyrant".equals(type) ||
                "Carnifex".equals(type) ||
                "Thornback".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Pair of m. scything talons", "Pair of monstrous scything talons", getPts("Monstrous scything talons (" + type + ")")));
            if(character) {
            	ogE.addElement(new OptionsGruppeEintrag("Scythes of Tyran", getPts("Monstrous scything talons (" + type + ")")).setRelic(true));
            }
        }
        if ("Hive Tyrant".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Monstrous rending claws", getPts("Monstrous rending claws"))); //Monstrous Bioweapons
            ogE.addElement(new OptionsGruppeEintrag("Monstrous boneswords", getPts("Monstrous boneswords"))); //Monstrous Bioweapons
            ogE.addElement(new OptionsGruppeEintrag("Lash whip and m. b.", "Lash whip and monstrous bonesword", getPts("Lash whip and monstrous bonesword"))); //Monstrous Bioweapons
            if(character) {
            	ogE.addElement(new OptionsGruppeEintrag("Slayer Sabres", getPts("Monstrous boneswords")).setRelic(true));
            }
        }
        if (type.equals("Hive Tyrant") ||
                "Carnifex".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Two deathsp. with maggots", "Two deathspitters with slimer maggots", getPts("Deathspitter with slimer maggots") * 2)); //Monstrous Bio-Cannons
            ogE.addElement(new OptionsGruppeEintrag("Two devourers with worms", "Two devourers with brainleech worms", getPts("Devourer with brainleech worms") * 2)); //Monstrous Bio-Cannons
            ogE.addElement(new OptionsGruppeEintrag("Stranglethorn cannon", getPts("Stranglethorn cannon"))); //Monstrous Bio-Cannons
            ogE.addElement(new OptionsGruppeEintrag("Heavy venom cannon", getPts("Heavy venom cannon"))); //Monstrous Bio-Cannons
            if(character) {
                ogE.addElement(new OptionsGruppeEintrag("The Miasma Cannon", getPts("Heavy venom cannon")).setRelic(true));
                ogE.addElement(new OptionsGruppeEintrag("Slimer Maggot Infestation", getPts("Deathspitter with slimer maggots") * 2).setRelic(true));
                ogE.addElement(new OptionsGruppeEintrag("Balethorn Cannon", getPts("Stranglethorn cannon")).setRelic(true));
            }
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }
        if ("Thornback".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Stranglethorn cannon", getPts("Stranglethorn cannon"))); //Monstrous Bio-Cannons
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);
        }

        seperator();

        if (type.equals("Hive Tyrant") ||
                "Carnifex".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Pair of m. scything talons", "Pair of monstrous scything talons", getPts("Monstrous scything talons (" + type + ")")));
            if(character) {
            	ogE.addElement(new OptionsGruppeEintrag("Scythes of Tyran", getPts("Monstrous scything talons (" + type + ")")).setRelic(true));
            }
        }
        if ("Hive Tyrant".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("M. rending claws", "Monstrous rending claws", getPts("Monstrous rending claws"))); //Monstrous Bioweapons
            ogE.addElement(new OptionsGruppeEintrag("Monstrous boneswords", getPts("Monstrous boneswords"))); //Monstrous Bioweapons
            ogE.addElement(new OptionsGruppeEintrag("Lash whip and m. bonesw.", "Lash whip and monstrous bonesword", getPts("Lash whip and monstrous bonesword"))); //Monstrous Bioweapons
            if(character) {
            	ogE.addElement(new OptionsGruppeEintrag("Slayer Sabres", getPts("Monstrous boneswords")).setRelic(true));
            }
        }
        if ("Hive Tyrant".equals(type) ||
                "Carnifex".equals(type) ||
                "Thornback".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Two deathsp. with maggots", "Two deathspitters with slimer maggots", getPts("Deathspitter with slimer maggots") * 2)); //Monstrous Bio-Cannons
            ogE.addElement(new OptionsGruppeEintrag("Two devourers with worms", "Two devourers with brainleech worms", getPts("Devourer with brainleech worms") * 2)); //Monstrous Bio-Cannons
            if ("Carnifex".equals(type)) {
                ogE.addElement(new OptionsGruppeEintrag("Monstrous crushing claws", getPts("Monstrous crushing claws")));
            }
            if(character) {
            	ogE.addElement(new OptionsGruppeEintrag("Slimer Maggot Infestation", getPts("Deathspitter with slimer maggots") * 2).setRelic(true));
            }
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if ("Thornback".equals(type)) o2.setSelected(1, true);
        }

        seperator();

        if ("Carnifex".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
            ogE.addElement(new OptionsGruppeEintrag("Bone mace", getPts("Bone mace")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bio plasma", getPts("Bio plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Enhanced Senses", getPts("Enhanced Senses")));
            ogE.addElement(new OptionsGruppeEintrag("Acid maw", getPts("Monstrous acid maw")));
            ogE.addElement(new OptionsGruppeEintrag("Tusks", getPts("Tusks")));
            ogE.addElement(new OptionsGruppeEintrag("Chitin thorns", getPts("Chitin thorns")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Spine banks", getPts("Spine banks")));
            ogE.addElement(new OptionsGruppeEintrag("Spore cysts", getPts("Spore cysts")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }

        if ("Thornback".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enhanced Senses", getPts("Enhanced Senses")));

            ogE.addElement(new OptionsGruppeEintrag("Spine banks", getPts("Spine banks")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }

        if ("Screamer-Killer".equals(type)) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Carnifex)")));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Spore cysts", getPts("Spore cysts")));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }

        if ("Tyranid Prime".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Devourer", getPts("Devourer")));
            ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons"))); //Basic Bio-Weapons
            ogE.addElement(new OptionsGruppeEintrag("Spinefists", getPts("Spinefists (Ravener)"))); //Basic Bio-Weapons
            ogE.addElement(new OptionsGruppeEintrag("Deathspitter", getPts("Deathspitter"))); //Basic Bio-Weapons
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons")));
            ogE.addElement(new OptionsGruppeEintrag("Rending Claws", getPts("Rending Claws"))); //Melee Bio-Weapons
            ogE.addElement(new OptionsGruppeEintrag("Boneswords", getPts("Boneswords"))); //Melee Bio-Weapons
            ogE.addElement(new OptionsGruppeEintrag("Lash whip and bonesword", getPts("Lash whip and bonesword"))); //Melee Bio-Weapons
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        }

        if ("Stonecrusher Carnifex".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Wrecker claw", getPts("Wrecker claws (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("Bio-flail", getPts("Bio-flail") + getPts("Wrecker claws (single)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Thresher scythe", getPts("Thresher scythe")));
            ogE.addElement(new OptionsGruppeEintrag("Bone mace", getPts("Bone mace")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected(0, true);

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bio plasma", getPts("Bio plasma")));

        }
        sizeSetzen();

    }

    @Override
    public void refreshen() {

        if ("Hive Tyrant".equals(type) ||
                "Carnifex".equals(type)) {
            int cnt = (o3.isSelected() ? 2 : 0) + (o1.isSelected() ? 1 : 0) + (o2.isSelected() ? 1 : 0);
            boolean legal = cnt == 2;
            o1.setAktiv("Pair of monstrous scything talons", !o2.isSelected("Pair of monstrous scything talons"));
            o2.setAktiv("Pair of monstrous scything talons", !o1.isSelected("Pair of monstrous scything talons"));
            o3.setAktiv(!o1.isSelected() && !o2.isSelected());
            o3.setSelected(0, !o1.isSelected() && !o2.isSelected());
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        if (character) {
        	chamelonicMutation.setAktiv((chosenRelic == null || chamelonicMutation.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Kraken"));
        	hyperadaptiveBiology.setAktiv((chosenRelic == null || hyperadaptiveBiology.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Gorgon"));
        	if(MONSTER.contains(type)) {
        		infrasonicRoar.setAktiv((chosenRelic == null || infrasonicRoar.isSelected()) && BuildaHQ.aktBuildaVater.getFormationType().equals("Jormungandr"));
        	}
        	
        	theReaperofObliterax.setAktiv((chosenRelic == null || theReaperofObliterax.isSelected()) && 
        			((o1 != null && (o1.isSelected("Lash whip and monstrous bonesword") || o1.isSelected("Lash whip and bonesword"))) ||
        					(o2!= null && ( o2.isSelected("Lash whip and monstrous bonesword") || o2.isSelected("Lash whip and bonesword")))));
        	
        	theMawClawsofThyrax.setAktiv((chosenRelic == null || theMawClawsofThyrax.isSelected()) && 
        			((o1 != null && (o1.isSelected("Monstrous rending claws") || o1.isSelected("Rending claws"))) ||
        					(o2!= null && ( o2.isSelected("Monstrous rending claws") || o2.isSelected("Rending claws")))));
        	
        	
            if (o1 != null) {
                o1.setAktiv("Scythes of Tyran", (chosenRelic == null || o1.isSelected("Scythes of Tyran")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Behemoth"));
                o1.setAktiv("Slayer Sabres", (chosenRelic == null || o1.isSelected("Slayer Sabres")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Leviathan"));
                o1.setAktiv("Slimer Maggot Infestation", (chosenRelic == null || o1.isSelected("Slimer Maggot Infestation")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Hydra"));
                o1.setAktiv("Balethorn Cannon", (chosenRelic == null || o1.isSelected("Balethorn Cannon")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Kronos"));
            }
            
            if (o2 != null) {
                o2.setAktiv("Scythes of Tyran", (chosenRelic == null || o2.isSelected("Scythes of Tyran")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Behemoth"));
                o2.setAktiv("Slayer Sabres", (chosenRelic == null || o2.isSelected("Slayer Sabres")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Leviathan"));
                o2.setAktiv("Slimer Maggot Infestation", (chosenRelic == null || o2.isSelected("Slimer Maggot Infestation")) && BuildaHQ.aktBuildaVater.getFormationType().equals("Hydra"));
            }
            
            if(o1 != null && o2 != null){
            	if(o1.isSelected("Pair of monstrous scything talons")){
            		o2.setPreis("Scythes of Tyran", getPts("Monstrous scything talons (two pairs)(" + type + ")") - getPts("Monstrous scything talons (" + type + ")"));
            	} else {
            		o2.setPreis("Scythes of Tyran", getPts("Monstrous scything talons (" + type + ")"));
                }
            	
            	if(o2.isSelected("Pair of monstrous scything talons")){
            		o1.setPreis("Scythes of Tyran", getPts("Monstrous scything talons (two pairs)(" + type + ")") - getPts("Monstrous scything talons (" + type + ")"));
            	} else {
            		o1.setPreis("Scythes of Tyran", getPts("Monstrous scything talons (" + type + ")"));
                }
            }
        }

        if ("Tyranid Prime".equals(type)) {
            o1.alwaysSelected();
            o2.alwaysSelected();
        }

        if ("Stonecrusher Carnifex".equals(type)) {
            o1.alwaysSelected();
            o2.alwaysSelected();
        }
    }

}
