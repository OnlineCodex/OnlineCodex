package oc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


@SuppressWarnings("serial")
public class JTextAreaWithPopup extends JTextArea implements MouseListener, CaretListener, KeyListener {

    boolean kopierOption;
    boolean einfügOption;
    private final JPopupMenu popup;
    private JMenuItem kopieren;
    private JMenuItem allesKopieren;
    private JMenuItem einfügen;
    private final JMenuItem allesMarkieren;
    ActionListener menuActionListener = new ActionListener() {

        @Override
		public void actionPerformed(ActionEvent event) {

            final Object source = event.getSource();


            if (source == kopieren) {

                kopieren();
            }

            if (source == allesKopieren) {

                allesKopieren();
            } else if (source == einfügen) {

                einfügen();
            } else if (source == allesMarkieren) {

                allesMarkieren();
            }


        }

    };


    public JTextAreaWithPopup(boolean kopierOption, boolean einfügOption) {

        this.kopierOption = kopierOption;

        this.einfügOption = einfügOption;


        popup = new JPopupMenu();


        if (kopierOption) {

            kopieren = new JMenuItem("Kopieren");

            popup.add(kopieren);

            kopieren.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK ));

            kopieren.addActionListener(menuActionListener);

            kopieren.setEnabled(false);


            allesKopieren = new JMenuItem("Alles Kopieren");

            popup.add(allesKopieren);

            allesKopieren.addActionListener(menuActionListener);
        }


        if (einfügOption) {

            einfügen = new JMenuItem("Einfügen");

            popup.add(einfügen);

            einfügen.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK ));

            einfügen.addActionListener(menuActionListener);
        }


        allesMarkieren = new JMenuItem("Alles markieren");

        popup.add(allesMarkieren);

        allesMarkieren.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK ));

        allesMarkieren.addActionListener(menuActionListener);


        this.addMouseListener(this);

        this.addKeyListener(this);

        this.addCaretListener(this);

    }

    @Override
	public void mouseClicked(MouseEvent e) {
    }

    @Override
	public void mousePressed(MouseEvent e) {
    }

    @Override
	public void mouseEntered(MouseEvent e) {
    }

    @Override
	public void mouseExited(MouseEvent e) {
    }


    @Override
	public void mouseReleased(MouseEvent e) {

        //if(e.isPopupTrigger()){

        //	popup.show(this, e.getX(), e.getY());}

    }


    @Override
	public void caretUpdate(CaretEvent e) {

        if (kopierOption) {

            kopieren.setEnabled(e.getMark() != e.getDot());
        } // Text ist markiert

    }


    @Override
	public void keyTyped(KeyEvent e) {
    }

    @Override
	public void keyPressed(KeyEvent e) {
    }

    @Override
	public void keyReleased(KeyEvent e) {
    }


    public void kopieren() {

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl C"))).actionPerformed(null);		ACCES DENID!! Leider

    }

    public void allesKopieren() {

        allesMarkieren();

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl C"))).actionPerformed(null);

    }


    public void einfügen() {

        //this.getActionMap().get(this.getInputMap().get(KeyStroke.getKeyStroke("ctrl V"))).actionPerformed(null);

    }


    public void allesMarkieren() {

        this.requestFocusInWindow();

        this.selectAll();

    }


}