package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYMaleceptor extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    RuestkammerStarter psychicPowers;

    public TYMaleceptor() {
        name = "Maleceptor";
        grundkosten = getPts("Maleceptor") + getPts("Massive Scything Talons (Maleceptor)");
        power = 9;

        add(ico = new oc.Picture("oc/wh40k/images/TYMorgon.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
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
