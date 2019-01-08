package oc.wh40k.units.ae;



import oc.*;



public class AEWarpSpiders extends Eintrag {



    AnzahlPanel squad;

    OptionsEinzelUpgrade boss;

    OptionsUpgradeGruppe o1;

    OptionsEinzelUpgrade oe1;

    RuestkammerStarter rkBoss;



    public AEWarpSpiders() {



        name = "Warp Spiders";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warp Spiders", 5, 10, getPts("Warp Spiders") + getPts("Death spinner"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = AEExarch.ExarchType.WARP_SPIDERS;

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Death spinner");

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

            power = 10;

        } else {

            power = 5;

        }

    }

}

