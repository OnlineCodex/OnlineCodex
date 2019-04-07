package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AESwoopingHawks extends Eintrag {



	private final AnzahlPanel squad;

	private final RuestkammerStarter rkBoss;



    public AESwoopingHawks() {



        name = "Swooping Hawks";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Swooping Hawks", 5, 10, getPts("Swooping Hawks") + getPts("Lasblaster"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class,   "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Swooping Hawks";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Lasblaster");

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

