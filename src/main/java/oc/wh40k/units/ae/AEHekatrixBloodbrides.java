package oc.wh40k.units.ae;



import oc.*;



public class AEHekatrixBloodbrides extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsEinzelUpgrade oe1;

    RuestkammerStarter rkBoss;



    public AEHekatrixBloodbrides() {

        name = "Hekatrix Bloodbrides";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hekatrix Bloodbrides", 5, 20, getPts("Hekatrix Bloodbrides"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol and Hekatarii blade", getPts("Splinter pistol") + getPts("Hekatarii blade")));

        ogE.addElement(new OptionsGruppeEintrag("Razorflails", getPts("Razorflails")));

        ogE.addElement(new OptionsGruppeEintrag("Hydra gauntlets", getPts("Hydra gauntlets")));

        ogE.addElement(new OptionsGruppeEintrag("Shardnet and Impaler", getPts("Shardnet and Impaler")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AESyren.class, "Syren");

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

            power = 13;

        } else if (squad.getModelle() > 10) {

            power = 10;

        } else if (squad.getModelle() > 5) {

            power = 7;

        } else {

            power = 4;

        }

    }

}

