package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CHARIOT;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMONETTE;
import static oc.KeyWord.HERALD_OF_SLAANESH;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHeraldofSlaaneshonExaltedSeekerChariot extends Eintrag {

	private final OptionsUpgradeGruppe waffe1;

    public CHHeraldofSlaaneshonExaltedSeekerChariot() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, CHARIOT, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Herald of Slaanesh on Exalted Seeker Chariot";
        grundkosten = getPts("Herald of Slaanesh on Exalted Seeker Chariot");
        power = 7;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        ogE.addElement(new OptionsGruppeEintrag("Piercing claws", getPts("Piercing claws")));
        ogE.addElement(new OptionsGruppeEintrag("Lashes of torment", getPts("Lashes of torment")));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        seperator();

        addWarlordTraits("", SLAANESH);

        complete();
    }
}
