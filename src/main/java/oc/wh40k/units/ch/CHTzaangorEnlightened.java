package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHTzaangorEnlightened extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsUpgradeGruppe weapons;
	private final RuestkammerStarter rkBoss;

    public CHTzaangorEnlightened() {

        category = 1;

        name = "Tzaangor Enlightened";
        grundkosten = 0;
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Tzaangor Enlightened", 3, 9, getPts("Tzaangor Enlightened")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Divining spears", getPts("Divining spear")));
        ogE.addElement(new OptionsGruppeEintrag("Chainswords/Autopistols", getPts("Chainsword") + getPts("Autopistol")));
        ogE.addElement(new OptionsGruppeEintrag("Fatecaster greatbows", getPts("Fatecaster greatbow")));
        add(weapons = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Aviarch");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Aviarch";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Aviarch"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        weapons.alwaysSelected();

        weapons.setPreis("Divining spears", getPts("Divining spear") * (squad.getModelle()));
        weapons.setPreis("Chainswords/Autopistols", (getPts("Chainsword") + getPts("Autopistol")) * (squad.getModelle()));
        weapons.setPreis("Fatecaster greatbows", getPts("Fatecaster greatbow") * (squad.getModelle()));

        power = 3;
    }
}
