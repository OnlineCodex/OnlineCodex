package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMAstraeusSuperHeavyTank extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6;

    public IMAstraeusSuperHeavyTank() {
        name = "Astraeus Super-Heavy Tank";
        grundkosten = getPts("Astraeus Super-heavy Tank");
        power = 36;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter (SM)", getPts("Storm bolter (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ironhail heavy stubber", getPts("Ironhail heavy stubber")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two las-rippers", getPts("Las-ripper") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Two plasma eradicators", getPts("Plasma eradicator") * 2));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Enhanced repulsor field", getPts("Enhanced repulsor field")));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin macro-accelerator cannon", getPts("Twin macro-accelerator cannon")));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ironhail heavy stubber", getPts("Ironhail heavy stubber")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o4.alwaysSelected();
        o5.alwaysSelected();
        o6.alwaysSelected();
    }
}
