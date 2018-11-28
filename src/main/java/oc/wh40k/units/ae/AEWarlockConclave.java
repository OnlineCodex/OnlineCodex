package oc.wh40k.units.ae;



import oc.*;

import oc.wh40k.units.PsychicPowers;



public class AEWarlockConclave extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    RuestkammerStarter psychicPowers;



    public AEWarlockConclave() {

        name = "Warlock Conclave";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warlock Conclave", 2, 10, getPts("Warlock Conclave") + getPts("Shuriken pistol"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));

        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        o1.setAktiv(0, true);



        seperator();



        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");

        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);

        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfBattle();

        psychicPowers.initKammer();

        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);

        add(psychicPowers);

        psychicPowers.setAbwaehlbar(true);



        complete();

    }



    @Override

    public void refreshen() {

        power = squad.getModelle() * 3;



        o1.setMaxAnzahl(squad.getModelle());

    }

}

