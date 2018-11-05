package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class AEVoidweavers extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;



    public AEVoidweavers() {

        name = "Voidweavers";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Voidweavers", 1, 3, getPts("Voidweavers") + 2 * getPts("Shuriken cannon (Harlequins)"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Haywire cannon", getPts("Haywire cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Prismatic cannon", getPts("Prismatic cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());



        power = squad.getModelle() * 6;

    }

}

