package oc.wh40k.units.ae;



import oc.*;



public class AEWyches extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsEinzelUpgrade oe1;

    RuestkammerStarter rkBoss;



    public AEWyches() {

        name = "Wyches";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wyches", 5, 20, getPts("Wyches") + getPts("Darklight grenade"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & Hekatarii blade", getPts("Splinter pistol") + getPts("Hekatarii blade")));

        ogE.addElement(new OptionsGruppeEintrag("Razorflails", getPts("Razorflails")));

        ogE.addElement(new OptionsGruppeEintrag("Hydra gauntlets", getPts("hydra gauntlets")));

        ogE.addElement(new OptionsGruppeEintrag("Shardnet and impaler", getPts("Shardnet and impaler")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "AEHekatrix", "Hekatrix");

        rkBoss.initKammer();

        add(rkBoss);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() < 10) {

            o1.setMaxAnzahl(1);

        } else {

            o1.setMaxAnzahl(3);

        }



        if (squad.getModelle() > 15) {

            power = 10;

        } else if (squad.getModelle() > 10) {

            power = 8;

        } else if (squad.getModelle() > 5) {

            power = 6;

        } else {

            power = 3;

        }



    }



}

