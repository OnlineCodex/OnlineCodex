package oc.wh40k.units.da;



import oc.*;



public class DALandSpeederVengeance extends Eintrag {



    AnzahlPanel squad;

    OptionsUpgradeGruppe o1;

    OptionsEinzelUpgrade ej;



    boolean added = false;



    public DALandSpeederVengeance() {

        name = "Landspeeder Vengeance";

        grundkosten = 140;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));

        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        o1.setSelected(0, true);



        seperator();

    }



    @Override

    public void refreshen() {

        if (!o1.isSelected()) {

            o1.setSelected(0, true);

        }

    }



    @Override

    public void deleteYourself() {



        super.deleteYourself();

    }

}

