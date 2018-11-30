package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCaptaininCataphractiiArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMCaptaininCataphractiiArmour() {
        name = "Captain in Cataphractii Armour";
        grundkosten = getPts("Captain in Cataphractii Armour");
        power = 8;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Captain in Cataphractii Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
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
