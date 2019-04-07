package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AEHowlingBanshees extends Eintrag {



	private final AnzahlPanel squad;

	private final RuestkammerStarter rkBoss;



    public AEHowlingBanshees() {



        name = "Howling Banshees";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Howling Banshees", 5, 10, getPts("Howling Banshees") + getPts("Shuriken pistol") + getPts("Power sword"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt,AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Howling Banshees";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Shuriken pistol") + getPts("Power sword");

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

            power = 8;

        } else {

            power = 4;

        }

    }

}

