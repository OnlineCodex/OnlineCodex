package oc.wh40k.units.ta;

import oc.*;

public class TACommanderinXV8CrisisBattlesuit extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o5;
    RuestkammerStarter ob;

    public TACommanderinXV8CrisisBattlesuit() {
        name = "Commander";
        grundkosten = getPts("Commander in XV8 Crisis Battlesuit");
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "XV8-02 Iridium Battlesuit", getPts("XV8-02 Crisis Iridium battlesuite")));

        seperator();

        ob = new RuestkammerStarter(ID, randAbstand, cnt, new TAKampfanzugKammer(true, false, false, false), "Commander in XV8 Crisis Battlesuit");
        ob.setGrundkosten(0);
        ob.setButtonText("Rüstkammer");
        ob.setAbwaehlbar(false);
        add(ob);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        power = 7;
        if (o5.isSelected()) {
            power++;
        }
    }

}

