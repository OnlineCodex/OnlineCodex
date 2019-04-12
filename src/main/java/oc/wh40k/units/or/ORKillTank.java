package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORKillTank extends Eintrag {

	private final OptionsUpgradeGruppe tech, o1;
	public ORKillTank() {
        grundkosten = getPts("Kill Tank");
        power = 15;
        name = "Kill Tank";
        add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin big shoota", getPts("Twin big shoota")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bursta kannon", getPts("Bursta kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Giga shoota", getPts("Giga shoota")));
        add(tech = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Twin big shoota", getPts("Twin big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Rack of rokkits", getPts("Rack of rokkits")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
        tech.alwaysSelected();
        o1.alwaysSelected();
    }

}
