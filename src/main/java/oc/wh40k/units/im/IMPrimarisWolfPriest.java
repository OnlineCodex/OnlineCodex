package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.Warlordtraits;

public class IMPrimarisWolfPriest extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter warlord;

    public IMPrimarisWolfPriest() {
        name = "Primaris Wolf Priest";
        grundkosten = getPts("Primaris Wolf Priest") + getPts("Crozius arcanum") + getPts("Absolvor bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Wolf Priest");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

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
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }
}
