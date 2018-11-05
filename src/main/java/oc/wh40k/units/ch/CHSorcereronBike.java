package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHSorcereronBike extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHSorcereronBike() {

        name = "Sorcerer on Bike";
        grundkosten = getPts("Sorcerer on Bike");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        waffen.setUeberschriftTrotzNullKostenAusgeben(true);
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
