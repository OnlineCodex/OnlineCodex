package oc.wh40k.units.im;

import oc.*;

public class IMRunePriest extends Eintrag {


    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean fenrisSupp = false;

    public IMRunePriest() {
        name = "Rune Priest";
        grundkosten = getPts("Rune Priest");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Rune Priest with Jump Pack") - getPts("Rune Priest")));

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
        power = 6;
        if (oe1.isSelected()) {
            power += 1;
        }
    }

}
