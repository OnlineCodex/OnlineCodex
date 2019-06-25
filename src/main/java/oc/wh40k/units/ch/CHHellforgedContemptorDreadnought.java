package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHHellforgedContemptorDreadnought extends Eintrag {

	private final OptionsUpgradeGruppe oe1;
	private final OptionsZaehlerGruppe oe2;
	private final OptionsUpgradeGruppe oe3;
	public CHHellforgedContemptorDreadnought() {
        name = "Hellforged Contemptor Dreadnought";
        grundkosten = getPts("Hellforged Contemptor Dreadnought");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellforged deathclaw", getPts("Hellforged deathclaw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Hellforged chainclaw", getPts("Hellforged chainclaw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma cannon", getPts("Ectoplasma cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Kheres assault cannon", getPts("Kheres assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
        add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellforged deathclaw", getPts("Hellforged deathclaw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Hellforged chainclaw", getPts("Hellforged chainclaw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma cannon", getPts("Ectoplasma cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Kheres assault cannon", getPts("Kheres assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
        add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Hellflamer", getPts("Hellflamer")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma blaster", getPts("Ectoplasma blaster")));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner", getPts("Soulburner")));
        add(oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        oe2.setAnzahl(0, 2);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", getPts("Havoc launcher")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {

        oe1.alwaysSelected();
        oe3.alwaysSelected();

        oe2.setMaxAnzahl((oe3.isSelected("Hellforged chainclaw") || (oe3.isSelected("Hellforged deathclaw")) ? 1 : 0) + (oe1.isSelected("Hellforged chainclaw") || (oe1.isSelected("Hellforged deathclaw")) ? 1 : 0));
		oe2.setLegal(oe2.getAnzahl() == oe2.getMaxAnzahl());

        if (oe1.isSelected("Hellforged chainclaw") && oe3.isSelected("Hellforged chainclaw")) {
            oe1.setPreis("Hellforged chainclaw", getPts("Hellforged chainclaw (pair)") / 2);
            oe3.setPreis("Hellforged chainclaw", getPts("Hellforged chainclaw (pair)") / 2);
        } else {
            oe1.setPreis("Hellforged chainclaw", getPts("Hellforged chainclaw (single)"));
            oe3.setPreis("Hellforged chainclaw", getPts("Hellforged chainclaw (single)"));
        }
        
        if (oe1.isSelected("Hellforged deathclaw") && oe3.isSelected("Hellforged deathclaw")) {
            oe1.setPreis("Hellforged deathclaw", getPts("Hellforged deathclaw (pair)") / 2);
            oe3.setPreis("Hellforged deathclaw", getPts("Hellforged deathclaw (pair)") / 2);
        } else {
            oe1.setPreis("Hellforged deathclaw", getPts("Hellforged deathclaw (single)"));
            oe3.setPreis("Hellforged deathclaw", getPts("Hellforged deathclaw (single)"));
        }

        power = 8;
    }

}
