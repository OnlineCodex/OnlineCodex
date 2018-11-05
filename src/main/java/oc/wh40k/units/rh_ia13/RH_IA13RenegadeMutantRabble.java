package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeMutantRabble extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe weapon;
    OptionsZaehlerGruppe weaponStd;
    RuestkammerStarter champ1;
    OptionsEinzelUpgrade ca;

    public RH_IA13RenegadeMutantRabble() {
        name = "Renegade Mutant Rabble\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Mutants", 10, 50, 3);
        squad.setGrundkosten(0);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
        add(weaponStd = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", "Worker with lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stub gun", "Worker with lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Worker with lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", "Worker with lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Worker with lasgun", 0));
        add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sub-flak armour", 10));
        add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 10));

        seperator();

        champ1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13MutantChampionKammer", "", 1);
        champ1.initKammer();
        champ1.setButtonText("Mutant Champion");
        add(champ1);

        addToInformationVector("MutantRabble", 1);

        complete();
    }

    @Override
    public void refreshen() {
        weaponStd.setMaxAnzahl(squad.getModelle() - weapon.getAnzahl());
        weaponStd.setAnzahl(0, squad.getModelle() - weapon.getAnzahl());
        weapon.setMaxAnzahl(squad.getModelle() - (champ1.isSelected() ? 1 : 0));

        ca.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver") == 1);

        if (getCountFromInformationVector("RHMutantOverlord") == 1 && getCountFromInformationVector("MutantRabble") < 2) {
            setFehlermeldung("2+ Mutant Rabble");
        } else if (getCountFromInformationVector("RHMasterOfTheHorde") == 1 && getCountFromInformationVector("InfPlatoon") < 2) {
            setFehlermeldung("2+ Inf. Platoons");
        } else {
            setFehlermeldung("");
        }

    }

    @Override
    public void deleteYourself() {
        addToInformationVector("MutantRabble", -1);
        super.deleteYourself();
    }

}
