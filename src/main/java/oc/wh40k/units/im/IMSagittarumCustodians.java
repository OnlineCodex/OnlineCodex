package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMSagittarumCustodians extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2;


    public IMSagittarumCustodians() {

        name = "Sagittarum Custodians";

        grundkosten = 0;

        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Sagittarum Custodians", 3, 5, getPts("Sagittarum Custodians"));

        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Adrastus bolt caliver", getPts("Adrastus bolt caliver")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Misericordia", getPts("Misericordia")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());

        o1.setLegal(squad.getModelle() == o1.getAnzahl());


        if(squad.getModelle() == 3) power = 8;
        if(squad.getModelle() == 4) power = 11;
        if(squad.getModelle() == 5) power = 14;
    }

}

