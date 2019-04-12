package oc.wh40k.units.im;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMAquilonCustodians extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3;


    public IMAquilonCustodians() {

        name = "Aquilon Custodians";

        grundkosten = 0;

        applyTitle = true;





        squad = new AnzahlPanel(ID, randAbstand, cnt, "Aquilon Custodians", 3, 6, getPts("Aquilon Custodians"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Lastrum storm bolter", getPts("Lastrum storm bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Infernus firepike", getPts("Infernus firepike")));

        ogE.addElement(new OptionsGruppeEintrag("Twin Adrathic destructor", getPts("Twin Adrathic destructor")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setAnzahl(0, squad.getModelle());



        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Solerite power gauntlet", getPts("Solerite power gauntlet")));

        ogE.addElement(new OptionsGruppeEintrag("Solerite power talon", getPts("Solerite power talon")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o3.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Misericordia", getPts("Misericordia")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle());

        o3.setMaxAnzahl(squad.getModelle());

        o1.setLegal(squad.getModelle() == o1.getAnzahl());
        o3.setLegal(squad.getModelle() == o3.getAnzahl());


        if(squad.getModelle() == 3) power = 13;
        if(squad.getModelle() == 4) power = 17;
        if(squad.getModelle() == 5) power = 21;
        if(squad.getModelle() == 6) power = 25;
    }

}

