package oc.wh40k.units.ty;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYSanctus extends Eintrag {

	OptionsUpgradeGruppe o1, o2;

    public TYSanctus() {

        name = "Sanctus";

        grundkosten = getPts("Sanctus");

        ogE.addElement(new OptionsGruppeEintrag("Soulsight familiar", getPts("Familiars")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Silencer sniper rifle", getPts("Silencer sniper rifle")));
        ogE.addElement(new OptionsGruppeEintrag("Sanctus bio-dagger", getPts("Sanctus bio-dagger")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        
        power = 3;

        complete();

    }
    
    @Override

    public void refreshen() {
    	o1.alwaysSelected();
    	o2.alwaysSelected();
    }

}

