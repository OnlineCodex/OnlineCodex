//IA Adeptus Astartes

package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class IMRelicContemptorDreadnought extends Eintrag {



	private final OptionsZaehlerGruppe o1;



    public IMRelicContemptorDreadnought() {

        name = "Relic Contemptor Dreadnought";

        grundkosten = getPts("Relic Contemptor Dreadnought");

        power = 13;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("D. CW & storm bolter", "Dreadnought combat weapon & storm bolter", getPts("Dreadnought combat weapon (single)") + getPts("Storm bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("D. CW & heavy flamer", "Dreadnought combat weapon & heavy flamer", getPts("Dreadnought combat weapon (single)") + getPts("Heavy flamer")));

        ogE.addElement(new OptionsGruppeEintrag("D. CW & plasma blastgun", "Dreadnought combat weapon & plasma blastgun", getPts("Dreadnought combat weapon (single)") + getPts("Plasma blastgun")));

        ogE.addElement(new OptionsGruppeEintrag("D. CW & graviton blaster", "Dreadnought combat weapon & graviton blaster", getPts("Dreadnought combat weapon (single)") + getPts("Graviton blaster")));

        ogE.addElement(new OptionsGruppeEintrag("D. CF & storm bolter", "Dreadnought chainfist & storm bolter", getPts("Dreadnought chainfist (single)") + getPts("Storm bolter (IA)")));

        ogE.addElement(new OptionsGruppeEintrag("D. CF & heavy flamer", "Dreadnought chainfist & storm bolter", getPts("Dreadnought chainfist (single)") + getPts("Heavy flamer")));

        ogE.addElement(new OptionsGruppeEintrag("D. CF & plasma blastgun", "Dreadnought chainfist & storm bolter", getPts("Dreadnought chainfist (single)") + getPts("Plasma blastgun")));

        ogE.addElement(new OptionsGruppeEintrag("D. CF & graviton blaster", "Dreadnought chainfist & graviton blaster", getPts("Dreadnought chainfist (single)") + getPts("Graviton blaster")));

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));

        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy plasma cannon", getPts("Heavy plasma cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Kheres assault cannon", getPts("Kheres assault cannon")));

        ogE.addElement(new OptionsGruppeEintrag("C-Beam cannon", getPts("C-Beam cannon")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {



        final int dcw = (o1.getAnzahl("Dreadnought combat weapon & storm bolter") +

                o1.getAnzahl("Dreadnought combat weapon & heavy flamer") +

                o1.getAnzahl("Dreadnought combat weapon & plasma blastgun") +

                o1.getAnzahl("Dreadnought combat weapon & graviton blaster"));



        if (dcw == 2) {

            o1.setPreis("Dreadnought combat weapon & storm bolter", getPts("Dreadnought combat weapon (pair)") / 2 + getPts("Storm bolter (IA)"));

            o1.setPreis("Dreadnought combat weapon & heavy flamer", getPts("Dreadnought combat weapon (pair)") / 2 + getPts("Heavy flamer"));

            o1.setPreis("Dreadnought combat weapon & plasma blastgun", getPts("Dreadnought combat weapon (pair)") / 2 + getPts("Plasma blastgun"));

            o1.setPreis("Dreadnought combat weapon & graviton blaster", getPts("Dreadnought combat weapon (pair)") / 2 + getPts("Graviton blaster"));

        } else {

            o1.setPreis("Dreadnought combat weapon & storm bolter", getPts("Dreadnought combat weapon (single)") + getPts("Storm bolter (IA)"));

            o1.setPreis("Dreadnought combat weapon & heavy flamer", getPts("Dreadnought combat weapon (single)") + getPts("Heavy flamer"));

            o1.setPreis("Dreadnought combat weapon & plasma blastgun", getPts("Dreadnought combat weapon (single)") + getPts("Plasma blastgun"));

            o1.setPreis("Dreadnought combat weapon & graviton blaster", getPts("Dreadnought combat weapon (single)") + getPts("Graviton blaster"));

        }



        final int cf = (o1.getAnzahl("Dreadnought combat weapon & storm bolter") +

                o1.getAnzahl("Dreadnought combat weapon & heavy flamer") +

                o1.getAnzahl("Dreadnought combat weapon & plasma blastgun") +

                o1.getAnzahl("Dreadnought combat weapon & graviton blaster"));



        if (cf == 2) {

            o1.setPreis("Dreadnought chainfist & storm bolter", getPts("Dreadnought chainfist (pair)") / 2 + getPts("Storm bolter (IA)"));

            o1.setPreis("Dreadnought chainfist & heavy flamer", getPts("Dreadnought chainfist (pair)") / 2 + getPts("Heavy flamer"));

            o1.setPreis("Dreadnought chainfist & plasma blastgun", getPts("Dreadnought chainfist (pair)") / 2 + getPts("Plasma blastgun"));

            o1.setPreis("Dreadnought chainfist & graviton blaster", getPts("Dreadnought chainfist (pair)") / 2 + getPts("Graviton blaster"));

        } else {

            o1.setPreis("Dreadnought chainfist & storm bolter", getPts("Dreadnought chainfist (single)") + getPts("Storm bolter (IA)"));

            o1.setPreis("Dreadnought chainfist & heavy flamer", getPts("Dreadnought chainfist (single)") + getPts("Heavy flamer"));

            o1.setPreis("Dreadnought chainfist & plasma blastgun", getPts("Dreadnought chainfist (single)") + getPts("Plasma blastgun"));

            o1.setPreis("Dreadnought chainfist & graviton blaster", getPts("Dreadnought chainfist (single)") + getPts("Graviton blaster"));

        }

    }

}

