package oc.wh40k.units.im;

import oc.*;

public class IMIronPriestonThunderwolf extends Eintrag {

	private final OptionsUpgradeGruppe o1, o5;

    public IMIronPriestonThunderwolf() {
        name = "Iron Priest on Thunderwolf";
        grundkosten = getPts("Iron Priest on Thunderwolf") + getPts("Servo-arm");
        power = 7;

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
