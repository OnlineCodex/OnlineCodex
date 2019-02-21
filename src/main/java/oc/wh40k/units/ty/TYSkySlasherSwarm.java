package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYSkySlasherSwarm extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsEinzelUpgrade oe1;

    public TYSkySlasherSwarm() {
        name = "Sky-Slasher Swarm";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Sky-Slasher Swarms", 3, 9, getPts("Sky-Slasher Swarms"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYAbsorber.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spinemaws", getPts("Spinemaws")));

        complete();
    }

    @Override
    public void refreshen() {
        oe1.setPreis(squad.getModelle() * getPts("Spinemaws"));
        if (squad.getModelle() > 6) {
            power = 6;
        } else if (squad.getModelle() > 3) {
            power = 4;
        } else {
            power = 2;
        }
    }

}
