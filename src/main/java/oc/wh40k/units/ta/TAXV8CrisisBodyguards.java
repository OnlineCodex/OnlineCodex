package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TAXV8CrisisBodyguards extends Eintrag {

	private RuestkammerStarter ob2;
	private Vector<RuestkammerStarter> rk;
	private OptionsZaehlerGruppe o4;
	private boolean warscaper = false;

    public TAXV8CrisisBodyguards() {
        name = "XV8 Crisis Bodyguards";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 9; i++) {
            rk.add(createTroopChampion(TAKampfanzugKammer.class, true, "Crisis Bodyguard", "Crisis Bodyguard"));
            rk.lastElement().setGrundkosten(getPts("XV8 Crisis Bodyguards"));
            add(rk.lastElement());
        }


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        addToInformationVector("Bodyguards", 1);

        complete();
    }

    @Override
    public void refreshen() {
        int krisisNumber = 0;
        for (int i = 0; i < 9; i++) {
            krisisNumber += (rk.get(i).isSelected() && rk.get(i).isAktiv() ? 1 : 0);
        }
        o4.setMaxAnzahl(krisisNumber * 2);
        o4.getPanel().setLocation(
                (int) o4.getPanel().getLocation().getX(),
                (int) rk.get(8).getPanel().getLocation().getY() + rk.get(8).getPanel().getSize().height + 5
        );

        boolean error = false;
        for (int i = 0; i < 9; i++) {
            ((TAKampfanzugKammer) rk.get(i).getKammer()).farsight = getCountFromInformationVector("Farsight Enclave") > 0;
            if (!rk.get(i).isSelected()) {
                ((TAKampfanzugKammer) rk.get(i).getKammer()).clearEntries();
            }
            if (((TAKampfanzugKammer) rk.get(i).getKammer()).uniqueError) {
                error = true;
            }
        }

        if (getCountFromInformationVector("Contingent Headquarters") > 0 && getCountFromInformationVector("Bodyguards") > 2) {
            setFehlermeldung("1-2 Bodyguards");
        } else if (error) {
            setFehlermeldung("Ausrüstung doppelt!");
        } else if (getCountFromInformationVector("FEWarscaper") > 1) {
            setFehlermeldung("Warscaper doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Bodyguards", -1);
        super.deleteYourself();
    }
}
