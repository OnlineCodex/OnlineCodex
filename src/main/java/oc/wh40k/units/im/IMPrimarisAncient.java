package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPrimarisAncient extends Eintrag {
    RuestkammerStarter waffenUndReliquien;
    boolean spacewolves = false;
    
    public IMPrimarisAncient() {
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
        name = "Primaris Ancient";
        grundkosten = getPts("Primaris Ancient") + getPts("Bolt pistol (SM)") + getPts("Bolt rifle") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        
        if(spacewolves) {
        	power = 5;
        } else {
        	power = 4;
        }
        
        seperator();

        if(spacewolves) {
	        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
	        ((IMSpaceWolvesRuestkammer) waffenUndReliquien.getKammer()).setType("Primaris Ancient");
	        waffenUndReliquien.initKammer();
	        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen"));
	        add(waffenUndReliquien);
	        waffenUndReliquien.setAbwaehlbar(false);

	        seperator();
        }
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
    	if(spacewolves) {
	        warlordTraits.getPanel().setLocation(
	                (int) warlordTraits.getPanel().getLocation().getX(),
	                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
	        );
    	}
    }
}
