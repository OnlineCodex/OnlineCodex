package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class IMPallasGravAttack extends Eintrag {

	private final OptionsUpgradeGruppe o2;


    public IMPallasGravAttack() {

        name = "Pallas Grav-Attack";

        grundkosten = getPts("Pallas Grav-Attack");

        power = 5;


        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Twin Arachnus blaze cannon", getPts("Twin Arachnus blaze cannon")));

        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));



        complete();

    }



    @Override

    public void refreshen() {

        o2.alwaysSelected();

    }

}

