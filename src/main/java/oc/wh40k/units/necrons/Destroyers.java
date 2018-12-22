package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class Destroyers extends Eintrag<Necrons, FastAttack> implements Infantry, Fly {

    private final AnzahlPanel squad;
    private final OptionsEinzelZaehler oe1;

    public Destroyers() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Destroyer", "Destroyers", 1, 6, getPts("Destroyers") + getPts("Gauss cannon"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Destroyers.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Heavy Destroyer", "Upgrade zum Heavy Destroyer", 0, getPts("Heavy Destroyers") - getPts("Destroyers") + getPts("Heavy gauss cannon") - getPts("Gauss cannon")));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() >= 3) {
            oe1.setMaxAnzahl(1);
        } else {
            oe1.setMaxAnzahl(0);
        }

        power = 3 * squad.getModelle();
    }
}