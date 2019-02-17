package oc.wh40k.units.ty;



import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

import oc.RuestkammerVater;



public class TYLeader extends RuestkammerVater {



    OptionsZaehlerGruppe o1, o2, o3;

    OptionsEinzelUpgrade oe1;

    String type = "";



    public TYLeader() {

        grundkosten = 0;

        name = "Sergeant";

    }



    @Override

    public void initButtons(boolean... defaults) {

        checkBuildaVater();



        seperator();

        if (type == "Metamorph") {



            ogE.addElement(new OptionsGruppeEintrag("Rending claws", getPts("Rending claws (GSC)")));

            ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));

            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setAnzahl(0, 1);


            seperator();



            ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));

            ogE.addElement(new OptionsGruppeEintrag("Metamorph whip", getPts("Metamorph whip")));

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);


            seperator();



            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Metamorph claw", getPts("Metamorph claw")));



            seperator();



            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));

            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));

            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o3.setAnzahl(0, 1);


            seperator();



            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bonesword (GSC)", getPts("Bonesword (GSC)")));



        } else if (type == "Neophyte") {

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lash whip and bonesword", getPts("Lash whip and bonesword")));



            seperator();



            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));

            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));

            ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));

            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));

            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setAnzahl(0, 1);


            seperator();



            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));

            ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));

            ogE.addElement(new OptionsGruppeEintrag("Web pistol", getPts("Web pistol")));

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);


        } else if (type == "Acolyte") {

            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));

            ogE.addElement(new OptionsGruppeEintrag("Bonesword", getPts("Bonesword (GSC)")));

            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setAnzahl(0, 1);


            seperator();



            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));

            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);


            seperator();



            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lash whip and bonesword", getPts("Lash whip and bonesword")));

        } else if (type == "Brood Brother") {
        	
            ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));

            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Autopistol")));

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if (type == "Atalan Leader") {
        	
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
            ogE.addElement(new OptionsGruppeEintrag("Demolition charge", getPts("Demolition charge")));
            ogE.addElement(new OptionsGruppeEintrag("Improvised weapon", getPts("Improvised weapon")));
            ogE.addElement(new OptionsGruppeEintrag("Power hammer", getPts("Power hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));
            ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            o1.setAnzahl(0, 1);
            o1.setAnzahl(5, 1);
        }



        sizeSetzen();

    }



    @Override

    public void refreshen() {

        if (type == "Metamorph") {

            o1.setAktiv(!oe1.isSelected());

            o2.setAktiv(!oe1.isSelected());

            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());

        } else if (type == "Neophyte") {

            o1.setAktiv(!oe1.isSelected());

            o2.setAktiv(!oe1.isSelected());

            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());

        } else if (type == "Acolyte") {

            o1.setAktiv(!oe1.isSelected());

            o2.setAktiv(!oe1.isSelected());

            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());

        } else if (type == "Brood Brother") {

            o1.setAnzahl(0, 1);

            o2.setAnzahl(0, 1);
        } else if (type == "Atalan Leader") {
        	o1.setLegal(o1.getAnzahl()==2);
        }

    }



    @Override

    public Object getSpecialValue() {

        return 0;

    }



    public void setKosten(int kosten) {

        grundkosten = kosten;

    }

}

