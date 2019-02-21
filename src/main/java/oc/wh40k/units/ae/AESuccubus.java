package oc.wh40k.units.ae;

import static oc.KeyWord.WYCH_CULT;
import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class AESuccubus extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;

    public AESuccubus() {
        name = "Succubus";
        grundkosten = getPts("Succubus");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("Impaler")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Archite glaive", getPts("Archite glaive")));
        ogE.addElement(new OptionsGruppeEintrag("Hydra gauntlets", getPts("Hydra gauntlets")));
        ogE.addElement(new OptionsGruppeEintrag("Razorflails", getPts("Razorflails")));
        ogE.addElement(new OptionsGruppeEintrag("Shardnet and impaler", getPts("Shardnet and impaler")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        addWarlordTraits("", WYCH_CULT);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
