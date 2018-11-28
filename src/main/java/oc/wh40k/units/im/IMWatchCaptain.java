package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMWatchCaptain extends Eintrag {

    boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
    OptionsEinzelUpgrade meister, sturm, termi;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter spezialAusruestung;
    OptionsEinzelUpgrade pistol;

    public IMWatchCaptain() {
        name = "Watch Captain";
        grundkosten = getPts("Watch Captain");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Watch Captain with Jump Pack") - getPts("Watch Captain")));

        seperator();

        add(pistol = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolt pistol", getPts("Bolt pistol (DW)")));

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, DeathWatchKammer.class, "");
        ((DeathWatchKammer) waffenUndReliquien.getKammer()).setType("Watch Captain");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        complete();
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        pistol.setSelected(true);
    }

}
