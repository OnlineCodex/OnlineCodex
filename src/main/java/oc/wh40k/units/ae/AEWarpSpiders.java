package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AEWarpSpiders extends Eintrag {



	private final AnzahlPanel squad;

	private final RuestkammerStarter rkBoss;



    public AEWarpSpiders() {



        name = "Warp Spiders";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warp Spiders", 5, 10, getPts("Warp Spiders") + getPts("Death spinner"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Warp Spiders";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Death spinner");

        rkBoss.initKammer();

        rkBoss.setGrundkosten(getPts("Exarch"));

        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);

        add(rkBoss);

        rkBoss.setAbwaehlbar(true);



        complete();



    }



    //@OVERRIDE

    @Override
	public void refreshen() {



        if (squad.getModelle() > 5) {

            power = 10;

        } else {

            power = 5;

        }

    }

}

