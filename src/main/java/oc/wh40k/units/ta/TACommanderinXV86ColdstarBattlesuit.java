package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TACommanderinXV86ColdstarBattlesuit extends Eintrag {

    OptionsUpgradeGruppe o1;
    RuestkammerStarter ob;
    RuestkammerStarter warlord;

    public TACommanderinXV86ColdstarBattlesuit() {
        name = "Commander";
        grundkosten = getPts("Commander in XV86 Coldstar Battlesuit");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ob = new RuestkammerStarter(ID, randAbstand, cnt, TAKampfanzugKammer.class, "Commander");
        ob.setGrundkosten(0);
        ((TAKampfanzugKammer) ob.getKammer()).setColdstar(true);
        ob.initKammer(true, false, false, false, false, false, false);
        ob.setButtonText("Rüstkammer");
        add(ob);
        ob.setAbwaehlbar(false);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        addToInformationVector("Commander", 1);

        complete();
    }

    @Override
    public void refreshen() {
        if (!ob.isSelected()) {
            ((TAKampfanzugKammer) ob.getKammer()).clearEntries();
        }

        ((TAKampfanzugKammer) ob.getKammer()).farsight = getCountFromInformationVector("Farsight Enclave") > 0;

        if (getCountFromInformationVector("Contingent Headquarters") > 0) {
            if (getCountFromInformationVector("Commander") > 1) {
                setFehlermeldung("Max 1 Commander");
            } else if (((TAKampfanzugKammer) ob.getKammer()).uniqueError) {
                setFehlermeldung("Ausrüstung doppelt!");
            } else {
                setFehlermeldung("");
            }
        } else {
            if (((TAKampfanzugKammer) ob.getKammer()).uniqueError) {
                setFehlermeldung("Ausrüstung doppelt!");
            } else {
                setFehlermeldung("");
            }
        }
        
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) ob.getPanel().getLocation().getY() + ob.getPanel().getSize().height + 5
        );
    }

    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();
    }

}
