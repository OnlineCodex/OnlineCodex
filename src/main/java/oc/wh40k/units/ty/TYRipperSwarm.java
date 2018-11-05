package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYRipperSwarm extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelUpgrade oe1;

    public TYRipperSwarm() {
        name = "Ripper Swarm";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ripper Swarms", 3, 9, getPts("Ripper Swarms"));
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
