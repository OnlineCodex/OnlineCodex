package oc.wh40k.units.ae;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class AEFalcon extends Eintrag {



	private final OptionsUpgradeGruppe o1, o2;



    public AEFalcon() {

        name = "Falcon";

        grundkosten = getPts("Falcon") + getPts("Pulse laser");

        power = 11;



        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Aeldari missile launcher", getPts("Aeldari missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("Bright lance", getPts("Bright lance")));

        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));

        ogE.addElement(new OptionsGruppeEintrag("Starcannon", getPts("Starcannon")));

        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken catapult", getPts("Twin shuriken catapult")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));



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

        o2.alwaysSelected();

    }



}

