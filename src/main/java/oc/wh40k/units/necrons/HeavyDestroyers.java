package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class HeavyDestroyers extends Eintrag<Necrons, HeavySupport> implements Infantry, Fly {

    private final AnzahlPanel squad;

    public HeavyDestroyers() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Destroyer", "Heavy Destroyers", 1, 3, getPts("Heavy Destroyers") + getPts("Heavy gauss cannon"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Destroyers.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = 3 * squad.getModelle();
    }
}