package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class AECronos extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2;



    public AECronos() {

        name = "Cronos";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Cronos", 1, 3, getPts("Cronos") + getPts("Spirit syphon") + getPts("Spirit-leech tentacles"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Spirit vortex", getPts("Spirit vortex")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Spirit probe", getPts("Spirit probe")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());



        power = squad.getModelle() * 5;

    }

}