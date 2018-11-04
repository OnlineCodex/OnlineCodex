package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYLictor extends Eintrag {

    AnzahlPanel squad;

    public TYLictor() {
        name = "Lictor";
        grundkosten = getPts("Lictor") + getPts("Flesh Hooks") + getPts("Grasping talons") + getPts("Rending claws");
        power = 2;

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYLiktor.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
