package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHHellforgedLeviathanDreadnought extends Eintrag {

	private final OptionsUpgradeGruppe oe1, oe4;
	private final OptionsZaehlerGruppe oe2;
	private final OptionsUpgradeGruppe oe3;
	private final OptionsUpgradeGruppe mark;

    public CHHellforgedLeviathanDreadnought() {
        name = "Hellforged Leviathan Dreadnought";
        grundkosten = getPts("Hellforged Leviathan Dreadnought");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellforged siege claw", getPts("Hellforged siege claw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Hellforged siege drill", getPts("Hellforged siege drill (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon array", getPts("Butcher cannon array")));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner ribaudkin", getPts("Soulburner ribaudkin")));
        ogE.addElement(new OptionsGruppeEintrag("Grav-flux bombard", getPts("Grav-flux bombard")));
        add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellforged siege claw", getPts("Hellforged siege claw (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Hellforged siege drill", getPts("Hellforged siege drill (single)")));
        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon array", getPts("Butcher cannon array")));
        ogE.addElement(new OptionsGruppeEintrag("Soulburner ribaudkin", getPts("Soulburner ribaudkin")));
        ogE.addElement(new OptionsGruppeEintrag("Grav-flux bombard", getPts("Grav-flux bombard")));
        add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        add(oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        oe2.setAnzahl(0, 2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Hellflamer", getPts("Hellflamer") * 2));
        add(oe4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {

        oe1.alwaysSelected();
        oe3.alwaysSelected();

        oe2.setMaxAnzahl((oe3.isSelected("Hellforged siege drill") || (oe3.isSelected("Hellforged siege claw")) ? 1 : 0) + (oe1.isSelected("Hellforged siege drill") || (oe1.isSelected("Hellforged siege claw")) ? 1 : 0));
        oe2.setAnzahl(0, oe2.getMaxAnzahl());
        oe4.alwaysSelected();

        
        
        if (oe1.isSelected("Hellforged siege claw") && oe3.isSelected("Hellforged siege claw")) {
            oe1.setPreis("Hellforged siege claw", getPts("Hellforged siege claw (pair)"));
            oe3.setPreis("Hellforged siege claw", 0);
        } else {
            oe1.setPreis("Hellforged siege claw", getPts("Hellforged siege claw (single)"));
            oe3.setPreis("Hellforged siege claw", getPts("Hellforged siege claw (single)"));
        }

        if (oe1.isSelected("Hellforged siege drill") && oe3.isSelected("Hellforged siege drill")) {
            oe1.setPreis("Hellforged siege drill", getPts("Hellforged siege drill (pair)"));
            oe3.setPreis("Hellforged siege drill", 0);
        } else {
            oe1.setPreis("Hellforged siege drill", getPts("Hellforged siege drill (single)"));
            oe3.setPreis("Hellforged siege drill", getPts("Hellforged siege drill (single)"));
        }

        power = 8;
    }

}
