package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMIronPriestonBike extends Eintrag {

	private final OptionsUpgradeGruppe o1, o5;

    public IMIronPriestonBike() {
        name = "Iron Priest on Bike";
        grundkosten = getPts("Iron Priest on Bike") + getPts("Servo-arm");
        power = 6;

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Boltgun"), getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bolt pistol"), getPts("Bolt pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helfrost pistol"), getPts("Helfrost pistol")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Thunder hammer"), getPts("Thunder hammer (Characters)")));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tempest hammer"), getPts("Tempest hammer")));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o5.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o5.alwaysSelected();
    }

}
