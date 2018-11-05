package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class APOWarlordKampftitan extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;

    public APOWarlordKampftitan() {
        name = "Warlord-Kampftitan";
        grundkosten = 2500;


        add(ico = new oc.Picture("oc/wh40k/images/WarlordKampftitan.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Doppelläufiger Turbolaseer-Annihilator", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasmageschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Inferno-Geschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vulkan-Megabolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", "Apokalypse-Raketenbwerfer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Warpfeldgranate", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multilaserkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Gatlingblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("Meltergeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma-Annihilator", 0));
        ogE.addElement(new OptionsGruppeEintrag("Tremorgeschütz", "Ragnarok-Tremorgeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Vulkangeschütz", 0));
        ogE.addElement(new OptionsGruppeEintrag("Titanen-NKW", "Titanen-Nahkampfwaffe", 0));
        add(o2 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        complete();

    }

    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
        o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
    }
}
