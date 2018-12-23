package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.TEMPESTAS_DISCIPLINE;

public class IMRunePriestinTerminatorArmour extends Eintrag {

    private final RuestkammerStarter waffenUndArtefakte;
    private final RuestkammerStarter psychicPowers;

    public IMRunePriestinTerminatorArmour() {
        name = "Rune Priest on Bike";
        grundkosten = getPts("Rune Priest on Bike");
        power = 8;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psychic hood", getPts("psychic hood")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runic Terminator armour", getPts("runic Terminator armour")));

        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, TEMPESTAS_DISCIPLINE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Rune Priest in Terminator Armour"), "");
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndArtefakte.setAbwaehlbar(false);
        add(waffenUndArtefakte);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        waffenUndArtefakte.getPanel().setLocation(
                (int) waffenUndArtefakte.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );
    }

}
