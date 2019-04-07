package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMVenatariCustodians extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3, o4;


    public IMVenatariCustodians() {

        name = "Venatari Custodians";

        grundkosten = 0;

        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Venatari Custodians", 3, 6, getPts("Venatari Custodians"));

        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kinetic destroyer", getPts("Kinetic destroyer")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tarsus buckler", getPts("Tarsus buckler")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o3.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Venatari lance", getPts("Venatari lance")));

        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o3.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Misericordia", getPts("Misericordia")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o4.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle());

        o3.setMaxAnzahl(squad.getModelle() - o4.getAnzahl());

        o4.setMaxAnzahl(squad.getModelle());

        o1.setLegal(squad.getModelle() == o1.getAnzahl() + o4.getAnzahl());
        o3.setLegal(squad.getModelle() == o3.getAnzahl() + o4.getAnzahl());



        if(squad.getModelle() == 3) power = 10;
        if(squad.getModelle() == 4) power = 13;
        if(squad.getModelle() == 5) power = 16;
        if(squad.getModelle() == 5) power = 19;
    }

}

