package oc.wh40k.units.ta;

import oc.*;

public class TAEthereal extends Eintrag {

    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade hd;

    public TAEthereal() {
        name = "Ethereal";
        grundkosten = getPts("Ethereal");

        add(ico = new oc.Picture("oc/wh40k/images/Himmlischer.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Honour blade", getPts("Honour blade")));
        ogE.addElement(new OptionsGruppeEintrag("Equalizers", "", getPts("Equalizers")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(hd = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hover Drone", getPts("Ethereal with Hover Drone") - getPts("Ethereal")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
        
        seperator();

		addWarlordTraits("", true);

        addToInformationVector("Ethereal", 1);

        complete();
    }

    @Override
    public void refreshen() {
        power = 2;
        if (o1.getAnzahl() > 0) {
            power++;
        }
        if (hd.isSelected()) {
            power++;
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
