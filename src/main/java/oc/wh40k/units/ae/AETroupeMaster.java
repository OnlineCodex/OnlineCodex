package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

public class AETroupeMaster extends Eintrag {
	private final OptionsZaehlerGruppe o1, o2;

    public AETroupeMaster() {
        name = "Troupe Master";
        grundkosten = getPts("Troupe Master");
        power = 4;

        ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol (Harlequins)")));
        ogE.addElement(new OptionsGruppeEintrag("Neuro disruptor", getPts("Neuro disruptor")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol (Harlequins)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Harlequin's blade", getPts("Harlequin's blade")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Harlequins)")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's embrace", getPts("Harlequin's embrace")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's kiss", getPts("Harlequin's kiss")));
        ogE.addElement(new OptionsGruppeEintrag("Harlequin's caress", getPts("Harlequin's caress")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}