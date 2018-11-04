package oc.wh40k.units.ch;

import oc.*;

public class CHChaosLord extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHChaosLord() {

        name = "Chaos Lord";
        grundkosten = getPts("Chaos Lord");
        power = 5;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Chaos Lord with Jump Pack") - getPts("Chaos Lord")));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Chainsword");
        ((CHWaffenkammer) waffen.getKammer()).setChampion(true);
        waffen.initKammer(true, true, true, true);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
