package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisBattleLeader extends Eintrag {
	
    private final RuestkammerStarter waffenUndArtefakte;

    public IMPrimarisBattleLeader() {
        name = "Primaris Battle Leader";
        grundkosten = getPts("Primaris Battle Leader") + getPts("bolt pistol") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 4;

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Primaris Battle Leader"));
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndArtefakte.setAbwaehlbar(false);
        add(waffenUndArtefakte);

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }
}
