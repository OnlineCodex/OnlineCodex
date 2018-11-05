package oc.wh40k.units.ae;



import oc.AnzahlPanel;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class AEWraithblades extends Eintrag {



    AnzahlPanel squad;

    OptionsUpgradeGruppe o1;



    public AEWraithblades() {

        name = "Wraithblades";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wraithblades", 5, 10, getPts("Wraithblades"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Ghostswords", getPts("Ghostsword")));

        ogE.addElement(new OptionsGruppeEintrag("Ghostaxes and forceshields", getPts("Ghostaxe") + getPts("Forceshield")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setSelected(0, true);





        complete();

    }



    @Override

    public void refreshen() {

        if (squad.getModelle() > 5) {

            power = 20;

        } else {

            power = 10;

        }

        o1.setPreis("Ghostswords", getPts("Ghostsword") * squad.getModelle());

        o1.setPreis("Ghostaxes and forceshields", (getPts("Ghostaxe") + getPts("Forceshield")) * squad.getModelle());

    }

}

