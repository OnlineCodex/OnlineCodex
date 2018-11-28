package oc.wh40k.units.im;

import oc.*;

public class IMWolfLord extends Eintrag {

    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    
    public IMWolfLord() {
        name = "Wolf Lord";
        grundkosten = getPts("Wolf Lord") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Lord with Jump Pack") - getPts("Wolf Lord")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndReliquien.getKammer()).setType("Wolf Lord");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (jump.isSelected() ? 1 : 0);
    }
}
