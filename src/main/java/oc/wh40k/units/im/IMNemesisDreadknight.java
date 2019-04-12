package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMNemesisDreadknight extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    RuestkammerStarter psychicPowers;

    public IMNemesisDreadknight() {
        name = "Nemesis Dreadknight";
        grundkosten = getPts("Nemesis Dreadknight");

        add(ico = new oc.Picture("oc/wh40k/images/GKNemesisRitter.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis Daemon greathammer", getPts("Nemesis Daemon greathammer")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis greatsword", getPts("Nemesis greatsword")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy incinerator", getPts("Heavy incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Gatling psilencer", getPts("Gatling psilencer")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy psycannon", getPts("Heavy psycannon")));
        add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dreadknight teleporter", getPts("Dreadknight teleporter")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanctic();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        if (o1.isSelected("Dreadfist") && o2.isSelected("Dreadfist")) {
            o1.setPreis("Dreadfist", 0);
            o2.setPreis("Dreadfist", getPts("Dreadfist (pair)"));
        } else {
            o1.setPreis("Dreadfist", getPts("Dreadfist (single)"));
            o2.setPreis("Dreadfist", getPts("Dreadfist (single)"));
        }

        power = 11;
    }

}
