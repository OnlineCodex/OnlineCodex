package oc.wh40k.units.ty;



import oc.*;



public class TYNeophyteHybrids extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1, o2, o3, o4;

    RuestkammerStarter rkBoss;



    public TYNeophyteHybrids() {

        name = "Neophyte Hybrids";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Neophyte Hybrids", 10, 20, getPts("Neophyte Hybrids"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun")));

        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));

        ogE.addElement(new OptionsGruppeEintrag("Lasgun", getPts("Lasgun")));

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



        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("Mortar", getPts("Mortar")));

        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));

        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cult icon", getPts("Cult icon")));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TYLeader.class, "Neophyte Leader");

        ((TYLeader) rkBoss.getKammer()).type = "Acolyte";

        rkBoss.initKammer();

        add(rkBoss);

        rkBoss.setAbwaehlbar(false);



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o3.getAnzahl() - 2 * o4.getAnzahl() - 1);



        o3.setAktiv(!o4.isSelected());

        o4.setAktiv(!o3.isSelected());



        if (squad.getModelle() > 10)

            power = 10;

        else

            power = 5;

    }

}