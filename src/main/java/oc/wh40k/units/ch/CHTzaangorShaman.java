package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;

public class CHTzaangorShaman extends Eintrag {

    private final OptionsUpgradeGruppe stave;
    private final RuestkammerStarter psychicPowers;

    public CHTzaangorShaman() {

        name = "Tzaangor Shaman";
        grundkosten = getPts("Tzaangor Shaman");
        power = 5;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, CHANGE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        stave.alwaysSelected();
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
