package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYLictor extends Eintrag {

    public TYLictor() {
        name = "Lictor";
        grundkosten = getPts("Lictor") + getPts("Flesh Hooks") + getPts("Grasping talons") + getPts("Rending claws");
        power = 2;

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYLiktor.jpg"));

        complete();
    }

}
