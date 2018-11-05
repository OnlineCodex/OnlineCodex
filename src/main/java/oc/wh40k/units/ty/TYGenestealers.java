package oc.wh40k.units.ty;

import oc.*;

public class TYGenestealers extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, oe3, oe5, oe6;
    OptionsEinzelUpgrade oe2, oe4;

    public TYGenestealers() {
        name = "Genestealers";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Genestealers", 5, 20, getPts("Genestealers") + getPts("Rending claws"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TYSymbionten.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Scything talons", getPts("Scything talons")));
        add(oe3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        ogE.addElement(new OptionsGruppeEintrag("Flesh hooks", getPts("Flesh hooks")));
        add(oe5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        ogE.addElement(new OptionsGruppeEintrag("Acid maw", getPts("Acid maw")));
        add(oe6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Genestealer)")));
        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extended carapaces", getPts("Extended carapace")));

        complete();
    }

    @Override
    public void refreshen() {
        oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Genestealer)"));
        oe3.setMaxAnzahl(squad.getModelle());
        oe5.setMaxAnzahl(squad.getModelle() / 4);
        oe6.setMaxAnzahl(squad.getModelle() / 4);
        oe4.setPreis(squad.getModelle() * getPts("Extended carapace"));
        power = squad.getModelle() / 5 * 4;
    }

}
