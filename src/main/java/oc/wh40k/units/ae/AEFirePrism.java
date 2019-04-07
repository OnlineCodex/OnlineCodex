package oc.wh40k.units.ae;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class AEFirePrism extends Eintrag {



	private final OptionsUpgradeGruppe o1;



    public AEFirePrism() {

        name = "Fire Prism";

        grundkosten = getPts("Fire Prism") + getPts("Prism cannon");

        power = 9;



        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken catapult", getPts("Twin shuriken catapult")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crystal targeting matrix", getPts("Crystal targeting matrix")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit stones", getPts("Spirit stones")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", getPts("Star engines")));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored engines", getPts("Vectored engines")));



        complete();

    }



    @Override

    public void refreshen() {

        o1.alwaysSelected();

    }



}

