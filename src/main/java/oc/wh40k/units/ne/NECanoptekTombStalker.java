package oc.wh40k.units.ne;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;



public class NECanoptekTombStalker extends Eintrag {



    public NECanoptekTombStalker() {

        name = "Canoptek Tomb Stalker";

        grundkosten = getPts("Canoptek Tomb Stalker") + getPts("Twin gauss slicers") + getPts("Automaton claws");

        power = 8;



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom prism", getPts("Gloom prism")));



        complete();

    }



}

