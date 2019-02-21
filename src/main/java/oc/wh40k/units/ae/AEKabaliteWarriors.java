package oc.wh40k.units.ae;



import oc.*;



public class AEKabaliteWarriors extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1;

	private final OptionsZaehlerGruppe o2;

	private final RuestkammerStarter rkBoss;



    public AEKabaliteWarriors() {

        name = "Kabalite Warriors";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Kabalite Warriors", 5, 20, getPts("Kabalite Warriors"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Shredder", getPts("Shredder")));

        ogE.addElement(new OptionsGruppeEintrag("Blaster", getPts("Blaster")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", getPts("Splinter cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Dark lance", getPts("Dark lance")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, AESybarite.class, "Sybarite");

        rkBoss.initKammer();

        add(rkBoss);



        seperator();



        complete();

    }



    @Override

    public void refreshen() {



        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 5)).intValue());

        o2.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 10)).intValue());



        if (squad.getModelle() > 15) {

            power = 8;

        } else if (squad.getModelle() > 10) {

            power = 6;

        } else if (squad.getModelle() > 5) {

            power = 4;

        } else {

            power = 2;

        }

    }

}

