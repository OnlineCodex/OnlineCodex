package oc.wh40k.units.ta;



import oc.*;



public class TACommanderinXV85EnforcerBattlesuit extends Eintrag {



    OptionsUpgradeGruppe o1;

    RuestkammerStarter ob;

    OptionsZaehlerGruppe o5;



    public TACommanderinXV85EnforcerBattlesuit() {

        name = "Commander in XV85 Enforcer Battlesuit";

        grundkosten = getPts("Commander in XV85 Enforcer Battlesuit");



        überschriftSetzen = true;



        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));

        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));

        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));

        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        ob = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Commander in XV85 Enforcer Battlesuit");

        ob.setGrundkosten(0);

        ob.initKammer(true, false, false, false, false, false, false);

        ob.setButtonText("Rüstkammer");

        add(ob);



        complete();

    }



    //@OVERRIDE

    public void refreshen() {

        power = 7;

        if (o5.isSelected()) {

            power++;

        }

    }



    //@OVERRIDE

    public void deleteYourself() {

        super.deleteYourself();

    }



}

