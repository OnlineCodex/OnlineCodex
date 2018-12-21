package oc.wh40k.units.necrons;

import oc.Tag;
import oc.wh40k.units.Faction;

public abstract class Necrons extends Faction {
    private Necrons() {}

    public static final class Sautekh extends Necrons {}
    public static final class Nihlakh extends Necrons {}
    public static final class Novokh extends Necrons {}
    public static final class Mephrit extends Necrons {}
    public static final class Nephrekh extends Necrons {}
    public static final class Maynarkh extends Necrons {}
    public static final class Canoptek extends Necrons {}
    public static final class CTanShards extends Necrons {}

    interface Lord extends Tag {}
    interface Overlord extends Tag {}
    interface Cryptek extends Tag {}
}