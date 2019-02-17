package oc.wh40k.units.im;

import oc.*;

public class IMRoughRiders extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;
	private final OptionsUpgradeGruppe o5;

	private boolean kamirSelected = false;

    public IMRoughRiders() {
        checkBuildaVater();
        name = "Rough Riders";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Rough Riders", 5, 10, getPts("RoughRiders") + getPts("Hunting lance"));
        squad.setGrundkosten(getPts("Hunting lance") * -2);
        add(squad);

        seperator();

        ogE = IMAstraMilitarumSpecialWeapons.createRK("Hunting lance", "Hunting lance", buildaVater);
        ogE.remove(1); //Sniper r. entf.
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        o1.setAnzahl(0, 2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rough Rider Sergeant", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o5.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power lance (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        o3.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o2.alwaysSelected();
        o5.alwaysSelected();
        o3.alwaysSelected();
        o1.setLegal(o1.getAnzahl() == 2);
    }


}
