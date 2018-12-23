package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMGreatCompanyAncient extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;

    public IMGreatCompanyAncient() {
        name = "Great Company Ancient";
        grundkosten = getPts("Great Company Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 4;
        
        seperator();

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
