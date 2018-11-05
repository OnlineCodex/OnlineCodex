package oc.wh40k.units.as;

import oc.*;

public class ASTransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe immoWeapons;
    OptionsPanelSwitcher switcher;

    boolean offerRhino = false;
    boolean offerImmolator = false;
    boolean offerRepressor = false;

    public ASTransporterKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        this.offerRhino = defaults[0];
        this.offerImmolator = defaults[1];
        this.offerRepressor = defaults[1];

        add(ico = new oc.Picture("oc/wh40k/images/ASRhino.jpg"));


        if (this.offerRhino) {
            ogE.addElement(new OptionsGruppeEintrag("Rhino", 40));
        }
        if (this.offerImmolator) {
            ogE.addElement(new OptionsGruppeEintrag("Immolator", 60));
        }
        if (this.offerRepressor) {
            ogE.addElement(new OptionsGruppeEintrag("[FW] Repressor", 75));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        OptionsVater[] rhino = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stimmverstärker", 10)
        };

        OptionsVater[] immolator = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozer-Schaufel", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stimmverstärker", 10)
        };

        OptionsVater[] repressor = new OptionsVater[]{
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10)
        };

        OptionsVater[] empty = new OptionsVater[]{
        };

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, rhino, immolator, repressor, empty));

        // If Immolator should be available, offer weapons for selection
        if (offerImmolator) {
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Multimelter", "Synchronisierte Multimelter", 0));
            add(immoWeapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (typ.isSelected("Rhino")) {
            switcher.forceSwitchPanel(0);
        } else if (typ.isSelected("Immolator")) {
            switcher.forceSwitchPanel(1);
        } else {
            switcher.forceSwitchPanel(2);
        }

        if (offerImmolator) {
            immoWeapons.setAktiv(typ.isSelected("Immolator"));
            if (immoWeapons.isAktiv() && !immoWeapons.isSelected()) {
                immoWeapons.setSelected(0, true);
            }

            immoWeapons.getPanel().setLocation(
                    (int) switcher.getPanel().getLocation().getX(),
                    (int) switcher.getPanel().getLocation().getY() + switcher.getPanel().getSize().height + 8
            );
        }

        if (typ.isSelected("Rhino")) {
            String icon = "oc/wh40k/images/ASRhino.jpg";
            ico.setIcon(icon);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
        } else { // all Land Raiders
            String icon = "oc/wh40k/images/ASImmolator.jpg";
            ico.setIcon(icon);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
        }
    }

}
