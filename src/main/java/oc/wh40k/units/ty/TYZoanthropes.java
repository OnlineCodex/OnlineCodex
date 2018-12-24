package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYZoanthropes extends Eintrag {

    private final AnzahlPanel squad;

    public TYZoanthropes() {
        name = "Zoanthropes";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Zoanthrope", "Zoanthropes", 3, 6, getPts("Zoanthropes") + getPts("Claws and teeth"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYZoantrophen.jpg"));

        seperator();

        addPsychicPowers(1, HIVE_MIND);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
        if (squad.getModelle() > 3) {
            power = 12;
        }
    }
}
