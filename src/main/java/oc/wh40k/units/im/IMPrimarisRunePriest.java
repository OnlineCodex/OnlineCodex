package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMPrimarisRunePriest extends Eintrag {
	
    RuestkammerStarter waffenUndArtefakte;
	RuestkammerStarter psychicPowers;
    RuestkammerStarter warlord;

    public IMPrimarisRunePriest() {
        name = "Primaris Rune Priest";
        grundkosten = getPts("Primaris Rune Priest") + getPts("Runic sword") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTempestasDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Primaris Rune Priest");
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
        waffenUndArtefakte.getPanel().setLocation(
                (int) waffenUndArtefakte.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
        
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }
}
