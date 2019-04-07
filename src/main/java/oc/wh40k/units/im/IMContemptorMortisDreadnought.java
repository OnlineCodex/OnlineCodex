//IA Adeptus Astartes + FAQ 1.2

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMContemptorMortisDreadnought extends Eintrag {



	public IMContemptorMortisDreadnought() {

        name = "Contemptor Mortis Dreadnought";

        grundkosten = getPts("Contemptor Mortis Dreadnought");

        power = 9;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 twin heavy bolters", 2 * getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("2 twin autocannon", 2 * getPts("Twin autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 twin lascannon", 2 * getPts("Twin lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 missile launcher", 2 * getPts("Missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("2 assault cannon", 2 * getPts("Assault cannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 multi-melta", 2 * getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("2 heavy plasma cannon", 2 * getPts("Heavy plasma cannon")));

        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cyclone missile launcher", getPts("Cyclone missile launcher")));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

