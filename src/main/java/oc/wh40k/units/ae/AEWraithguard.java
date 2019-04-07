package oc.wh40k.units.ae;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class AEWraithguard extends Eintrag {



	private final AnzahlPanel squad;

	private final OptionsUpgradeGruppe o1;



    public AEWraithguard() {

        name = "Wraithguard";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wraithguard", 5, 10, getPts("Wraithguard") + getPts("Wraithguard fists"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Wraithcannons", getPts("Wraithcannon")));

        ogE.addElement(new OptionsGruppeEintrag("D-scythes", getPts("D-scythe")));

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

        o1.setPreis("Wraithcannons", getPts("Wraithcannon") * squad.getModelle());

        o1.setPreis("D-scythes", getPts("D-scythe") * squad.getModelle());

    }

}

