package oc.wh40k.units.ia;

import oc.*;

public class IACanoness extends Eintrag {

    OptionsZaehlerGruppe o1;
    RuestkammerStarter waffenUndRelikte;

    public IACanoness() {
        name = "Canoness";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rosarius", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

        seperator();

        waffenUndRelikte = new RuestkammerStarter(ID, randAbstand, cnt, "IAWaffenUndRelikte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndRelikte.initKammer(true, false, false, false, false);
        waffenUndRelikte.setButtonText(BuildaHQ.translate("Waffen & Relikte"));
        add(waffenUndRelikte);
        waffenUndRelikte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        if (((IAWaffenUndRelikte) waffenUndRelikte.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

}
