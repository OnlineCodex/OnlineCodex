package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AEShiningSpears extends Eintrag {



	private final AnzahlPanel squad;


	private final RuestkammerStarter rkBoss;



    public AEShiningSpears() {



        name = "Shining Spears";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Shining Spears", 3, 9, getPts("Shining Spears") + getPts("Laser lance") + getPts("Twin shuriken catapult"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class,"Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Shining Spears";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Laser lance");

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



        if (squad.getModelle() > 6) {

            power = 21;

        } else if (squad.getModelle() > 3) {

            power = 14;

        } else {

            power = 7;

        }

    }

}

