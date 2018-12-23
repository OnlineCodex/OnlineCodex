package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TACommanderinXV86ColdstarBattlesuit extends Eintrag {

    OptionsUpgradeGruppe o1;
    RuestkammerStarter ob;

    public TACommanderinXV86ColdstarBattlesuit() {
        name = "Commander";
        grundkosten = getPts("Commander in XV86 Coldstar Battlesuit");

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ob = new RuestkammerStarter(ID, randAbstand, cnt, new TAKampfanzugKammer(true, false, false, false), "Commander");
        ob.setGrundkosten(0);
        ((TAKampfanzugKammer) ob.getKammer()).setColdstar(true);
        ob.setButtonText("Rüstkammer");
        add(ob);
        ob.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

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
    }
}