package oc.wh40k.units.as;

import oc.*;

public class ASPrincipalis extends Eintrag {

    OptionsZaehlerGruppe o1;
    RuestkammerStarter waffenUndRelikte;

    public ASPrincipalis() {
        name = "Principalis";
        grundkosten = 65;

        addToInformationVector("ASPrincipalis", 1);

        add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rosarius", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

        seperator();

        waffenUndRelikte = new RuestkammerStarter(ID, randAbstand, cnt, "ASWaffenUndRelikte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndRelikte.initKammer(true, false, false, false, false);
        waffenUndRelikte.setButtonText(BuildaHQ.translate("Waffen & Relikte"));
        add(waffenUndRelikte);
        waffenUndRelikte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("ASPrincipalis", -1);
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        if (((ASWaffenUndRelikte) waffenUndRelikte.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

}
