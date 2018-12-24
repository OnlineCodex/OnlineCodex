package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMTechmarineGK extends Eintrag {

    private final RuestkammerStarter waffenUndReliquien;

    public IMTechmarineGK() {
        name = "Techmarine";
        grundkosten = getPts("Techmarine (GK)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceMarinesRuestkammer(name, getKeywords()), "");
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        addPsychicPowers(1, SANCTIC);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).oe1.isSelected() ? 1 : 0);
        
    	psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
