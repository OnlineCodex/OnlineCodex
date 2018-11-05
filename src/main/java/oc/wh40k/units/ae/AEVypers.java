package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class AEVypers extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsZaehlerGruppe o7;

    OptionsZaehlerGruppe o1x;



    public AEVypers() {

        name = "Vypers";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "", "Vypers", 1, 3, getPts("Vypers"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Bright lance", getPts("Bright lance")));

        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));

        ogE.addElement(new OptionsGruppeEintrag("Starcannon", getPts("Starcannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken catapult", getPts("Twin shuriken catapult")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        o7.setAnzahl(0, squad.getModelle());



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());

        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o7.setMaxAnzahl(squad.getModelle());



        o7.setLegal(o7.getAnzahl() == squad.getModelle());



        power = squad.getModelle() * 4;

    }

}

