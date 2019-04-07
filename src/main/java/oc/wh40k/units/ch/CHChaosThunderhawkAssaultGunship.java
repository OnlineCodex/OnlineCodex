package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class CHChaosThunderhawkAssaultGunship extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final OptionsZaehlerGruppe o2;
	private final OptionsUpgradeGruppe o3, o4;
	public CHChaosThunderhawkAssaultGunship() {
        name = "Chaos Thunderhawk Assault Gunship";
        grundkosten = getPts("Chaos Thunderhawk Assault Gunship");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Thunderhawk heavy cannon", getPts("Thunderhawk heavy cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Turbo-laser destruktor", getPts("Turbo-laser destruktor")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter") * 4));
        ogE.addElement(new OptionsGruppeEintrag("Reaper battery", getPts("Reaper battery")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        o2.setAnzahl(0, 4);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Lascannon", getPts("Lascannon") * 2));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellstrike battery", getPts("Hellstrike battery") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Balefire missiles", getPts("Balefire missiles")));
        ogE.addElement(new OptionsGruppeEintrag("Thunderhawk cluster bombs", getPts("Thunderhawk cluster bombs")));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
        o1.alwaysSelected();
        o3.alwaysSelected();
        o4.alwaysSelected();

        power = 42;
    }

}
