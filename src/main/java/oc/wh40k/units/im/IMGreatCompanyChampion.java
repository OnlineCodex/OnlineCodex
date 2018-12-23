package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMGreatCompanyChampion extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;

    public IMGreatCompanyChampion() {
        name = "Great Company Champion";
        grundkosten = getPts("Great Company Champion") + getPts("bolt pistol (SM)") +  getPts("master crafted power sword") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 3;
        
        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer(name));
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}
