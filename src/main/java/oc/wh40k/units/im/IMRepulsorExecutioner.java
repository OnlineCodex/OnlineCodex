package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMRepulsorExecutioner extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2, o3, o6, o7, o8, o9;

    public IMRepulsorExecutioner() {
        name = "Repulsor Executioner";
        grundkosten = getPts("Repulsor Executioner");
        power = 16;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Auto launchers", getPts("Auto launchers")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Fragstorm grenade launcher", getPts("Fragstorm grenade launcher")*2));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy onslaught gatling cannon", getPts("Heavy onslaught gatling cannon")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Icarus rocket pod", getPts("Icarus rocket pod")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ironhail heavy stubber", getPts("Ironhail heavy stubber")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Storm bolter", getPts("Storm bolter (SM)")*2));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Twin Icarus ironhail heavy stubber", getPts("Twin Icarus ironhail heavy stubber")));
        add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Macro plasma incinerator", getPts("Macro plasma incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy laser destroyer", getPts("Heavy laser destroyer")));
        add(o9 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o6.alwaysSelected();
        o7.alwaysSelected();
        o8.alwaysSelected();
        o9.alwaysSelected();
    }
}
