package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;



public class IMMinistorumPriest extends Eintrag {



    public IMMinistorumPriest() {

        name = "Ministorum Priest";

        grundkosten = getPts("Ministorum Priest") + getPts("Laspistol") + getPts("Frag grenades") + getPts("Krak grenades");

        power = 2;



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Autogun", getPts("Autogun")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chainsword", getPts("Chainsword")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}