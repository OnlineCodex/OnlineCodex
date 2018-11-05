package oc.wh40k.units.im;



import oc.*;



public class IMRavenwingBlackKnights extends Eintrag {



    AnzahlPanel squad;

    OptionsUpgradeGruppe o1;

    RuestkammerStarter rkBoss;



    public IMRavenwingBlackKnights() {

        name = "Ravenwing Black Knights";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing Black Knights", 3, 10, getPts("Ravenwing Black Knights") + getPts("Corvus hammer") + getPts("Bolt pistol (SM)") + getPts("Frag grenade") + getPts("Krak grenade") + getPts("Plasma talon") /*sollten weniger werden, wenn o1 ausgewählt ist*/);

        add(squad);



        ogE.addElement(new OptionsGruppeEintrag("Plasma talon", getPts("Plasma talon")));

        ogE.addElement(new OptionsGruppeEintrag("Ravenwing grenade launcher", getPts("Ravenwing grenade launcher")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o1.setSelected(0, true);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMRavenwingHuntmaster", "Ravenwing Huntmaster");

        rkBoss.initKammer();

        add(rkBoss);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 5) {

            power = 23;

        } else if (squad.getModelle() > 3) {

            power = 12;

        } else {

            power = 7;

        }



        o1.setMaxAnzahl(squad.getModelle() / 3);

    }

}

