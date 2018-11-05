package oc.wh40k.units.ty;



import oc.*;



public class TYCultScoutSentinels extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1;

    OptionsZaehlerGruppe o1x;

    OptionsEinzelZaehler oe1;

    OptionsEinzelZaehler oe2;



    public TYCultScoutSentinels() {

        name = "Cult Scout Sentinels";

        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Cult Scout Sentinel", "Cult Scout Sentinels", 1, 3, getPts("Cult Scout Sentinels"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser")));

        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));



        seperator();



        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sentinel chainsaw", 1, getPts("Sentinel chainsaw")));

        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 1, getPts("Hunter-killer missile")));



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());

        o1x.setMaxAnzahl(squad.getModelle());

        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());



        oe1.setMaxAnzahl(squad.getModelle());

        oe2.setMaxAnzahl(squad.getModelle());



        power = 2 * squad.getModelle();

    }

}