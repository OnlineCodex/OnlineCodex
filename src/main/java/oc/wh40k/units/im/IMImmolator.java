package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMImmolator extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMImmolator() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, VEHICLE, TRANSPORT, IMMOLATOR);
        name = "Immolator";
        grundkosten = getPts("Immolator");
        power = 5;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Immolation flamer", getPts("Immolation flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta (AMI)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AMI)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AMI)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
