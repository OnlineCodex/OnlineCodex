package oc.wh40k.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class WarlordTrait extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12, o13, o14, o15;
    String type = "";
    int numPowers = 0;
    String formation = "";

    public WarlordTrait() {
        grundkosten = 0;
        name = "Sergeant";
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        switch (formation) {
            case "Heretic Astartes":
            case "Chaos Space Marines":
            case "Emperor's Children":
            case "World Eaters":
            case "CHAOS":
                ogE.addElement(new OptionsGruppeEintrag("Eternal Vendetta", 0));
                ogE.addElement(new OptionsGruppeEintrag("Flames of Spite", 0));
                ogE.addElement(new OptionsGruppeEintrag("Unholy Fortitude", 0));
                ogE.addElement(new OptionsGruppeEintrag("Hatred Incarnate", 0));
                ogE.addElement(new OptionsGruppeEintrag("Lord of Terror", 0));
                ogE.addElement(new OptionsGruppeEintrag("Warptime", 0));
                ogE.addElement(new OptionsGruppeEintrag("Exalted Champion", 0));
                ogE.addElement(new OptionsGruppeEintrag("I am Alpharius", 0));
                ogE.addElement(new OptionsGruppeEintrag("First amongst Traitors", 0));
                ogE.addElement(new OptionsGruppeEintrag("Stimulated by Pain", 0));
                ogE.addElement(new OptionsGruppeEintrag("Cold and Bitter", 0));
                ogE.addElement(new OptionsGruppeEintrag("Night Haunter's Curse", 0));
                ogE.addElement(new OptionsGruppeEintrag("Slaughterborn", 0));
                ogE.addElement(new OptionsGruppeEintrag("The Voice of Lorgar", 0));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            case "Death Guard":
                ogE.addElement(new OptionsGruppeEintrag("Revoltingly Resilient", 0));
                ogE.addElement(new OptionsGruppeEintrag("Living Plague", 0));
                ogE.addElement(new OptionsGruppeEintrag("Tainted Regeneration", 0));
                ogE.addElement(new OptionsGruppeEintrag("Hulking Physique", 0));
                ogE.addElement(new OptionsGruppeEintrag("Rotten Contitution", 0));
                ogE.addElement(new OptionsGruppeEintrag("Arch-Contaminator", 0));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            case "Thousand Sons":
                ogE.addElement(new OptionsGruppeEintrag("Arrogance of Aeons", 0));
                ogE.addElement(new OptionsGruppeEintrag("Undying Form", 0));
                ogE.addElement(new OptionsGruppeEintrag("Aetherstride", 0));
                ogE.addElement(new OptionsGruppeEintrag("Lord of forbidden Lore", 0));
                ogE.addElement(new OptionsGruppeEintrag("Otherworldly Presience", 0));
                ogE.addElement(new OptionsGruppeEintrag("High Magister", 0));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            case "Chaosdaemons":
                ogE.addElement(new OptionsGruppeEintrag("Aspect of Death", 0));
                ogE.addElement(new OptionsGruppeEintrag("Glory of Battle", 0));
                ogE.addElement(new OptionsGruppeEintrag("Oblivious to Pain", 0));
                ogE.addElement(new OptionsGruppeEintrag("Immense Power", 0));
                ogE.addElement(new OptionsGruppeEintrag("Devastating Blow", 0));
                ogE.addElement(new OptionsGruppeEintrag("Rage Incarnate", 0));
                ogE.addElement(new OptionsGruppeEintrag("", 0));
                ogE.addElement(new OptionsGruppeEintrag("Born of Sorcery", 0));
                ogE.addElement(new OptionsGruppeEintrag("Incorporeal Form", 0));
                ogE.addElement(new OptionsGruppeEintrag("Warp Teather", 0));
                ogE.addElement(new OptionsGruppeEintrag("Lorekeeper of Tzeentch", 0));
                ogE.addElement(new OptionsGruppeEintrag("Daemonspark", 0));
                ogE.addElement(new OptionsGruppeEintrag("", 0));
                ogE.addElement(new OptionsGruppeEintrag("Blessed with Corpulence", 0));
                ogE.addElement(new OptionsGruppeEintrag("Acidic Ichor", 0));
                ogE.addElement(new OptionsGruppeEintrag("Plagufly Hive", 0));
                ogE.addElement(new OptionsGruppeEintrag("Virulent Touch", 0));
                ogE.addElement(new OptionsGruppeEintrag("Impenetrable Hide", 0));
                ogE.addElement(new OptionsGruppeEintrag("Pestilent Miasma", 0));
                ogE.addElement(new OptionsGruppeEintrag("", 0));
                ogE.addElement(new OptionsGruppeEintrag("Celerity of Slaanesh", 0));
                ogE.addElement(new OptionsGruppeEintrag("Quicksilver Duellist", 0));
                ogE.addElement(new OptionsGruppeEintrag("The Murderdance", 0));
                ogE.addElement(new OptionsGruppeEintrag("Fatal Caress", 0));
                ogE.addElement(new OptionsGruppeEintrag("Savage Hedonist", 0));
                ogE.addElement(new OptionsGruppeEintrag("Bewitching Aura", 0));
                add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
                break;
            default:
                break;
        }

        o1.setMaxAnzahl(1);

        sizeSetzen();
    }

    public void setFormation(String s) {
        formation = s;
    }

    @Override
    public void refreshen() {

    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    public void setKosten(int kosten) {
        grundkosten = kosten;
    }


}
