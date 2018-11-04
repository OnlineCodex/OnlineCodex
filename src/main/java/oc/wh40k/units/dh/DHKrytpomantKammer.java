package oc.wh40k.units.dh;

import oc.*;

public class DHKrytpomantKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsPanelSwitcher switcher;

    OptionsVater[] verzweiflung;
    OptionsVater[] zerstoerung;
    OptionsVater[] ewigkeit;
    OptionsVater[] sturm;
    OptionsVater[] verwandlung;

    public DHKrytpomantKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/NEKrytpomant.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Krytpomant", 25));
        ogE.addElement(new OptionsGruppeEintrag("Bote der Verzweiflung", 30));
        ogE.addElement(new OptionsGruppeEintrag("Bote der Zerstörung", 35));
        ogE.addElement(new OptionsGruppeEintrag("Bote der Ewigkeit", 25));
        ogE.addElement(new OptionsGruppeEintrag("Bote des Sturms", 25));
        ogE.addElement(new OptionsGruppeEintrag("Bote der Verwandlung", 30));
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        verzweiflung = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aura des Schreckens", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schleier der Finsternis", 30),
        };

        zerstoerung = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flammenblick", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Solarimpuls", 20),
        };

        ewigkeit = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chronometrum", 15),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zeitsplittermantel", 30),
        };

        sturm = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hochspannungsfeld", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ätherkristall", 15),
        };

        verwandlung = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockwelleninduktor", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Harfe der Dissonanz", 25),
        };

        OptionsVater[] empty = new OptionsVater[]{
        };

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, verzweiflung, zerstoerung, ewigkeit, sturm, verwandlung, empty));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (typ.isSelected("Bote der Verzweiflung")) {
            switcher.forceSwitchPanel(0);
        } else if (typ.isSelected("Bote der Zerstörung")) {
            switcher.forceSwitchPanel(1);
        } else if (typ.isSelected("Bote der Ewigkeit")) {
            switcher.forceSwitchPanel(2);
        } else if (typ.isSelected("Bote des Sturms")) {
            switcher.forceSwitchPanel(3);
        } else if (typ.isSelected("Bote der Verwandlung")) {
            switcher.forceSwitchPanel(4);
        } else { // normaler Krytpomant
            switcher.forceSwitchPanel(5);
        }
    }

}
