package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class AEWindriders extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1;



    public AEWindriders() {

        name = "Windriders";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Windriders", 3, 9, getPts("Windriders"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken catapult", getPts("Twin shuriken catapult")));

        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        o1.setAnzahl(0, squad.getModelle());



        complete();

    }



    @Override

    public void refreshen() {



        o1.setMaxAnzahl(squad.getModelle());

        o1.setLegal(o1.getAnzahl() == squad.getModelle());

        if (squad.getModelle() > 6) {

            power = 15;

        } else if (squad.getModelle() > 3) {

            power = 10;

        } else {

            power = 5;

        }

    }



}

