package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHChaosLordonBike extends Eintrag {

    private final RuestkammerStarter waffen;

    public CHChaosLordonBike() {

        name = "Chaos Lord on Bike";
        grundkosten = getPts("Chaos Lord on Bike");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Chainsword", true, true, true, true, CHAMPION));
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}
