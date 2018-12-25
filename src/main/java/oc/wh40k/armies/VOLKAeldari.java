package oc.wh40k.armies;


import com.google.common.collect.ImmutableList;
import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;
import oc.utils.ResourceUtils;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import oc.wh40k.units.ae.*;


public class VOLKAeldari extends BuildaVater {

	private static final Set<String> CRAFTWORLDS = ImmutableSet.of("Alaitoc", "Biel-Tan", "Iyanden", "Saim-Hann", "Ulthwe");
	private static final Set<String> DRUKHARI = ImmutableSet.of("Kabal of the Black Heart", "Kabal of the Flayed Skull", "Kabal of the Poisoned Tongue", "Kabal of the Obsidian Rose", "Cult of Strife", Cult of the Cursed Blade", "Cult of the Red Grief", "The Prophets of Flesh", "The Dark Creed", "Coven of Twelve");
	private static final Set<String> HARLEQUINS = ImmutableSet.of("Midnight Sorrow", "Veiled Path", "Frozen Stars", "Dreaming Shadow", "Soaring Spite", "Silent Shroud");

    public VOLKAeldari() {
        super("AE", ResourceUtils.loadPoints("/oc/wh40k/indices/ae.yaml", "/oc/wh40k/indices/de.yaml"));

        AdditionalInformation = ImmutableList.of(null);
        HQeinträge = ImmutableList.of(null);
        Eliteeinträge = ImmutableList.of(null);
        Standardeinträge = ImmutableList.of(null);
        Sturmeinträge = ImmutableList.of(null);
        Unterstützungeinträge = ImmutableList.of(null);
        Transporteinträge = ImmutableList.of(null);
        Fliegereinträge = ImmutableList.of(null);
        Befestigungen = ImmutableList.of(null);
        LordofWar = ImmutableList.of(null);

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

        nameDerArtDerArmee = BuildaHQ.translate("AELDARI");
        nameDerArtDerArmeeDekliniert = BuildaHQ.translate("AELDARI");
        textAreaUeberschrift = BuildaHQ.translate("Meine") + " " + BuildaHQ.translate("AELDARI");

        formationen.add("AELDARI");
        formationen.add(null);
        formationen.add("ASURYANI");
        CRAFTWORLDS.forEach(craftworld -> formationen.add(craftworld));
        formationen.add("Warhost");
        formationen.add("Spirit Host");
        formationen.add("Aspect Warrior");
        formationen.add(null);
        formationen.add("DRUKHARI");
        DRUKHARI.forEach(drukhari -> formationen.add(drukhari));
        formationen.add("Incubi");
        formationen.add(null);
        formationen.add("HARLEQUINS");
        HARLEQUINS.forEach(harlequins -> formationen.add(harlequins));
        formationen.add(null);
        formationen.add("Ynnari");

        complete();
    }

    @Override
    public void volkRefresh() {
        if (getFormationType().equals("AELDARI")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,
                    null,
AEEldrad Ulthran.class,
AEPrince Yriel.class,
AEIllic Nightspear.class,
AEAsurmen.class,
AEJain Zar.class,
AEKarandras.class,
AEFuegan.class,
AEBaharroth.class,
AEMaugan Ra.class,
AEAvatar of Khaine.class,

                    null,
AEArchon.class,
AESuccubus.class,
AEHaemonculus.class,
                    null,
AELelith Hesperax.class,
AEUrien Rakarth.class,
AEDrazhar.class,

                    null,
AETroupe Master.class,
AEShadowseer.class,

                    null,
AEYvraine.class,
AEThe Visarch.class,
AEThe Yncarne.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers.class,
                    null,
AEKabalite Warriors.class,
AEWyches.class,
AEWracks.class,
                    null,
AETroupe"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades.class,
AEBonesinger.class,

                    null,
AELhamaean.class,
AEMedusae.class,
AESslyth.class,
AEUr-Ghul.class,
AEKabalite Trueborn.class,
AEHekatrix Bloodbrides.class,
AEIncubi.class,
AEMandrakes.class,
AEGrotesques.class,
AEBeastmaster.class,

                    null,
AEDeath Jester.class,
AESolitaire"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers.class,
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEReavers.class,
AEHellions.class,
AEScourges.class,

                    null,
AESkyweavers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord.class,

                    null,
AETalos.class,
AECronos.class,
AERavager.class,
                    null,
AEReaper.class,
AETantalus.class,
                    null,
AEVoidweavers"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent.class,
                    null,
AERaider.class,
AEVenom.class,
                    null,
AEStarweaver"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter.class,
                    null,
AERazorwing Jetfighter.class,
AEVoidraven"));
        } else if (getFormationType().equals("ASURYANI")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,
                    null,
AEEldrad Ulthran.class,
AEPrince Yriel.class,
AEIllic Nightspear.class,
AEAsurmen.class,
AEJain Zar.class,
AEKarandras.class,
AEFuegan.class,
AEBaharroth.class,
AEMaugan Ra.class,
AEAvatar of Khaine.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades.class,
AEBonesinger"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter"));
        } else if (getFormationType().equals("Warhost")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
                    null,
AEEldrad Ulthran.class,
AEPrince Yriel.class,
AEIllic Nightspear.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AEVypers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent"));
        } else if (getFormationType().equals("Spirit Host")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AESpiritseer"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithguard.class,
AEWraithblades"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithlord"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHemlock Wraithfighter"));
        } else if (getFormationType().equals("Aspect Warrior")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAsurmen.class,
AEJain Zar.class,
AEKarandras.class,
AEFuegan.class,
AEBaharroth.class,
AEMaugan Ra.class,
AEAvatar of Khaine"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDire Avengers"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch"));
        } else if (getFormationType().equals("Ulthwe")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,
                    null,
AEEldrad Ulthran.class,
AEAvatar of Khaine.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades.class,
AEBonesinger"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter"));
        } else if (getFormationType().equals("Iyanden")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,
                    null,
AEPrince Yriel.class,
AEAvatar of Khaine"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter"));
        } else if (getFormationType().equals("Alaitoc")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,

                    null,
AEIllic Nightspear.class,
AEAvatar of Khaine.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter"));
        } else if (getFormationType().equals("DRUKHARI")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEArchon.class,
AESuccubus.class,
AEHaemonculus.class,
                    null,
AELelith Hesperax.class,
AEUrien Rakarth.class,
AEDrazhar"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEKabalite Warriors.class,
AEWyches.class,
AEWracks"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AELhamaean.class,
AEMedusae.class,
AESslyth.class,
AEUr-Ghul.class,
AEKabalite Trueborn.class,
AEHekatrix Bloodbrides.class,
AEIncubi.class,
AEMandrakes.class,
AEGrotesques.class,
AEBeastmaster"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEReavers.class,
AEHellions.class,
AEScourges"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AETalos.class,
AECronos.class,
AERavager.class,
                    null,
AEReaper.class,
AETantalus"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERaider.class,
AEVenom"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERazorwing Jetfighter.class,
AEVoidraven"));
        } else if (getFormationType().equals("Kabal of the Black Heart")
        		|| getFormationType().equals("Flayed Skull")
        		|| getFormationType().equals("Poisoned Tongue")
        		|| getFormationType().equals("Kabal of the Obsidian Rose")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEArchon.class,
                    null,
AEDrazhar"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEKabalite Warriors"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEKabalite Trueborn.class,
AELhamaean.class,
AEMedusae.class,
AESslyth.class,
AEUr-Ghul.class,
AEIncubi.class,
AEMandrakes"));
        	myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEScourges"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERavager.class,
                    null,
AEReaper.class,
AETantalus"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERaider.class,
AEVenom"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERazorwing Jetfighter.class,
AEVoidraven"));
        } else if (getFormationType().equals("Cult of Strife")
        		|| getFormationType().equals("Cult of the Cursed Blade")
        		|| getFormationType().equals("Cult of the Red Grief")) {
        	if(getFormationType().equals("Cult of Strife")) {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
        				null,
AESuccubus.class,
        				null,
AEDrazhar.class,
AELelith Hesperax"));
        	} else {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                        null,
AESuccubus.class,
                        null,
AEDrazhar"));
        	}
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWyches"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHekatrix Bloodbrides.class,
AEIncubi.class,
AEMandrakes.class,
AEBeastmaster"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEReavers.class,
AEHellions.class,
AEScourges"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEReaper.class,
AETantalus"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERaider.class,
AEVenom"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERazorwing Jetfighter.class,
AEVoidraven"));
        } else if (getFormationType().equals("The Prophets of Flesh")
        		|| getFormationType().equals("The Dark Creed")
        		|| getFormationType().equals("Coven of Twelve")) {
        	if(getFormationType().equals("The Prophets of Flesh")){
	            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
	                    null,
AEHaemonculus.class,
	                    null,
AEUrien Rakarth.class,
AEDrazhar"));
        	} else {
        		myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
	                    null,
AEHaemonculus.class,
	                    null,
AEDrazhar"));
        	}
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWracks"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEIncubi.class,
AEMandrakes.class,
AEGrotesques"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEScourges"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AETalos.class,
AECronos.class,
                    null,
AEReaper.class,
AETantalus"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AERaider.class,
AEVenom"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(null));
        } else if (getFormationType().equals("Incubi")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDrazhar"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEIncubi"));
        } else if (getFormationType().equals("HARLEQUINS") || HARLEQUINS.contains(getFormationType())) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AETroupe Master.class,
AEShadowseer"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AETroupe"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDeath Jester.class,
AESolitaire"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AESkyweavers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEVoidweavers"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEStarweaver"));
            myChooserGruppen.get(FORTIFICATION).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWebway Gate"));
        } else if (getFormationType().equals("Ynnari")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEYvraine.class,
AEThe Visarch.class,
AEThe Yncarne.class,
                    null,
AEAutarch.class,
AEAutarch with Swooping Hawk Wings.class,
AEAutarch Skyrunner.class,
AEFarseer.class,
AEFarseer Skyrunner.class,
AEWarlock.class,
AEWarlock Conclave.class,
AEWarlock Skyrunner.class,
AEWarlock Skyrunner Conclave.class,
AESpiritseer.class,
                    null,
AEEldrad Ulthran.class,
AEPrince Yriel.class,
AEIllic Nightspear.class,
AEAsurmen.class,
AEJain Zar.class,
AEKarandras.class,
AEFuegan.class,
AEBaharroth.class,
AEMaugan Ra.class,
                    null,
AEArchon.class,
AESuccubus.class,
                    null,
AELelith Hesperax.class,
                    null,
AETroupe Master.class,
AEShadowseer.class,
                    null,
AEAutarch Index.class,
AEAutarch with Swooping Hawk Wings Index.class,
AEAutarch with Warp Jump Generator Index.class,
AEAutarch Skyrunner Index"));
            myChooserGruppen.get(TROOPS).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEGuardian Defenders.class,
AEStorm Guardians.class,
AERangers.class,
AEDire Avengers.class,
                    null,
AEKabalite Warriors.class,
AEWyches.class,
                    null,
AETroupe"));
            myChooserGruppen.get(ELITE).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEHowling Banshees.class,
AEStriking Scorpions.class,
AEFire Dragons.class,
AEWraithguard.class,
AEWraithblades.class,
                    null,
AELhamaean.class,
AEMedusae.class,
AESslyth.class,
AEUr-Ghul.class,
AEKabalite Trueborn.class,
AEHekatrix Bloodbrides.class,
AEIncubi.class,
AEBeastmaster.class,
                    null,
AEDeath Jester.class,
AESolitaire"));
            myChooserGruppen.get(FAST_ATTACK).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWindriders.class,
AESwooping Hawks.class,
AEWarp Spiders.class,
AEShining Spears.class,
AEVypers.class,
                    null,
AEClawed Fiends.class,
AEKhymerae.class,
AERazorwing Flocks.class,
AEReavers.class,
AEHellions.class,
AEScourges.class,
                    null,
AESkyweavers"));
            myChooserGruppen.get(HEAVY_SUPPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEDark Reapers.class,
AEVaul's Wrath Support Battery.class,
AEFalcon.class,
AEFire Prism.class,
AENight Spinner.class,
AEWar Walkers.class,
AEWraithlord.class,
                    null,
AERavager.class,
                    null,
AEVoidweavers"));
            myChooserGruppen.get(DEDICATED_TRANSPORT).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWave Serpent.class,
                    null,
AERaider.class,
AEVenom.class,
                    null,
AEStarweaver"));
            myChooserGruppen.get(LORD_OF_WAR).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AEWraithknight"));
            myChooserGruppen.get(FLIER).changeComboBoxAuswahlen(ImmutableList.of(
                    null,
AECrimson Hunter.class,
AECrimson Hunter Exarch.class,
AEHemlock Wraithfighter.class,
                    null,
AERazorwing Jetfighter.class,
AEVoidraven"));
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}