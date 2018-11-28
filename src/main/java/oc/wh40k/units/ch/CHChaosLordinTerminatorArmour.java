package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHChaosLordinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    public CHChaosLordinTerminatorArmour() {

        name = "Chaos Lord in Terminator Armour";
        grundkosten = getPts("Chaos Lord in Terminator Armour");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Combi-bolter");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Power sword");
        ((CHWaffenkammer) waffen.getKammer()).setChampion(true);
        ((CHWaffenkammer) waffen.getKammer()).setTerminatorArmour(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {
    }
}
