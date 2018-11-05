package oc.wh40k.units.dh;

import oc.*;

public class DHCharnelLychguard extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    RuestkammerStarter rkTransport;

    public DHCharnelLychguard() {
        grundkosten = 0;

        addToInformationVector("DHLychguard", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Charnel Lychguards", 5, 10, 45);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NELeibgarde.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kriegssensen", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwert & Schild", "Hyperphasenschwerter und Dispersionsschilde", 5));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flensing scrarabs", 10));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DHTransporterKammer", "Transporter");
        rkTransport.initKammer(false, true);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        o1.setPreis(1, squad.getModelle() * 5);

        int highLords = getCountFromInformationVector("DHHochlord");
        int councils = getCountFromInformationVector("DHLychguard");
        if (councils > highLords) {
            setFehlermeldung("Max: " + highLords);
        } else {

            setFehlermeldung("");

        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("DHLychguard", -1);
        super.deleteYourself();
    }

}
