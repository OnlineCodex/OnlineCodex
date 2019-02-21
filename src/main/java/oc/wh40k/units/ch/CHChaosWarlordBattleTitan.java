package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHChaosWarlordBattleTitan extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;
	private final OptionsZaehlerGruppe o3, o4;

    public CHChaosWarlordBattleTitan() {
        name = "Chaos Warlord Battle Titan";
        grundkosten = getPts("Chaos Warlord Battle Titan");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Ardex-defensor mauler bolter", getPts("Ardex-defensor mauler")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Ardex-defensor Twin lascannon", getPts("Reaper chainfist")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dual turbo-laser destructor", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Titan plasma blastgun", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Twin Titan Vulcan mega-bolter", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Apocalypse missile launcher", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Reaver laser blaster", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Reaver gatling blaster", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Incinerator missile bank", getPts("")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sunfurry plasma annihilator", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Mori quake cannon", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Saturnyne lascutter", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Arioch Titan power claw", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Warlord gatling blaster", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Belicosa volcano cannon", getPts("")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o3.setLegal(o3.getAnzahl() == 2);
        o4.setLegal(o4.getAnzahl() == 2);

        power = 200;
    }

}
