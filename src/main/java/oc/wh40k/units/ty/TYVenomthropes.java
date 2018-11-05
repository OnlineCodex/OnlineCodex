package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYVenomthropes extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter pod;

    public TYVenomthropes() {
        name = "Venomthropes";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Venomthrope", "Venomthropes", 3, 6, getPts("Venomthropes") + getPts("Toxic lashes (NK)") + getPts("Toxic lashes (FK)"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYToxotrophen.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
        if (squad.getModelle() > 3) {
            power = 8;
        }
    }

}
