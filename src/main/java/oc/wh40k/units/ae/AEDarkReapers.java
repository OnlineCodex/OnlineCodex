package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AEDarkReapers extends Eintrag {



	private final AnzahlPanel squad;

	private final RuestkammerStarter rkBoss;



    public AEDarkReapers() {



        name = "Dark Reapers";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dark Reapers", 3, 10, getPts("Dark Reapers") + getPts("Reaper launcher"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Dark Reapers";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Reaper launcher");

        rkBoss.initKammer();

        rkBoss.setGrundkosten(getPts("Exarch"));

        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);

        add(rkBoss);

        rkBoss.setAbwaehlbar(true);



        seperator(15);



        complete();



    }



    //@OVERRIDE

    @Override
	public void refreshen() {



        if (squad.getModelle() > 5) {

            power = 18;

        } else if (squad.getModelle() > 3) {

            power = 9;

        } else {

            power = 5;

        }

    }

}

