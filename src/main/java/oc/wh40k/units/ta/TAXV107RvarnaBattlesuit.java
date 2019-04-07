package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

//[IA Experimental]

public class TAXV107RvarnaBattlesuit extends Eintrag {

	public TAXV107RvarnaBattlesuit() {
        name = "XV107 R'varna Battlesuit";
        grundkosten = 260;

        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schild-Raketendrohnen", 25));
        add(new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Positionssender", 5));
        ogE.addElement(new OptionsGruppeEintrag("Stimulanzinjektor", 35));
        add(new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 2));
        //Positional Relay, Stimulant injectors

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    }

}
