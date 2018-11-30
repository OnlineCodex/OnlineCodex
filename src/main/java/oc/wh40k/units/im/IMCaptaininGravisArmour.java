package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCaptaininGravisArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMCaptaininGravisArmour() {
        name = "Captain in Gravis Armour";
        grundkosten = getPts("Captain in Gravis Armour") + getPts("Master-crafted power sword") + getPts("Boltstorm gauntlet");
        power = 7;
        
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
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}
