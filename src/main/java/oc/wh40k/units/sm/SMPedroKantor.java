package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMPedroKantor extends Eintrag {

    public SMPedroKantor() {
        name = "Pedro Kantor";
        grundkosten = 185;

        addToInformationVector("SMChapterMaster", 1);
        addToInformationVector("Pedro Kantor", 1);

        add(ico = new oc.Picture("oc/wh40k/images/SMOrdensmeisterPedroKantor.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        //Detachments
        boolean max1Error = false;
        if (getCountFromInformationVector("Strike Force Command") > 0) {
            int i = getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Captain") + getCountFromInformationVector("Chaplain") +
                    getCountFromInformationVector("Chaplain Cassius") + getCountFromInformationVector("Chaplain Grimaldus") + getCountFromInformationVector("Kor'sarro Khan") +
                    getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") + getCountFromInformationVector("Marneus Calgar") +
                    getCountFromInformationVector("Pedro Kantor") + getCountFromInformationVector("High Marshal Helbrecht");
            if (i > 1) {
                max1Error = true;
            }
        }

        //Errors
        if (max1Error) {
            setFehlermeldung("Genau 1");
        } else if (getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
            setFehlermeldung("nur ein Ordensmeister");
        } else if (getCountFromInformationVector("SMImperialFists") != 1) {
            setFehlermeldung("Keine Imperial Fists");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("SMChapterMaster", -1);
        addToInformationVector("Pedro Kantor", -1);
        super.deleteYourself();
    }

}
