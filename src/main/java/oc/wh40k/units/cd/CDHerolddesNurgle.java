package oc.wh40k.units.cd;

import oc.*;

public class CDHerolddesNurgle extends CDHerold {

    OptionsZaehlerGruppe o1, o2, o3;
    OptionsUpgradeGruppe praesenz, mount;
    RuestkammerStarter artefakte;

    public CDHerolddesNurgle() {

        name = "Herold des Nurgle";

        grundkosten = 45;

        this.setEintragsCNT(0.5);

        add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesNurgle.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnungen", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnungen", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Erhabene Belohnungen", 30));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 1", 25));
        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 50));
        add(praesenz = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Präsenz der Virulenz", "Geringe Präsenz der Virulenz", 10));
        ogE.addElement(new OptionsGruppeEintrag("Präsenz der Fruchtbarkeit", "Mächtige Präsenz der Fruchtbarkeit", 25));
        ogE.addElement(new OptionsGruppeEintrag("Präsenz der Ansteckung", "Erhabene Präsenz der Ansteckung", 25));
        add(praesenz = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sänfte des Nurgle", 40));
        add(mount = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        //HöllengeschmiedeteArtefakte
        artefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CDArtefakte", "");
        artefakte.initKammer();
        artefakte.setButtonText(BuildaHQ.translate("Artefakte"));
        add(artefakte);

        ((CDArtefakte) artefakte.getKammer()).enableEntry(6);
        ((CDArtefakte) artefakte.getKammer()).enableEntry(7);
        ((CDArtefakte) artefakte.getKammer()).enableEntry(9);
        ((CDArtefakte) artefakte.getKammer()).enableEntry(10);
        ((CDArtefakte) artefakte.getKammer()).enableEntry(11);

        complete();

    }

    @Override
    public void refreshen() {
        super.refreshen();
        int max = 30;
        int geringeBelohnung = 10;
        int mächtigeBelohnung = 20;
        int erhabeneBelohnung = 30;

        int freePoints = max - o1.getAnzahl() * geringeBelohnung - o2.getAnzahl() * mächtigeBelohnung - o3.getAnzahl() * erhabeneBelohnung;
        if (freePoints < erhabeneBelohnung) {
            o3.setMaxAnzahl(o3.getAnzahl());
        } else {
            o3.setMaxAnzahl(freePoints / erhabeneBelohnung);
        }
        if (freePoints < mächtigeBelohnung) {
            o2.setMaxAnzahl(o2.getAnzahl());
        } else {
            o2.setMaxAnzahl(o2.getAnzahl() + freePoints / mächtigeBelohnung);
        }
        if (freePoints < geringeBelohnung) {
            o1.setMaxAnzahl(o1.getAnzahl());
        } else {
            o1.setMaxAnzahl(o1.getAnzahl() + freePoints / geringeBelohnung);
        }

        if (((CDArtefakte) artefakte.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }
    }
}
