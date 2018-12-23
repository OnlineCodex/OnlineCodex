package oc.wh40k.units.im;

import oc.*;

public class IMWolfLord extends Eintrag {

    private final OptionsEinzelUpgrade jump;
    private final RuestkammerStarter waffenUndReliquien;
    
    public IMWolfLord() {
        name = "Wolf Lord";
        grundkosten = getPts("Wolf Lord") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Lord with Jump Pack") - getPts("Wolf Lord")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Wolf Lord"));
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (jump.isSelected() ? 1 : 0);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}
