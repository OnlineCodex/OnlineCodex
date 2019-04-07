package oc.wh40k.units.ty;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class TYAberrants extends Eintrag {



    private final AnzahlPanel squad, squad2;

    private final OptionsZaehlerGruppe o1, o2;



    public TYAberrants() {

        name = "Aberrants";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Aberrants", 4, 10, getPts("Aberrants") + getPts("Rending claws (GSC)"));

        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy power hammer", getPts("Heavy power hammer")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        squad2 = new AnzahlPanel(ID, randAbstand, cnt, "Aberrant Hypermorph", 0, 1, getPts("Aberrants") + getPts("Hypermorph tail") + getPts("Rending claws (GSC)"));
        add(squad2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy improvised weapon", getPts("Heavy improvised weapon")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy power hammer", getPts("Heavy power hammer")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad2.getModelle());

        if(squad.getModelle() >= 4) squad2.setMaxModelle(1);
        if(squad.getModelle() >= 8) squad2.setMaxModelle(2);

        final int modelle = squad.getModelle() + squad2.getModelle();
        final boolean legal = modelle >=5 && modelle <= 10;
        squad.setLegal(legal);


        if (modelle > 4) {

            power = 14;

        } else {

            power = 7;

        }

    }



}