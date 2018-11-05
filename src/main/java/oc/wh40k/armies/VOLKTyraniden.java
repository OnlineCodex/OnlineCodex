package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

import java.io.InputStream;

public class VOLKTyraniden extends BuildaVater {

    public VOLKTyraniden() {

        reflectionKennung = "TY";
        InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/ty.csv");
        pointValues = BuildaHQ.loadindexFile(is);

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
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TR, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, EL, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FA, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FL, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORT, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LOW, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = BuildaHQ.translate("Tyraniden");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("Tyraniden");
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("Tyraniden");

        formationen.add("TYRANIDS");
        formationen.add("Genestealer Cults");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("TYRANIDS")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Hive Tyrant", "Broodlord", "Tyranid Prime", "Tervigon", "Malanthrope", "Neurotrophe",
                    "", "The Swarmlord", "Old One Eye",
                    "", "Patriarch", "Magus", "Primus", "Acolyte Iconward"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Tyranid Warriors", "Genestealers", "Termagants", "Hormagaunts", "Ripper Swarm",
                    "", "Acolyte Hybrids", "Neophyte Hybrids"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Tyrant Guard", "Hive Guard", "Lictor", "Maleceptor", "Zoanthropes", "Venomthropes",
                    "Pyrovores", "Haruspex",
                    "", "Deathleaper", "The Red Terror",
                    "", "Hybrid Metamorphs", "Aberrants", "Purestrain Genestealers"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Tyranid Shrikes", "Raveners", "Sky-Slasher Swarm", "Gargoyles",
                    "Mucolid Spores", "Sporenmines", "Dimachaeron", "Meiotic Spores",
                    "", "Cult Scout Sentinels", "Cult Armoured Sentinels"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Harpy", "Hive Crone"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Carnifexes", "Screamer-Killers", "Thornbacks", "Biovores", "Trygon Prime", "Trygon", "Mawloc", "Exocrine", "Toxicrene",
                    "Tyrannofex", "Stonecrusher Carnifex Brood",
                    "", "Cult Leman Russ", "Goliath Rockgrinder"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Tyrannocyte",
                    "", "Goliath Truck", "Cult Chimera"});
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{"", "Sporocyst"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Barbed Hierodule", "Scythed Hierodule", "Harridan", "Hierophant Bio-titan"});
        } else if (getFormationType().equals("Genestealer Cults")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Patriarch", "Magus", "Primus", "Acolyte Iconward"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Acolyte Hybrids", "Neophyte Hybrids"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Hybrid Metamorphs", "Aberrants", "Purestrain Genestealers"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Cult Scout Sentinels", "Cult Armoured Sentinels"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Cult Leman Russ", "Goliath Rockgrinder"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    ""});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Goliath Truck", "Cult Chimera"});
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}