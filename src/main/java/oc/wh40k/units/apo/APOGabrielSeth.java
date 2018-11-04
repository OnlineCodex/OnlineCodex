package oc.wh40k.units.apo;

import oc.Eintrag;

public class APOGabrielSeth extends Eintrag {

    public APOGabrielSeth() {
        name = "Ordensmeister Gabriel Seth";
        grundkosten = 155;

        addToInformationVector("BAHQ", 1);

        add(ico = new oc.Picture("oc/wh40k/images/BAOrdensmeisterGabrielSeth.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("BAHQ", -1);
    }

}
