package oc.wh40k.units.ta;

import oc.*;
import oc.wh40k.units.Warlordtraits;

public class TACommanderinXV85EnforcerBattlesuit extends Eintrag {

    OptionsUpgradeGruppe o1;
    RuestkammerStarter ob;
    OptionsZaehlerGruppe o5;
    RuestkammerStarter warlord;

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

        ob = new RuestkammerStarter(ID, randAbstand, cnt, TAKampfanzugKammer.class, "Commander in XV85 Enforcer Battlesuit");
        ob.setGrundkosten(0);
        ob.initKammer(true, false, false, false, false, false, false);
        ob.setButtonText("Rüstkammer");
        add(ob);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();

    }

    @Override
    public void refreshen() {
        power = 7;
        if (o5.isSelected()) {
            power++;
        }
        
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) ob.getPanel().getLocation().getY() + ob.getPanel().getSize().height + 5
        );
    }

}

