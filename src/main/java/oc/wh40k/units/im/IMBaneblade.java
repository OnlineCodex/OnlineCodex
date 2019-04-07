package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IMBaneblade extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsUpgradeGruppe o3;
	public IMBaneblade() {
        name = "Baneblade";
        grundkosten = getPts("Baneblade") + getPts("Autocannon") + getPts("Baneblade cannon") +
                getPts("Demolisher Cannon (AM)") + getPts("Twin heavy bolter (AM)") + getPts("Adamantium tracks");
        power = 30;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", getPts("Lascannon (AM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("4 Lascannons", getPts("Lascannon (AM)") * 4));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy Flamer (AM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o3.alwaysSelected();

        o1.setMaxAnzahl(o3.getSelectedIndex() * 2 + 2);
        o1.setLegal(o1.getAnzahl() == o3.getSelectedIndex() * 2 + 2);
    }

}
