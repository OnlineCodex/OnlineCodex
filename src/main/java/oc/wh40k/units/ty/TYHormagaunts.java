package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYHormagaunts extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsEinzelUpgrade oe1;
    private final OptionsEinzelUpgrade oe2;

    public TYHormagaunts() {
        name = "Hormagaunts";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hormagaunts", 10, 30, getPts("Hormagaunts"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYHormaganten.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Hormagaunt)")));

        complete();
    }

    @Override
    public void refreshen() {
        oe1.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
        oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Hormagaunt)"));

        if (squad.getModelle() > 20) {
            power = 9;
        } else if (squad.getModelle() > 10) {
            power = 6;
        } else {
            power = 3;
        }
    }

}
