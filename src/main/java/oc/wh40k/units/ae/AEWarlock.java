package oc.wh40k.units.ae;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;



public class AEWarlock extends Eintrag {



    OptionsZaehlerGruppe o1;

    RuestkammerStarter psychicPowers;



    public AEWarlock() {

        name = "Warlock";

        grundkosten = getPts("Warlock") + getPts("Shuriken pistol");

        power = 6;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));

        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o1.setAktiv(0, true);



        seperator();



        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");

        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);

        ((PsychicPowers) psychicPowers.getKammer()).enableRunesOfBattle();

        psychicPowers.initKammer();

        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);

        add(psychicPowers);

        psychicPowers.setAbwaehlbar(true);



        complete();

    }



    @Override

    public void refreshen() {

    }

}

