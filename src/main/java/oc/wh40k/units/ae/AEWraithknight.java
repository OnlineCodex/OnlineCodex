package oc.wh40k.units.ae;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;



public class AEWraithknight extends Eintrag {



	private final OptionsZaehlerGruppe o1;

	private final OptionsUpgradeGruppe o2;



    public AEWraithknight() {

        name = "Wraithknight";

        grundkosten = getPts("Wraithknight") + getPts("Titanic wraithbone fists") + getPts("Titanic feet");

        power = 27;



        ogE.addElement(new OptionsGruppeEintrag("2 Heavy wraithcannons", 2 * getPts("Heavy wraithcannon")));

        ogE.addElement(new OptionsGruppeEintrag("Titanic ghostglaive and scattershield", getPts("Titanic ghostglaive") + getPts("Scattershield")));

        ogE.addElement(new OptionsGruppeEintrag("Sun cannon and scattershield", getPts("Sun cannon") + getPts("Scattershield")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o2.setSelected(0, true);



        seperator(15);



        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", getPts("Scatter laser")));

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));

        ogE.addElement(new OptionsGruppeEintrag("Star cannon", getPts("Star cannon")));

        o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);

        add(o1);



        complete();

    }



    @Override

    public void refreshen() {

        o2.alwaysSelected();

    }



}

