package oc.wh40k.units.ae;



import oc.*;



public class AEWraithlord extends Eintrag {



    OptionsZaehlerGruppe o3;

    OptionsZaehlerGruppe o3x;

    OptionsZaehlerGruppe o1;

    OptionsUpgradeGruppe o2;



    public AEWraithlord() {

        name = "Wraithlord";

        grundkosten = getPts("Wraithlord");

        power = 7;



        ogE.addElement(new OptionsGruppeEintrag("Shuriken catapult", getPts("Shuriken catapult")));

        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ghostglaive", getPts("Ghostglaive")));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Bright lance", getPts("Bright lance")));

        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Starcannon", getPts("Starcannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        complete();

    }



    @Override

    public void refreshen() {

        o3x.setAnzahl(0, o3x.getMaxAnzahl() - o3.getAnzahl());

    }



}

