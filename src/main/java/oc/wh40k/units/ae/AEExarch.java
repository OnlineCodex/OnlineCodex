package oc.wh40k.units.ae;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

import static java.util.Objects.requireNonNull;

public class AEExarch extends RuestkammerVater {

    private final int unitSurcharge;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade oe1;
    ExarchType type = null;
    int weaponCost = 0;

    public enum ExarchType {
        HOWLING_BANSHEES,
        DIRE_AVENGERS,
        STRIKING_SCORPIONS,
        DARK_REAPERS,
        FIRE_DRAGONS,
        SHINING_SPEARS,
        SWOOPING_HAWKS,
        WARP_SPIDERS,
        SHADOW_SPECTRES,
    }

    public AEExarch(ExarchType type, int weaponCost, int unitSurcharge) {
        this.name = "Exharch";
        this.type = requireNonNull(type);
        this.weaponCost = weaponCost;
        this.unitSurcharge = unitSurcharge;
    }

    public AEExarch () {
        name = "Exarch";
        unitSurcharge = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        seperator();

        switch (type) {
            case HOWLING_BANSHEES:
                ogE.addElement(new OptionsGruppeEintrag("Power sword & Shuriken pistol", getPts("Power sword") + getPts("Shuriken pistol")));
                ogE.addElement(new OptionsGruppeEintrag("Triskele & Shuriken pistol", getPts("Triskele") + getPts("Shuriken pistol")));
                ogE.addElement(new OptionsGruppeEintrag("Executioner & Shuriken pistol", getPts("Executioner") + getPts("Shuriken pistol")));
                ogE.addElement(new OptionsGruppeEintrag("Mirrorswords", getPts("Mirrorswords")));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            case DIRE_AVENGERS:
                ogE.addElement(new OptionsGruppeEintrag("Avenger shuriken catapult", getPts("Avenger shuriken catapult")));
                ogE.addElement(new OptionsGruppeEintrag("2 Avenger shuriken catapults", 2 * getPts("Avenger shuriken catapult")));
                ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol & power glaive", getPts("Shuriken pistol") + getPts("Power glaive")));
                ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol & diresword", getPts("Shuriken pistol") + getPts("Diresword")));
                ogE.addElement(new OptionsGruppeEintrag("Shimmershield & power glaive", getPts("Shimmershield") + getPts("Power glaive")));
                o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
                add(o1);
                break;
            case STRIKING_SCORPIONS:
                ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
                ogE.addElement(new OptionsGruppeEintrag("Scorpion's claw", getPts("Scorpion's claw")));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

                seperator();

                ogE.addElement(new OptionsGruppeEintrag("Scorpion chainsword", getPts("Scorpion chainsword")));
                ogE.addElement(new OptionsGruppeEintrag("Biting blade", getPts("Biting blade")));
                add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

                seperator();

                ogE.addElement(new OptionsGruppeEintrag("Chainsabres", getPts("Chainsabres")));
                add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            case DARK_REAPERS:
                ogE.addElement(new OptionsGruppeEintrag("Reaper launcher", getPts("Reaper launcher")));
                ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
                ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));
                ogE.addElement(new OptionsGruppeEintrag("Tempest launcher", getPts("Tempest launcher")));
                o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
                add(o1);
                break;
            case FIRE_DRAGONS:
                ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));
                ogE.addElement(new OptionsGruppeEintrag("Dragon's breath flamer", getPts("Dragon's breath flamer")));
                ogE.addElement(new OptionsGruppeEintrag("Firepike", getPts("Firepike")));
                o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
                add(o1);
                break;
            case SHINING_SPEARS:
                ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));
                ogE.addElement(new OptionsGruppeEintrag("Star lance", getPts("Star lance")));
                ogE.addElement(new OptionsGruppeEintrag("Paragon blade", getPts("Paragon blade")));
                o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
                add(o1);
                break;
            case SWOOPING_HAWKS:
                ogE.addElement(new OptionsGruppeEintrag("Lasblaster", getPts("Lasblaster")));
                ogE.addElement(new OptionsGruppeEintrag("Hawk's talon", getPts("Hawk's talon")));
                ogE.addElement(new OptionsGruppeEintrag("Sunrifle", getPts("Sunrifle")));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                o1.setSelected(0, true);

                seperator();

                add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));
                break;
            case WARP_SPIDERS:
                ogE.addElement(new OptionsGruppeEintrag("Death spinner", getPts("Death spinner")));
                ogE.addElement(new OptionsGruppeEintrag("2 Death spinners", 2 * getPts("Death spinner")));
                ogE.addElement(new OptionsGruppeEintrag("Spinneret rifle", getPts("Spinneret rifle")));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                o1.setSelected(0, true);

                seperator();

                add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Powerblade", getPts("Powerblades")));
                break;
            case SHADOW_SPECTRES:
                ogE.addElement(new OptionsGruppeEintrag("prism rifle", getPts("prism rifle")));
                ogE.addElement(new OptionsGruppeEintrag("prism blaster", getPts("prism blaster")));
                ogE.addElement(new OptionsGruppeEintrag("haywire launcher", getPts("haywire launcher")));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                o1.setSelected(0, true);
                break;
            default: throw new IllegalStateException("unknown exarch type: " + type);
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        switch (type) {
            case HOWLING_BANSHEES:
            case DIRE_AVENGERS:
            case DARK_REAPERS:
            case FIRE_DRAGONS:
            case SHINING_SPEARS:
            case SWOOPING_HAWKS:
            case SHADOW_SPECTRES:
            case WARP_SPIDERS:
                o1.alwaysSelected();
                break;
            case STRIKING_SCORPIONS:
                o1.alwaysSelected();
                o2.alwaysSelected();

                o1.setAktiv(!o3.isSelected());
                o2.setAktiv(!o3.isSelected());
                break;
            default: throw new IllegalStateException("unknown exarch type: " + type);
        }

        grundkosten = unitSurcharge - weaponCost;
    }
}
