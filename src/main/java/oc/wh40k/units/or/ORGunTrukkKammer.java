package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORGunTrukkKammer extends RuestkammerVater {

	public ORGunTrukkKammer() {
        grundkosten = 45;
    }

    @Override
	public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/GunWagon.gif"));


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rokkit launcha", 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red paint job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukka", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced ram", 5));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Supa-skorcha", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", 5));
        ogE.addElement(new OptionsGruppeEintrag("Big lobba", 10));
        ogE.addElement(new OptionsGruppeEintrag("Big-zzappa", 20));
        ogE.addElement(new OptionsGruppeEintrag("Flakka-gunz", 30));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {

    }

}
