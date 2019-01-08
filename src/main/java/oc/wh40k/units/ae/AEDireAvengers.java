package oc.wh40k.units.ae;



import oc.*;



public class AEDireAvengers extends Eintrag {



    AnzahlPanel squad;

    OptionsEinzelUpgrade boss;

    OptionsUpgradeGruppe o1;

    RuestkammerStarter rkBoss;



    public AEDireAvengers() {



        name = "Dire Avengers";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dire Avengers", 5, 10, getPts("Dire Avengers") + getPts("Avenger shuriken catapult") + getPts("Sunburst grenade"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = AEExarch.ExarchType.DIRE_AVENGERS;

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Avenger shuriken catapult");

        rkBoss.initKammer();

        rkBoss.setGrundkosten(getPts("Exarch"));

        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);

        add(rkBoss);

        rkBoss.setAbwaehlbar(true);



        complete();



    }



    //@OVERRIDE

    public void refreshen() {



        if (squad.getModelle() > 5) {

            power = 12;

        } else {

            power = 6;

        }

    }

}

