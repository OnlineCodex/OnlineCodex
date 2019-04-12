package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.EXORCIST;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.ORDER;
import static oc.KeyWord.VEHICLE;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMExorcist extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMExorcist() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, VEHICLE, EXORCIST);
        name = "Exorcist";
        grundkosten = getPts("Exorcist");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Exorcist missile launcher", getPts("Exorcist missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

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
