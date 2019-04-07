package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class AEVaulsWrathSupportBattery extends Eintrag {

	private final AnzahlPanel squad;

    private final OptionsZaehlerGruppe o1;



    public AEVaulsWrathSupportBattery() {



        name = "Vaul' Wrath Support Battery";



        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Vaul's Wrath Support Battery", 1, 3, getPts("Vaul's Wrath Support Battery") + getPts("Shuriken catapult"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Shadow weaver", getPts("Shadow weaver")));

        ogE.addElement(new OptionsGruppeEintrag("Vibro cannon", getPts("Vibro cannon")));

        ogE.addElement(new OptionsGruppeEintrag("D-cannon", getPts("D-cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        o1.setAnzahl(0, squad.getModelle());



        complete();



    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o1.setLegal(o1.getAnzahl() == squad.getModelle());

        power = squad.getModelle() * 5;

    }

}

