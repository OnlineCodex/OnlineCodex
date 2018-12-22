package oc.wh40k.units.necrons;

import oc.Tag;
import oc.wh40k.units.Faction;
import oc.wh40k.units.SupportFaction;

public abstract class Necrons extends Faction {
    private Necrons() {}

    public static abstract class Dynasty extends Necrons {
        private Dynasty () {}
    }
    public static final class Sautekh extends Dynasty {}
    public static final class Nihlakh extends Dynasty {}
    public static final class Novokh extends Dynasty {}
    public static final class Mephrit extends Dynasty {}
    public static final class Nephrekh extends Dynasty {}
    public static final class Maynarkh extends Dynasty {}

    @SupportFaction(Necrons.class)
    public static final class Canoptek extends Necrons {}
    @SupportFaction(Necrons.class)
    public static final class CTanShards extends Necrons {}

    interface Lord extends Tag {}
    interface Overlord extends Tag {}
    interface Cryptek extends Tag {}
}