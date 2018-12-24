package oc.wh40k.units.im;

import oc.*;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.TEMPESTAS_DISCIPLINE;

public class IMRunePriest extends Eintrag {

    private final OptionsEinzelUpgrade oe1;
    private final RuestkammerStarter waffenUndArtefakte;

    public IMRunePriest() {
        name = "Rune Priest";
        grundkosten = getPts("Rune Priest");

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Rune Priest with Jump Pack") - getPts("Rune Priest")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psychic hood", getPts("psychic hood")));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runic armour", getPts("runic armour")));

        seperator();
        
        addPsychicPowers(2, TEMPESTAS_DISCIPLINE);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, new IMSpaceWolvesRuestkammer("Rune Priest"));
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        waffenUndArtefakte.setAbwaehlbar(false);
        add(waffenUndArtefakte);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
        if (oe1.isSelected()) {
            power += 1;
        }
        
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
