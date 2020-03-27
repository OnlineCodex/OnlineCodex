package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAXV8CrisisBodyguards extends Eintrag {

	private final Vector<RuestkammerStarter> rk;
	private OptionsZaehlerGruppe o4, o5;
	public TAXV8CrisisBodyguards() {
        name = "XV8 Crisis Bodyguards";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 9; i++) {
            rk.add(createTroopChampion(TAKampfanzugKammer.class, false, "Crisis Bodyguard", "Crisis Bodyguard"));
            rk.lastElement().setGrundkosten(getPts("XV8 Crisis Bodyguards"));
            add(rk.lastElement());
        }


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("XV8-02 Iridium battlesuite", getPts("XV8-02 Crisis Iridium battlesuite")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

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
        
        o5.getPanel().setLocation(
                (int) o4.getPanel().getLocation().getX(),
                (int) o4.getPanel().getLocation().getY() + o4.getPanel().getSize().height + 5
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
        
        o5.setMaxAnzahl(krisisNumber/3);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Bodyguards", -1);
        super.deleteYourself();
    }
}
