package oc.wh40k.units.im;



import oc.*;



public class IMAgamatusCustodians extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsZaehlerGruppe o1, o2, o3;


    public IMAgamatusCustodians() {

        name = "Agamatus Custodians";

        grundkosten = 0;

        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Agamatus Custodians", 3, 6, getPts("Agamatus Custodians"));

        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lastrum bolt cannon", getPts("Lastrum bolt cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Adrathic devastator", getPts("Adrathic devastator")));

        ogE.addElement(new OptionsGruppeEintrag("Twin las-pulser", getPts("Twin las-pulser")));
        
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Interceptor lance", getPts("Interceptor lance")));

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

        if(squad.getModelle() == 3) power = 16;
        if(squad.getModelle() == 4) power = 21;
        if(squad.getModelle() == 5) power = 26;
        if(squad.getModelle() == 5) power = 31;
    }

}

