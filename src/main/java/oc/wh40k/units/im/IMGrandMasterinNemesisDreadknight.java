package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMGrandMasterinNemesisDreadknight extends Eintrag {

    private final OptionsUpgradeGruppe o1;
    private final OptionsUpgradeGruppe o2;

    public IMGrandMasterinNemesisDreadknight() {
        name = "Grand Master in Nemesis Dreadknight";
        grundkosten = getPts("Grand Master in Nemesis Dreadknight");

        add(ico = new oc.Picture("oc/wh40k/images/GKNemesisRitter.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadfist", getPts("Dreadfist (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis Daemon greathammer", getPts("Nemesis Daemon greathammer")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis greatsword", getPts("Nemesis greatsword")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy incinerator", getPts("Heavy incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Gatling psilencer", getPts("Gatling psilencer")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy psycannon", getPts("Heavy psycannon")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dreadknight teleporter", getPts("Dreadknight teleporter")));

        seperator();

        addPsychicPowers(1, SANCTIC);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        power = 14;

        if (o1.isSelected("Dreadfist") && o2.isSelected("Dreadfist")) {
            o1.setPreis("Dreadfist", 0);
            o2.setPreis("Dreadfist", getPts("Dreadfist (pair)"));
        } else {
            o1.setPreis("Dreadfist", getPts("Dreadfist (single)"));
            o2.setPreis("Dreadfist", getPts("Dreadfist (single)"));
        }
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}