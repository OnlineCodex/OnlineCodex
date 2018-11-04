package oc.wh40k.units.im;

import oc.*;

public class IMRunePriestonBike extends Eintrag {


    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean fenrisSupp = false;

    public IMRunePriestonBike() {
        name = "Rune Priest on Bike";
        grundkosten = getPts("Rune Priest on Bike");
        power = 8;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psychic hood", getPts("psychic hood")));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runic armour", getPts("runic armour")));

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Rune Priest");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
