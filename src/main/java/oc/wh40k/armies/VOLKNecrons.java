package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.reflection.FactionDescription;
import oc.reflection.FactionIndexer;
import oc.utils.ResourceUtils;
import oc.wh40k.units.necrons.Necrons;

import java.io.InputStream;
import java.util.Map;

import static oc.reflection.FactionIndexer.indexFaction;
import static oc.utils.ResourceUtils.loadPoints;

public class VOLKNecrons extends BuildaVater {

    private final Map<Class<? extends Necrons>, FactionDescription<? extends Necrons>> subFactions;

    public VOLKNecrons() {
        super("NE", loadPoints(
                "/oc/wh40k/indices/ne.yaml",
                "/oc/wh40k/indices/iane.yaml"));

        subFactions = indexFaction("oc.wh40k.units.necrons", Necrons.class);

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{""};
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