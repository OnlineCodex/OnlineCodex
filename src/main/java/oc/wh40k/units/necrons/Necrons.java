package oc.wh40k.units.necrons;

import oc.wh40k.units.Faction;
import oc.wh40k.units.SubFaction;

public interface Necrons extends Faction {
    @SubFaction
    interface Sautekh extends Necrons {}
    @SubFaction
    interface Nihlakh extends Necrons {}
    @SubFaction
    interface Novokh extends Necrons {}
    @SubFaction
    interface Mephrit extends Necrons {}
    @SubFaction
    interface Nephrekh extends Necrons {}
    @SubFaction
    interface Maynarkh extends Necrons {}
    @SubFaction
    interface Canoptek extends Necrons {}
    @SubFaction
    interface CTanShards extends Necrons {}

    interface Lord extends Necrons {}
    interface Overlord extends Necrons {}
    interface Cryptek extends Necrons {}
    interface DestroyerLord extends Necrons {}
    interface Warriors extends Necrons{}
    interface Immortals extends Necrons {}
    interface Lynchguard extends Necrons {}
    interface Deathmarks extends Necrons {}
    interface FlayedOnes extends Necrons {}
    interface TriarchPraetorians extends Necrons {}
    interface TriarchStalker extends Necrons {}
    interface CTanShardOfTheDeceiver extends Necrons {}
    interface CTanShardOfTheNightbringer extends Necrons {}
    interface CanoptekWraiths extends Necrons {}
    interface CanoptekScarabs extends Necrons {}
    interface TombBlades extends Necrons {}
    interface Destroyer extends Necrons {}
    interface HeavyDestroyer extends Necrons {}
    interface CanoptekSpyders extends Necrons {}
}