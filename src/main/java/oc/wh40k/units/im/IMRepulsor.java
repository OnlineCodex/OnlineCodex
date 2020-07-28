package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMRepulsor extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3, o4, o5, o6, o7;

    public IMRepulsor() {
        name = "Repulsor";
        grundkosten = getPts("Repulsor");
        power = 16;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin Heavy Bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy onslaught gatling cannon", getPts("Heavy onslaught gatling cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Las-talon", getPts("Las-talon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ironhail heavy stubber", getPts("Ironhail heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Onslaught gatling cannon", getPts("Onslaught gatling cannon")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two storm bolters", getPts("Storm bolter (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Two fragstorm grenade launcher", getPts("Fragstorm grenade launcher") * 2));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Icarus ironhail heavy stubber", getPts("Icarus ironhail heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Icarus rocket pod", getPts("Icarus rocket pod")));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Fragstorm grenade launcher", getPts("Fragstorm grenade launcher")));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Auto launchers", getPts("Auto launchers")));
        ogE.addElement(new OptionsGruppeEintrag("Two fragstorm grenade launchers", getPts("Fragstorm grenade launcher") * 2));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Two krakstorm grenade launchers", getPts("Krakstorm grenade launcher") * 2));
        add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
        o7.alwaysSelected();
    }
}
