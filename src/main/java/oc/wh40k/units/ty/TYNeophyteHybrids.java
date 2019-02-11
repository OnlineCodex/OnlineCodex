package oc.wh40k.units.ty;



import oc.*;



public class TYNeophyteHybrids extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1, o2, o3;

    RuestkammerStarter rkBoss;



    public TYNeophyteHybrids() {

        name = "Neophyte Hybrids";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Neophyte Hybrids", 10, 20, getPts("Neophyte Hybrids"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun")));

        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", getPts("Grenade launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Webber", getPts("Webber")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));

        ogE.addElement(new OptionsGruppeEintrag("Mining laser", getPts("Mining laser")));

        ogE.addElement(new OptionsGruppeEintrag("Seismic cannon", getPts("Seismic cannon")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));


        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cult icon", getPts("Cult icon")));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TYLeader.class, "Neophyte Leader");

        ((TYLeader) rkBoss.getKammer()).type = "Acolyte";

        rkBoss.initKammer();

        add(rkBoss);

        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o3.getAnzahl() - 1);

        if (squad.getModelle() > 10)

            power = 6;

        else

            power = 4;

    }

}