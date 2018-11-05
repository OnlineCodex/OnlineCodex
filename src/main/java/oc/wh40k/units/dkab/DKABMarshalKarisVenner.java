package oc.wh40k.units.dkab;



import oc.*;



public class DKABMarshalKarisVenner extends Eintrag {



    OptionsEinzelUpgrade o1;

    OptionsZaehlerGruppe o4;

    OptionsZaehlerGruppe o4x;

    OptionsUpgradeGruppe o5;

    //	OptionsZaehlerGruppe o5x;

    OptionsEinzelZaehler oe3;

    OptionsEinzelZaehler oe4;

    OptionsEinzelZaehler oe5;

    OptionsEinzelZaehler oe6;

    OptionsEinzelUpgrade mb;

    RuestkammerStarter rkTransport;



    boolean creedSelected = false;

    boolean strakenSelected = false;

    boolean kellSelected = false;

    boolean deddogSelected = false;



    public DKABMarshalKarisVenner() {



        kategorie = 1;

        name = "Marshal Karis Venner";

        grundkosten = 165;



        add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));



        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Marshal Venner", 0));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Regimental standard", 0));

        ogE.addElement(new OptionsGruppeEintrag("Icon of Righteous Spite", 20));

        ogE.addElement(new OptionsGruppeEintrag("Banner of Martyrdom", 15));

        ogE.addElement(new OptionsGruppeEintrag("Ossuary of the Blessed Dead", 25));

        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox caster", 1, 5));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Veteran with Lasgun", 0));

        add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Flamer", "Veteran with Flamer", 5));

        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Veteran with Grenade launcher", 5));

        ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Veteran with Melta gun", 10));

        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Veteran with Plasma gun", 15));

        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Carapace armour", 10));



        seperator();



        add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Quartermaster", 1, 30));

        add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Artillerist", 1, 30));



        seperator(5);



        add(oe6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Tech-Priest Militant", 1, 30));

        add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));



        seperator();



        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKABStormChimera", "Storm Chimera");

        rkTransport.initKammer();

        add(rkTransport);



        complete();



    }



    //@OVERRIDE

    public void refreshen() {

        setUnikat(true);



        o1.setSelected(true);



        o4x.setMaxAnzahl(3 - o4.getAnzahl()); //Spez

        o4x.setAnzahl(0, 3 - o4.getAnzahl()); //Spez



        if (!o5.isSelected()) {

            o5.setSelected(0, true);

        }



        mb.setAktiv(oe6.isSelected());



    }

}

