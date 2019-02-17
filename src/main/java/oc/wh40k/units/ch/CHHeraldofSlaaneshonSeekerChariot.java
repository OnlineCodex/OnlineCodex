package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHeraldofSlaaneshonSeekerChariot extends Eintrag {

	private final OptionsUpgradeGruppe waffe1;

    public CHHeraldofSlaaneshonSeekerChariot() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, CHARIOT, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Herald of Slaanesh on Seeker Chariot";
        grundkosten = getPts("Herald of Slaanesh on Seeker Chariot");
        power = 6;

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
