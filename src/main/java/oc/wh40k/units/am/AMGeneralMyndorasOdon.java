package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class AMGeneralMyndorasOdon extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelZaehler oe1b;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkTransport2;
    RuestkammerStarter rkValkyrie;

    boolean creedSelected = false;
    boolean strakenSelected = false;
    boolean kellSelected = false;
    boolean deddogSelected = false;

    public AMGeneralMyndorasOdon() {
        name = "General Myndoras Odon";
        grundkosten = 115;

        add(ico = new oc.Picture("oc/wh40k/images/IGGeneralMyndorasOdon.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regimentsstandarte", "Veteran mit Regimentsstandarte", 0));
        add(oe1b = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Standard of the Lost 113th", "Veteran mit Standard of the Lost 113th", 1, 30));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Funkgerät", "Veteran mit Funkgerät", 0));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melter", "Veteran mit Melter", 0));

        seperator();

        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Astropath", 1, 30));
        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Artillerieoffizier", 1, 30));
        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Flottenoffizier", 1, 30));
        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Leibwächter", 2, 15));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaere", "Chimäre");
        rkTransport.initKammer(true);
        add(rkTransport);

        rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMChimaereIA1", "[IA1 2nd Ed] Chimäre");
        rkTransport2.initKammer(true);
        add(rkTransport2);

        rkValkyrie = new RuestkammerStarter(ID, randAbstand, cnt, "AMWalkuereKammer", "Walküre");
        rkValkyrie.initKammer();
        add(rkValkyrie);

        complete();
    }

    @Override
    public void refreshen() {
        if (!oe1.isSelected()) oe1.setSelected(true);
        if (!oe2.isSelected()) oe2.setSelected(true);
        if (!oe3.isSelected()) oe3.setSelected(true);

        oe1b.setAktiv(!oe1.isSelected() && (getCountFromInformationVector("Cadian Detachment") > 0));
        oe1.setAktiv(!oe1b.isSelected());

        rkTransport.setAktiv(!rkValkyrie.isSelected() && !rkTransport2.isSelected());
        rkTransport2.setAktiv(!rkValkyrie.isSelected() && !rkTransport.isSelected());
        rkValkyrie.setAktiv(!rkTransport.isSelected() && !rkTransport2.isSelected());
    }

}
