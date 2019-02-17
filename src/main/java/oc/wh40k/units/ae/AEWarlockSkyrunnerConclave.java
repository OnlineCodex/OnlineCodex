package oc.wh40k.units.ae;



import oc.*;

import oc.wh40k.units.PsychicPowers;



public class AEWarlockSkyrunnerConclave extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1;

	private final RuestkammerStarter psychicPowers;



    public AEWarlockSkyrunnerConclave() {

        name = "Warlock Skyrunner Conclave";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warlock Skyrunner Conclave", 2, 10, getPts("Warlock Skyrunner Conclave") + getPts("Shuriken pistol") + getPts("Twin shuriken catapult"));

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

        power = squad.getModelle() * 5;



        o1.setMaxAnzahl(squad.getModelle());

    }

}

