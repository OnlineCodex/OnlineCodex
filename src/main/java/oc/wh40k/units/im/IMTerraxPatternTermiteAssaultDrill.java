//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class IMTerraxPatternTermiteAssaultDrill extends Eintrag {

    OptionsUpgradeGruppe waffe1;

    public IMTerraxPatternTermiteAssaultDrill() {

        name = "Terrax-Pattern Termite Assault Drill";

        grundkosten = getPts("Terrax-Pattern Termite Assault Drill") + getPts("Melta cutter") + getPts("Termite drill");

        ogE.addElement(new OptionsGruppeEintrag("2 Storm bolter", getPts("Storm bolter")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamer", getPts("Heavy flamer")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Twin volkite charger", getPts("Twin volkite charger")*2));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);
        
        power = 8;



        seperator();



        complete();

    }



    @Override

    public void refreshen() {
    	waffe1.alwaysSelected();
    }

}

