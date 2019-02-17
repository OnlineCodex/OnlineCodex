package oc.wh40k.units.ch;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CHWaffenkammer extends RuestkammerVater {

    public boolean uniqueError = false;
    public boolean terminator = false;
    public boolean sorcerer = false;
    public boolean champion = false;
    public boolean nurgle = false;
    public boolean biker = false;
    public boolean noise = false;
    private OptionsUpgradeGruppe handwaffen = null;
    private OptionsUpgradeGruppe fkwaffen = null;
    private boolean melee = false;
    private boolean range = false;
    private boolean rangeForMelee = false;
    private boolean meleeForRange = false;
    private String defaultNK = "";
    private String defaultFK = "";
    public String type = "";

    //BP/NK gg RNG/NK

    public CHWaffenkammer() {
        grundkosten = 0;
    }

    public void setDefaultCloceCombat(String s) {
        defaultNK = s;
    }

    public void setDefaultRanged(String s) {
        defaultFK = s;
    }

    public void setTerminatorArmour(boolean s) {
        terminator = s;
    }

    public void setSorcerer(boolean s) {
        sorcerer = s;
    }

    public void setChampion(boolean s) {
        champion = s;
    }

    public void setNurgle(boolean s) {
        nurgle = s;
    }

    public void setBiker(boolean s) {
        biker = s;
    }

    public void setNoiseMarine(boolean s) {
        noise = s;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            melee = defaults[0];
            range = defaults[1];
            rangeForMelee = defaults[2];
            meleeForRange = defaults[3];
        } catch (Exception e) {
        }

        if (type == "Scarab Occult Sorcerer") {
            ogE.addElement(new OptionsGruppeEintrag("Inferno combi-bolter", getPts("Inferno combi-bolter")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
            add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else {
            if (!defaultFK.equals("no weapon")) {
                if (defaultFK.equals("")) {
                    ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
                } else {
                    ogE.addElement(new OptionsGruppeEintrag(defaultFK, getPts(defaultFK)));
                }
            }
            if (range) {

                if (noise)
                    ogE.addElement(new OptionsGruppeEintrag("Sonic blaster", getPts("Sonic blaster")));
                if (!terminator && !sorcerer) {
                    ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
                    ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));

                    if (nurgle) {
                        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
                    }
                }
                if (champion) {
                    if (terminator) {
                        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
                    } else if (sorcerer) {
                        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
                        if (type == "Aspiring Sorcerer TS") ;
                        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
                    } else if (nurgle) {
                        // no combi weapons
                    } else {
                        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
                    }
                }
            }
            if (rangeForMelee) {
                if (!terminator) {
                    ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
                    ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
                } else
                    ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
                ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
                ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
                ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
                ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
                ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
            }
            if (ogE.size() > 0) {
                add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                if (!defaultFK.equals("no weapon")) {
                    fkwaffen.setSelected(0, true);
                }
            }

            seperator();

            if (!defaultNK.equals("no weapon")) {
                if (defaultNK.equals("")) {
                    ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
                } else {
                    ogE.addElement(new OptionsGruppeEintrag(defaultNK, getPts(defaultNK)));
                }
            }
            if (meleeForRange) {
                ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
                ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
            }
            if (melee) {
                if (sorcerer) {
                    ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
                    ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
                } else {
                    if (nurgle) {
                        ogE.addElement(new OptionsGruppeEintrag("Plague sword", getPts("Plague sword")));
                    } else {
                        if (!terminator) {
                            ogE.addElement(new OptionsGruppeEintrag("Chainaxe", getPts("Chainaxe")));
                            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
                        } else
                            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));

                        ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw single")));
                        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
                        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist")));
                        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
                        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
                    }
                }
            }
            if (ogE.size() > 0) {
                add(handwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                if (!defaultNK.equals("no weapon")) {
                    handwaffen.setSelected(0, true);
                }
            }

            seperator();

            if (noise) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Doom siren", getPts("Doom siren")));
            }

            if (nurgle) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist")));
            }

        }

        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (type == "Scarab Occult Sorcerer") {
            handwaffen.alwaysSelected();
            fkwaffen.alwaysSelected();
        } else {

            if (!defaultFK.equals("no weapon")) {
                fkwaffen.alwaysSelected();
            }

            if (!defaultNK.equals("no weapon")) {
                handwaffen.alwaysSelected();
            }

            if (!defaultFK.equals("no weapon") && !defaultNK.equals("no weapon")) {
                if (fkwaffen.isSelected("Lightning claw") && handwaffen.isSelected("Lightning claw")) {
                    fkwaffen.setPreis("Lightning claw", getPts("Lightning claw pair") / 2 + 1);
                    handwaffen.setPreis("Lightning claw", getPts("Lightning claw pair") / 2);
                } else {
                    fkwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                    handwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                }
            }

        }
    }

}
