package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CHHellforgedRapierBattery extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe crew, weapon;

    public CHHellforgedRapierBattery() {
        //name = "Thousand Sons\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hellforged Rapier", 1, 3, getPts("Hellforged Rapier"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Laser destroyer", getPts("Laser destroyer")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma cannon", getPts("Ectoplasma cannon")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        weapon.setAnzahl(0, 1);
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chaos Space Marine Crew", getPts("Chaos Space Marine Crew")));
        add(crew = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        crew.setMaxAnzahl(squad.getModelle() * 2);
        crew.setAnzahl(0, squad.getModelle() * 2);
        weapon.setMaxAnzahl(squad.getModelle());

        power = 4;
    }
}
