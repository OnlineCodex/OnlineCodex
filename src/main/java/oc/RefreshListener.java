package oc;

import java.util.Vector;


public abstract class RefreshListener {


    final static int reihenfolgeMin = 0;
    final static int reihenfolgeMax = 15;
    static Vector<RefreshListener> listener = new Vector<RefreshListener>();
    static private int IDcnt = 0;
    byte reihenfolge; // wann das aktuelle Object drankommt. von reihenfolgeMin bis reihenfolgeMax, reihenfolgeMin ist als erstes dran, reihenfolgeMax als letztes

//	OnlineCodex oc;
    private int ID;

    public RefreshListener(byte reihenfolge) { // neue ID

        if (reihenfolge < reihenfolgeMin || reihenfolge > reihenfolgeMax) {
            throw new IllegalArgumentException("Bytewert außerhalb des Bereiches");
        }

        this.reihenfolge = reihenfolge;


        addRefreshListener(this);

        this.ID = IDcnt++;

    }

//	public void setOC(OnlineCodex oc){
//		this.oc = oc;
//	}

    public RefreshListener(byte reihenfolge, int id) { // selbe ID wie ein anderer Listener. Wenn einer von beiden RefreshListener.remove(myID) macht, werden beide removed...

        if (reihenfolge < reihenfolgeMin || reihenfolge > reihenfolgeMax) {
            throw new IllegalArgumentException("Bytewert außerhalb des Bereiches");
        }

        this.reihenfolge = reihenfolge;


        addRefreshListener(this);

        this.ID = id;

    }

    public static void addRefreshListener(RefreshListener rl) {

        listener.addElement(rl);
    }

    public static void remove(RefreshListener rl) {

        for (int i = 0; i < listener.size(); ++i) {

            if (listener.elementAt(i) == rl) {

                listener.remove(i);
            }
        }
    }

    public static void remove(int id) {

        for (int i = 0; i < listener.size(); ++i) {

            if (listener.elementAt(i).ID == id) {

                listener.remove(i);
            }
        }
    }

    public static void removeAll() {

        listener.removeAllElements();
    }

    public static void fireRefresh() {

        for (int reihenfolgeIndex = reihenfolgeMin; reihenfolgeIndex <= reihenfolgeMax; ++reihenfolgeIndex) {
            //LOGGER.info("reihenfolgeIndex: "+reihenfolgeIndex);
            for (int i = 0; i < listener.size(); ++i) {

                if (listener.elementAt(i).reihenfolge == reihenfolgeIndex) {
                    //	LOGGER.info("(vor) listener.elementAt(i).refresh():"+i);
                    listener.elementAt(i).refresh();
                    //LOGGER.info("(nach) listener.elementAt(i).refresh():"+i);
                }
            }
            //LOGGER.info("refresh fertig");
        }
    }

    public int getID() {
        return this.ID;
    }





/*  So ist die aktuelle Index-Reihenfolge:

		0.OC akt Pos

		1. AnzahlPanel

		3. OptionsCollection

		4. RuestkammerVater

		5. OptionsRuestkammerStarterGruppe  // noch in Arbeit...

		6. RuestkammerStarter // nur fürn angezeigten Text, deswegen so hoch...

		7. Eintrag

		9. Chooser

		11. ChooserGruppe

		13. BuildaVater

		15. OnlineCodex

*/

    public abstract void refresh();

}