package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DAInterrogatorChaplain extends Eintrag {

    private final OptionsEinzelUpgrade energyFist;
    private final OptionsEinzelUpgrade termi;
    private final RuestkammerStarter waffenUndReliquien;
    private final RuestkammerStarter termiWaffen;
    private final RuestkammerStarter spezialAusruestung;
    boolean termiBool;
    boolean bikeBool;

    public DAInterrogatorChaplain() {
        name = "Interrogator-Chaplain";
        grundkosten = 110;

        add(ico = new oc.Picture("oc/wh40k/images/DAInterrogatorChaplain.gif"));

        seperator();

        add(energyFist = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiefaust", 25));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 30));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "DATerminatorwaffen", "");
        termiWaffen.initKammer(false, true, false);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Reliquien"));
        termiWaffen.setAbwaehlbar(false);
        add(termiWaffen);

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DAWaffenUndReliquien", "");
        // Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine, Techmarine
        waffenUndReliquien.initKammer(false, true, false, false, false, false);
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "DASpezialausruestung", "");
        spezialAusruestung.initKammer(false, false, false);
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        seperator(5);

        addToInformationVector("DAHQ", 1);

        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        energyFist.setAktiv(!termi.isSelected());
        waffenUndReliquien.setAktiv(!termi.isSelected());
        termiWaffen.setAktiv(termi.isSelected());

        termi.setAktiv(!((DASpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") && !((DASpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Sprungmodul"));

        spezialAusruestung.getKammer().switchEntry("Sprungmodul", termi.isSelected());
        spezialAusruestung.getKammer().switchEntry("Space-Marine-Bike", termi.isSelected());

        if (((DAWaffenUndReliquien) waffenUndReliquien.getKammer()).uniqueError ||
                ((DATerminatorwaffen) termiWaffen.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }

        if (termiBool != termi.isSelected()) {
            termiBool = termi.isSelected();
            addToInformationVector("DATermiHQ", (termiBool ? 1 : -1));
        }

        if (bikeBool != ((DASpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike")) {
            bikeBool = ((DASpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike");
            addToInformationVector("DABikeHQ", (bikeBool ? 1 : -1));
        }

        waffenUndReliquien.getPanel().setLocation(
                (int) waffenUndReliquien.getPanel().getLocation().getX(),
                (int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
        );

        spezialAusruestung.getPanel().setLocation(
                (int) spezialAusruestung.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );

        if (getCountFromInformationVector("Deathwing Redemption Force") > 0) {
            if (!termi.isSelected()) termi.setSelected(true);
        }

        if (getCountFromInformationVector("Ravenwing Strike Force") > 0) {
            if (!spezialAusruestung.isSelected()) spezialAusruestung.setSelected(true);
            ((DASpezialausruestung) spezialAusruestung.getKammer()).ravenwing = true;
        }
    }

}

