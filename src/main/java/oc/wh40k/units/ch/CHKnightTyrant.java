package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHKnightTyrant extends Eintrag {

	private final OptionsUpgradeGruppe shieldbreaker, decimator, melta, siegebreaker, siegebreaker2;

    public CHKnightTyrant() {

        kategorie = 1;

        name = "Knight Tyrant";
        grundkosten = getPts("Knight Tyrant");

        ogE.addElement(new OptionsGruppeEintrag("Decimator & Lance", "Plasma decimator and volcano lance", getPts("Plasma decimator") + getPts("Volcano lance")));
        ogE.addElement(new OptionsGruppeEintrag("Cannon & Harpoon", "Conflagration cannon and thundercoil harpoon", getPts("Conflagration cannon") + getPts("Thundercoil harpoon")));
        add(decimator = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        decimator.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
        add(shieldbreaker = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two twin meltaguns", getPts("Twin meltagun") * 2));
        add(melta = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        melta.setSelected(0, true);
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Two shieldbreaker missiles", getPts("Shieldbreaker missile") * 2));
        add(siegebreaker = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        siegebreaker.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin siegebreaker cannon", getPts("Twin siegebreaker cannon")));
        add(siegebreaker2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        siegebreaker2.setSelected(0, true);

        power = 30;

        complete();
    }


    @Override
    public void refreshen() {
        shieldbreaker.alwaysSelected();
        decimator.alwaysSelected();
        melta.alwaysSelected();
        siegebreaker.alwaysSelected();
        siegebreaker2.alwaysSelected();
    }
}
