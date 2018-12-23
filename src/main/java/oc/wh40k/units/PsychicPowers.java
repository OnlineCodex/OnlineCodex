package oc.wh40k.units;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

import java.util.*;

import static com.google.common.collect.Sets.newEnumSet;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static oc.wh40k.units.PsychicPowers.ChaosGod.NURGLE;
import static oc.wh40k.units.PsychicPowers.ChaosGod.SLAANESH;
import static oc.wh40k.units.PsychicPowers.ChaosGod.TZEENTCH;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class PsychicPowers extends RuestkammerVater {

    private final int numPowers;

    private final OptionsUpgradeGruppe smite;
    private final Map<PsychicPowerGroup, OptionsUpgradeGruppe> powers;
    private final Set<ChaosGod> chaosGods;

    public void setGod(ChaosGod god, boolean b) {
        if (b) {
            chaosGods.add(god);
        } else {
            chaosGods.remove(god);
        }
    }

    public enum ChaosGod {
        NURGLE,
        TZEENTCH,
        SLAANESH,
    }

	public enum PsychicPowerGroup {
        DARK_HERETICUS(
                "Infernal Gaze",
                "Daeth Hex",
                "Gift of Chaos",
                "Prescience",
                "Diabolic Strength",
                "Warptime",
                "Weaver of Fates",
                "Miasma of Pestilence",
                "Deligthful Agonies"),
        CONTAGION(
                "Miasma of Pestilence",
                "Gift of Contagion",
                "Plague Wind",
                "Blades of Putrefaction",
                "Putrescent Vitality",
                "Curse of the Leper"),
        DISCIPLINE_OF_TZEENTCH(
                "Boon of Change",
                "Bolt of Change",
                "Gaze of Fate",
                "Treason of Tzeentch",
                "Flickering Flames",
                "Infernal Gateway"),
        CHANGE(
                "Tzeentch's Firestorm",
                "Boon of Mutation",
                "Glamour of Tzeentch",
                "Doombolt",
                "Temporal Manipulation",
                "Weaver of Fates"),
        DISCIPLINE_OF_NURGLE(
                "Stream of Corruption",
                "Fleshy Abundance",
                "Nurgle's Rot",
                "Shrivelling Pox",
                "Virulent Blessing",
                "Miasma of Pestilence"),
        DISCIPLINE_OF_SLAANESH(
                "Cacaphonic Choir",
                "Symphony of Pain",
                "Hysterical Frenzy",
                "Delightful Agonies",
                "Pavane of Slaanesh",
                "Phantasmagoria"),
        RUNES_OF_FATE(
                "Guide",
                "Doom",
                "Fortune",
                "Executioner",
                "Will of Asuryan",
                "Mind War"),
        RUNES_OF_BATTLE(
                "Conceal/Reveal",
                "Embolden/Horrify",
                "Enhance/Drain",
                "Protect/Jinx",
                "Quicken/Restrain",
                "Empower/Enervate"),
        SANCTIC(
                "Purge Soul",
                "Gate of Infinity",
                "Hammerhand",
                "Sanctuary",
                "Astral Aim",
                "Vortex of Doom"),
        HIVE_MIND(
                "Dominion",
                "Catalyst",
                "The Horror",
                "Onslaught",
                "Paroxysm",
                "Psychic Scream"),
        LIBRARIUS(
                "Veil of Time",
                "Might of Heroes",
                "Psychic Scourge",
                "Fury of the Ancients",
                "Psychic Fortress",
                "Null Zone"),
        PSYKANA(
                "Terrifying Visions",
                "Gaze of the Emperor",
                "Psychic Barrier",
                "Nightshroud",
                "Mental Fortitude",
                "Psychic Maelstrom"),
        SANGUINARY(
                "Quickening",
                "Unleash Rage",
                "Shield of Sanguinius",
                "Blood Boil",
                "The Blood Lance",
                "Wings of Sanguinius"),
        INTERROMANCY(
                "Mind Worm",
                "Aversion",
                "Righteous Repugnance",
                "Trephination",
                "Engulfing Fear",
                "Mind Wipe"),
        POWER_OF_THE_WAAAGH(
                "'Eadbanger",
                "Warpath",
                "Da Jump",
                "Fists of Gork",
                "Da Krunch",
                "Roar of Mork"),
        TEMPESTAS_DISCIPLINE(
                "Living Lightning",
                "Tempest's Wrath",
                "Murderous Hurricane",
                "Fury of the Wolf Spirits",
                "Storm Caller",
                "Jaws of the World Wolf"),
        ;

        private final List<String> powers;

        PsychicPowerGroup(String... powers) {
            this.powers = ImmutableList.copyOf(powers);
        }
    }

    public PsychicPowers(int numPowers, PsychicPowerGroup... groups) {
        this(numPowers, ImmutableSet.of(), groups);
    }

    public PsychicPowers(int numPowers, Iterable<ChaosGod> chaosGods, PsychicPowerGroup... groups) {
	    this.numPowers = numPowers;
	    this.chaosGods = newEnumSet(chaosGods, ChaosGod.class);
        checkBuildaVater();

        ogE.addElement(new OptionsGruppeEintrag("Smite", 0));
        add(smite = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        this.powers = Arrays.stream(groups)
                .filter(g -> !g.powers.isEmpty())
                .collect(toMap(identity(), group -> {
                    Vector<OptionsGruppeEintrag> opts = new Vector();
                    group.powers.stream()
                            .map(p -> new OptionsGruppeEintrag(p, 0))
                            .forEach(opts::add);
                    OptionsUpgradeGruppe groupElem = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", opts);
                    if (group == DARK_HERETICUS) {
                        groupElem.setAktiv("Weaver of Fates", false);
                        groupElem.setAktiv("Miasma of Pestilence", false);
                        groupElem.setAktiv("Deligthful Agonies", false);
                    }
                    return groupElem;
                }));

        this.powers.values().forEach(this::add);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        smite.alwaysSelected();

        powers.forEach((group, optGroup) -> {
            if (DARK_HERETICUS.equals(group)) {
                optGroup.setMaxAnzahl(numPowers);
                optGroup.setAktiv("Miasma of Pestilence", chaosGods.contains(NURGLE));
                optGroup.setAktiv("Weaver of Fates", chaosGods.contains(TZEENTCH));
                optGroup.setAktiv("Deligthful Agonies", chaosGods.contains(SLAANESH));
            }
            optGroup.setMaxAnzahl(numPowers);
        });
    }
}