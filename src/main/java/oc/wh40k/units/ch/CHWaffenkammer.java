package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableList;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

import java.util.EnumSet;

import static com.google.common.collect.Sets.newEnumSet;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.*;

public class CHWaffenkammer extends RuestkammerVater {

    public enum ChaosWeaponsOption {
        TERMINATOR,
        SORCERER,
        CHAMPION,
        NURGLE,
        BIKER,
        NOISE,
    }


    private final String defaultNK;
    private final String defaultFK;
    private final String type;

    private OptionsUpgradeGruppe handwaffen;
    private OptionsUpgradeGruppe fkwaffen;


    public CHWaffenkammer(String type) {
        this(type, "", "", false, false, false, false);
    }

    public CHWaffenkammer(String type, String defaultFK, String defaultNK,
                          boolean melee, boolean range, boolean rangeForMelee, boolean meleeForRange,
                          ChaosWeaponsOption... opts) {
        this.type = type;
        this.defaultFK = defaultFK;
        this.defaultNK = defaultNK;
        EnumSet<ChaosWeaponsOption> options = newEnumSet(ImmutableList.copyOf(opts), ChaosWeaponsOption.class);

        if ("Scarab Occult Sorcerer".equals(type)) {
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
                if (options.contains(NOISE))
                    ogE.addElement(new OptionsGruppeEintrag("Sonic blaster", getPts("Sonic blaster")));
                if (!options.contains(TERMINATOR) && !options.contains(SORCERER)) {
                    ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
                    ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));

                    if (options.contains(NURGLE)) {
                        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
                    }
                }
                if (options.contains(CHAMPION)) {
                    if (options.contains(TERMINATOR)) {
                        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
                    } else if (options.contains(SORCERER)) {
                        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
                        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
                    } else if (!options.contains(NURGLE)) {
                        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
                        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
                    }
                }
            }
            if (rangeForMelee) {
                if (!options.contains(TERMINATOR)) {
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
                if (options.contains(SORCERER)) {
                    ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
                    ogE.addElement(new OptionsGruppeEintrag("Force axe", getPts("Force axe")));
                } else {
                    if (options.contains(NURGLE)) {
                        ogE.addElement(new OptionsGruppeEintrag("Plague sword", getPts("Plague sword")));
                    } else {
                        if (!options.contains(TERMINATOR)) {
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

            if (options.contains(NOISE)) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Doom siren", getPts("Doom siren")));
            }

            if (options.contains(NURGLE)) {
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist")));
            }

        }

        setUeberschrift("Waffen");
        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if ("Scarab Occult Sorcerer".equals(type)) {
            handwaffen.alwaysSelected();
            fkwaffen.alwaysSelected();
        } else {

            if (!"no weapon".equals(defaultFK)) {
                fkwaffen.alwaysSelected();
            }

            if (!"no weapon".equals(defaultNK)) {
                handwaffen.alwaysSelected();
            }

            if (!"no weapon".equals(defaultFK) && !"no weapon".equals(defaultNK)) {
                if (fkwaffen.isSelected("Lightning claw") && handwaffen.isSelected("Lightning claw")) {
                    int clawPoints = getPts("Lightning claw pair") / 2;
                    fkwaffen.setPreis("Lightning claw", clawPoints + 1);
                    handwaffen.setPreis("Lightning claw", clawPoints);
                } else {
                    fkwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                    handwaffen.setPreis("Lightning claw", getPts("Lightning claw single"));
                }
            }

        }
    }

}
