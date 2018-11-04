package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMTechmarineGK extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter psychicPowers;

    public IMTechmarineGK() {
        name = "Techmarine";
        grundkosten = getPts("Techmarine (GK)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();


        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Techmarine");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanctic();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
