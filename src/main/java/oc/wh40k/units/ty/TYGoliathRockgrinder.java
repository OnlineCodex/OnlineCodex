package oc.wh40k.units.ty;



import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class TYGoliathRockgrinder extends Eintrag {



    private final OptionsUpgradeGruppe o1;

    public TYGoliathRockgrinder() {

        name = "Goliath Rockgrinder";

        grundkosten = getPts("Goliath Rockgrinder") + getPts("Heavy stubber");

        power = 6;



        ogE.addElement(new OptionsGruppeEintrag("Heavy mining laser", getPts("Heavy mining laser")));

        ogE.addElement(new OptionsGruppeEintrag("Clearance incinerator", getPts("Clearance incinerator")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy seismic cannon", getPts("Heavy seismic cannon")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cache of demolition charges", 1, getPts("Cache of demolition charges")));



        complete();

    }



    @Override

    public void refreshen() {
    	o1.alwaysSelected();
    }

}