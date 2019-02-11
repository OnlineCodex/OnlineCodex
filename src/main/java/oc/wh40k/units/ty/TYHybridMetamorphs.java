package oc.wh40k.units.ty;



import oc.*;



public class TYHybridMetamorphs extends Eintrag {



    AnzahlPanel squad;

    OptionsZaehlerGruppe o1, o2, o3, o4;

    RuestkammerStarter rkBoss;



    public TYHybridMetamorphs() {

        name = "Hybrid Metamorphs";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hybrid Metamorphs", 5, 10, getPts("Hybrid Metamorphs"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Rending claws", getPts("Rending claws (GSC)")));

        ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));

        ogE.addElement(new OptionsGruppeEintrag("Metamorph whip", getPts("Metamorph whip")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Metamorph claw", getPts("Metamorph claw")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));

        ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));

        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cult icon", getPts("Cult icon")));



        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TYLeader.class, "Metamorph Leader");

        ((TYLeader) rkBoss.getKammer()).type = "Metamorph";

        rkBoss.initKammer();

        add(rkBoss);

        rkBoss.setAbwaehlbar(false);



        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - 1);

        o2.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - 1);

        if (o2.getAnzahl() > o1.getAnzahl())

            o3.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1);

        else

            o3.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - 1);

        o4.setMaxAnzahl(squad.getModelle() - 1);



        if (squad.getModelle() > 5)

            power = 6;

        else

            power = 3;

    }

}