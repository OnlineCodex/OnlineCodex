package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;



public class IMLandRaiderAchilles extends Eintrag {



    public IMLandRaiderAchilles() {

        name = "Land Raider Achilles";

        grundkosten = getPts("Land Raider Achilles") + getPts("Quad launcher") + 2 * getPts("Twin multi-melta");

        power = 21;



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));



        complete();

    }



    @Override

    public void refreshen() {

    }

}

