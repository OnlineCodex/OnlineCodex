package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianGK extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter psychicPowers;

    public IMLibrarianGK() {
        name = "Librarian";
        grundkosten = getPts("Librarian GK");
        power = 9;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Librarian GK");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanctic();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
