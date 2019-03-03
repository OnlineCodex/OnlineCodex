package oc.wh40k.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class PsychicPowers extends RuestkammerVater {

	private OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6, o7, o8, o9, o10;
	private OptionsUpgradeGruppe o11, o12, o13, o14, o15, o16, o17, o18, o19, o20;
	private String type = "";
	private int numPowers = 0;
	private boolean darkHereticus = false;
	private boolean contagion = false;
	private boolean change = false;
	private boolean disciplineOfTzeentch = false;
	private boolean disciplineOfNurgle = false;
	private boolean disciplineOfSlaanesh = false;
	private boolean runesOfFate = false;
	private boolean runesOfBattle = false;
	private boolean sanctic = false;
	private boolean hiveMind = false;
	private boolean librarius = false;
	private boolean psykana = false;
	private boolean sanguinary = false;
	private boolean interromancy = false;
    private boolean powerOfTheWaaagh = false;
    private boolean tempestasDiscipline = false;
    private boolean broodmind = false;
    private boolean obscuration = false;
    private boolean malefic = false;
    
    private boolean nurgle = false;
    private boolean tzeentch = false;
    private boolean slaanesh = false;

    public PsychicPowers() {
        grundkosten = 0;
        name = "Sergeant";
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        ogE.addElement(new OptionsGruppeEintrag("Smite", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        if (darkHereticus) {
            ogE.addElement(new OptionsGruppeEintrag("Infernal Gaze", 0));
            ogE.addElement(new OptionsGruppeEintrag("Daeth Hex", 0));
            ogE.addElement(new OptionsGruppeEintrag("Gift of Chaos", 0));
            ogE.addElement(new OptionsGruppeEintrag("Prescience", 0));
            ogE.addElement(new OptionsGruppeEintrag("Diabolic Strength", 0));
            ogE.addElement(new OptionsGruppeEintrag("Warptime", 0));
            ogE.addElement(new OptionsGruppeEintrag("Weaver of Fates", 0));
            ogE.addElement(new OptionsGruppeEintrag("Miasma of Pestilence", 0));
            ogE.addElement(new OptionsGruppeEintrag("Deligthful Agonies", 0));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            o2.setAktiv("Weaver of Fates", false);
            o2.setAktiv("Miasma of Pestilence", false);
            o2.setAktiv("Deligthful Agonies", false);
        }

        if (contagion) {
            ogE.addElement(new OptionsGruppeEintrag("Miasma of Pestilence", 0));
            ogE.addElement(new OptionsGruppeEintrag("Gift of Contagion", 0));
            ogE.addElement(new OptionsGruppeEintrag("Plague Wind", 0));
            ogE.addElement(new OptionsGruppeEintrag("Blades of Putrefaction", 0));
            ogE.addElement(new OptionsGruppeEintrag("Putrescent Vitality", 0));
            ogE.addElement(new OptionsGruppeEintrag("Curse of the Leper", 0));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (change) {
            ogE.addElement(new OptionsGruppeEintrag("Tzeentch's Firestorm", 0));
            ogE.addElement(new OptionsGruppeEintrag("Boon of Mutation", 0));
            ogE.addElement(new OptionsGruppeEintrag("Glamour of Tzeentch", 0));
            ogE.addElement(new OptionsGruppeEintrag("Doombolt", 0));
            ogE.addElement(new OptionsGruppeEintrag("Temporal Manipulation", 0));
            ogE.addElement(new OptionsGruppeEintrag("Weaver of Fates", 0));
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (disciplineOfTzeentch) {
            ogE.addElement(new OptionsGruppeEintrag("Boon of Change", 0));
            ogE.addElement(new OptionsGruppeEintrag("Bolt of Change", 0));
            ogE.addElement(new OptionsGruppeEintrag("Gaze of Fate", 0));
            ogE.addElement(new OptionsGruppeEintrag("Treason of Tzeentch", 0));
            ogE.addElement(new OptionsGruppeEintrag("Flickering Flames", 0));
            ogE.addElement(new OptionsGruppeEintrag("Infernal Gateway", 0));
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (disciplineOfNurgle) {
            ogE.addElement(new OptionsGruppeEintrag("Stream of Corruption", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fleshy Abundance", 0));
            ogE.addElement(new OptionsGruppeEintrag("Nurgle's Rot", 0));
            ogE.addElement(new OptionsGruppeEintrag("Shrivelling Pox", 0));
            ogE.addElement(new OptionsGruppeEintrag("Virulent Blessing", 0));
            ogE.addElement(new OptionsGruppeEintrag("Miasma of Pestilence", 0));
            add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (disciplineOfSlaanesh) {
            ogE.addElement(new OptionsGruppeEintrag("Cacaphonic Choir", 0));
            ogE.addElement(new OptionsGruppeEintrag("Symphony of Pain", 0));
            ogE.addElement(new OptionsGruppeEintrag("Hysterical Frenzy", 0));
            ogE.addElement(new OptionsGruppeEintrag("Delightful Agonies", 0));
            ogE.addElement(new OptionsGruppeEintrag("Pavane of Slaanesh", 0));
            ogE.addElement(new OptionsGruppeEintrag("Phantasmagoria", 0));
            add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (runesOfFate) {
            ogE.addElement(new OptionsGruppeEintrag("Guide", 0));
            ogE.addElement(new OptionsGruppeEintrag("Doom", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fortune", 0));
            ogE.addElement(new OptionsGruppeEintrag("Executioner", 0));
            ogE.addElement(new OptionsGruppeEintrag("Will of Asuryan", 0));
            ogE.addElement(new OptionsGruppeEintrag("Mind War", 0));
            add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (runesOfBattle) {
            ogE.addElement(new OptionsGruppeEintrag("Conceal/Reveal", 0));
            ogE.addElement(new OptionsGruppeEintrag("Embolden/Horrify", 0));
            ogE.addElement(new OptionsGruppeEintrag("Enhance/Drain", 0));
            ogE.addElement(new OptionsGruppeEintrag("Protect/Jinx", 0));
            ogE.addElement(new OptionsGruppeEintrag("Quicken/Restrain", 0));
            ogE.addElement(new OptionsGruppeEintrag("Empower/Enervate", 0));
            add(o9 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (sanctic) {
            ogE.addElement(new OptionsGruppeEintrag("Purge Soul", 0));
            ogE.addElement(new OptionsGruppeEintrag("Gate of Infinity", 0));
            ogE.addElement(new OptionsGruppeEintrag("Hammerhand", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sanctuary", 0));
            ogE.addElement(new OptionsGruppeEintrag("Astral Aim", 0));
            ogE.addElement(new OptionsGruppeEintrag("Vortex of Doom", 0));
            add(o10 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (hiveMind) {
            ogE.addElement(new OptionsGruppeEintrag("Dominion", 0));
            ogE.addElement(new OptionsGruppeEintrag("Catalyst", 0));
            ogE.addElement(new OptionsGruppeEintrag("The Horror", 0));
            ogE.addElement(new OptionsGruppeEintrag("Onslaught", 0));
            ogE.addElement(new OptionsGruppeEintrag("Paroxysm", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychic Scream", 0));
            add(o11 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (librarius) {
            ogE.addElement(new OptionsGruppeEintrag("Veil of Time", 0));
            ogE.addElement(new OptionsGruppeEintrag("Might of Heroes", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychic Scourge", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fury of the Ancients", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychic Fortress", 0));
            ogE.addElement(new OptionsGruppeEintrag("Null Zone", 0));
            add(o12 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (psykana) {
            ogE.addElement(new OptionsGruppeEintrag("Terrifying Visions", 0));
            ogE.addElement(new OptionsGruppeEintrag("Gaze of the Emperor", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychic Barrier", 0));
            ogE.addElement(new OptionsGruppeEintrag("Nightshroud", 0));
            ogE.addElement(new OptionsGruppeEintrag("Mental Fortitude", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychic Maelstrom", 0));
            add(o13 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (sanguinary) {
            ogE.addElement(new OptionsGruppeEintrag("Quickening", 0));
            ogE.addElement(new OptionsGruppeEintrag("Unleash Rage", 0));
            ogE.addElement(new OptionsGruppeEintrag("Shield of Sanguinius", 0));
            ogE.addElement(new OptionsGruppeEintrag("Blood Boil", 0));
            ogE.addElement(new OptionsGruppeEintrag("The Blood Lance", 0));
            ogE.addElement(new OptionsGruppeEintrag("Wings of Sanguinius", 0));
            add(o14 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (interromancy) {
            ogE.addElement(new OptionsGruppeEintrag("Mind Worm", 0));
            ogE.addElement(new OptionsGruppeEintrag("Aversion", 0));
            ogE.addElement(new OptionsGruppeEintrag("Righteous Repugnance", 0));
            ogE.addElement(new OptionsGruppeEintrag("Trephination", 0));
            ogE.addElement(new OptionsGruppeEintrag("Engulfing Fear", 0));
            ogE.addElement(new OptionsGruppeEintrag("Mind Wipe", 0));
            add(o15 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (powerOfTheWaaagh) {
            ogE.addElement(new OptionsGruppeEintrag("'Eadbanger", 0));
            ogE.addElement(new OptionsGruppeEintrag("Warpath", 0));
            ogE.addElement(new OptionsGruppeEintrag("Da Jump", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fists of Gork", 0));
            ogE.addElement(new OptionsGruppeEintrag("Da Krunch", 0));
            ogE.addElement(new OptionsGruppeEintrag("Roar of Mork", 0));
            add(o16 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }
        
        if (tempestasDiscipline) {
            ogE.addElement(new OptionsGruppeEintrag("Living Lightning", 0));
            ogE.addElement(new OptionsGruppeEintrag("Tempest's Wrath", 0));
            ogE.addElement(new OptionsGruppeEintrag("Murderous Hurricane", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fury of the Wolf Spirits", 0));
            ogE.addElement(new OptionsGruppeEintrag("Storm Caller", 0));
            ogE.addElement(new OptionsGruppeEintrag("Jaws of the World Wolf", 0));
            add(o17 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }
        
        if (broodmind) {
            ogE.addElement(new OptionsGruppeEintrag("Mass Hypnosis", 0));
            ogE.addElement(new OptionsGruppeEintrag("Mind Control", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psionic Blast", 0));
            ogE.addElement(new OptionsGruppeEintrag("Mental Onslaught", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psychis Stimulus", 0));
            ogE.addElement(new OptionsGruppeEintrag("Migth From Beyond", 0));
            add(o18 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }
        
        if (obscuration) {
            ogE.addElement(new OptionsGruppeEintrag("Living Lightning", 0));
            ogE.addElement(new OptionsGruppeEintrag("Tempest's Wrath", 0));
            ogE.addElement(new OptionsGruppeEintrag("Murderous Hurricane", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fury of the Wolf Spirits", 0));
            ogE.addElement(new OptionsGruppeEintrag("Storm Caller", 0));
            ogE.addElement(new OptionsGruppeEintrag("Jaws of the World Wolf", 0));
            add(o19 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }
        
        if (malefic) {
            ogE.addElement(new OptionsGruppeEintrag("Living Lightning", 0));
            ogE.addElement(new OptionsGruppeEintrag("Tempest's Wrath", 0));
            ogE.addElement(new OptionsGruppeEintrag("Murderous Hurricane", 0));
            ogE.addElement(new OptionsGruppeEintrag("Fury of the Wolf Spirits", 0));
            ogE.addElement(new OptionsGruppeEintrag("Storm Caller", 0));
            ogE.addElement(new OptionsGruppeEintrag("Jaws of the World Wolf", 0));
            add(o20 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }


        sizeSetzen();
    }

    public void setNumberOfPowers(int number) {
        numPowers = number;
    }

    public void enableDarkHereticus() {
        darkHereticus = true;
    }

    public void enableContagion() {
        contagion = true;
    }

    public void enableChange() {
        change = true;
    }

    public void enableTzeentch() {
        disciplineOfTzeentch = true;
    }

    public void enableNurgle() {
        disciplineOfNurgle = true;
    }

    public void enableSlaanesh() {
        disciplineOfSlaanesh = true;
    }

    public void enableRunesOfFate() {
        runesOfFate = true;
    }

    public void enableRunesOfBattle() {
        runesOfBattle = true;
    }

    public void enableSanctic() {
        sanctic = true;
    }

    public void enableHiveMind() {
        hiveMind = true;
    }
    
    public void enableBroodMind() {
        broodmind = true;
    }


    public void enableLibrarius() {
        librarius = true;
    }

    public void enablePsykana() {
        psykana = true;
    }

    public void enableSanguinary() {
        sanguinary = true;
    }

    public void enableInterromancy() {
        interromancy = true;
    }
    
    public void enableObscuration() {
        obscuration = true;
    }
    
    public void setNurgle(boolean n) {
        nurgle = n;
    }

    public void setTzeentch(boolean t) {
        tzeentch = t;
    }

    public void setSlaanesh(boolean s) {
        slaanesh = s;
    }

    public void enablePowerOfTheWaaagh() {
        powerOfTheWaaagh = true;
    }
    
    public void enableTempestasDiscipline() {
    	tempestasDiscipline = true;
    }
    
    public void enableMalefic() {
    	malefic = true;
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();

        if (darkHereticus) {
            o2.setMaxAnzahl(numPowers);
            if (nurgle)
                o2.setAktiv("Miasma of Pestilence", nurgle);
            if (tzeentch)
                o2.setAktiv("Weaver of Fates", tzeentch);
            if (slaanesh)
                o2.setAktiv("Deligthful Agonies", slaanesh);
        }

        if (contagion) {
            o3.setMaxAnzahl(numPowers);
        }

        if (change) {
            o4.setMaxAnzahl(numPowers);
        }

        if (disciplineOfTzeentch) {
            o5.setMaxAnzahl(numPowers);
        }

        if (disciplineOfNurgle) {
            o6.setMaxAnzahl(numPowers);
        }

        if (disciplineOfSlaanesh) {
            o7.setMaxAnzahl(numPowers);
        }

        if (runesOfFate) {
            o8.setMaxAnzahl(numPowers);
        }

        if (runesOfBattle) {
            o9.setMaxAnzahl(numPowers);
        }

        if (sanctic) {
            o10.setMaxAnzahl(numPowers);
        }

        if (hiveMind) {
            o11.setMaxAnzahl(numPowers);
        }

        if (librarius) {
            o12.setMaxAnzahl(numPowers);
        }

        if (psykana) {
            o13.setMaxAnzahl(numPowers);
        }

        if (sanguinary) {
            o14.setMaxAnzahl(numPowers);
        }

        if (interromancy) {
            o15.setMaxAnzahl(numPowers);
        }
        
        if(powerOfTheWaaagh) {
        	o16.setMaxAnzahl(numPowers);
        }
        
        if(tempestasDiscipline) {
        	o17.setMaxAnzahl(numPowers);
        }
        
        if(broodmind) {
        	o18.setMaxAnzahl(numPowers);
        }
        
        if(obscuration) {
        	o19.setMaxAnzahl(numPowers);
        }
        
        if(malefic) {
        	o20.setMaxAnzahl(numPowers);
        }
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    public void setKosten(int kosten) {
        grundkosten = kosten;
    }


}
