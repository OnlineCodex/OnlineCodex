package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.ChaosGod.NURGLE;
import static oc.wh40k.units.PsychicPowers.ChaosGod.SLAANESH;
import static oc.wh40k.units.PsychicPowers.ChaosGod.TZEENTCH;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.TERMINATOR;

public class CHSorcererinTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffen;
    private final OptionsUpgradeGruppe mark;

    public CHSorcererinTerminatorArmour() {

        name = "Sorcerer in Terminator Armour";
        grundkosten = getPts("Sorcerer in Terminator Armour");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt,
                new CHWaffenkammer(name, "Combi-bolter", "Force sword", true, true, true, false, CHAMPION, TERMINATOR, SORCERER));
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

        addPsychicPowers(2, DARK_HERETICUS);

        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        PsychicPowers pp = (PsychicPowers) psychicPowers.getKammer();
        pp.setGod(NURGLE, mark.isSelected("Mark of Nurgle"));
        pp.setGod(TZEENTCH, mark.isSelected("Mark of Tzeentch"));
        pp.setGod(SLAANESH, mark.isSelected("Mark of Slaanesh"));

        psychicPowers.getPanel().setLocation(
                (int) psychicPowers.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
