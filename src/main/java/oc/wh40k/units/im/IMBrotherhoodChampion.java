package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMBrotherhoodChampion extends Eintrag {


    public IMBrotherhoodChampion() {
        name = "Brotherhood Champion";
        grundkosten = getPts("Brotherhood Champion") + getPts("Storm bolter (SM)") + getPts("Frag grenades (SM)") + getPts("Frag grenades (SM)") + getPts("Krak grenades (SM)") + getPts("Psyk-out grenades (SM)");

        add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
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
        power = 6;
    }
}
