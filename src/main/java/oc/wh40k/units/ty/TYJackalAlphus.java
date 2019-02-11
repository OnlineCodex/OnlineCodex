package oc.wh40k.units.ty;



import oc.Eintrag;



public class TYJackalAlphus extends Eintrag {



    public TYJackalAlphus() {

        name = "Jackal Alphus";

        grundkosten = getPts("Jackal Alphus") + getPts("Autopistol") + getPts("Jackal sniper rifle") + getPts("Blasting charges");

        seperator();
        
        addWarlordTraits("", true);
        
        power = 4;

        complete();

    }
}

