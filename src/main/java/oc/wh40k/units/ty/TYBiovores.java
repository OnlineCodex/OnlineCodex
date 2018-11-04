package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYBiovores extends Eintrag {

    AnzahlPanel squad;

    public TYBiovores() {
        name = "Biovores";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Biovore", "Biovores", 1, 3, getPts("Biovores") + getPts("Spore mine launcher"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYBiovoren.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle() * 2;
    }

}
