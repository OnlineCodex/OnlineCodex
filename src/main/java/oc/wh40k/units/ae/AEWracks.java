package oc.wh40k.units.ae;



import oc.*;



public class AEWracks extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    RuestkammerStarter rkBoss;



    public AEWracks() {

        name = "Wracks";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wracks", 5, 10, getPts("Wracks") + getPts("Haemonculus tools"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Liquifier gun", getPts("Liquifier gun")));

        ogE.addElement(new OptionsGruppeEintrag("Ossefactor", getPts("Ossefactor")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEAcothyst.class, "Acothyst");

        rkBoss.initKammer();

        add(rkBoss);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 5)).intValue());



        if (squad.getModelle() > 5) {

            power = 6;

        } else {

            power = 3;

        }

    }



}

