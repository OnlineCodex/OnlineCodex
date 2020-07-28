package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRavenwingLandSpeeders extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1, o2;



    public IMRavenwingLandSpeeders() {

        name = "Ravenwing Land Speeders";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing Land Speeders", 1, 5, getPts("Ravenwing Land Speeders"));

        add(squad);



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy Bolter (SM other)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM other)")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM other)")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o1.setAktiv(0, true);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon (other)")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM other)")));

        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy Bolter (SM other)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM other)")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        power = squad.getModelle() * 6;



        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());

    }

}

