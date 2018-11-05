package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeInfantrySquadKammer extends RuestkammerVater {

    OptionsEinzelZaehler chaos;
    OptionsZaehlerGruppe specWeapon;
    OptionsZaehlerGruppe weaponTeam;
    OptionsZaehlerGruppe weapon;
    OptionsZaehlerGruppe weaponStd;

    AnzahlPanel squad;
    RuestkammerStarter champ1;
    RuestkammerStarter champ2;
    RuestkammerStarter rkTransport;

    OptionsUpgradeGruppe oug;

    boolean isCommandSquad;

    public RH_IA13RenegadeInfantrySquadKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            isCommandSquad = defaults[0];
        } catch (Exception e) {
        }

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Renegades", 10, 20, 3);
        squad.setGrundkosten(0);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        ogE.addElement(new OptionsGruppeEintrag("Vox caster", 5));
        if (isCommandSquad) {
            ogE.addElement(new OptionsGruppeEintrag("Command net vox", 5));
        }
        ogE.addElement(new OptionsGruppeEintrag("Chaos sigil", 5));
        add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber team", 5));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", 10));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon team", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", 15));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon team", 20));
        add(weaponTeam = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
        add(weaponStd = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
        ogE.addElement(new OptionsGruppeEintrag("Stubgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
        add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sub-flak armour", 5));
        ogE.addElement(new OptionsGruppeEintrag("Carapace armour", 10));
        ogE.addElement(new OptionsGruppeEintrag("Militia Training", 10));
        ogE.addElement(new OptionsGruppeEintrag("krak grenades", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fanatic SR", 20));
        ogE.addElement(new OptionsGruppeEintrag("Feel no Pain SR", 10));
        add(oug = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 5));

        seperator();

        champ1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13InfantryChampionKammer", "");
        champ1.initKammer(false);
        champ1.setButtonText("Champion");
        add(champ1);

        seperator();

        if (isCommandSquad) {
            champ2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13InfantryChampionKammer", "");
            champ2.initKammer(true);
            champ2.setButtonText("Demagogue");
            add(champ2);
        }

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeChimera", "Renegade Chimera");
        rkTransport.initKammer(true);
        add(rkTransport);

        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (isCommandSquad) {
            champ1.setAktiv(!champ2.isSelected());
            champ2.setAktiv(!champ1.isSelected());
        }

        weaponTeam.setMaxAnzahl(squad.getModelle() / 10);
        specWeapon.setMaxAnzahl(squad.getModelle() / 5);
        weaponStd.setMaxAnzahl(squad.getModelle() - weapon.getAnzahl() - weaponTeam.getAnzahl() * 2 - (champ1.isSelected() ? 1 : 0) - ((champ2 != null && champ2.isSelected()) ? 1 : 0));
        weaponStd.setAnzahl(0, squad.getModelle() - weapon.getAnzahl() - weaponTeam.getAnzahl() * 2 - (champ1.isSelected() ? 1 : 0) - ((champ2 != null && champ2.isSelected()) ? 1 : 0));
        weapon.setMaxAnzahl(squad.getModelle() - weaponTeam.getAnzahl() * 2 - (champ1.isSelected() ? 1 : 0) - ((champ2 != null && champ2.isSelected()) ? 1 : 0));

        if (BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            oug.setSelected(2, true);
        }

        oug.setAktiv(1, BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver") == 1);
        oug.setAktiv(4, BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHArchHereticRev") == 1);
        oug.setAktiv(5, BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHHeretekMagus") == 1);
    }

}
