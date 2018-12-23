package oc.wh40k.units.ch;

import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHChaosLord extends Eintrag {

    private final RuestkammerStarter waffen;

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
