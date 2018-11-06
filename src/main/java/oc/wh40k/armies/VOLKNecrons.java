package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

import java.io.InputStream;

public class VOLKNecrons extends BuildaVater {

    //Vanilla Necrons
    private static final String[] HQeinträge_NE = new String[]{"", "Overlord", "Lord", "Cryptek", "Destroyer Lord", "Catacomb Command Barge",};
    private static final String[] Standardeinträge_NE = new String[]{"", "Necron Warriors", "Immortals",};
    private static final String[] Eliteeinträge_NE = new String[]{"", "Lychguard", "Deathmarks", "Flayed Ones",};
    private static final String[] Sturmeinträge_NE = new String[]{"", "Tomb Blades", "Destroyers",};
    private static final String[] Unterstützungeinträge_NE = new String[]{"", "Heavy Destroyers", "Monolith", "Annihilation Barge", "Doomsday Ark",};
    private static final String[] Transporteinträge_NE = new String[]{"", "Ghost Ark",};
    private static final String[] Fliegereinträge_NE = new String[]{"", "Doom Scythe", "Night Scythe",};
    private static final String[] LordofWareinträge_NE = new String[]{"", "Obelisk",};

    //ohne Dynasty
    private static final String[] HQeinträge_Vanilla_only = new String[]{"", "Illuminor Szeras", "Anrakyr the Traveller",};
    private static final String[] Eliteeinträge_Vanilla_only = new String[]{"", "Triarch Praetorians", "Triarch Stalker",};

    //Sautekh Dynasty
    private static final String[] HQeinträge_Sautekh = new String[]{"", "Imotekh the Stormlord", "Nemesor Zahndrekh", "Vargard Obyron", "Orikan the Diviner",};

    //Nihilakh Dynasty
    private static final String[] HQeinträge_Nihilakh = new String[]{"", "Trazyn the Infinite",};

    //C'tan Shards
    private static final String[] Eliteeinträge_Ctan_Shards = new String[]{"", "C'tan Shard of the Deceiver", "C'tan Shard of the Nightbringer",};
    private static final String[] Unterstützungeinträge_Ctan_Shards = new String[]{"", "Transcendent C'tan",};

    //C'tan Shards & Dynasty
    private static final String[] LordofWareinträge_Ctan_Shards_Dynasty = new String[]{"", "Tesseract Vault",};

    //Canoptek
    private static final String[] Sturmeinträge_Canoptek = new String[]{"", "Canoptek Wraiths", "Canoptek Scarabs",};
    private static final String[] Unterstützungeinträge_Canoptek = new String[]{"", "Canoptek Spyders",};

    //Imperial Armour Xenos Vanilla
    private static final String[] Unterstützungeinträge_IA_NE = new String[]{"", "Sentry Pylon", "Tesseract Ark",};
    private static final String[] Fliegereinträge_IA_NE = new String[]{"", "Night Shroud",};
    private static final String[] LordofWareinträge_IA_NE = new String[]{"", "Gauss Pylon",};
    private static final String[] Befestigungen_IA_NE = new String[]{"", "Tomb Citadel",};

    //Imperial Armour Xenos Maynarkh Dynasty
    private static final String[] HQeinträge_IA_Maynarkh = new String[]{"", "Kutlakh the World Killer", "Toholk the Blinded",};

    //Imperial Armour Xenos Canoptek
    private static final String[] Eliteeinträge_IA_Canoptek = new String[]{"", "Canoptek Tomb Stalker",};
    private static final String[] Sturmeinträge_IA_Canoptek = new String[]{"", "Canoptek Acanthrites", "Canoptek Tomb Sentinel",};

    public VOLKNecrons() {
        reflectionKennung = "NE";
        InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ne.csv");
        pointValues = BuildaHQ.loadindexFile(is);

        is = this.getClass().getResourceAsStream("/oc/wh40k/indices/iane.csv");
        appendPointList(BuildaHQ.loadindexFile(is));

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Transporteinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TROOPS, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, ELITE, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FAST_ATTACK, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HEAVY_SUPPORT, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DEDICATED_TRANSPORT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        //Formationen
        formationen.add("NECRONS");
        formationen.add("");
        formationen.add("Sautekh");
        formationen.add("Nihilakh");
        formationen.add("Novokh");
        formationen.add("Mephrit");
        formationen.add("Nephrekh");
        formationen.add("Maynarkh");
        formationen.add("");
        formationen.add("C'tan Shards");
        formationen.add("Canoptek");

        complete();
    }

    @Override
    public void volkRefresh() {

        if (getFormationType().equals("NECRONS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh, HQeinträge_Nihilakh, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(Standardeinträge_NE));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(Transporteinträge_NE));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Sautekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Sautekh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nihilakh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_Nihilakh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Novokh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Mephrit")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Nephrekh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("Maynarkh")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(HQeinträge_NE, HQeinträge_Vanilla_only, HQeinträge_IA_Maynarkh));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_NE);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(Eliteeinträge_NE, Eliteeinträge_Vanilla_only, Eliteeinträge_Ctan_Shards, Eliteeinträge_IA_Canoptek));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_NE, Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(Unterstützungeinträge_NE, Unterstützungeinträge_Canoptek, Unterstützungeinträge_Ctan_Shards, Unterstützungeinträge_IA_NE));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_NE);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(uniteUnitList(Fliegereinträge_NE, Fliegereinträge_IA_NE));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(Befestigungen, Befestigungen_IA_NE));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(uniteUnitList(LordofWareinträge_NE, LordofWareinträge_Ctan_Shards_Dynasty, LordofWareinträge_IA_NE));
        } else if (getFormationType().equals("C'tan Shards")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_Ctan_Shards);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_Ctan_Shards);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LordofWareinträge_Ctan_Shards_Dynasty);
        } else if (getFormationType().equals("Canoptek")) {
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_IA_Canoptek);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(Sturmeinträge_Canoptek, Sturmeinträge_IA_Canoptek));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungeinträge_Canoptek);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungen);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}