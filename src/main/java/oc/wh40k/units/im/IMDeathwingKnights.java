package oc.wh40k.units.im;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;



public class IMDeathwingKnights extends Eintrag {



    AnzahlPanel squad;



    public IMDeathwingKnights() {

        name = "Deathwing Knights";



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathwing Knights", 5, 10, getPts("Deathwing Knights") + getPts("Mace of absolution") /*Knight Master hat eigentlich Flail of the Unforgiven*/ + getPts("Storm shield (others)"));

        add(squad);



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Watcher in the Dark", getPts("Watcher in the Dark")));



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 5) {

            power = 24;

        } else {

            power = 12;

        }

    }

}