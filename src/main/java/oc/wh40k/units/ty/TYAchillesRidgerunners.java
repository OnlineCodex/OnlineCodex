package oc.wh40k.units.ty;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class TYAchillesRidgerunners extends Eintrag {



    private final AnzahlPanel squad;

    private final OptionsZaehlerGruppe o1, o2;

    private final OptionsZaehlerGruppe o1x, o2x;



    public TYAchillesRidgerunners() {

        name = "Achilles Ridgerunners";

        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Achilles Ridgerunner", "Achilles Ridgerunners", 1, 3, getPts("Achilles Ridgerunner") + 2 * getPts("Heavy stubber"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy mining laser", getPts("Heavy mining laser")));

        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy mortar", getPts("Heavy mortar")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flare launcher", getPts("Flare launcher")));

        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Survey augur", getPts("Survey augur")));

        ogE.addElement(new OptionsGruppeEintrag("Spotter", getPts("Spotter")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o1x.setMaxAnzahl(squad.getModelle());

        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle());

        o2x.setMaxAnzahl(squad.getModelle());

        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl());

        power = 4 * squad.getModelle();

    }

}