package oc.wh40k.units.im;



import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;



public class IMRavenwingAttackBikeKammer extends RuestkammerVater {

	private OptionsUpgradeGruppe o1;

    public IMRavenwingAttackBikeKammer() {

        grundkosten = getPts("Ravenwing Attack Bike Squad") + getPts("Twin boltgun");

    }



    @Override

    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));

        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));



        sizeSetzen();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }

}