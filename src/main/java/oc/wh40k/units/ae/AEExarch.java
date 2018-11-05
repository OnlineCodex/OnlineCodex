package oc.wh40k.units.ae;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEExarch extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade oe1;
    String type = "";
    int weaponCost = 0;

    public AEExarch() {
        grundkosten = 0;
        name = "Sergeant";
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        seperator();
        if (type == "Howling Banshees") {
            ogE.addElement(new OptionsGruppeEintrag("Power sword & Shuriken pistol", getPts("Power sword") + getPts("Shuriken pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Triskele & Shuriken pistol", getPts("Triskele") + getPts("Shuriken pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Executioner & Shuriken pistol", getPts("Executioner") + getPts("Shuriken pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Mirrorswords", getPts("Mirrorswords")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (type == "Dire Avengers") {
            ogE.addElement(new OptionsGruppeEintrag("Avenger shuriken catapult", getPts("Avenger shuriken catapult")));
            ogE.addElement(new OptionsGruppeEintrag("2 Avenger shuriken catapults", 2 * getPts("Avenger shuriken catapult")));
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol & power glaive", getPts("Shuriken pistol") + getPts("Power glaive")));
            ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol & diresword", getPts("Shuriken pistol") + getPts("Diresword")));
            ogE.addElement(new OptionsGruppeEintrag("Shimmershield & power glaive", getPts("Shimmershield") + getPts("Power glaive")));
            o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
            add(o1);
        } else if (type == "Striking Scorpions") {
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
        } else if (type == "Dark Reapers") {
            ogE.addElement(new OptionsGruppeEintrag("Reaper launcher", getPts("Reaper launcher")));
            ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));
            ogE.addElement(new OptionsGruppeEintrag("Tempest launcher", getPts("Tempest launcher")));
            o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
            add(o1);
        } else if (type == "Fire Dragons") {
            ogE.addElement(new OptionsGruppeEintrag("Fusion gun", getPts("Fusion gun")));
            ogE.addElement(new OptionsGruppeEintrag("Dragon's breath flamer", getPts("Dragon's breath flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Firepike", getPts("Firepike")));
            o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
            add(o1);
        } else if (type == "Shining Spears") {
            ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));
            ogE.addElement(new OptionsGruppeEintrag("Star lance", getPts("Star lance")));
            ogE.addElement(new OptionsGruppeEintrag("Paragon blade", getPts("Paragon blade")));
            o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
            add(o1);
        } else if (type == "Swooping Hawks") {
            ogE.addElement(new OptionsGruppeEintrag("Lasblaster", getPts("Lasblaster")));
            ogE.addElement(new OptionsGruppeEintrag("Hawk's talon", getPts("Hawk's talon")));
            ogE.addElement(new OptionsGruppeEintrag("Sunrifle", getPts("Sunrifle")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));
        } else if (type == "Warp Spiders") {
            ogE.addElement(new OptionsGruppeEintrag("Death spinner", getPts("Death spinner")));
            ogE.addElement(new OptionsGruppeEintrag("2 Death spinners", 2 * getPts("Death spinner")));
            ogE.addElement(new OptionsGruppeEintrag("Spinneret rifle", getPts("Spinneret rifle")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Powerblade", getPts("Powerblades")));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (type == "Howling Banshees" || type == "Dire Avengers" || type == "Dark Reapers" || type == "Fire Dragons"
                || type == "Shining Spears" || type == "Swooping Hawks" || type == "Warp Spiders") {
            o1.alwaysSelected();
        } else if (type == "Striking Scorpions") {
            o1.alwaysSelected();
            o2.alwaysSelected();

            o1.setAktiv(!o3.isSelected());
            o2.setAktiv(!o3.isSelected());
        }

        grundkosten = -weaponCost;
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    public void setKosten(int kosten) {
        grundkosten = kosten;
    }


}
