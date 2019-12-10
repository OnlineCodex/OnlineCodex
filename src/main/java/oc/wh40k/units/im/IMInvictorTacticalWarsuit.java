package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMInvictorTacticalWarsuit extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3, o4, o5;

    public IMInvictorTacticalWarsuit() {
        name = "Invictor Tactical Warsuit";
        grundkosten = getPts("Invictor Tactical Warsuit");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Incendium cannon", getPts("Incendium cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin ironhail autocannon", getPts("Twin ironhail autocannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fragstorm grenade launcher", getPts("Fragstorm grenade launcher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Invictor fist", getPts("Invictor fist")));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 Ironhail heavy stubber", getPts("Ironhail heavy stubber")*2));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o4.alwaysSelected();
        o5.alwaysSelected();
    }
}
