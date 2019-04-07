package oc.wh40k.armies;

import static oc.utils.ResourceUtils.loadPoints;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKTyraniden extends BuildaVater {

    private static final Set<String> HIVEFLEETS = ImmutableSet.of("Behemoth", "Kraken", "Leviathan", "Gorgon", "Jormungandr", "Hydra", "Kronos");
    private static final Set<String> CULTS = ImmutableSet.of("Cult Of The Four-Armed Emperor", "The Hivecult", "The Bladed Cog", "The Rusted Claw", "The Pauper Princes", "The Twisted Helix");

    private static final String[] HQeinträge_GenestealerCult = new String[]{"", "Patriarch", "Magus", "Primus", "Acolyte Iconward", "Abominant", "Jackal Alphus"};
    private static final String[] Eliteeinträge_GenestealerCult = new String[]{"", "Hybrid Metamorphs", "Aberrants", "Purestrain Genestealers", "Clamavus", "Locus", "Sanctus", "Kelermorph", "Nexos", "Biophagus"};
    private static final String[] Standardeinträge_GenestealerCult = new String[]{"", "Acolyte Hybrids", "Neophyte Hybrids", "Brood Brothers Infantry Squad"};
    private static final String[] Sturmeinträge_GenestealerCult = new String[]{"", "Achilles Ridgerunners", "Atalan Jackals", "Cult Armoured Sentinels", "Cult Scout Sentinels"};
    private static final String[] Unterstützungseinträge_GenestealerCult = new String[]{"", "Cult Leman Russ", "Brood Brothers Heavy Weapon Squad", "Goliath Rockgrinder"};
    private static final String[] Transporteinträge_GenestealerCult = new String[]{"", "Goliath Truck", "Cult Chimera"};
    private static final String[] Fliegereinträge_GenestealerCult = new String[]{"",};
    private static final String[] Befestigungseinträge_GenestealerCult = new String[]{"", "Tectonic Fragdrill"};
    private static final String[] LOWeinträge_GenestealerCult = new String[]{""};


    public VOLKTyraniden() {
        super("TY", loadPoints( "/oc/wh40k/indices/ty.yaml"));

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

        adden(new ChooserGruppe(this, getId(), cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, ELITE, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FAST_ATTACK, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HEAVY_SUPPORT, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, DEDICATED_TRANSPORT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FLIER, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FORTIFICATION, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = BuildaHQ.translate("Tyraniden");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Tyraniden");
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("Tyraniden");

        formationen.add("TYRANIDS");
        HIVEFLEETS.forEach(fleet -> formationen.add(fleet));
        formationen.add("");
        formationen.add("GENESTEALER CULTS");
        formationen.addAll(CULTS);
        formationen.add("");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("TYRANIDS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Hive Tyrant", "Broodlord", "Tyranid Prime", "Tervigon", "Malanthrope", "Neurotrophe",
                    "", "The Swarmlord", "Old One Eye"},
            		HQeinträge_GenestealerCult));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Tyranid Warriors", "Genestealers", "Termagants", "Hormagaunts", "Ripper Swarm"},
            		Standardeinträge_GenestealerCult));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Tyrant Guard", "Hive Guard", "Lictor", "Maleceptor", "Zoanthropes", "Venomthropes",
                    "Pyrovores", "Haruspex",
                    "", "Deathleaper", "The Red Terror"},
            		Eliteeinträge_GenestealerCult));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Tyranid Shrikes", "Raveners", "Sky-Slasher Swarm", "Gargoyles",
                    "Mucolid Spores", "Sporenmines", "Dimachaeron", "Meiotic Spores"},
            		Sturmeinträge_GenestealerCult));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Harpy", "Hive Crone"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Carnifexes", "Screamer-Killers", "Thornbacks", "Biovores", "Trygon Prime", "Trygon", "Mawloc", "Exocrine", "Toxicrene",
                    "Tyrannofex", "Stonecrusher Carnifex Brood"},
            		Unterstützungseinträge_GenestealerCult));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(uniteUnitList(new String[]{
                    "", "Tyrannocyte"},
            		Transporteinträge_GenestealerCult));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(uniteUnitList(new String[]{"", "Sporocyst"}, Befestigungseinträge_GenestealerCult));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Barbed Hierodule", "Scythed Hierodule", "Harridan", "Hierophant Bio-titan"});
        } else if (HIVEFLEETS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Hive Tyrant", "Broodlord", "Tyranid Prime", "Tervigon", "Malanthrope", "Neurotrophe",
                    "", "The Swarmlord", "Old One Eye"});
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(new String[]{
                    "", "Tyranid Warriors", "Genestealers", "Termagants", "Hormagaunts", "Ripper Swarm"});
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(new String[]{
                    "", "Tyrant Guard", "Hive Guard", "Lictor", "Maleceptor", "Zoanthropes", "Venomthropes",
                    "Pyrovores", "Haruspex",
                    "", "Deathleaper", "The Red Terror"});
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(new String[]{
                    "", "Tyranid Shrikes", "Raveners", "Sky-Slasher Swarm", "Gargoyles",
                    "Mucolid Spores", "Sporenmines", "Dimachaeron", "Meiotic Spores"});
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(new String[]{
                    "", "Harpy", "Hive Crone"});
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Carnifexes", "Screamer-Killers", "Thornbacks", "Biovores", "Trygon Prime", "Trygon", "Mawloc", "Exocrine", "Toxicrene",
                    "Tyrannofex", "Stonecrusher Carnifex Brood"});
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(new String[]{
                    "", "Tyrannocyte"});
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(new String[]{"", "Sporocyst"});
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(new String[]{
                    "", "Barbed Hierodule", "Scythed Hierodule", "Harridan", "Hierophant Bio-titan"});
        } else if (getFormationType().equals("GENESTEALER CULTS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_GenestealerCult);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_GenestealerCult);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_GenestealerCult);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_GenestealerCult);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_GenestealerCult);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_GenestealerCult);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_GenestealerCult);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungseinträge_GenestealerCult);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_GenestealerCult);
        } else if (CULTS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge_GenestealerCult);
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(Standardeinträge_GenestealerCult);
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(Eliteeinträge_GenestealerCult);
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(Sturmeinträge_GenestealerCult);
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(Unterstützungseinträge_GenestealerCult);
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(Fliegereinträge_GenestealerCult);
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(Transporteinträge_GenestealerCult);
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(Befestigungseinträge_GenestealerCult);
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(LOWeinträge_GenestealerCult);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}