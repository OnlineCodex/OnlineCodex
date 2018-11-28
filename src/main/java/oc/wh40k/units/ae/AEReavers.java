package oc.wh40k.units.ae;



import oc.*;



public class AEReavers extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsZaehlerGruppe o2;

    RuestkammerStarter rkBoss;



    public AEReavers() {

        name = "Reavers";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Reavers", 3, 12, getPts("Reavers") + getPts("Splinter pistol") + getPts("Bladevanes"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter rifle", getPts("Splinter rifle")));

        ogE.addElement(new OptionsGruppeEintrag("Heat lance", getPts("Heat lance")));

        ogE.addElement(new OptionsGruppeEintrag("Blaster", getPts("Blaster")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Grav-talon", getPts("Grav-talon")));

        ogE.addElement(new OptionsGruppeEintrag("Cluster caltrops", getPts("Cluster caltrops")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEArenaChampion.class, "Arena Champion");

        rkBoss.initKammer();

        add(rkBoss);



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 3)).intValue());

        o2.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 3)).intValue());



        if (squad.getModelle() > 9) {

            power = 20;

        } else if (squad.getModelle() > 6) {

            power = 15;

        } else if (squad.getModelle() > 3) {

            power = 10;

        } else {

            power = 5;

        }

    }



}

