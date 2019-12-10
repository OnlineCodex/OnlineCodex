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

	private final OptionsUpgradeGruppe o1, o2;

    public IMExorcist() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, VEHICLE, EXORCIST);
        name = "Exorcist";
        grundkosten = getPts("Exorcist");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Exorcist missile launcher", getPts("Exorcist missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Exorcist conflagration rockets", getPts("Exorcist conflagration rockets")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AMI)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AMI)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
