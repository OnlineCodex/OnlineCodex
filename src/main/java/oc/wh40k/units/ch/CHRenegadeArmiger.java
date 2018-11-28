package oc.wh40k.units.ch;

import oc.*;

public class CHRenegadeArmiger extends Eintrag {
    OptionsZaehlerGruppe fk1;
    OptionsZaehlerGruppe fk2;
    AnzahlPanel squad;

    public CHRenegadeArmiger() {
        name = "Renegade Armiger";
        grundkosten = 0;
        power = 9;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Renegade Armiger", 1, 3, getPts("Renegade Armiger"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Armiger autocannons", getPts("Armiger autocannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Thermal Spear & Reaper", getPts("Thermal Spear") + getPts("Reaper chain-cleaver")));
        add(fk1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        fk1.setAnzahl(0, 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", getPts("Melta gun")));
        add(fk2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        fk2.setAnzahl(0, 1);

        setInformationVectorValue("Armiger selected", getCountFromInformationVector("Armiger selected") + 1);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk1.setMaxAnzahl(squad.getModelle());
        fk1.setLegal(fk1.getAnzahl() == squad.getModelle());
        fk2.setMaxAnzahl(squad.getModelle());
        fk2.setLegal(fk2.getAnzahl() == squad.getModelle());

        power = 9 * squad.getModelle();
    }

    //@OVERRIDE
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("Armiger selected", getCountFromInformationVector("Armiger selected") - 1);
    }
}
