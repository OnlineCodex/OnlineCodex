package oc.wh40k.units.im;

import static oc.KeyWord.ASTRA_MILITARUM;
import static oc.KeyWord.ASTROPATH;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMAstropath extends Eintrag {
	private final OptionsUpgradeGruppe o1;
    private final RuestkammerStarter psychicPowers;

    public IMAstropath() {
    	super(IMPERIUM, ASTRA_MILITARUM, INFANTRY, CHARACTER, PSYKER, ASTROPATH);

        name = "Astropath";
        grundkosten = getPts("Astropath");
        power = 1;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Telepathica stave", getPts("Telepathica stave")));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enablePsykana();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override

    public void refreshen() {
        o1.alwaysSelected();
    }

}

