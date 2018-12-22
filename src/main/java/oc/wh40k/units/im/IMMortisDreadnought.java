//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;



public class IMMortisDreadnought extends Eintrag {



    OptionsZaehlerGruppe o1;



    public IMMortisDreadnought() {

        name = "Mortis Dreadnought";

        grundkosten = getPts("Mortis Dreadnought");

        power = 8;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("2 twin heavy bolters", 2 * getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("2 twin autocannon", 2 * getPts("Twin autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 twin lascannon", 2 * getPts("Twin lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 missile launcher", 2 * getPts("Missile launcher")));

        ogE.addElement(new OptionsGruppeEintrag("2 assault cannon", 2 * getPts("Troops cannon")));

        ogE.addElement(new OptionsGruppeEintrag("2 multi-melta", 2 * getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("2 heavy plasma cannon", 2 * getPts("Heavy plasma cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}

