package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMDeathwatchLibrarianinTerminatorArmour extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter psychicPowers;

    public IMDeathwatchLibrarianinTerminatorArmour() {
        name = "Librarian in Terminator Armour";
        grundkosten = getPts("Librarian in Terminator Armour");
        power = 8;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DeathWatchKammer", "");
        ((DeathWatchKammer) waffenUndReliquien.getKammer()).setType("Librarian in Terminator Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        if (!buildaVater.getFormationType().equals("Dark Angels") && !buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableLibrarius();
        if (buildaVater.getFormationType().equals("Blood Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        if (buildaVater.getFormationType().equals("Dark Angels"))
            ((PsychicPowers) psychicPowers.getKammer()).enableInterromancy();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {

        psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );
    }
}
