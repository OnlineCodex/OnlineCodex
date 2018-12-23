package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.ChaosGod.NURGLE;
import static oc.wh40k.units.PsychicPowers.ChaosGod.SLAANESH;
import static oc.wh40k.units.PsychicPowers.ChaosGod.TZEENTCH;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHSorcerer extends Eintrag {

    private final RuestkammerStarter waffen;
    private final OptionsUpgradeGruppe mark;
    private final RuestkammerStarter psychicPowers;

    public CHSorcerer() {
        name = "Sorcerer";
        grundkosten = getPts("Sorcerer");
        power = 7;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Sorcerer with Jump Pack") - getPts("Sorcerer")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Bolt pistol", "Force sword", true, true, true, false, SORCERER), "");
        waffen.setButtonText("Waffenkammer");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DARK_HERETICUS), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        PsychicPowers kammer = (PsychicPowers) psychicPowers.getKammer();
        kammer.setGod(NURGLE, mark.isSelected("Mark of Nurgle"));
        kammer.setGod(TZEENTCH, mark.isSelected("Mark of Tzeentch"));
        kammer.setGod(SLAANESH, mark.isSelected("Mark of Slaanesh"));
        
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
