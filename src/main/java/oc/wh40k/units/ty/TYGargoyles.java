package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYGargoyles extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsEinzelUpgrade oe1, oe2;

    public TYGargoyles() {
        name = "Gargoyles";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Gargoyles", 10, 30, getPts("Gargoyles"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYGargoyles.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Gargoyle)")));

        complete();
    }

    @Override
    public void refreshen() {
        oe1.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
        oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Gargoyle)"));

        if (squad.getModelle() > 20) {
            power = 12;
        } else if (squad.getModelle() > 10) {
            power = 8;
        } else {
            power = 4;
        }
    }

}
