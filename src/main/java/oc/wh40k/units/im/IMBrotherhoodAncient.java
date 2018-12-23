package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMBrotherhoodAncient extends Eintrag {

    private final OptionsUpgradeGruppe o1;
    private final RuestkammerStarter psychicPowers;

    public IMBrotherhoodAncient() {
        name = "Brotherhood Ancient";
        grundkosten = getPts("Brotherhood Ancient") + getPts("Frag grenades (SM)") + getPts("Krak grenades (SM)") + getPts("Psyk-out grenades (SM)");

        add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nemesis falchion", getPts("Nemesis falchion")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, SANCTIC), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 7;
        if (!o1.isSelected()) o1.setSelected(0, true);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
