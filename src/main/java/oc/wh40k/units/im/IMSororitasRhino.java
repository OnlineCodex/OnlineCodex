package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMSororitasRhino extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMSororitasRhino() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER,VEHICLE, TRANSPORT, RHINO, SORORITAS_RHINO);
        name = "Sororitas Rhino";
        grundkosten = getPts("Sororitas Rhino");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
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
