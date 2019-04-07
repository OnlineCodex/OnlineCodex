package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;



public class AEFireDragons extends Eintrag {

	private final RuestkammerStarter rkBoss;

	private final AnzahlPanel squad;

    public AEFireDragons() {



        name = "Fire Dragons";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Fire Dragons", 5, 10, getPts("Fire Dragons") + getPts("Fusion gun") + getPts("Melta bomb"));

        add(squad);



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AEExarch.class, "Exarch");

        ((AEExarch) rkBoss.getKammer()).type = "Fire Dragons";

        ((AEExarch) rkBoss.getKammer()).weaponCost = getPts("Fusion gun");

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

            power = 12;

        } else {

            power = 6;

        }

    }

}

