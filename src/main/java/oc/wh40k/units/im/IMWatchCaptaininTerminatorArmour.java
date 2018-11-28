package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMWatchCaptaininTerminatorArmour extends Eintrag {

    boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
    OptionsEinzelUpgrade meister, sturm, termi;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter spezialAusruestung;

    public IMWatchCaptaininTerminatorArmour() {
        name = "Watch Captain";
        grundkosten = getPts("Watch Captain in Terminator Armour");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, DeathWatchKammer.class, "");
        ((DeathWatchKammer) waffenUndReliquien.getKammer()).setType("Watch Captain in Terminator Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        complete();
    }
}
