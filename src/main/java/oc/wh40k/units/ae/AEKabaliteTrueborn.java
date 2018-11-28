package oc.wh40k.units.ae;



import oc.*;



public class AEKabaliteTrueborn extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsZaehlerGruppe o2;

    RuestkammerStarter rkBoss;



    public AEKabaliteTrueborn() {

        name = "Kabalite Trueborn";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Kabalite Trueborn", 5, 20, getPts("Kabalite Trueborn"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter rifle", getPts("Splinter rifle")));

        ogE.addElement(new OptionsGruppeEintrag("Shredder", getPts("Shredder")));

        ogE.addElement(new OptionsGruppeEintrag("Blaster", getPts("Blaster")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter rifle", getPts("Splinter rifle")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Dark lance", getPts("Dark lance")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEDracon.class, "Dracon");

        rkBoss.initKammer();

        add(rkBoss);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {



        int o1max = squad.getModelle() - 1 - o2.getAnzahl();

        o1.setMaxAnzahl(o1max > 4 ? 4 : o1max);



        int o2max = squad.getModelle() - 1 - o1.getAnzahl();

        o2.setMaxAnzahl(o2max > 2 ? 2 : o2max);



        if (squad.getModelle() > 15) {

            power = 14;

        } else if (squad.getModelle() > 10) {

            power = 11;

        } else if (squad.getModelle() > 5) {

            power = 8;

        } else {

            power = 5;

        }



    }



}

