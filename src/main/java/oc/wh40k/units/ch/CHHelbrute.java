package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHHelbrute extends Eintrag {

	private final OptionsUpgradeGruppe oe1;
	private final OptionsZaehlerGruppe oe2;
	private final OptionsUpgradeGruppe oe3;
	public CHHelbrute() {
        name = "Helbrute";
        grundkosten = getPts("Helbrute");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (other)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Helbrute plasma cannon", getPts("Helbrute plasma cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", getPts("Reaper autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (other)")));
        ogE.addElement(new OptionsGruppeEintrag("Helbrute fist", getPts("Helbrute fist")));
        ogE.addElement(new OptionsGruppeEintrag("Helbrute hammer", getPts("Helbrute hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Power scourge", getPts("Power scourge")));
        add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Helbrute fist", getPts("Helbrute fist")));
        ogE.addElement(new OptionsGruppeEintrag("Helbrute hammer", getPts("Helbrute hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Power scourge", getPts("Power scourge")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (other)")));
        add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (other)")));
        add(oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

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

        oe2.setMaxAnzahl((oe3.isSelected("Helbrute fist") ? 1 : 0) + (oe1.isSelected("Helbrute fist") ? 1 : 0));
        oe1.setAktiv("Missile launcher", !oe3.isSelected("Missile launcher"));
        oe3.setAktiv("Missile launcher", !oe1.isSelected("Missile launcher"));

        if (oe1.isSelected("Helbrute fist") && oe3.isSelected("Helbrute fist")) {
            oe1.setPreis("Helbrute fist", getPts("Helbrute fist pair") / 2);
            oe3.setPreis("Helbrute fist", getPts("Helbrute fist pair") / 2);
        } else {
            oe1.setPreis("Helbrute fist", getPts("Helbrute fist"));
            oe3.setPreis("Helbrute fist", getPts("Helbrute fist"));
        }

        power = 8;
    }

}
